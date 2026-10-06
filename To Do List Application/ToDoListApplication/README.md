# To-Do List Application Using Java

## Project Overview

The **To-Do List Application** is a console-based Java application developed to help users manage their daily tasks. The application allows users to add, view, complete, edit, delete, and search tasks.

The project demonstrates important Java programming concepts such as classes, objects, constructors, encapsulation, ArrayList, methods, loops, conditional statements, switch statements, exception handling, and file handling.

## Features

1. Add Task
2. View Tasks
3. Mark Task as Completed
4. Edit Task
5. Delete Task
6. Search Task
7. Save tasks automatically
8. Load saved tasks when the application starts

## Technologies Used

- Java
- JDK 21
- Visual Studio Code
- Java Collections Framework
- Java File Handling / Serialization

## Project Structure

```text
ToDoListApplication/
│
├── Task.java
├── ToDoList.java
├── README.md
└── .gitignore
```

## Requirements

- Windows 10/11
- JDK 21 or later
- Visual Studio Code
- Extension Pack for Java

## How to Run in VS Code

1. Open the `ToDoListApplication` folder in VS Code.
2. Open the integrated terminal.
3. Check Java:

```bash
java -version
```

4. Check the compiler:

```bash
javac -version
```

5. Compile:

```bash
javac Task.java ToDoList.java
```

6. Run:

```bash
java ToDoList
```

## Main Menu

```text
==============================================
           TO-DO LIST APPLICATION
==============================================
1. Add Task
2. View Tasks
3. Mark Task as Completed
4. Edit Task
5. Delete Task
6. Search Task
7. Exit
==============================================
```

## Data Persistence

Tasks are saved in a file named `tasks.dat`. The file is automatically created after a task is added. When the application starts again, previously saved tasks are loaded automatically.

## Java Concepts Demonstrated

- Classes and Objects
- Constructors
- Encapsulation
- ArrayList
- Methods
- Loops
- Conditional statements
- Switch statements
- Exception handling
- File handling
- Serialization
- CRUD operations

## Future Scope

The application can be extended by adding:

- Graphical User Interface using Java Swing or JavaFX
- Task priorities
- Due dates
- Categories
- Reminders
- User login
- MySQL database connectivity
- Sorting and filtering
- Dark/light theme

## Author

Student Java Programming Project
