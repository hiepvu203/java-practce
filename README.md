# Object-oriented programming (OOP) 
It's a programming technique that allows programmers to create objects in code that abstract objects.
## Object
An object includes two pieces of information: attributes and methods.

- Attributes are information and characteristics of the object.
  > For example, humans have characteristics such as eyes, nose, hands, feet...
  
- Methods are operations and actions that an object can perform.
  >For example, a person will be able to perform the actions of speaking, walking, eating, drinking, etc.

##Class
A class is a data type that includes predefined properties and methods. Unlike regular data types, a class is an (abstract) unit consisting of a combination of methods and properties.
### Difference between object and class
A class can be understood as a stereotype, an object is an instance entity based on that stereotype. 
> For example: When we talk about dogs, you can understand it as the dog class with:

>>> Information and characteristics: 4 legs, 2 eyes, tail, height, weight, fur color...

>>> Actions such as barking, walking, eating, sleeping...

>The object is the Phu Quoc dog we are raising at home, which also has the characteristics of the dog class.

## Basic principles of OOP
1. Encapsulation
   - Attributes are often _private_. Related data and methods are packaged into classes for ease of management and use. Only that class has the right to directly manage the properties of any class. Other classes or outside the class scope that want to use must go through public components.
   - In addition, packaging also hides some internal information and installation details so that they cannot be seen by the outside world.
2. Inheritance
   - Allows reuse and utilization of existing classes to create new classes.
   - To implement inheritance, use the **extends** keyword
   - The class that is inherited by another class is called the parent class or base class.
   - The class that inherits another class is called a subclass or derived class
   - With Java, only single inheritance is allowed.
3. Polymorphism
   - Polymorphism is an action that can be performed in many different ways. This is a property that contains most of the power of object-oriented programming.
   - To understand more simply: Polymorphism is the concept that two or more classes have the same methods but can be implemented in different ways.
     >>>For example, each smartphone inherits from the Smartphone parent class but can store data in the cloud in different ways. Android stores on Google Drive, iPhone stores on iCloud.
     
     >>>An example of polymorphism in action. We have 2 animals: dog and cat. Both of these animals are animals. But when we tell both animals to meow, the dog will meow, the cat will meow.
4. Abstraction
   - Abstraction focuses on the essential aspects of an object without concern for internal implementation details. It hides the internal complexity of the object, displaying only necessary information to the user.
### Difference between abstract class and interface class.
1. Concepts:
- Abstract class: A class that can contain both abstract and concrete methods. Abstract methods have no definition and must be defined in derived subclasses. The abstract class provides a template for subclasses to inherit, helping to ensure consistency in implementing common functionality.
- Interface class: Is a set of abstract methods that classes must implement. The interface does not contain any concrete methods. The interface class specifies the behaviors that the classes must perform, which increases flexibility and code reuse.
2. Inheritance:
- Abstract Class: A class can only inherit from another abstract class.
- Interface class: A class can implement multiple interfaces.
3. Deployment:
- Abstract class: Abstract methods in an abstract class must be defined in derived subclasses.
- Interface class: The methods in the interface must be implemented in classes that implement the interface.
### Overloading
Method overloading allows different methods to have the same name but differ in the number, order, and type of parameters.
### Override
- Appears only in interface inheritance/implementation relationships.
- Allows subclasses to redefine an existing function in the superclass in the way the subclass desires.
