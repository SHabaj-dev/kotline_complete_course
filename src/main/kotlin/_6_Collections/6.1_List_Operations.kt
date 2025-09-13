package _6_Collections

// 6.1 List Operations

// 6.1.1 Creating lists
/*
    - Lists are ordered collections that can contain duplicate elements.
    - Lists can be mutable or immutable.
    - Use listOf() for immutable lists and mutableListOf() for mutable lists.
*/

//Example:
// fun main() {
//     // Immutable list
//     val immutableList = listOf("apple", "banana", "orange")
//     println("Immutable list: $immutableList")
//     
//     // Mutable list
//     val mutableList = mutableListOf("red", "green", "blue")
//     mutableList.add("yellow")
//     println("Mutable list: $mutableList")
// }

//Output:
//Immutable list: [apple, banana, orange]
//Mutable list: [red, green, blue, yellow]

// 6.1.2 List access and modification
/*
    - Lists support indexed access using square brackets.
    - Mutable lists can be modified by adding, removing, or updating elements.
    - Use get() and set() methods for safe access.
*/

//Example:
// fun main() {
//     val numbers = mutableListOf(1, 2, 3, 4, 5)
//     
//     // Access elements
//     println("First element: ${numbers[0]}")
//     println("Last element: ${numbers.last()}")
//     
//     // Modify elements
//     numbers[0] = 10
//     numbers.add(6)
//     numbers.removeAt(1)
//     
//     println("Modified list: $numbers")
// }

//Output:
//First element: 1
//Last element: 5
//Modified list: [10, 3, 4, 5, 6]

// 6.1.3 List filtering
/*
    - Filtering allows you to create new lists based on conditions.
    - filter() creates a new list with elements that match the condition.
    - filterNot() creates a new list with elements that don't match the condition.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//     
//     val evens = numbers.filter { it % 2 == 0 }
//     val odds = numbers.filterNot { it % 2 == 0 }
//     val greaterThan5 = numbers.filter { it > 5 }
//     
//     println("Even numbers: $evens")
//     println("Odd numbers: $odds")
//     println("Numbers greater than 5: $greaterThan5")
// }

//Output:
//Even numbers: [2, 4, 6, 8, 10]
//Odd numbers: [1, 3, 5, 7, 9]
//Numbers greater than 5: [6, 7, 8, 9, 10]

// 6.1.4 List mapping
/*
    - Mapping transforms each element in a list using a function.
    - map() creates a new list with transformed elements.
    - mapIndexed() provides both index and element to the transformation function.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     
//     val doubled = numbers.map { it * 2 }
//     val squared = numbers.map { it * it }
//     val withIndex = numbers.mapIndexed { index, value -> "Index $index: $value" }
//     
//     println("Doubled: $doubled")
//     println("Squared: $squared")
//     println("With index: $withIndex")
// }

//Output:
//Doubled: [2, 4, 6, 8, 10]
//Squared: [1, 4, 9, 16, 25]
//With index: [Index 0: 1, Index 1: 2, Index 2: 3, Index 3: 4, Index 4: 5]

// 6.1.5 List reduction and folding
/*
    - Reduction operations combine all elements in a list into a single value.
    - reduce() starts with the first element and combines with the next.
    - fold() starts with an initial value and combines with each element.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     
//     val sum = numbers.reduce { acc, element -> acc + element }
//     val product = numbers.fold(1) { acc, element -> acc * element }
//     val concatenated = numbers.fold("") { acc, element -> acc + element.toString() }
//     
//     println("Sum: $sum")
//     println("Product: $product")
//     println("Concatenated: $concatenated")
// }

//Output:
//Sum: 15
//Product: 120
//Concatenated: 12345

// 6.1.6 List sorting
/*
    - Lists can be sorted in various ways.
    - sorted() creates a new sorted list in ascending order.
    - sortedDescending() creates a new sorted list in descending order.
    - sortedBy() sorts by a specific property or transformation.
*/

//Example:
// fun main() {
//     val numbers = listOf(5, 2, 8, 1, 9, 3)
//     val words = listOf("banana", "apple", "cherry", "date")
//     
//     val ascending = numbers.sorted()
//     val descending = numbers.sortedDescending()
//     val byLength = words.sortedBy { it.length }
//     val byLengthDesc = words.sortedByDescending { it.length }
//     
//     println("Ascending: $ascending")
//     println("Descending: $descending")
//     println("By length: $byLength")
//     println("By length desc: $byLengthDesc")
// }

//Output:
//Ascending: [1, 2, 3, 5, 8, 9]
//Descending: [9, 8, 5, 3, 2, 1]
//By length: [date, apple, banana, cherry]
//By length desc: [banana, cherry, apple, date]

// 6.1.7 List grouping and partitioning
/*
    - Grouping allows you to group elements by a key.
    - Partitioning splits a list into two lists based on a condition.
    - groupBy() groups elements by a key function.
*/

//Example:
// fun main() {
//     val words = listOf("apple", "banana", "cherry", "date", "elderberry")
//     
//     val byLength = words.groupBy { it.length }
//     val byFirstLetter = words.groupBy { it.first() }
//     val (longWords, shortWords) = words.partition { it.length > 5 }
//     
//     println("By length: $byLength")
//     println("By first letter: $byFirstLetter")
//     println("Long words: $longWords")
//     println("Short words: $shortWords")
// }

//Output:
//By length: {5=[apple, cherry], 6=[banana], 4=[date], 10=[elderberry]}
//By first letter: {a=[apple], b=[banana], c=[cherry], d=[date], e=[elderberry]}
//Long words: [banana, cherry, elderberry]
//Short words: [apple, date]

// 6.1.8 List searching and checking
/*
    - Various methods help you search and check conditions in lists.
    - find() returns the first element matching a condition.
    - any() checks if any element matches a condition.
    - all() checks if all elements match a condition.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//     
//     val firstEven = numbers.find { it % 2 == 0 }
//     val hasEven = numbers.any { it % 2 == 0 }
//     val allPositive = numbers.all { it > 0 }
//     val countEven = numbers.count { it % 2 == 0 }
//     
//     println("First even: $firstEven")
//     println("Has even: $hasEven")
//     println("All positive: $allPositive")
//     println("Count even: $countEven")
// }

//Output:
//First even: 2
//Has even: true
//All positive: true
//Count even: 5
