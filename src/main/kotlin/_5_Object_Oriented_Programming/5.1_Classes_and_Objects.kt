package _5_Object_Oriented_Programming

// 5.1 Classes and Objects

// 5.1.1 Basic class definition
/*
    - A class is a blueprint for creating objects.
    - Classes define properties (data) and methods (functions) that objects will have.
    - In Kotlin, classes are declared using the 'class' keyword.
*/

//Example:
// class Person {
//     var name: String = ""
//     var age: Int = 0
//     
//     fun introduce() {
//         println("Hi, I'm $name and I'm $age years old.")
//     }
// }
//
// fun main() {
//     val person = Person()
//     person.name = "Alice"
//     person.age = 25
//     person.introduce()
// }

//Output:
//Hi, I'm Alice and I'm 25 years old.

// 5.1.2 Primary constructor
/*
    - Primary constructor is declared in the class header.
    - It can have parameters that are used to initialize properties.
    - Properties can be declared directly in the constructor.
*/

//Example:
// class Person(val name: String, var age: Int) {
//     fun introduce() {
//         println("Hi, I'm $name and I'm $age years old.")
//     }
// }
//
// fun main() {
//     val person = Person("Bob", 30)
//     person.introduce()
//     person.age = 31  // Can modify var properties
//     person.introduce()
// }

//Output:
//Hi, I'm Bob and I'm 30 years old.
//Hi, I'm Bob and I'm 31 years old.

// 5.1.3 Secondary constructor
/*
    - Secondary constructors provide alternative ways to create objects.
    - They must delegate to the primary constructor using 'this'.
    - Useful when you need multiple ways to initialize an object.
*/

//Example:
// class Person(val name: String, var age: Int) {
//     constructor(name: String) : this(name, 0) {
//         println("Secondary constructor called")
//     }
//     
//     fun introduce() {
//         println("Hi, I'm $name and I'm $age years old.")
//     }
// }
//
// fun main() {
//     val person1 = Person("Alice", 25)
//     val person2 = Person("Bob")
//     person1.introduce()
//     person2.introduce()
// }

//Output:
//Secondary constructor called
//Hi, I'm Alice and I'm 25 years old.
//Hi, I'm Bob and I'm 0 years old.

// 5.1.4 Init blocks
/*
    - Init blocks are executed when an object is created.
    - They are used for initialization logic that can't be done in the constructor.
    - Multiple init blocks are executed in the order they appear.
*/

//Example:
// class Person(val name: String, var age: Int) {
//     init {
//         println("Creating person: $name")
//         if (age < 0) {
//             age = 0
//             println("Age cannot be negative, setting to 0")
//         }
//     }
//     
//     fun introduce() {
//         println("Hi, I'm $name and I'm $age years old.")
//     }
// }
//
// fun main() {
//     val person = Person("Charlie", -5)
//     person.introduce()
// }

//Output:
//Creating person: Charlie
//Age cannot be negative, setting to 0
//Hi, I'm Charlie and I'm 0 years old.

// 5.1.5 Properties with custom getters and setters
/*
    - Properties can have custom getters and setters.
    - Getters are called when you read a property value.
    - Setters are called when you assign a value to a property.
*/

//Example:
// class Rectangle(var width: Double, var height: Double) {
//     val area: Double
//         get() = width * height
//     
//     var perimeter: Double
//         get() = 2 * (width + height)
//         set(value) {
//             val ratio = value / (2 * (width + height))
//             width *= ratio
//             height *= ratio
//         }
// }
//
// fun main() {
//     val rectangle = Rectangle(5.0, 3.0)
//     println("Area: ${rectangle.area}")
//     println("Perimeter: ${rectangle.perimeter}")
//     
//     rectangle.perimeter = 20.0
//     println("New width: ${rectangle.width}, height: ${rectangle.height}")
// }

//Output:
//Area: 15.0
//Perimeter: 16.0
//New width: 6.25, height: 3.75

// 5.1.6 Visibility modifiers
/*
    - Visibility modifiers control the accessibility of classes, properties, and methods.
    - public: accessible from anywhere (default)
    - private: accessible only within the same class
    - protected: accessible within the class and its subclasses
    - internal: accessible within the same module
*/

//Example:
// class BankAccount {
//     private var balance: Double = 0.0
//     internal val accountNumber: String = "123456789"
//     
//     fun deposit(amount: Double) {
//         if (amount > 0) {
//             balance += amount
//             println("Deposited $amount. New balance: $balance")
//         }
//     }
//     
//     fun withdraw(amount: Double) {
//         if (amount > 0 && amount <= balance) {
//             balance -= amount
//             println("Withdrew $amount. New balance: $balance")
//         } else {
//             println("Insufficient funds or invalid amount")
//         }
//     }
//     
//     fun getBalance(): Double = balance
// }
//
// fun main() {
//     val account = BankAccount()
//     account.deposit(1000.0)
//     account.withdraw(300.0)
//     println("Current balance: ${account.getBalance()}")
// }

//Output:
//Deposited 1000.0. New balance: 1000.0
//Withdrew 300.0. New balance: 700.0
//Current balance: 700.0

// 5.1.7 Data classes
/*
    - Data classes are designed to hold data.
    - They automatically generate equals(), hashCode(), toString(), copy(), and componentN() methods.
    - Use the 'data' keyword to declare a data class.
*/

//Example:
// data class User(val name: String, val age: Int, val email: String)
//
// fun main() {
//     val user1 = User("Alice", 25, "alice@example.com")
//     val user2 = User("Alice", 25, "alice@example.com")
//     val user3 = user1.copy(name = "Bob")
//     
//     println("User1: $user1")
//     println("User1 == User2: ${user1 == user2}")
//     println("User3: $user3")
// }

//Output:
//User1: User(name=Alice, age=25, email=alice@example.com)
//User1 == User2: true
//User3: User(name=Bob, age=25, email=alice@example.com)

// 5.1.8 Object declarations (Singleton)
/*
    - Object declarations create singleton objects.
    - Only one instance of the object exists throughout the application.
    - Objects are initialized lazily when first accessed.
*/

//Example:
// object DatabaseConnection {
//     private var isConnected = false
//     
//     fun connect() {
//         if (!isConnected) {
//             isConnected = true
//             println("Connected to database")
//         } else {
//             println("Already connected")
//         }
//     }
//     
//     fun disconnect() {
//         if (isConnected) {
//             isConnected = false
//             println("Disconnected from database")
//         } else {
//             println("Not connected")
//         }
//     }
// }
//
// fun main() {
//     DatabaseConnection.connect()
//     DatabaseConnection.connect()
//     DatabaseConnection.disconnect()
// }

//Output:
//Connected to database
//Already connected
//Disconnected from database
