# SWE-25 - Java Object-Oriented Programming

This repository contains my Java learning journey and practice exercises covering object-oriented programming, functional programming, GUI development, databases, and advanced topics.

## 📚 About

A comprehensive Java course covering:
- **Fundamentals**: Variables, control structures, arrays, collections
- **Object-Oriented Programming**: Classes, inheritance, interfaces, polymorphism
- **Advanced Topics**: Concurrency, functional programming, testing, lambda expressions
- **Application Development**: GUI development with JavaFX, database integration with JDBC

## 🗂️ Repository Structure

```
SWE-25/
├── 1.10/          # Java as a Programming Language
├── 1.20/          # Variables, Input/Output, Type Conversion
├── 1.30/          # Control Structures
├── 1.40/          # Arrays
├── 2.10/          # Class, Object, Constructor
├── 2.20/          # Collections
├── 2.30/          # Association
├── 3.10/          # Inheritance
├── 3.20/          # Interface
├── 3.30/          # Static Variables, Methods, Packages
├── 3.4/           # Data Streams and Exceptions
├── 4.1/           # Version Control and AI-assisted Coding
├── 5.1/           # Threads
├── 5.2/           # Synchronization
├── 6.10/          # GUI foundations (Maven JavaFX project)
├── 7.1/           # SQL scripts for database setup and queries
├── 7.2/           # JDBC-based database exercises
├── 8.1/           # Unit Testing (Maven project)
├── 8.2/           # Test-Driven Development (Maven project)
├── 8.3/           # Lambda Expressions (Maven project)
├── 8.4/           # Functional Programming (Maven project)
└── Gui/           # Full JavaFX currency converter application
```

## 📖 Modules Overview

### Module 1: Java Fundamentals ✅
- **1.10** - Java as a Programming Language
  - Basic Java programs (Cat class, task exercises)
- **1.20** - Variables, Input/Output, Type Conversion, and Arithmetic Operators
  - Conversion programs (FahrenheitToCelsius, MedievalUnitsConverter, TriangleHypotenuse)
- **1.30** - Control Structures
  - Control structure exercises (4 tasks)
- **1.40** - Arrays
  - Array exercises (3 tasks + Main)

### Module 2: Object-Oriented Basics ✅
- **2.10** - Class, Object, Constructor, Instance Variable, Method
  - Class and object implementations (Car, CoffeeMaker, Television with driver classes)
- **2.20** - Collections
  - Collections practice (GroceryListManager)
- **2.30** - Association
  - Association concepts (Library system with Book and User classes)

### Module 3: Advanced OOP Concepts ✅
- **3.10** - Inheritance
  - Shape hierarchy (Circle, Rectangle, Triangle); Car inheritance (SportsCar, Bus)
- **3.20** - Interface
  - Interface implementations (4 tasks covering various interface concepts)
- **3.30** - Static Variables and Methods, Packages, Modifiers
  - Static variables, methods, packages, and modifiers (3 tasks)
- **3.4** - Data Streams and Exceptions
  - Data streams and exceptions (3 tasks including file I/O and exception handling)

### Module 4: Development Tools ✅
- **4.1** - Version Control Systems and AI-assisted Coding
  - Calculator class with GitHub Copilot integration

### Module 5: Concurrency ✅
- **5.1** - Threads
  - Thread creation and management (2 tasks)
- **5.2** - Synchronization
  - Thread synchronization and thread-safe operations (2 tasks)

### Module 6: GUI Development ✅
- **6.10** - GUI Foundations
  - Maven-based JavaFX GUI setup and foundations
- **Gui/** - Full Application
  - Complete JavaFX currency converter application using MVC pattern and JPA-style persistence

### Module 7: Database Integration ✅
- **7.1** - Preparing the Database and the Connection
  - SQL scripts for schema and sample data (`currency_converter.sql`, `queries.sql`)
- **7.2** - Database Usage via JDBC Driver
  - JDBC-based database interaction and query execution

### Module 8: Advanced Topics ✅
- **8.1** - Unit Testing
  - Unit tests for existing code (JUnit, assertions, and test structure)
- **8.2** - Test-Driven Development (TDD)
  - Test-Driven Development workflows for new features
- **8.3** - Lambda Expressions
  - Lambda expressions and functional interfaces (sorting, filtering, forEach, removeIf, replaceAll)
- **8.4** - Functional Programming
  - Functional programming with Streams API (map/filter/reduce, mean calculation, immutable transformations)

## 🚀 Getting Started

### Running Simple Java Programs (Modules 1.x - 5.x)

These modules contain standalone Java files with IntelliJ IDEA module files (`.iml`).

```bash
# Navigate to the module directory
cd 1.20

# Compile the Java files
javac src/*.java

# Run the main class
java src/MainClassName
```

### Running Maven Projects (Modules 6.10, 8.x, Gui)

These modules use Maven for dependency management and building.

```bash
# Navigate to the module directory
cd 8.1

# Compile and run tests
mvn test

# Build the project
mvn clean package

# Run the application
mvn exec:java -Dexec.mainClass="org.example.MainClass"
```

**Recommended**: Open the module in IntelliJ IDEA as a Maven project for easier running and debugging.

## 🛠️ Technologies Used

- **Language**: Java
- **Build Tool**: Maven (for modules 6.10, 8.x, and Gui)
- **Testing**: JUnit 5
- **GUI Framework**: JavaFX
- **Database**: JDBC, SQL
- **IDE**: IntelliJ IDEA
- **Version Control**: Git & GitHub
- **AI Tools**: GitHub Copilot

## 📝 Notes

- All code follows Java best practices and OOP principles
- Exercises are organized by module and section for easy navigation
- Some modules include driver classes to demonstrate class usage
- Module 4.1 includes AI-assisted coding examples using GitHub Copilot
- Build outputs (`out/`, `target/`) and IDE configuration files (`.idea/`, `*.iml`) are excluded from version control

## 📊 Progress Status

All modules have been completed:
- ✅ Module 1: Java Fundamentals
- ✅ Module 2: Object-Oriented Basics
- ✅ Module 3: Advanced OOP Concepts
- ✅ Module 4: Development Tools
- ✅ Module 5: Concurrency
- ✅ Module 6: GUI Development
- ✅ Module 7: Database Integration
- ✅ Module 8: Advanced Topics

---

**Repository**: [SWE-25 on GitHub](https://github.com/TanvirNibir/SWE-25)
