package _1_Basics_of_kotlin

// 1. Package,Imports and Comments

/*
A. Package
    A Package is a way to organise related Kotlin files. It helps avoid naming conflicts.

    You define a package at the top of a kotlin file.
    If no package is defined, the file belongs to default package.

B. Imports
   The import keyword is used to import functions, classes, and objects from other packages.
   You can use wildcard imports (*) to import everything from a package.
   Kotlin automatically imports some standard packages like kotlin.io, kotlin.math, etc.

C. Comments in Kotlin
    Comments are ignored by the compiler and are used for documentation and explanation.

    Type Of Comments:
        1. Single-line comment -> Start With //
        2. Multi-line comment -> Enclosed within /* */
        3. KDocs comments -> Used for documentation (//** */)
*/


// 2. Entry Point of Program is main() Main Function and print standard Output

//Example:
/*
fun main() {
    println("This is print standard Output") //This will break line once output printed
    print("This is printing after println")
}
*/

/*
 This is print standard Output
 This is printing after println
 */


// 3. Variables, lateinit and Data Types

/*
Kotlin has two types of variables:
    val (Immutable) -> Read-only, cannot be changed.
    var (Mutable) -> Can Be changed.
*/

//Example for val
/*
fun main() {
    val name = "Android"
    name = "Developer" // This line will show error as its Immutable
    println(name)
}
*/

//Example for var
/*
fun main() {
    val name = "Android"
    name = "Developer"
    println(name)
}
Output: Developer
*/


// lateinit is used to initialize variables later
//Example:

/*
fun main() {
    lateinit var name: String //We are going to initialize the value of name later in program.
    name = "John"
    println(name)
}
//Output: John

Note:
    If we forgot to initialize the will get Error during compile -> lateinit property name has not been initialized.
    Used Only with var, not val.
    Useful when you cannot initialize a variable immediately

 */


 //4. Standard Input
 /*
 What is Standard Input?
    - Standard Input is the input from the user.
    - We can take input from the user using readLine() function.
    - readLine() function returns a String.
 */

 //Example:
// fun main() {
//    println("Enter your name: ")
//    val name = readLine()
//    println("Hello, $name")
// }

 //Output:
 /*Enter your name:
 John
 Hello, John*/


//5. Collection Types
/*
What is Collection?
    In kotlin, collections are used to store and manipulate groups of related data.
    There are two main types of collections:

    1. Immutable Collections (Read-only)
        - List<T> -> Ordered Collection (duplicate elements allowed)
        - Set<T> -> Unordered Collection (no duplicate elements)
        - Map<K,V> -> Key-Value Pairs (no duplicate keys)

    2. Mutable Collections (Can be changed)
        - ArrayList<T> -> List with modification functions
        - HashSet<T> -> Set with modification functions
        - HashMap<K,V> -> Map with modification functions
 */

 //Example of Immutable Collections:
//  fun main() {
//     val list = listOf(1, 2, 3, 4, 5)
//     val set = setOf(1, 2, 3, 4, 5)
//     val map = mapOf(1 to "One", 2 to "Two", 3 to "Three")
//     println(list)
//     println(set)
//     println(map)
//  }

 //Output:
 /*[1, 2, 3, 4, 5]
 [1, 2, 3, 4, 5]
 {1=One, 2=Two, 3=Three}*/

 //Example of Mutable Collections:
//  fun main() {
//     val list = mutableListOf(1, 2, 3, 4, 5)
//     val set = mutableSetOf(1, 2, 3, 4, 5)
//     val map = mutableMapOf(1 to "One", 2 to "Two", 3 to "Three")
//     println(list)
//     println(set)
//     println(map)
//  }

 //Output:
 /*[1, 2, 3, 4, 5]
 [1, 2, 3, 4, 5]
 {1=One, 2=Two, 3=Three}*/


//6. Operators
/*
Kotlin Operators 
Operators in kotlin are special symbols used to perform operations on variables and values.

There are several types of operators in kotlin:

    1. Arithmetic Operators -> +, -, *, /, % -> Arithmetic Operators are used to perform arithmetic operations on variables and values.
    2. Assignment Operators -> =, +=, -=, *=, /=, %= -> Assignment Operators are used to assign values to variables and values.
    3. Comparison Operators -> ==, !=, >, <, >=, <= -> Comparison Operators are used to compare variables and values.
    4. Logical Operators -> &&, ||, ! -> Logical Operators are used to perform logical operations on variables and values.
    5. Bitwise Operators -> and , or , xor , inv, shl, shr, ushr -> Bitwise Operators are used to perform bitwise operations on variables and values.
    6. Increment and Decrement Operators -> ++, -- -> Increment and Decrement Operators are used to increment and decrement variables and values.
    7. Type Check and Cast Operators -> is, as -> Type Check and Cast Operators are used to check and cast variables and values.
    8. Elvis Operator -> ?: -> Elvis Operator is used to provide a default value if the expression is null.
    9. Safe Call Operator -> ?. -> Safe Call Operator is used to safely call a function on a nullable object.
    10. Null Check Operator -> ?: -> Null Check Operator is used to check if the expression is null.
    11. Range Operators -> .., downTo, until,step -> Range Operators are used to create ranges of values.
 */

 //Example of Arithmetic Operators:
//  fun main() {
//     val a = 10
//     val b = 20
//     println(a + b)
//     println(a - b)
//     println(a * b)
//     println(a / b)
//     println(a % b)
//  }

//  //Output:
//  /*30
//  -10
//  200
//  0
//  10*/


//Example of Assignment Operators:
// fun main() {
//     var a = 10
//     a += 5
//     println(a)
// }

//Output:
/*15*/

//Example of Comparison Operators:
// fun main() {
//     val a = 10
//     val b = 20
//     println(a == b)
//     println(a != b)
//     println(a > b)
//     println(a < b)
//     println(a >= b)
//     println(a <= b)
// }

//Output:
/*false
true
false
true
false
true*/

//Example of Logical Operators:
// fun main() {
//     val a = 10
//     val b = 20
//     println(a && b)
//     println(a || b)
//     println(!a)
// }

//Output:
/*true
true
false*/

//Example of Bitwise Operators:
// fun main() {
//     val a = 10
//     val b = 20
//     println(a and b)
//     println(a or b)
//     println(a xor b)
//     println(a inv)
// }
//Output:
/*10
30
30
-11*/   


//Example of Increment and Decrement Operators:
// fun main() {
//     var a = 10
//     println(a++)
//     println(a--)
//     println(++a)
//     println(--a)
// }

//Output:
/*10
11
10*/

//Example of Type Check and Cast Operators:
// fun main() {
//     val a = 10
//     println(a is Int)
//     println(a as Int)
// }

//Output:
/*true
10*/

//Example of Elvis Operator:
// fun main() {
//     val a = 10
//     println(a ?: "Default Value")
// }

//Output:
/*10*/

//Example of Safe Call Operator:
// fun main() {
//     val a: Int? = null
//     println(a?.toString())
// }

//Output:
/*null*/

//Example of Null Check Operator:
// fun main() {
//     val a: Int? = null
//     println(a ?: "Default Value")
// }

//Output:
/*Default Value*/

//Example of Range Operators:
// fun main() {
//     val a = 10
//     println(a .. 20)
//     println(a downTo 1)
//     println(a until 20)
//     println(a step 2)
// }

//Output:
/*true
10*/
//     println(a is Int)
//     println(a as Int)
// }

//Output:
/*true
10*/

//Example of Elvis Operator:
// fun main() {
//     val a: Int? = null
//     println(a ?: "Default Value")
// }

//Output:
/*Default Value*/

//Example of Safe Call Operator:
// fun main() {
//     val a: Int? = null
//     println(a?.toString())
// }

//Output:
/*true
10*/

