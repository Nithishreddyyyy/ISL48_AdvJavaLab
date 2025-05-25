# ISL48 Advanced Java Lab 🚀

This repository contains solutions to all lab experiments for **ISL48 – Advanced Java Laboratory**. Each program demonstrates core Java concepts like interfaces, packages, GUI development, exception handling, collections, generics, and more.

---

## 🧪 List of Experiments

---

### ✅ 1. Payroll System using Interface and Packages

📌 **Question:**

> Write a Java Program for the following Payroll System. Create a package called `PayrollManagement`. Define an interface `Payable` with a method `calculate()`.  
> Create a super class called `Employee` with the following data members: name, age, salary and designation. Use a parameterised constructor to initialize all the data members.  
> The Employee class is inherited in three sub-classes: `FullTime`, `PartTime`, and `Intern`, which implement the `Payable` interface. Full-Time Employee receives monthly salary, Part-Time Employee receives hourly wages, Intern takes a fixed stipend.  
> Create another package `Company` and import these classes to complete the payroll system. Create an array of Employee objects.

🔧 **Highlights:**
- Packages: `PayrollManagement`, `Company`
- OOP: Inheritance, Interface (`Payable`), Polymorphism
- Employee types: FullTime, PartTime, Intern
- Salary calculated differently based on type
- Uses `Employee[]` array

---

### ✅ 2. Queue Implementation with Custom Exceptions

📌 **Question:**

> Create a `Queue` class and implement `enqueue`, `dequeue` and `display` operations.  
> Create Custom Exceptions to handle **Queue Overflow** and **Queue Underflow**.

🔧 **Highlights:**
- Data structure: Queue
- Methods: `enqueue()`, `dequeue()`, `display()`
- Custom exceptions: `QueueOverflowException`, `QueueUnderflowException`
- Demonstrates exception handling in DS

---

### ✅ 3. String Operations using Interfaces and Packages

📌 **Question:**

> Define a package named `stringoperations` to encapsulate string processing functionality.  
> Create an interface `StringManipulator` with methods:
> - `reverse()`, `toUpperCase()`, `toLowerCase()`, `concatenate()`, `countVowels()`, `wordCount()`  
    > Implement this in `StringProcessor` class.  
    > Create a `main` class in another package `application` that:
> - Creates an object of `StringProcessor`
> - Accepts user input
> - Tests and displays output of all methods

🔧 **Highlights:**
- Interface-based design: `StringManipulator`
- String operations (6+ methods)
- Organized into two packages: `stringoperations`, `application`
- Clean input/output handling

---

### ✅ 4. Palindrome Checker with Custom Exceptions

📌 **Question:**

> Create a Palindrome Checker using `StringBuffer`.
> - Throw `InvalidInputException` if input has non-alphabetical characters.
> - Throw `ShortStringException` if string length < 3.
> - If palindrome (case-insensitive), display success message.
> - Otherwise, display failure message.

🔧 **Highlights:**
- Uses `StringBuffer` for reverse
- Custom exceptions:
    - `InvalidInputException`
    - `ShortStringException`
- Validates input strictly
- Checks palindromes ignoring case

---

### ✅ 5. Password Security Application

📌 **Question:**

> Create a Password Security Application in Java that takes a user's password and performs:
> - Checks for uppercase, lowercase, and digit
> - Counts special characters
> - Masks password (except 1st and last char)
> - Reverses password
> - Appends a security token (e.g., `@123!`)
> - Replaces vowels with `#`

🔧 **Highlights:**
- Security checks using regex
- Encryption-like masking
- Vowel obfuscation
- Demonstrates string manipulations and validations

---

### ✅ 6. Missed Call Management System

📌 **Question:**

> Simulate a telephone missed call log. Store:
> - Time of call, number, and caller name
> - Name = "Private Caller" if not listed  
    > Use a collection with:
> - Max 3 calls (FIFO)
> - On new call, drop oldest
> - After each call, let user:
    >   - Delete it or not
>   - View details  
      > Finally, show full list of missed calls.

🔧 **Highlights:**
- Uses `LinkedList` or `Queue` for FIFO
- Call limit of 3
- Dynamic deletion and viewing
- `IncomingCall` helper class

---

### ✅ 7. Book Database with Collections and Sorting

📌 **Question:**

> Create a `Book` class with: title, author, publisher, price.  
> Store in a List.
> - Sort books by price (ascending)
> - Search books by author name
> - Filter books above a user-specified price
> - Maintain book ID uniquely

🔧 **Highlights:**
- Uses `ArrayList` and sorting
- `Comparator` or `Comparable` implementation
- Search and filter logic
- Good use of Java Collections API

---

### ✅ 8. Generic Stack Class

📌 **Question:**

> Write a program to create a generic `Stack<T>` class with:
> - `push()`, `pop()`, `clear()`, `isEmpty()`, `display()`  
    > Demonstrate with `Integer` and `String` stacks.

🔧 **Highlights:**
- Generic class using `<T>`
- Implements classic stack behavior
- Demonstrates type safety
- Examples with two different data types

---

### ✅ 9. Swing-based Student CGPA Application

📌 **Question:**

> Create a Swing application where user enters:
> - name, usn, age, address, sgpa (4 semesters), category  
    > Features:
> - Validate all fields with pop-up error messages
> - `Compute` button calculates CGPA
> - `Done` adds student to a collection
> - `Complete` displays collection in a `TextArea`
> - Enable/Disable buttons based on workflow

🔧 **Highlights:**
- GUI with Java Swing
- Form validation
- Button action handling
- CGPA computation
- State management via enable/disable

---
👨‍💻 Author
Nithish Mahesh
B.E. ISE - Ramaiah Institute of Technology