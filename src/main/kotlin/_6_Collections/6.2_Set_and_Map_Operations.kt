package _6_Collections

// 6.2 Set and Map Operations

// 6.2.1 Set operations
/*
    - Sets are collections that contain unique elements.
    - Sets can be mutable or immutable.
    - Use setOf() for immutable sets and mutableSetOf() for mutable sets.
*/

//Example:
// fun main() {
//     // Immutable set
//     val immutableSet = setOf("apple", "banana", "orange", "apple")
//     println("Immutable set: $immutableSet")  // Duplicates are removed
//     
//     // Mutable set
//     val mutableSet = mutableSetOf("red", "green", "blue")
//     mutableSet.add("yellow")
//     mutableSet.add("red")  // Won't add duplicate
//     println("Mutable set: $mutableSet")
// }

//Output:
//Immutable set: [apple, banana, orange]
//Mutable set: [red, green, blue, yellow]

// 6.2.2 Set operations (union, intersection, difference)
/*
    - Sets support mathematical operations like union, intersection, and difference.
    - union() combines two sets.
    - intersect() finds common elements.
    - subtract() removes elements from one set that are in another.
*/

//Example:
// fun main() {
//     val set1 = setOf(1, 2, 3, 4, 5)
//     val set2 = setOf(4, 5, 6, 7, 8)
//     
//     val union = set1.union(set2)
//     val intersection = set1.intersect(set2)
//     val difference = set1.subtract(set2)
//     
//     println("Set1: $set1")
//     println("Set2: $set2")
//     println("Union: $union")
//     println("Intersection: $intersection")
//     println("Difference: $difference")
// }

//Output:
//Set1: [1, 2, 3, 4, 5]
//Set2: [4, 5, 6, 7, 8]
//Union: [1, 2, 3, 4, 5, 6, 7, 8]
//Intersection: [4, 5]
//Difference: [1, 2, 3]

// 6.2.3 Map creation and access
/*
    - Maps store key-value pairs.
    - Keys must be unique, values can be duplicated.
    - Use mapOf() for immutable maps and mutableMapOf() for mutable maps.
*/

//Example:
// fun main() {
//     // Immutable map
//     val immutableMap = mapOf(
//         "name" to "Alice",
//         "age" to 25,
//         "city" to "New York"
//     )
//     println("Immutable map: $immutableMap")
//     
//     // Mutable map
//     val mutableMap = mutableMapOf<String, Int>()
//     mutableMap["apple"] = 5
//     mutableMap["banana"] = 3
//     mutableMap["orange"] = 8
//     println("Mutable map: $mutableMap")
//     
//     // Access values
//     println("Name: ${immutableMap["name"]}")
//     println("Apple count: ${mutableMap["apple"]}")
// }

//Output:
//Immutable map: {name=Alice, age=25, city=New York}
//Mutable map: {apple=5, banana=3, orange=8}
//Name: Alice
//Apple count: 5

// 6.2.4 Map operations
/*
    - Maps support various operations for manipulation and querying.
    - put() and remove() for adding and removing entries.
    - containsKey() and containsValue() for checking existence.
*/

//Example:
// fun main() {
//     val inventory = mutableMapOf(
//         "laptop" to 10,
//         "mouse" to 25,
//         "keyboard" to 15
//     )
//     
//     // Add new item
//     inventory["monitor"] = 5
//     
//     // Update existing item
//     inventory["laptop"] = 8
//     
//     // Remove item
//     inventory.remove("mouse")
//     
//     // Check existence
//     println("Has laptop: ${inventory.containsKey("laptop")}")
//     println("Has 10 items: ${inventory.containsValue(10)}")
//     
//     println("Updated inventory: $inventory")
// }

//Output:
//Has laptop: true
//Has 10 items: false
//Updated inventory: {laptop=8, keyboard=15, monitor=5}

// 6.2.5 Map iteration
/*
    - Maps can be iterated in various ways.
    - Iterate over keys, values, or entries.
    - Use destructuring to separate keys and values.
*/

