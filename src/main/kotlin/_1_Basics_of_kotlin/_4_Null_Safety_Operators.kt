package _1_Basics_of_kotlin

// 4. Null Safety Operators

// 4.1 What is Null Safety?
/*
    - Null safety is one of Kotlin's most important features.
    - It helps prevent NullPointerException (NPE) at compile time.
    - In Kotlin, types are non-nullable by default.
    - You must explicitly mark types as nullable using the ? operator.
*/

//Example:
// fun main() {
//     var name: String = "Kotlin"  // Non-nullable String
//     var nullableName: String? = null  // Nullable String
//     
//     println("Name: $name")
//     println("Nullable name: $nullableName")
// }

//Output:
//Name: Kotlin
//Nullable name: null

// 4.2 Safe Call Operator (?.)
/*
    - The safe call operator (?.) allows you to call methods on nullable objects.
    - If the object is null, the expression returns null instead of throwing an exception.
    - It's a safe way to access properties and methods of nullable objects.
*/

//Example:
// fun main() {
//     val name: String? = "Kotlin"
//     val nullName: String? = null
//     
//     // Safe call on non-null value
//     println("Length: ${name?.length}")
//     
//     // Safe call on null value
//     println("Length: ${nullName?.length}")
//     
//     // Chaining safe calls
//     val person: Person? = Person("Alice", 25)
//     println("Person name length: ${person?.name?.length}")
// }
//
// class Person(val name: String, val age: Int)

//Output:
//Length: 6
//Length: null
//Person name length: 5

// 4.3 Elvis Operator (?:)
/*
    - The Elvis operator (?:) provides a default value when the left side is null.
    - It's equivalent to a null check with a fallback value.
    - Very useful for providing default values or handling null cases.
*/

//Example:
// fun main() {
//     val name: String? = null
//     val defaultName = "Anonymous"
//     
//     // Using Elvis operator
//     val displayName = name ?: defaultName
//     println("Display name: $displayName")
//     
//     // Another example
//     val length = name?.length ?: 0
//     println("Name length: $length")
//     
//     // With function calls
//     val result = getName() ?: "No name found"
//     println("Result: $result")
// }
//
// fun getName(): String? {
//     return null  // Simulating a function that might return null
// }

//Output:
//Display name: Anonymous
//Name length: 0
//Result: No name found

// 4.4 Not-null Assertion Operator (!!)
/*
    - The not-null assertion operator (!!) converts a nullable type to non-nullable.
    - It tells the compiler "I'm sure this value is not null."
    - If the value is actually null, it will throw a KotlinNullPointerException.
    - Use with caution - only when you're absolutely certain the value is not null.
*/

//Example:
// fun main() {
//     val name: String? = "Kotlin"
//     val nullName: String? = null
//     
//     // Safe to use with non-null value
//     val length1 = name!!.length
//     println("Length: $length1")
//     
//     // This will throw KotlinNullPointerException
//     try {
//         val length2 = nullName!!.length
//         println("Length: $length2")
//     } catch (e: KotlinNullPointerException) {
//         println("Caught exception: ${e.message}")
//     }
// }

//Output:
//Length: 6
//Caught exception: null

// 4.5 Safe Cast Operator (as?)
/*
    - The safe cast operator (as?) attempts to cast a value to a specific type.
    - If the cast fails, it returns null instead of throwing an exception.
    - It's safer than the regular cast operator (as).
*/

//Example:
// fun main() {
//     val obj: Any = "Hello"
//     val number: Any = 42
//     
//     // Safe cast to String
//     val stringValue = obj as? String
//     println("String value: $stringValue")
//     
//     // Safe cast to Int (will return null)
//     val intValue = obj as? Int
//     println("Int value: $intValue")
//     
//     // Safe cast to Int (will succeed)
//     val intValue2 = number as? Int
//     println("Int value 2: $intValue2")
// }

//Output:
//String value: Hello
//Int value: null
//Int value 2: 42

// 4.6 Let Function with Null Safety
/*
    - The let function is often used with null safety.
    - It executes a block of code only if the object is not null.
    - The object becomes the parameter of the lambda function.
*/

