package _7_Exception_Handling

// 7.1 Basic Exception Handling

// 7.1.1 What are exceptions?
/*
    - Exceptions are runtime errors that occur during program execution.
    - They disrupt the normal flow of the program.
    - Examples: division by zero, null pointer access, file not found.
    - Exception handling allows programs to gracefully handle these errors.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     
//     // This will throw an exception
//     try {
//         val result = numbers[10]  // Index out of bounds
//         println("Result: $result")
//     } catch (e: IndexOutOfBoundsException) {
//         println("Error: Index out of bounds")
//     }
// }

//Output:
//Error: Index out of bounds

// 7.1.2 try-catch blocks
/*
    - try-catch blocks are used to handle exceptions.
    - Code that might throw an exception is placed in the try block.
    - Exception handling code is placed in the catch block.
    - Multiple catch blocks can handle different types of exceptions.
*/

//Example:
// fun divide(a: Int, b: Int): Int {
//     return a / b
// }
//
// fun main() {
//     try {
//         val result = divide(10, 0)  // Division by zero
//         println("Result: $result")
//     } catch (e: ArithmeticException) {
//         println("Error: Division by zero")
//     } catch (e: Exception) {
//         println("General error: ${e.message}")
//     }
// }

//Output:
//Error: Division by zero

// 7.1.3 finally blocks
/*
    - finally blocks are executed regardless of whether an exception occurs.
    - They are used for cleanup operations like closing files or connections.
    - finally blocks are optional but recommended for resource management.
*/

//Example:
// fun riskyOperation(): String {
//     return "Success"
// }
//
// fun main() {
//     try {
//         val result = riskyOperation()
//         println("Result: $result")
//     } catch (e: Exception) {
//         println("Error: ${e.message}")
//     } finally {
//         println("Cleanup: This always executes")
//     }
// }

//Output:
//Result: Success
//Cleanup: This always executes

// 7.1.4 Multiple catch blocks
/*
    - Multiple catch blocks can handle different types of exceptions.
    - More specific exceptions should be caught before general ones.
    - The first matching catch block is executed.
*/

//Example:
// fun processNumber(input: String): Int {
//     return input.toInt()
// }
//
// fun main() {
//     val inputs = listOf("123", "abc", "999999999999999999999")
//     
//     for (input in inputs) {
//         try {
//             val number = processNumber(input)
//             println("Processed: $number")
//         } catch (e: NumberFormatException) {
//             println("Error: '$input' is not a valid number")
//         } catch (e: Exception) {
//             println("Error: ${e.message}")
//         }
//     }
// }

//Output:
//Processed: 123
//Error: 'abc' is not a valid number
//Error: 999999999999999999999

// 7.1.5 Exception hierarchy
/*
    - Exceptions in Kotlin are organized in a hierarchy.
    - All exceptions inherit from Throwable.
    - RuntimeException and its subclasses are unchecked exceptions.
    - Other exceptions are checked exceptions.
*/

//Example:
// fun demonstrateExceptionHierarchy() {
//     try {
//         // This will throw a RuntimeException
//         val result = 10 / 0
//     } catch (e: ArithmeticException) {
//         println("Caught ArithmeticException: ${e.message}")
//     } catch (e: RuntimeException) {
//         println("Caught RuntimeException: ${e.message}")
//     } catch (e: Exception) {
//         println("Caught Exception: ${e.message}")
//     }
// }
//
// fun main() {
//     demonstrateExceptionHierarchy()
// }

//Output:
//Caught ArithmeticException: / by zero

// 7.1.6 Custom exceptions
/*
    - You can create custom exceptions by extending Exception or RuntimeException.
    - Custom exceptions should have meaningful names and messages.
    - They help in creating more specific error handling.
*/

//Example:
// class InsufficientFundsException(message: String) : Exception(message)
//
// class BankAccount(private var balance: Double) {
//     fun withdraw(amount: Double) {
//         if (amount > balance) {
//             throw InsufficientFundsException("Insufficient funds. Available: $balance, Requested: $amount")
//         }
//         balance -= amount
//         println("Withdrawn $amount. New balance: $balance")
//     }
// }
//
// fun main() {
//     val account = BankAccount(100.0)
//     
//     try {
//         account.withdraw(50.0)
//         account.withdraw(100.0)  // This will throw an exception
//     } catch (e: InsufficientFundsException) {
//         println("Error: ${e.message}")
//     }
// }

//Output:
//Withdrawn 50.0. New balance: 50.0
//Error: Insufficient funds. Available: 50.0, Requested: 100.0

// 7.1.7 Exception propagation
/*
    - Exceptions can be propagated up the call stack.
    - If an exception is not caught, it propagates to the calling function.
    - This continues until the exception is caught or the program terminates.
*/

//Example:
// fun functionA() {
//     functionB()
// }
//
// fun functionB() {
//     functionC()
// }
//
// fun functionC() {
//     throw RuntimeException("Error in functionC")
// }
//
// fun main() {
//     try {
//         functionA()
//     } catch (e: RuntimeException) {
//         println("Caught exception: ${e.message}")
//     }
// }

//Output:
//Caught exception: Error in functionC

// 7.1.8 Exception handling best practices
/*
    - Catch specific exceptions rather than general ones.
    - Use meaningful error messages.
    - Don't ignore exceptions (empty catch blocks).
    - Use finally blocks for cleanup.
    - Log exceptions for debugging.
*/

//Example:
// fun safeDivide(a: Int, b: Int): Result<Int> {
//     return try {
//         if (b == 0) {
//             Result.failure(ArithmeticException("Division by zero"))
//         } else {
//             Result.success(a / b)
//         }
//     } catch (e: Exception) {
//         Result.failure(e)
//     }
// }
//
// fun main() {
//     val result1 = safeDivide(10, 2)
//     val result2 = safeDivide(10, 0)
//     
//     result1.onSuccess { value -> println("Result: $value") }
//            .onFailure { error -> println("Error: ${error.message}") }
//    
//     result2.onSuccess { value -> println("Result: $value") }
//            .onFailure { error -> println("Error: ${error.message}") }
// }

//Output:
//Result: 5
//Error: Division by zero