//Example:
// fun main() {
//     val scores = mapOf(
//         "Alice" to 95,
//         "Bob" to 87,
//         "Charlie" to 92,
//         "Diana" to 88
//     )
//     
//     // Iterate over entries
//     println("All scores:")
//     for ((name, score) in scores) {
//         println("$name: $score")
//     }
//     
//     // Iterate over keys
//     println("\nAll names:")
//     for (name in scores.keys) {
//         println(name)
//     }
//     
//     // Iterate over values
//     println("\nAll scores:")
//     for (score in scores.values) {
//         println(score)
//     }
// }

//Output:
//All scores:
//Alice: 95
//Bob: 87
//Charlie: 92
//Diana: 88
//
//All names:
//Alice
//Bob
//Charlie
//Diana
//
//All scores:
//95
//87
//92
//88

// 6.2.6 Map filtering and transformation
/*
    - Maps support filtering and transformation operations.
    - filterKeys() and filterValues() for filtering.
    - mapKeys() and mapValues() for transformation.
*/

//Example:
// fun main() {
//     val studentGrades = mapOf(
//         "Alice" to 95,
//         "Bob" to 87,
//         "Charlie" to 92,
//         "Diana" to 88,
//         "Eve" to 76
//     )
//     
//     // Filter high grades
//     val highGrades = studentGrades.filterValues { it >= 90 }
//     println("High grades: $highGrades")
//     
//     // Filter by name length
//     val shortNames = studentGrades.filterKeys { it.length <= 4 }
//     println("Short names: $shortNames")
//     
//     // Transform values to letter grades
//     val letterGrades = studentGrades.mapValues { (_, score) ->
//         when {
//             score >= 90 -> "A"
//             score >= 80 -> "B"
//             score >= 70 -> "C"
//             else -> "F"
//         }
//     }
//     println("Letter grades: $letterGrades")
// }

//Output:
//High grades: {Alice=95, Charlie=92}
//Short names: {Bob=87, Eve=76}
//Letter grades: {Alice=A, Bob=B, Charlie=A, Diana=B, Eve=C}

// 6.2.7 Map grouping and aggregation
/*
    - Maps can be grouped and aggregated in various ways.
    - groupBy() groups entries by a key function.
    - associateBy() creates a map with unique keys.
*/

//Example:
// fun main() {
//     val students = listOf(
//         "Alice" to "Math",
//         "Bob" to "Science",
//         "Charlie" to "Math",
//         "Diana" to "English",
//         "Eve" to "Science"
//     )
//     
//     // Group by subject
//     val bySubject = students.groupBy { it.second }
//     println("By subject: $bySubject")
//     
//     // Associate by name (unique key)
//     val byName = students.associateBy { it.first }
//     println("By name: $byName")
//     
//     // Count by subject
//     val subjectCount = students.groupingBy { it.second }.eachCount()
//     println("Subject count: $subjectCount")
// }

//Output:
//By subject: {Math=[(Alice, Math), (Charlie, Math)], Science=[(Bob, Science), (Eve, Science)], English=[(Diana, English)]}
//By name: {Alice=(Alice, Math), Bob=(Bob, Science), Charlie=(Charlie, Math), Diana=(Diana, English), Eve=(Eve, Science)}
//Subject count: {Math=2, Science=2, English=1}

// 6.2.8 Collection conversion
/*
    - Collections can be converted between different types.
    - toList(), toSet(), toMap() for conversion.
    - distinct() removes duplicates from lists.
*/

//Example:
// fun main() {
//     val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 5)
//     
//     // Convert to set (removes duplicates)
//     val uniqueNumbers = numbers.toSet()
//     println("Unique numbers: $uniqueNumbers")
//     
//     // Convert to map with index as key
//     val indexedMap = numbers.mapIndexed { index, value -> index to value }.toMap()
//     println("Indexed map: $indexedMap")
//     
//     // Remove duplicates from list
//     val distinctNumbers = numbers.distinct()
//     println("Distinct numbers: $distinctNumbers")
// }

//Output:
//Unique numbers: [1, 2, 3, 4, 5]
//Indexed map: {0=1, 1=2, 2=2, 3=3, 4=3, 5=3, 6=4, 7=5}
//Distinct numbers: [1, 2, 3, 4, 5]
