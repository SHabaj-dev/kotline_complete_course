package _3_Loops_and_Iteration

// 3.1 For Loops

// 3.1.1 Basic for loop with range
/*
    - for loop is used to iterate over a range of values.
    - The range can be created using the .. operator or rangeTo() function.
*/

//Example:
// fun main() {
//     for (i in 1..5) {
//         println("Number: $i")
//     }
// }

//Output:
//Number: 1
//Number: 2
//Number: 3
//Number: 4
//Number: 5

// 3.1.2 For loop with step
/*
    - step is used to specify the increment value in a for loop.
    - By default, step is 1, but you can specify any positive integer.
*/

//Example:
// fun main() {
//     for (i in 1..10 step 2) {
//         println("Odd numbers: $i")
//     }
// }

//Output:
//Odd numbers: 1
//Odd numbers: 3
//Odd numbers: 5
//Odd numbers: 7
//Odd numbers: 9

// 3.1.3 For loop with downTo
/*
    - downTo is used to iterate in reverse order.
    - It creates a range from a higher value to a lower value.
*/

//Example:
// fun main() {
//     for (i in 10 downTo 1) {
//         println("Countdown: $i")
//     }
// }

//Output:
//Countdown: 10
//Countdown: 9
//Countdown: 8
//Countdown: 7
//Countdown: 6
//Countdown: 5
//Countdown: 4
//Countdown: 3
//Countdown: 2
//Countdown: 1

// 3.1.4 For loop with until
/*
    - until is used to create a range that excludes the upper bound.
    - It's equivalent to using .. with the upper bound minus 1.
*/

//Example:
// fun main() {
//     for (i in 1 until 5) {
//         println("Number: $i")
//     }
// }

//Output:
//Number: 1
//Number: 2
//Number: 3
//Number: 4

// 3.1.5 For loop with collections
/*
    - for loop can iterate over collections like lists, arrays, etc.
    - It automatically handles the iteration without needing indices.
*/

//Example:
// fun main() {
//     val fruits = listOf("Apple", "Banana", "Orange", "Grape")
//     
//     for (fruit in fruits) {
//         println("Fruit: $fruit")
//     }
// }

//Output:
//Fruit: Apple
//Fruit: Banana
//Fruit: Orange
//Fruit: Grape

// 3.1.6 For loop with indices
/*
    - You can get both the index and value when iterating over collections.
    - Use withIndex() function or indices property.
*/

//Example:
// fun main() {
//     val colors = listOf("Red", "Green", "Blue", "Yellow")
//     
//     // Using withIndex()
//     for ((index, color) in colors.withIndex()) {
//         println("Index $index: $color")
//     }
//     
//     // Using indices
//     for (i in colors.indices) {
//         println("Index $i: ${colors[i]}")
//     }
// }

//Output:
//Index 0: Red
//Index 1: Green
//Index 2: Blue
//Index 3: Yellow

// 3.1.7 For loop with maps
/*
    - for loop can iterate over maps to get key-value pairs.
    - Use destructuring to separate keys and values.
*/

//Example:
// fun main() {
//     val capitals = mapOf(
//         "USA" to "Washington D.C.",
//         "France" to "Paris",
//         "Japan" to "Tokyo"
//     )
//     
//     for ((country, capital) in capitals) {
//         println("$capital is the capital of $country")
//     }
// }

//Output:
//Washington D.C. is the capital of USA
//Paris is the capital of France
//Tokyo is the capital of Japan

// 3.1.8 Nested for loops
/*
    - You can have for loops inside other for loops.
    - This is useful for working with 2D arrays or nested data structures.
*/

//Example:
// fun main() {
//     for (i in 1..3) {
//         for (j in 1..3) {
//             print("($i,$j) ")
//         }
//         println()
//     }
// }

//Output:
//(1,1) (1,2) (1,3)
//(2,1) (2,2) (2,3)
//(3,1) (3,2) (3,3)
