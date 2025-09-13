package _8_Advanced_Kotlin_Features

// 8.1 Generics

// 8.1.1 What are generics?
/*
    - Generics allow you to write code that works with different types.
    - They provide type safety at compile time.
    - Generics help avoid code duplication and improve code reusability.
    - They are commonly used in collections, functions, and classes.
*/

//Example:
// fun <T> printItem(item: T) {
//     println("Item: $item")
// }
//
// fun main() {
//     printItem("Hello")
//     printItem(42)
//     printItem(3.14)
// }

//Output:
//Item: Hello
//Item: 42
//Item: 3.14

// 8.1.2 Generic classes
/*
    - Generic classes can work with different types.
    - Type parameters are specified in angle brackets.
    - The same class can be instantiated with different types.
*/

//Example:
// class Box<T>(private var item: T) {
//     fun getItem(): T = item
//     fun setItem(newItem: T) {
//         item = newItem
//     }
// }
//
// fun main() {
//     val stringBox = Box("Hello")
//     val intBox = Box(42)
//     
//     println("String box: ${stringBox.getItem()}")
//     println("Int box: ${intBox.getItem()}")
// }

//Output:
//String box: Hello
//Int box: 42

// 8.1.3 Generic functions
/*
    - Generic functions can work with different types.
    - Type parameters are specified before the function name.
    - The compiler infers the type from the arguments.
*/

//Example:
// fun <T> swap(list: MutableList<T>, index1: Int, index2: Int) {
//     val temp = list[index1]
//     list[index1] = list[index2]
//     list[index2] = temp
// }
//
// fun main() {
//     val numbers = mutableListOf(1, 2, 3, 4, 5)
//     val words = mutableListOf("apple", "banana", "cherry")
//     
//     swap(numbers, 0, 4)
//     swap(words, 0, 2)
//     
//     println("Numbers: $numbers")
//     println("Words: $words")
// }

//Output:
//Numbers: [5, 2, 3, 4, 1]
//Words: [cherry, banana, apple]

// 8.1.4 Generic constraints
/*
    - Generic constraints limit the types that can be used.
    - Use 'where' clause or type bounds to specify constraints.
    - Common constraints include Comparable, Number, etc.
*/

//Example:
// fun <T : Comparable<T>> findMax(list: List<T>): T? {
//     if (list.isEmpty()) return null
//     
//     var max = list[0]
//     for (item in list) {
//         if (item > max) {
//             max = item
//         }
//     }
//     return max
// }
//
// fun main() {
//     val numbers = listOf(1, 5, 3, 9, 2)
//     val words = listOf("apple", "banana", "cherry")
//     
//     println("Max number: ${findMax(numbers)}")
//     println("Max word: ${findMax(words)}")
// }

//Output:
//Max number: 9
//Max word: cherry

// 8.1.5 Multiple type parameters
/*
    - Classes and functions can have multiple type parameters.
    - Each type parameter is independent and can have different constraints.
    - Use commas to separate multiple type parameters.
*/

//Example:
// class Pair<T, U>(val first: T, val second: U) {
//     fun swap(): Pair<U, T> = Pair(second, first)
// }
//
// fun <T, U> createPair(first: T, second: U): Pair<T, U> {
//     return Pair(first, second)
// }
//
// fun main() {
//     val pair1 = createPair("Hello", 42)
//     val pair2 = createPair(3.14, true)
//     
//     println("Pair1: ${pair1.first}, ${pair1.second}")
//     println("Pair2: ${pair2.first}, ${pair2.second}")
//     
//     val swapped = pair1.swap()
//     println("Swapped: ${swapped.first}, ${swapped.second}")
// }

//Output:
//Pair1: Hello, 42
//Pair2: 3.14, true
//Swapped: 42, Hello

// 8.1.6 Variance
/*
    - Variance defines the relationship between generic types.
    - Covariance: preserves the subtype relationship.
    - Contravariance: reverses the subtype relationship.
    - Invariance: no subtype relationship is preserved.
*/

//Example:
// open class Animal
// class Dog : Animal()
// class Cat : Animal()
//
// fun main() {
//     // Covariance (out keyword)
//     val animals: List<Animal> = listOf(Dog(), Cat())
//     
//     // Contravariance (in keyword)
//     val dogComparator: Comparator<Dog> = compareBy { it.hashCode() }
//     val animalComparator: Comparator<Animal> = dogComparator
//     
//     println("Animals: $animals")
// }

//Output:
//Animals: [Dog@hashcode, Cat@hashcode]

// 8.1.7 Type erasure
/*
    - Type information is erased at runtime in Kotlin.
    - You cannot check the generic type at runtime.
    - Use reified type parameters to preserve type information.
*/

//Example:
// inline fun <reified T> isTypeOf(value: Any): Boolean {
//     return value is T
// }
//
// fun main() {
//     val value: Any = "Hello"
//     
//     println("Is String: ${isTypeOf<String>(value)}")
//     println("Is Int: ${isTypeOf<Int>(value)}")
// }

//Output:
//Is String: true
//Is Int: false

// 8.1.8 Generic extensions
/*
    - Extension functions can be generic.
    - They can work with any type that meets the constraints.
    - Generic extensions are useful for adding functionality to existing types.
*/

//Example:
// fun <T> List<T>.second(): T? {
//     return if (size >= 2) this[1] else null
// }
//
// fun <T> List<T>.penultimate(): T? {
//     return if (size >= 2) this[size - 2] else null
// }
//
// fun main() {
//     val numbers = listOf(1, 2, 3, 4, 5)
//     val words = listOf("apple", "banana", "cherry")
//     
//     println("Second number: ${numbers.second()}")
//     println("Penultimate word: ${words.penultimate()}")
// }

//Output:
//Second number: 2
//Penultimate word: banana
