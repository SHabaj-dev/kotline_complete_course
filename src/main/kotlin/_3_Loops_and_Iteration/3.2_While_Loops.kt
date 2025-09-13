package _3_Loops_and_Iteration

// 3.2 While Loops

// 3.2.1 Basic while loop
/*
    - while loop executes a block of code as long as a condition is true.
    - The condition is checked before each iteration.
    - If the condition is false initially, the loop body won't execute at all.
*/

//Example:
// fun main() {
//     var count = 1
//     while (count <= 5) {
//         println("Count: $count")
//         count++
//     }
// }

//Output:
//Count: 1
//Count: 2
//Count: 3
//Count: 4
//Count: 5

// 3.2.2 do-while loop
/*
    - do-while loop executes the block of code at least once.
    - The condition is checked after each iteration.
    - Even if the condition is false initially, the loop body executes once.
*/

//Example:
// fun main() {
//     var number = 10
//     do {
//         println("Number: $number")
//         number++
//     } while (number <= 5)
// }

//Output:
//Number: 10

// 3.2.3 while loop with user input
/*
    - while loops are commonly used for user input validation.
    - Continue looping until valid input is provided.
*/

//Example:
// fun main() {
//     var userInput: String?
//     do {
//         print("Enter 'quit' to exit: ")
//         userInput = readLine()
//         println("You entered: $userInput")
//     } while (userInput != "quit")
// }

//Output:
//Enter 'quit' to exit: hello
//You entered: hello
//Enter 'quit' to exit: quit
//You entered: quit

// 3.2.4 while loop with break
/*
    - break statement is used to exit a loop immediately.
    - It's useful when you want to stop the loop based on a condition inside the loop body.
*/

//Example:
// fun main() {
//     var i = 1
//     while (i <= 10) {
//         if (i == 5) {
//             break
//         }
//         println("Number: $i")
//         i++
//     }
// }

//Output:
//Number: 1
//Number: 2
//Number: 3
//Number: 4

// 3.2.5 while loop with continue
/*
    - continue statement is used to skip the current iteration and continue with the next one.
    - It's useful when you want to skip certain iterations based on a condition.
*/

//Example:
// fun main() {
//     var i = 1
//     while (i <= 10) {
//         if (i % 2 == 0) {
//             i++
//             continue
//         }
//         println("Odd number: $i")
//         i++
//     }
// }

//Output:
//Odd number: 1
//Odd number: 3
//Odd number: 5
//Odd number: 7
//Odd number: 9

// 3.2.6 while loop with multiple conditions
/*
    - while loops can have complex conditions using logical operators.
    - Multiple conditions can be combined using && (AND) or || (OR).
*/

//Example:
// fun main() {
//     var temperature = 20
//     var isHeating = true
//     
//     while (temperature < 30 && isHeating) {
//         println("Temperature: ${temperature}°C")
//         temperature += 2
//         
//         if (temperature >= 28) {
//             isHeating = false
//         }
//     }
//     println("Final temperature: ${temperature}°C")
// }

//Output:
//Temperature: 20°C
//Temperature: 22°C
//Temperature: 24°C
//Temperature: 26°C
//Final temperature: 28°C

// 3.2.7 Infinite while loop
/*
    - An infinite while loop runs forever until explicitly stopped.
    - Use break statement or return to exit from infinite loops.
    - Be careful with infinite loops as they can cause your program to hang.
*/

//Example:
// fun main() {
//     var counter = 0
//     while (true) {
//         counter++
//         println("Counter: $counter")
//         
//         if (counter >= 5) {
//             break
//         }
//     }
// }

//Output:
//Counter: 1
//Counter: 2
//Counter: 3
//Counter: 4
//Counter: 5

// 3.2.8 while loop with collections
/*
    - while loops can be used to iterate over collections using indices.
    - This is useful when you need more control over the iteration process.
*/

//Example:
// fun main() {
//     val numbers = listOf(10, 20, 30, 40, 50)
//     var index = 0
//     
//     while (index < numbers.size) {
//         println("Index $index: ${numbers[index]}")
//         index++
//     }
// }

//Output:
//Index 0: 10
//Index 1: 20
//Index 2: 30
//Index 3: 40
//Index 4: 50
