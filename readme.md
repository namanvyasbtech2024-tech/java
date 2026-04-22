#  Inventory Management System 

## &#x20;Overview

This project is a simple **Inventory Management System** implemented in Java using key **Design Patterns**:

* Adapter Pattern
* Singleton Pattern
* Iterator Pattern

It demonstrates how modern and legacy systems can work together in a clean and scalable way.

---

##  Features

* Add and manage products in inventory
* Support for both:

  * New products
  * Legacy products (via Adapter)
* Single shared inventory instance (Singleton)
* Easy traversal of products (Iterator)

---

## &#x20;Design Patterns Used

### 1. Adapter Pattern

* Converts `LegacyItem` into `Product`
* Allows old code to work with new system

### 2. Singleton Pattern

* Ensures only **one instance** of `InventoryManager`
* Provides global access point

### 3. Iterator Pattern

* Used to traverse inventory items
* Provides clean looping without exposing internal structure

---

## &#x20;Project Structure

```
Product (Interface)
│
├── NewProduct (Modern implementation)
├── ProductAdapter (Adapter)
│     └── LegacyItem (Legacy class)
│
├── InventoryManager (Singleton)
│     └── List<Product>
│
└── InventoryManagementSystem (Main class)
```

---

## &#x20;How to Run

1. Compile the program:

```
javac InventoryManagementSystem.java
```

2. Run the program:

```
java InventoryManagementSystem
```

---

## Sample Output

```
========== Inventory ==========
New Product [Name: Wireless Keyboard]
New Product [Name: USB-C Hub]
New Product [Name: Noise-Cancelling Headphones]
Legacy Item [ID: 101, Description: Vintage Desk Lamp]
Legacy Item [ID: 202, Description: Mechanical Typewriter]
===============================
```

---

## Concepts Covered

* Interfaces in Java
* Object-Oriented Programming (OOP)
* Design Patterns implementation
* Collections (ArrayList)
* Iterators

---

## &#x20;Learning Outcome

By completing this project, you will understand:

* How to integrate legacy systems using Adapter Pattern
* How to control object creation using Singleton
* How to efficiently traverse collections using Iterator

---

## &#x20;Author

* Akshita Mishra

---

## &#x20;Note

This project is beginner-friendly and ideal for understanding **real-world use of design patterns in Java**.
