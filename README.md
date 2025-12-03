# SWE-25 - Java Object-Oriented Programming

This repository contains my Java learning journey and practice exercises as I study object-oriented programming.

## About

I am learning Java Object-Oriented Programming through a comprehensive course covering fundamentals, OOP concepts, GUI development, databases, and advanced topics.

## Course Modules

### Module 1: Java Fundamentals
- **1.10** - Java as a Programming Language
- **1.20** - Variables, Input/Output, Type Conversion, and Arithmetic Operators
- **1.30** - Control Structures
- **1.40** - Arrays

### Module 2: Object-Oriented Basics
- **2.10** - Class, Object, Constructor, Instance Variable, Method
- **2.20** - Collections
- **2.30** - Association

### Module 3: Advanced OOP Concepts
- **3.10** - Inheritance
- **3.20** - Interface
- **3.30** - Static Variables and Methods, Packages, Modifiers
- **3.4** - Data Streams and Exceptions

### Module 4: Development Tools
- **4.1** - Version Control Systems and AI-assisted Coding

### Module 5: Concurrency
- **5.1** - Threads
- **5.2** - Synchronization

### Module 6: GUI Development
- **6.1** - Principles of GUI, Events, MVC Model
- **6.2** - Layouts, Building the UI
- **6.3** - Graphics, Mouse and Keyboard Events, Updating the GUI
- **6.4** - GUI Design Tools

### Module 7: Database Integration
- **7.1** - Preparing the Database and the Connection
- **7.2** - Database Usage via JDBC Driver
- **7.3** - Basics of Object-Relational Mapping
- **7.4** - Association in Object-Relational Mapping

### Module 8: Advanced Topics
- **8.1** - Unit Testing
- **8.2** - Test-Driven Development (TDD)
- **8.3** - Lambda Expressions
- **8.4** - Functional Programming

## Progress

### Completed Modules
- ✅ **Module 1: Java Fundamentals** - Completed all sections (1.10, 1.20, 1.30, 1.40)
- ✅ **Module 2: Object-Oriented Basics** - Completed all sections (2.10, 2.20, 2.30)
- ✅ **Module 3: Advanced OOP Concepts** - Completed all sections (3.10, 3.20, 3.30, 3.4)
- ✅ **Module 4: Development Tools** - Completed section 4.1
- ✅ **Module 5: Concurrency** - Completed all sections (5.1, 5.2)
- ✅ **Module 6: GUI Development** - JavaFX GUI projects using the MVC pattern
- ✅ **Module 7: Database Integration** - SQL and JDBC-based persistence
- ✅ **Module 8: Advanced Topics** - Unit testing, TDD, lambdas, and functional-style programming

### Current Focus
- 🔁 Refining existing solutions, improving code quality, and experimenting with more advanced patterns and tools

## Project Structure

### Module 1: Java Fundamentals
- **1.10**: Basic Java programs (Cat, task exercises)
- **1.20**: Conversion programs (FahrenheitToCelsius, MedievalUnitsConverter, TriangleHypotenuse)
- **1.30**: Control structure exercises (4 tasks)
- **1.40**: Array exercises (3 tasks + Main)

### Module 2: Object-Oriented Basics
- **2.10**: Class and object implementations (Car, CoffeeMaker, Television with their driver classes)
- **2.20**: Collections practice (GroceryListManager)
- **2.30**: Association concepts (Library system with Book and User classes)

### Module 3: Advanced OOP Concepts
- **3.10**: Inheritance demonstrations (Shape hierarchy with Circle, Rectangle, Triangle; Car inheritance with SportsCar and Bus)
- **3.20**: Interface implementations (4 tasks covering various interface concepts)
- **3.30**: Static variables, methods, packages, and modifiers (3 tasks)
- **3.4**: Data streams and exceptions (3 tasks including file I/O and exception handling)

### Module 4: Development Tools
- **4.1**: Version Control Systems and AI-assisted Coding (Calculator class with GitHub Copilot integration)

### Module 5: Concurrency
- **5.1**: Threads (2 tasks covering thread creation and management)
- **5.2**: Synchronization (2 tasks covering thread synchronization and thread-safe operations)

### Module 6: GUI Development
- **6.10**: Maven-based JavaFX GUI setup and foundations
- **Gui**: Full JavaFX currency converter application using MVC and JPA-style persistence

### Module 7: Database Integration
- **7.1**: SQL scripts for schema and sample data (`currency_converter.sql`, `queries.sql`)
- **7.2**: JDBC-based database interaction and query execution

### Module 8: Advanced Topics
- **8.1**: Unit tests for existing code (JUnit, assertions, and test structure)
- **8.2**: Test-Driven Development workflows for new features
- **8.3**: Lambda expressions and functional-style utilities

## Repository Structure

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
├── 8.1/           # Unit testing (Maven project)
├── 8.2/           # Test-Driven Development (Maven project)
├── 8.3/           # Lambda expressions and functional programming (Maven project)
└── Gui/           # Full JavaFX currency converter application
```

## Technologies Used

- **Language**: Java
- **IDE**: IntelliJ IDEA
- **Version Control**: Git & GitHub
- **AI Tools**: GitHub Copilot

## Getting Started

Each early module directory (1.x–5.x) contains:
- Source code files (`.java`) in the `src/` directory
- IntelliJ IDEA module file (`.iml`)

To run a simple (non-Maven) program:
1. Navigate to the specific module directory (for example, `cd 1.20`)
2. Compile the Java files: `javac src/*.java`
3. Run the main class: `java src/MainClassName`

Maven-based modules (such as `6.10`, `8.1`, `8.2`, `8.3`, and `Gui`) contain:
- A `pom.xml` describing dependencies and build configuration
- Source code in `src/main/java` and tests in `src/test/java` (where applicable)

To work with a Maven-based module:
1. Navigate into the module directory (for example, `cd 8.1`)
2. Run tests or build with: `mvn test` or `mvn clean package`
3. Open the module in IntelliJ as a Maven project for easier running and debugging

## Git Ignore and Build Outputs

- IntelliJ IDEA project configuration files (such as `.idea/` and `*.iml`) are not committed to version control.
- Generated build and output directories such as `out/` and Maven `target/` folders are ignored, since they can always be recreated from the source.

## Notes

- All code follows Java best practices and OOP principles
- Exercises are organized by module and section for easy navigation
- Some modules include driver classes to demonstrate class usage
- Module 4.1 includes AI-assisted coding examples using GitHub Copilot

