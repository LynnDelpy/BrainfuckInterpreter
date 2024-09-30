# Brainfuck Interpreter

Welcome to the **Brainfuck Interpreter**! This project is a graphical user interface (GUI) application that allows you to write and execute Brainfuck code easily. The interpreter supports basic Brainfuck operations and visualizes the state of memory during execution.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Structure](#code-structure)

## Features
- **Simple GUI**: An intuitive interface for writing and executing Brainfuck code.
- **Memory Visualization**: Displays the state of memory cells being used.
- **Input Handling**: Supports user input for Brainfuck programs.
- **Output Display**: Shows the output generated by the Brainfuck program.

## Getting Started

### Prerequisites
Make sure you have Java Development Kit (JDK) installed on your machine.

### Clone the Repository
```bash
git clone https://github.com/yourusername/brainfuck-interpreter.git
cd brainfuck-interpreter
```

### Compile and Run
```bash
javac *.java
java Main
```

## Usage
1. Open the application.
2. Write your Brainfuck code in the editor.
3. Input any required data in the input field.
4. Click the "Run" button to execute the code.
5. View the output and memory state in the designated areas.

### Example Code
```brainfuck
++++++++[>++++++>+++>+++>+<<<<-]>+++++.>+++++.>+++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>++++++++++.
```

## Code Structure
The project is organized into several classes:
- **`BrainfuckInterpreter`**: Core logic for interpreting Brainfuck code.
- **`Memory`**: Manages the memory cells and their states.
- **`InputHandler`**: Handles input for the Brainfuck program.
- **`BrainfuckInterpreterGUI`**: Interface for the GUI components.
- **`SwingBrainfuckInterpreterGUI`**: Concrete Swing implementation of the GUI.
- **`Main`**: Entry point for the application.
