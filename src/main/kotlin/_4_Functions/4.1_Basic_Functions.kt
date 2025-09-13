package _4_Functions

// 4.1 Basic Functions

// 4.1.1 Function declaration and definition
/*
    - Functions are reusable blocks of code that perform a specific task.
    - Functions help in organizing code and avoiding repetition.
    - In Kotlin, functions are declared using the 'fun' keyword.
*/

//Example:
// fun greet() {
//     println("Hello, World!")
// }
//
// fun main() {
//     greet()
// }

//Output:
//Hello, World!

// 4.1.2 Functions with parameters
/*
    - Functions can accept parameters (inputs) to make them more flexible.
    - Parameters are declared inside parentheses after the function name.
    - Each parameter has a name and a type.
*/

//Example:
// fun greet(name: String) {
//     println("Hello, $name!")
// }
//
// fun main() {
//     greet("Alice")
//     greet("Bob")
// }

//Output:
//Hello, Alice!
//Hello, Bob!

// 4.1.3 Functions with multiple parameters
/*
    - Functions can have multiple parameters separated by commas.
    - Each parameter must have a unique name and a specified type.
*/

//Example:
// fun add(a: Int, b: Int) {
//     val result = a + b
//     println("$a + $b = $result")
// }
//
// fun main() {
//     add(5, 3)
//     add(10, 20)
// }

//Output:
//5 + 3 = 8
//10 + 20 = 30

// 4.1.4 Functions with return values
/*
    - Functions can return values using the 'return' keyword.
    - The return type is specified after the parameter list using a colon.
    - If no return type is specified, it defaults to 'Unit' (equivalent to void).
*/

//Example:
// fun add(a: Int, b: Int): Int {
//     return a + b
// }
//
// fun main() {
//     val result = add(5, 3)
//     println("Result: $result")
// }

//Output:
//Result: 8

// 4.1.5 Single expression functions
/*
    - When a function contains only a single expression, you can use the '=' operator.
    - The return type can be inferred automatically.
    - The 'return' keyword is not needed.
*/

//Example:
// fun multiply(a: Int, b: Int) = a * b
//
// fun main() {
//     val result = multiply(4, 5)
//     println("Result: $result")
// }

//Output:
//Result: 20

// 4.1.6 Functions with default parameters
/*
    - Parameters can have default values.
    - If no argument is provided, the default value is used.
    - Default parameters make functions more flexible.
*/

//Example:
// fun greet(name: String, greeting: String = "Hello") {
//     println("$greeting, $name!")
// }
//
// fun main() {
//     greet("Alice")                    // Uses default greeting
//     greet("Bob", "Hi")               // Uses custom greeting
// }

//Output:
//Hello, Alice!
//Hi, Bob!

// 4.1.7 Named parameters
/*
    - You can specify parameter names when calling functions.
    - Named parameters make function calls more readable.
    - You can change the order of parameters when using named parameters.
*/

//Example:
// fun createUser(name: String, age: Int, email: String) {
//     println("User: $name, Age: $age, Email: $email")
// }
//
// fun main() {
//     createUser("Alice", 25, "alice@example.com")
//     createUser(name = "Bob", email = "bob@example.com", age = 30)
// }

//Output:
//User: Alice, Age: 25, Email: alice@example.com
//User: Bob, Age: 30, Email: bob@example.com

// 4.1.8 Functions with vararg parameters
/*
    - vararg allows a function to accept a variable number of arguments.
    - The arguments are treated as an array inside the function.
    - Only one vararg parameter is allowed per function.
*/

//Example:
// fun sum(vararg numbers: Int): Int {
//     var total = 0
//     for (number in numbers) {
//         total += number
//     }
//     return total
// }
//
// fun main() {
//     println("Sum: ${sum(1, 2, 3)}")
//     println("Sum: ${sum(1, 2, 3, 4, 5)}")
// }

//Output:
//Sum: 6
//Sum: 15

// 4.1.9 Function scope and visibility
/*
    - Functions can be declared at different levels (top-level, inside classes, etc.).
    - Top-level functions are accessible from anywhere in the same package.
    - Functions inside classes are accessible based on their visibility modifiers.
*/

//Example:
// // Top-level function
// fun topLevelFunction() {
//     println("This is a top-level function")
// }
//
// fun main() {
//     topLevelFunction()
// }

//Output:
//This is a top-level function
