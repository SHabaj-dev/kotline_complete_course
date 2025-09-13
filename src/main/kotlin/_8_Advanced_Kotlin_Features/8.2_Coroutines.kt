package _8_Advanced_Kotlin_Features

// 8.2 Coroutines

// 8.2.1 What are coroutines?
/*
    - Coroutines are lightweight threads for asynchronous programming.
    - They allow you to write asynchronous code in a sequential manner.
    - Coroutines are more efficient than threads for I/O operations.
    - They help avoid callback hell and make code more readable.
*/

//Example:
// import kotlinx.coroutines.*
//
// suspend fun fetchData(): String {
//     delay(1000) // Simulate network delay
//     return "Data fetched"
// }
//
// fun main() = runBlocking {
//     println("Starting...")
//     val data = fetchData()
//     println("Received: $data")
//     println("Finished")
// }

//Output:
//Starting...
//Received: Data fetched
//Finished

// 8.2.2 Launching coroutines
/*
    - Coroutines can be launched using launch() or async().
    - launch() starts a coroutine that doesn't return a value.
    - async() starts a coroutine that returns a Deferred value.
    - runBlocking() blocks the current thread until all coroutines complete.
*/

//Example:
// import kotlinx.coroutines.*
//
// fun main() = runBlocking {
//     // Launch a coroutine
//     launch {
//         delay(1000)
//         println("Coroutine 1 finished")
//     }
//     
//     // Launch another coroutine
//     launch {
//         delay(500)
//         println("Coroutine 2 finished")
//     }
//     
//     println("Main thread continues")
// }

//Output:
//Main thread continues
//Coroutine 2 finished
//Coroutine 1 finished

// 8.2.3 Async and await
/*
    - async() starts a coroutine and returns a Deferred value.
    - await() waits for the result of a Deferred value.
    - Multiple async operations can run concurrently.
*/

//Example:
// import kotlinx.coroutines.*
//
// suspend fun fetchUser(id: Int): String {
//     delay(1000) // Simulate network delay
//     return "User $id"
// }
//
// fun main() = runBlocking {
//     val startTime = System.currentTimeMillis()
//     
//     // Start multiple async operations
//     val user1 = async { fetchUser(1) }
//     val user2 = async { fetchUser(2) }
//     val user3 = async { fetchUser(3) }
//     
//     // Wait for all results
//     val users = listOf(user1.await(), user2.await(), user3.await())
//     
//     val endTime = System.currentTimeMillis()
//     println("Users: $users")
//     println("Time taken: ${endTime - startTime} ms")
// }

//Output:
//Users: [User 1, User 2, User 3]
//Time taken: 1000 ms

// 8.2.4 Coroutine scope
/*
    - Coroutine scope defines the lifetime of coroutines.
    - GlobalScope runs coroutines for the entire application lifetime.
    - CoroutineScope creates a scope that can be cancelled.
    - Structured concurrency ensures proper cleanup of coroutines.
*/

//Example:
// import kotlinx.coroutines.*
//
// fun main() = runBlocking {
//     // Create a coroutine scope
//     coroutineScope {
//         launch {
//             delay(1000)
//             println("Task 1")
//         }
//         
//         launch {
//             delay(500)
//             println("Task 2")
//         }
//     }
//     
//     println("All tasks completed")
// }

//Output:
//Task 2
//Task 1
//All tasks completed

// 8.2.5 Cancellation
/*
    - Coroutines can be cancelled using cancel().
    - Cancellation is cooperative - coroutines must check for cancellation.
    - Use isActive to check if a coroutine is still active.
    - Cancellation exceptions are thrown when a coroutine is cancelled.
*/

//Example:
// import kotlinx.coroutines.*
//
// fun main() = runBlocking {
//     val job = launch {
//         try {
//             repeat(1000) { i ->
//                 println("Working $i")
//                 delay(100)
//             }
//         } catch (e: CancellationException) {
//             println("Coroutine was cancelled")
//         }
//     }
//     
//     delay(500)
//     job.cancel()
//     job.join()
//     println("Main thread finished")
// }

//Output:
//Working 0
//Working 1
//Working 2
//Working 3
//Working 4
//Coroutine was cancelled
//Main thread finished

// 8.2.6 Exception handling
/*
    - Exceptions in coroutines can be handled using try-catch.
    - CoroutineExceptionHandler can handle uncaught exceptions.
    - Exceptions in async coroutines are deferred until await() is called.
*/

//Example:
// import kotlinx.coroutines.*
//
// fun main() = runBlocking {
//     val handler = CoroutineExceptionHandler { _, exception ->
//         println("Caught exception: $exception")
//     }
//     
//     val job = GlobalScope.launch(handler) {
//         throw RuntimeException("Something went wrong")
//     }
//     
//     job.join()
// }

//Output:
//Caught exception: java.lang.RuntimeException: Something went wrong

// 8.2.7 Dispatchers
/*
    - Dispatchers determine which thread pool a coroutine runs on.
    - Dispatchers.Main runs on the main thread (UI thread).
    - Dispatchers.IO is optimized for I/O operations.
    - Dispatchers.Default is optimized for CPU-intensive work.
*/

//Example:
// import kotlinx.coroutines.*
//
// fun main() = runBlocking {
//     // Run on different dispatchers
//     launch(Dispatchers.Default) {
//         println("Default dispatcher: ${Thread.currentThread().name}")
//     }
//     
//     launch(Dispatchers.IO) {
//         println("IO dispatcher: ${Thread.currentThread().name}")
//     }
//     
//     launch(Dispatchers.Unconfined) {
//         println("Unconfined dispatcher: ${Thread.currentThread().name}")
//     }
// }

//Output:
//Default dispatcher: DefaultDispatcher-worker-1
//IO dispatcher: DefaultDispatcher-worker-2
//Unconfined dispatcher: main

// 8.2.8 Channels
/*
    - Channels provide a way to communicate between coroutines.
    - They are similar to queues but for coroutines.
    - Channels can be used for producer-consumer patterns.
    - Different types of channels include regular, buffered, and rendezvous.
*/

//Example:
// import kotlinx.coroutines.*
// import kotlinx.coroutines.channels.*
//
// fun main() = runBlocking {
//     val channel = Channel<Int>()
//     
//     // Producer coroutine
//     launch {
//         for (x in 1..5) {
//             channel.send(x)
//         }
//         channel.close()
//     }
//     
//     // Consumer coroutine
//     launch {
//         for (value in channel) {
//             println("Received: $value")
//         }
//     }
// }

//Output:
//Received: 1
//Received: 2
//Received: 3
//Received: 4
//Received: 5
