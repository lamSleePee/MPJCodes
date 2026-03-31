# MPJCodes

Java programs from MPJ College (Sixth Sem).

## Prerequisites

- [Java JDK](https://adoptium.net/) (Java 8 or later)
- Ensure `javac` and `java` are on your PATH

## How to Run

### cloudFileLogger.java

Tracks cloud file access (filename, user, access count, last access time).

```bash
# Compile
javac cloudFileLogger.java

# Run
java CloudFileLogger
```

### rectangle.java

Computes area of rectangles using the `Rectangle` class. Entry point is the `RectangleArea` class.

```bash
# Compile
javac rectangle.java

# Run
java RectangleArea
```

## Quick Reference

| File                 | Run with        |
|----------------------|-----------------|
| cloudFileLogger.java | `java CloudFileLogger` |
| rectangle.java       | `java Wow`      |

## Added Thread and Exception Programs

### 1) `ThreadCreationDemo.java`
- Demonstrates thread creation by extending the `Thread` class.
- Creates 8 threads in a loop.
- Each thread displays its running thread name and thread ID.
- Includes error handling with `try-catch` in `run()`.

Compile and run:
```bash
javac ThreadCreationDemo.java
java ThreadCreationDemo
```

### 2) `TryCatchDemo.java`
- Demonstrates one `try` block with multiple `catch` blocks.
- Takes two integer inputs and performs division.
- Handles invalid input and divide-by-zero errors.
- Uses a user-defined exception when output is not greater than 1.

Compile and run:
```bash
javac TryCatchDemo.java
java TryCatchDemo
```

### 3) `RunnableSleepDemo.java`
- Demonstrates thread creation using the `Runnable` interface.
- Uses two classes:
  - `HalfSecondTask` sleeps for 500 ms.
  - `OneSecondTask` sleeps for 1000 ms.
- Runs both tasks as separate threads.

Compile and run:
```bash
javac RunnableSleepDemo.java
java RunnableSleepDemo
```