//Example:
// fun main() {
//     val name: String? = "Kotlin"
//     val nullName: String? = null
//     
//     // Using let with non-null value
//     name?.let { 
//         println("Name is not null: $it")
//         println("Length: ${it.length}")
//     }
//     
//     // Using let with null value (block won't execute)
//     nullName?.let { 
//         println("This won't print")
//     }
//     
//     // Chaining with other operations
//     val result = name?.let { it.uppercase() }?.let { "Hello, $it!" }
//     println("Result: $result")
// }

//Output:
//Name is not null: Kotlin
//Length: 6
//Result: Hello, KOTLIN!

// 4.7 Also Function with Null Safety
/*
    - The also function is similar to let but returns the original object.
    - It's useful for performing side effects on nullable objects.
    - The object becomes the parameter of the lambda function.
*/

//Example:
// fun main() {
//     val name: String? = "Kotlin"
//     
//     // Using also with nullable value
//     val result = name?.also { 
//         println("Processing: $it")
//     }?.uppercase()
//     
//     println("Final result: $result")
// }

//Output:
//Processing: Kotlin
//Final result: KOTLIN

// 4.8 TakeIf and TakeUnless Functions
/*
    - takeIf returns the object if it satisfies the given predicate, otherwise null.
    - takeUnless returns the object if it doesn't satisfy the given predicate, otherwise null.
    - Both are useful for conditional operations with null safety.
*/

//Example:
// fun main() {
//     val number: Int? = 42
//     val negativeNumber: Int? = -5
//     
//     // takeIf - returns object if condition is true
//     val positiveNumber = number?.takeIf { it > 0 }
//     println("Positive number: $positiveNumber")
//     
//     val positiveNegative = negativeNumber?.takeIf { it > 0 }
//     println("Positive negative: $positiveNegative")
//     
//     // takeUnless - returns object if condition is false
//     val nonZeroNumber = number?.takeUnless { it == 0 }
//     println("Non-zero number: $nonZeroNumber")
// }

//Output:
//Positive number: 42
//Positive negative: null
//Non-zero number: 42

// 4.9 Null Safety with Collections
/*
    - Collections can contain nullable elements.
    - Use null safety operators when working with nullable collections.
    - Filter out null values when needed.
*/

//Example:
// fun main() {
//     val names: List<String?> = listOf("Alice", null, "Bob", null, "Charlie")
//     
//     // Filter out null values
//     val nonNullNames = names.filterNotNull()
//     println("Non-null names: $nonNullNames")
//     
//     // Safe operations on nullable elements
//     val lengths = names.map { it?.length ?: 0 }
//     println("Lengths: $lengths")
//     
//     // Using let with collections
//     names.forEach { name ->
//         name?.let { 
//             println("Name: $it, Length: ${it.length}")
//         }
//     }
// }

//Output:
//Non-null names: [Alice, Bob, Charlie]
//Lengths: [5, 0, 3, 0, 7]
//Name: Alice, Length: 5
//Name: Bob, Length: 3
//Name: Charlie, Length: 7

// 4.10 Best Practices for Null Safety
/*
    - Prefer nullable types over non-nullable when values can be null.
    - Use safe call operator (?.) instead of not-null assertion (!!) when possible.
    - Use Elvis operator (?:) to provide default values.
    - Use let, also, takeIf, and takeUnless for cleaner null-safe code.
    - Avoid using !! operator unless absolutely necessary.
    - Use filterNotNull() to remove null values from collections.
*/

//Example:
// fun processUser(user: User?) {
//     // Good: Using safe call and Elvis operator
//     val name = user?.name ?: "Unknown"
//     val age = user?.age ?: 0
//     
//     // Good: Using let for null-safe operations
//     user?.let { 
//         println("Processing user: ${it.name}")
//         // Perform operations on non-null user
//     }
//     
//     // Good: Using takeIf for conditional operations
//     val adultUser = user?.takeIf { it.age >= 18 }
//     adultUser?.let { 
//         println("Adult user: ${it.name}")
//     }
// }
//
// data class User(val name: String, val age: Int)
//
// fun main() {
//     val user1 = User("Alice", 25)
//     val user2 = null
//     
//     processUser(user1)
//     processUser(user2)
// }

//Output:
//Processing user: Alice
//Adult user: Alice
