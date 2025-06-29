# ISL48 Advanced Java Lab 🚀

This repository contains solutions to all lab experiments for **ISL48 – Advanced Java Laboratory**. Each program demonstrates core Java concepts like interfaces, packages, GUI development, exception handling, collections, generics, JDBC, Swing, and JSP-based web applications.

---

## 🧪 List of Experiments

---

### ✅ 1. Payroll System using Interface and Packages

📌 **Question:**

> Write a Java Program for the following Payroll System. Create a package called `PayrollManagement`. Define an interface `Payable` with a method `calculate()`.  
> Create a superclass called `Employee` with data members: name, age, salary, and designation. Use a parameterized constructor to initialize them.  
> The `Employee` class is inherited by `FullTime`, `PartTime`, and `Intern`, all implementing `Payable`.  
> - FullTime: Monthly salary  
> - PartTime: Hourly wages  
> - Intern: Fixed stipend  
> Create another package `Company` and import these classes.  
> Store all employees in an `ArrayList<Employee>`.

🔧 **Highlights:**
- Packages: `PayrollManagement`, `Company`
- Inheritance + Interface
- Polymorphism in salary calculation
- Dynamic data storage with `ArrayList`

---

### ✅ 2. Queue Implementation with Custom Exceptions

📌 **Question:**

> Create a `Queue` class to store `String` names and implement `enqueue`, `dequeue`, and `display`.  
> Use **Custom Exceptions**:
> - `QueueOverflowException`
> - `QueueUnderflowException`

🔧 **Highlights:**
- Data structure: Queue
- Custom exception handling
- Queue behavior simulation using arrays or lists

---

### ✅ 3. String Operations using Interface and Packages

📌 **Question:**

> Define a package `stringoperations` and an interface `StringManipulator` with methods:
> - `reverse(String input)`
> - `toUpperCase(String input)`
> - `concatenate(String str1, String str2)`
> - `countVowels(String input)`
> - `wordCount(String input)`  
> Implement in `StringProcessor`.  
> Create a main class in `application` package that takes input from user and tests all methods.

🔧 **Highlights:**
- Interface-based design
- Two-package separation
- String operations and metrics
- Modular, testable design

---

### ✅ 4. Palindrome Checker with Custom Exceptions

📌 **Question:**

> Create a palindrome checker using `StringBuffer`.  
> Implement exception handling:
> - `InvalidInputException`: if input has special characters  
> - `LongStringException`: if string length > 5  
> - Ignore case while checking  
> Show appropriate messages.

🔧 **Highlights:**
- Exception handling
- String reversal using `StringBuffer`
- Clean validations
- Case-insensitive palindrome check

---

### ✅ 5. Password Security Application

📌 **Question:**

> Create a Java app that performs password validation:
> - Check for uppercase, lowercase, digit  
> - Count special and non-special characters  
> - Mask the password (show only first and last chars)  
> - Reverse password  
> - Append a security token (e.g., `@123!`)  
> - Replace vowels with `#`

🔧 **Highlights:**
- Regex-based checks
- Password transformations
- Encryption-style manipulation

---

### ✅ 6. Missed Call Management System

📌 **Question:**

> Maintain a **LinkedList** of contact details (name, number).  
> For each incoming call:
> - Store time, number, and name (or "Private Caller") in an `ArrayList`.  
> - Max 5 calls: remove oldest if exceeded.  
> For each call:
> - Let user delete or view it  
> - Options to view contact list and missed call list

🔧 **Highlights:**
- `LinkedList` + `ArrayList`
- Max queue size: 5
- Contact lookup logic
- User-driven deletion/viewing

---

### ✅ 7. Book Database with HashMap and Sorting

📌 **Question:**

> Create a `Book` class with: title, author, publisher, price, and a unique book ID.  
> Store books in a `HashMap`.  
> - Sort books by price → new List  
> - Search by author  
> - Filter books above a user-specified price

🔧 **Highlights:**
- Uses `HashMap` and `ArrayList`
- `Comparable` / `Comparator`
- Multiple filters and views
- Unique ID maintenance

---

### ✅ 8. Generic Stack using ArrayList

📌 **Question:**

> Create a generic class `Stack<T>` with:
> - `push()`, `pop()`, `clear()`, `isEmpty()`, `display()`  
> Backed by `ArrayList`.  
> Demonstrate with `String` and `Float`.

🔧 **Highlights:**
- Java Generics
- Type-safe stack
- Demonstration with multiple types
- Internal storage: `ArrayList<T>`

---

### ✅ 9. Student CGPA Swing Application

📌 **Question:**

> Create a Swing app for student details: name, usn, age, address, sgpas (4 sems), and category (ComboBox).  
> - Validate fields with pop-up errors  
> - `Compute` CGPA  
> - `Done`: add to collection  
> - `Complete`: display collection in `TextArea`  
> - Control button visibility dynamically

🔧 **Highlights:**
- Java Swing GUI
- Input validation
- Event-driven programming
- Form state management

---

### ✅ 10. Login & Purchase Validation App (Swing)

📌 **Question:**

> Build a Swing GUI app for login and item purchase:
> - Validate login with dialog boxes  
> - Handle new/existing customers  
> - Enter item ID & quantity  
> - Show item name and cost  
> - Offer discount choices  
> - `Print` button shows purchase info in dialog

🔧 **Highlights:**
- Dialog-based validation
- Customer and item entry
- Dynamic GUI updates
- User interaction flow

---

### ✅ 11. Representative-Customer Management (Swing + JDBC)

📌 **Question:**

> Create a desktop app using Swing and JDBC:
> - Create `Representative` and `Customer` tables in MySQL  
> - Insert data via Swing forms  
> - Display `Representative` info if `Credit_Limit` > 15,000

🔧 **Highlights:**
- JDBC integration
- SQL table operations
- Conditional query logic
- Multi-form GUI

---

### ✅ 12. JSP Shirt Purchase Web Application

📌 **Question:**

> Create a JSP-based web app for shirt purchase:
> - Show shirt types and cost (table)  
> - Dropdown for shirt type  
> - Radio buttons for neck type  
> - Input quantity  
> - `Compute` button → total cost + purchase info

🔧 **Highlights:**
- JSP front-end logic
- Table + dropdown + radio + textbox
- Price computation and display
- Interactive UI

---

👨‍💻 **Author**  
Nithish Reddy  
B.E. ISE – Ramaiah Institute of Technology
