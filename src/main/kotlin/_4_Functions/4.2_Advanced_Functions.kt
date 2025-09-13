package _4_Functions

// 4.2 Advanced Functions

// 4.2.1 Higher-order functions
/*
    - Higher-order functions are functions that take other functions as parameters or return functions.
    - They enable functional programming patterns in Kotlin.
    - Common examples include map, filter, reduce, etc.
*/

//Example:
// fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
//     return operation(a, b)
// }
//
// fun main() {
//     val add = { x: Int, y: Int -> x + y }
//     val multiply = { x: Int, y: Int -> x * y }
//     
//     println("Addition: ${calculate(5, 3, add)}")
//     println("Multiplication: ${calculate(5, 3, multiply)}")
// }

//Output:
//Addition: 8
//Multiplication: 15

// 4.2.2 Lambda expressions
/*
    - Lambda expressions are anonymous functions that can be passed as arguments.
    - They are defined using curly braces {} and the arrow operator ->.
    - They can capture variables from their surrounding scope.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     
//     // Lambda to double each number
//     val doubled = numbers.map { it * 2 }
//     println("Doubled: $doubled")
//     
//     // Lambda to filter even numbers
//     val evens = numbers.filter { it % 2 == 0 }
//     println("Even numbers: $evens")
// }

//Output:
//Doubled: [2, 4, 6, 8, 10]
//Even numbers: [2, 4]

// 4.2.3 Function references
/*
    - Function references allow you to pass existing functions as arguments.
    - Use the :: operator to create a reference to a function.
    - This is useful when you want to pass a function without calling it.
*/

//Example:
// fun isEven(number: Int): Boolean = number % 2 == 0
// fun isOdd(number: Int): Boolean = number % 2 != 0
//
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     
//     val evens = numbers.filter(::isEven)
//     val odds = numbers.filter(::isOdd)
//     
//     println("Even numbers: $evens")
//     println("Odd numbers: $odds")
// }

//Output:
//Even numbers: [2, 4]
//Odd numbers: [1, 3, 5]

// 4.2.4 Inline functions
/*
    - Inline functions are functions marked with the 'inline' keyword.
    - The function body is copied directly to the call site, reducing function call overhead.
    - Useful for higher-order functions to improve performance.
*/

//Example:
// inline fun measureTime(block: () -> Unit) {
//     val start = System.currentTimeMillis()
//     block()
//     val end = System.currentTimeMillis()
//     println("Execution time: ${end - start} ms")
// }
//
// fun main() {
//     measureTime {
//         // Some computation
//         Thread.sleep(100)
//     }
// }

//Output:
//Execution time: 100 ms

// 4.2.5 Extension functions
/*
    - Extension functions allow you to add new functionality to existing classes.
    - They are defined outside the class but can be called as if they were methods.
    - They don't modify the original class.
*/

//Example:
// fun String.isEmail(): Boolean {
//     return this.contains("@") && this.contains(".")
// }
//
// fun main() {
//     val email = "user@example.com"
//     val notEmail = "notanemail"
//     
//     println("$email is email: ${email.isEmail()}")
//     println("$notEmail is email: ${notEmail.isEmail()}")
// }

//Output:
//user@example.com is email: true
//notanemail is email: false

// 4.2.6 Infix functions
/*
    - Infix functions allow you to call functions using infix notation.
    - They must be member functions or extension functions with a single parameter.
    - They make code more readable for certain operations.
*/

//Example:
// infix fun Int.power(exponent: Int): Int {
//     return Math.pow(this.toDouble(), exponent.toDouble()).toInt()
// }
//
// fun main() {
//     val result = 2 power 3
//     println("2 to the power of 3: $result")
// }

//Output:
//2 to the power of 3: 8

// 4.2.7 Operator overloading
/*
    - Operator overloading allows you to define custom behavior for operators.
    - You can override operators like +, -, *, /, etc. for your classes.
    - Use the 'operator' keyword to mark functions for operator overloading.
*/

//Example:
// data class Point(val x: Int, val y: Int) {
//     operator fun plus(other: Point): Point {
//         return Point(x + other.x, y + other.y)
//     }
// }
//
// fun main() {
//     val point1 = Point(1, 2)
//     val point2 = Point(3, 4)
//     val result = point1 + point2
//     println("Result: $result")
// }

//Output:
//Result: Point(x=4, y=6)

// 4.2.8 Tail recursive functions
/*
    - Tail recursive functions are optimized by the compiler to avoid stack overflow.
    - Use the 'tailrec' keyword to mark functions as tail recursive.
    - The recursive call must be the last operation in the function.
*/

//Example:
// tailrec fun factorial(n: Int, acc: Int = 1): Int {
//     return if (n <= 1) acc else factorial(n - 1, n * acc)
// }
//
// fun main() {
//     println("Factorial of 5: ${factorial(5)}")
// }

//Output:
//Factorial of 5: 120

// 4.2.9 Local functions
/*
    - Local functions are functions defined inside other functions.
    - They have access to the variables of the enclosing function.
    - They help in organizing code and reducing duplication.
*/

//Example:
// fun processNumbers(numbers: List<Int>) {
//     fun isPositive(n: Int): Boolean = n > 0
//     fun square(n: Int): Int = n * n
//     
//     val positiveSquares = numbers
//         .filter(::isPositive)
//         .map(::square)
//     
//     println("Positive squares: $positiveSquares")
// }
//
// fun main() {
//     val numbers = listOf(-2, -1, 0, 1, 2, 3)
//     processNumbers(numbers)
// }

//Output:
//Positive squares: [1, 4, 9]
