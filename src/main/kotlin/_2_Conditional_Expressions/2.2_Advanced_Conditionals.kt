package _2_Conditional_Expressions

// 2. Advanced Conditionals

// 2.1 Nested if-else
/*
    - Nested if-else is when you have an if-else statement inside another if-else statement.
    - This allows you to check multiple conditions in a hierarchical manner.
*/

//Example:
// fun main() {
//     val age = 25
//     val hasLicense = true
//     
//     if (age >= 18) {
//         if (hasLicense) {
//             println("You can drive")
//         } else {
//             println("You need a license to drive")
//         }
//     } else {
//         println("You are too young to drive")
//     }
// }

//Output:
//You can drive

// 2.2 if-else if-else ladder
/*
    - if-else if-else ladder is used when you have multiple conditions to check.
    - Only one block of code will be executed based on the first true condition.
*/

//Example:
// fun main() {
//     val score = 85
//     
//     if (score >= 90) {
//         println("Grade: A")
//     } else if (score >= 80) {
//         println("Grade: B")
//     } else if (score >= 70) {
//         println("Grade: C")
//     } else if (score >= 60) {
//         println("Grade: D")
//     } else {
//         println("Grade: F")
//     }
// }

//Output:
//Grade: B

// 2.3 when as expression
/*
    - when can be used as an expression that returns a value.
    - The value of the matching branch becomes the value of the entire expression.
*/

//Example:
// fun main() {
//     val day = 3
//     val dayName = when (day) {
//         1 -> "Monday"
//         2 -> "Tuesday"
//         3 -> "Wednesday"
//         4 -> "Thursday"
//         5 -> "Friday"
//         6 -> "Saturday"
//         7 -> "Sunday"
//         else -> "Invalid day"
//     }
//     println("Day $day is $dayName")
// }

//Output:
//Day 3 is Wednesday

// 2.4 when with ranges
/*
    - when can be used with ranges using the 'in' operator.
    - This is useful for checking if a value falls within a specific range.
*/

//Example:
// fun main() {
//     val temperature = 25
//     val weather = when (temperature) {
//         in -10..0 -> "Freezing"
//         in 1..10 -> "Cold"
//         in 11..20 -> "Cool"
//         in 21..30 -> "Warm"
//         in 31..40 -> "Hot"
//         else -> "Extreme"
//     }
//     println("Temperature $temperature°C is $weather")
// }

//Output:
//Temperature 25°C is Warm

// 2.5 when with multiple conditions
/*
    - when can check multiple conditions using commas.
    - If any of the conditions match, that branch will be executed.
*/

//Example:
// fun main() {
//     val grade = 'B'
//     val result = when (grade) {
//         'A', 'B' -> "Excellent"
//         'C', 'D' -> "Good"
//         'F' -> "Fail"
//         else -> "Invalid grade"
//     }
//     println("Grade $grade is $result")
// }

//Output:
//Grade B is Excellent

// 2.6 when without argument
/*
    - when can be used without an argument, acting like a series of if-else statements.
    - Each condition is evaluated as a boolean expression.
*/

//Example:
// fun main() {
//     val x = 10
//     val y = 20
//     
//     when {
//         x > y -> println("x is greater than y")
//         x < y -> println("x is less than y")
//         else -> println("x is equal to y")
//     }
// }

//Output:
//x is less than y

// 2.7 Smart casting with when
/*
    - when can be used with smart casting to automatically cast types.
    - This is useful when working with sealed classes or type checking.
*/

//Example:
// fun main() {
//     val obj: Any = "Hello"
//     
//     when (obj) {
//         is String -> println("String length: ${obj.length}")
//         is Int -> println("Integer value: $obj")
//         is Boolean -> println("Boolean value: $obj")
//         else -> println("Unknown type")
//     }
// }

//Output:
//String length: 5
