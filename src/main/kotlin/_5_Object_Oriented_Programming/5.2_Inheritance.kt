package _5_Object_Oriented_Programming

// 5.2 Inheritance

// 5.2.1 Basic inheritance
/*
    - Inheritance allows a class to inherit properties and methods from another class.
    - The class being inherited from is called the parent class or superclass.
    - The class that inherits is called the child class or subclass.
    - In Kotlin, all classes are final by default and must be marked 'open' to be inherited.
*/

//Example:
// open class Animal(val name: String) {
//     open fun makeSound() {
//         println("$name makes a sound")
//     }
// }
//
// class Dog(name: String) : Animal(name) {
//     override fun makeSound() {
//         println("$name barks")
//     }
// }
//
// fun main() {
//     val animal = Animal("Generic Animal")
//     val dog = Dog("Buddy")
//     
//     animal.makeSound()
//     dog.makeSound()
// }

//Output:
//Generic Animal makes a sound
//Buddy barks

// 5.2.2 Method overriding
/*
    - Method overriding allows a subclass to provide a specific implementation of a method.
    - The method in the parent class must be marked 'open'.
    - The method in the child class must be marked 'override'.
*/

//Example:
// open class Vehicle(val brand: String) {
//     open fun start() {
//         println("$brand vehicle is starting")
//     }
//     
//     open fun stop() {
//         println("$brand vehicle is stopping")
//     }
// }
//
// class Car(brand: String, val model: String) : Vehicle(brand) {
//     override fun start() {
//         println("$brand $model car is starting with key")
//     }
//     
//     override fun stop() {
//         println("$brand $model car is stopping")
//     }
// }
//
// fun main() {
//     val vehicle = Vehicle("Generic")
//     val car = Car("Toyota", "Camry")
//     
//     vehicle.start()
//     car.start()
// }

//Output:
//Generic vehicle is starting
//Toyota Camry car is starting with key

// 5.2.3 Property overriding
/*
    - Properties can also be overridden in subclasses.
    - The property in the parent class must be marked 'open'.
    - The property in the child class must be marked 'override'.
*/

//Example:
// open class Shape {
//     open val area: Double = 0.0
//     open val perimeter: Double = 0.0
// }
//
// class Rectangle(val width: Double, val height: Double) : Shape() {
//     override val area: Double
//         get() = width * height
//     
//     override val perimeter: Double
//         get() = 2 * (width + height)
// }
//
// fun main() {
//     val rectangle = Rectangle(5.0, 3.0)
//     println("Rectangle area: ${rectangle.area}")
//     println("Rectangle perimeter: ${rectangle.perimeter}")
// }

//Output:
//Rectangle area: 15.0
//Rectangle perimeter: 16.0

// 5.2.4 Calling parent class methods
/*
    - You can call parent class methods using the 'super' keyword.
    - This is useful when you want to extend the parent's functionality.
*/

//Example:
// open class Employee(val name: String, val salary: Double) {
//     open fun displayInfo() {
//         println("Employee: $name, Salary: $salary")
//     }
// }
//
// class Manager(name: String, salary: Double, val department: String) : Employee(name, salary) {
//     override fun displayInfo() {
//         super.displayInfo()  // Call parent method
//         println("Department: $department")
//     }
// }
//
// fun main() {
//     val manager = Manager("John", 75000.0, "Engineering")
//     manager.displayInfo()
// }

//Output:
//Employee: John, Salary: 75000.0
//Department: Engineering

// 5.2.5 Abstract classes
/*
    - Abstract classes cannot be instantiated directly.
    - They can contain abstract methods that must be implemented by subclasses.
    - Abstract methods are declared without implementation.
*/

//Example:
// abstract class Shape {
//     abstract val area: Double
//     abstract val perimeter: Double
//     
//     fun displayInfo() {
//         println("Area: $area, Perimeter: $perimeter")
//     }
// }
//
// class Circle(val radius: Double) : Shape() {
//     override val area: Double
//         get() = Math.PI * radius * radius
//     
//     override val perimeter: Double
//         get() = 2 * Math.PI * radius
// }
//
// fun main() {
//     val circle = Circle(5.0)
//     circle.displayInfo()
// }

//Output:
//Area: 78.53981633974483, Perimeter: 31.41592653589793

// 5.2.6 Interfaces
/*
    - Interfaces define contracts that classes must implement.
    - A class can implement multiple interfaces.
    - Interfaces can have default implementations for methods.
*/

//Example:
// interface Flyable {
//     fun fly()
// }
//
// interface Swimmable {
//     fun swim()
// }
//
// class Duck : Flyable, Swimmable {
//     override fun fly() {
//         println("Duck is flying")
//     }
//     
//     override fun swim() {
//         println("Duck is swimming")
//     }
// }
//
// fun main() {
//     val duck = Duck()
//     duck.fly()
//     duck.swim()
// }

//Output:
//Duck is flying
//Duck is swimming

// 5.2.7 Interface with default implementations
/*
    - Interfaces can provide default implementations for methods.
    - Classes implementing the interface can override these methods or use the default.
*/

//Example:
// interface Drawable {
//     fun draw()
//     fun erase() {
//         println("Erasing...")
//     }
// }
//
// class Circle : Drawable {
//     override fun draw() {
//         println("Drawing a circle")
//     }
// }
//
// class Square : Drawable {
//     override fun draw() {
//         println("Drawing a square")
//     }
//     
//     override fun erase() {
//         println("Erasing square...")
//     }
// }
//
// fun main() {
//     val circle = Circle()
//     val square = Square()
//     
//     circle.draw()
//     circle.erase()
//     
//     square.draw()
//     square.erase()
// }

//Output:
//Drawing a circle
//Erasing...
//Drawing a square
//Erasing square...

// 5.2.8 Sealed classes
/*
    - Sealed classes are used to represent restricted class hierarchies.
    - All subclasses must be declared in the same file.
    - They are useful for representing a fixed set of types.
*/

//Example:
// sealed class Result {
//     data class Success(val data: String) : Result()
//     data class Error(val message: String) : Result()
//     object Loading : Result()
// }
//
// fun handleResult(result: Result) {
//     when (result) {
//         is Result.Success -> println("Success: ${result.data}")
//         is Result.Error -> println("Error: ${result.message}")
//         is Result.Loading -> println("Loading...")
//     }
// }
//
// fun main() {
//     val success = Result.Success("Data loaded")
//     val error = Result.Error("Network error")
//     val loading = Result.Loading
//     
//     handleResult(success)
//     handleResult(error)
//     handleResult(loading)
// }

//Output:
//Success: Data loaded
//Error: Network error
//Loading...
