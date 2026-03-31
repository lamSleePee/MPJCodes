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

#### Detailed Explanation (Study Notes)
- `CloudFile` is a model class with 4 fields:
  - `filename`: name of the file
  - `userId`: user who owns/accesses the file
  - `accessCount`: how many times file was accessed
  - `lastAccessTime`: latest timestamp for access
- Constructor initializes `accessCount` to `0` and `lastAccessTime` to `null`.
- `recordAccess()` is the key method:
  - increments `accessCount`
  - updates `lastAccessTime` with `new Date()`
- `generateAccessReport()` prints all current values for one object.
- `main()` creates 3 sample files and calls `recordAccess()` multiple times to simulate usage.

#### What to Remember for Tests
- This program demonstrates **encapsulation + object state update over time**.
- Each object maintains its own independent counters and timestamps.
- There is a small logical issue in the current code: in `generateAccessReport()`, the line `"Last Access Time: Never accessed"` is printed inside the `if` block, so it can appear even after access. For ideal behavior, this should be in an `else` block.

### rectangle.java

Computes area of rectangles using the `Rectangle` class. Entry point is the `RectangleArea` class.

```bash
# Compile
javac rectangle.java

# Run
java RectangleArea
```

#### Detailed Explanation (Study Notes)
- `Rectangle` class contains:
  - `length` and `breadth`
  - `Area()` method returns `length * breadth`
- `RectangleArea` (main class) creates two `Rectangle` objects (`r1`, `r2`), assigns dimensions, then prints their areas.
- Flow:
  1. Object creation
  2. Field assignment
  3. Method call
  4. Output

#### What to Remember for Tests
- This is a basic OOP example: **class, object, fields, method call**.
- Area formula used: `length * breadth`.
- Method names conventionally start with lowercase in Java (`area()`), but program still runs with `Area()`.

## Quick Reference

| File                 | Run with        |
|----------------------|-----------------|
| cloudFileLogger.java | `java CloudFileLogger` |
| rectangle.java       | `java Wow`      |

## Added Thread and Exception Programs

### 1) `ThreadCreation.java`
- Demonstrates thread creation by extending the `Thread` class.
- Creates 8 threads in a loop.
- Each thread displays its running thread name and thread ID.
- Includes error handling with `try-catch` in `run()`.

Compile and run:
```bash
javac ThreadCreation.java
java ThreadCreation
```

#### Detailed Explanation (Study Notes)
- `MyWorkerThread` extends `Thread`, so each object is a thread.
- `run()` contains the work done by each thread:
  - prints `Thread.currentThread().getName()`
  - prints `Thread.currentThread().getId()`
  - uses `try-catch` for runtime safety
- In `main()`:
  - loop runs 8 times
  - each iteration creates a new `MyWorkerThread`
  - `start()` is called to execute `run()` on a separate thread
- Important concept:
  - `start()` creates a new thread
  - `run()` alone executes in the current thread (not concurrent)

#### What to Remember for Tests
- Thread output order is **non-deterministic** (can change each run).
- `Thread ID` is unique during JVM execution.
- Extending `Thread` is one common way to create threads.

### 2) `TryCatch.java`
- Demonstrates one `try` block with multiple `catch` blocks.
- Takes two integer inputs and performs division.
- Handles invalid input and divide-by-zero errors.
- Uses a user-defined exception when output is not greater than 1.

Compile and run:
```bash
javac TryCatch.java
java TryCatch
```

#### Detailed Explanation (Study Notes)
- Uses `Scanner` to read two integers from user.
- Performs division: `result = numerator / denominator`.
- Validation rule:
  - if `result <= 1`, custom exception is thrown.
- Custom exception:
  - `OutputNotGreaterThanOneException extends Exception`
  - created to enforce business rule (result must be > 1)
- Catch blocks handle different failures:
  - `InputMismatchException`: non-integer input
  - `ArithmeticException`: denominator is zero
  - `OutputNotGreaterThanOneException`: quotient rule failure
  - generic `Exception`: fallback safety
- `finally` always runs:
  - closes scanner
  - prints `"Program ended."`

#### What to Remember for Tests
- One `try` can have **multiple catch** blocks.
- Specific catches should be above generic `Exception`.
- `finally` runs whether exception occurs or not.

### 3) `RunnableSleep.java`
- Demonstrates thread creation using the `Runnable` interface.
- Uses two classes:
  - `HalfSecondTask` (currently sleeps for 3000 ms in code).
  - `OneSecondTask` sleeps for 1000 ms.
- Runs both tasks as separate threads.

Compile and run:
```bash
javac RunnableSleep.java
java RunnableSleep
```

#### Detailed Explanation (Study Notes)
- `HalfSecondTask` and `OneSecondTask` both implement `Runnable`.
- Each class defines `run()` method with:
  - start message
  - `Thread.sleep(...)` delay
  - end message
  - `try-catch` for interruption/runtime errors
- In `main()`:
  - `new Thread(new HalfSecondTask(), "...")`
  - `new Thread(new OneSecondTask(), "...")`
  - `start()` on both threads
- This shows the second thread-creation style:
  - **implements `Runnable`** instead of extending `Thread`

#### What to Remember for Tests
- `Runnable` is preferred when your class may need to extend another class.
- `sleep()` pauses current thread for given milliseconds.
- Current source uses `3000 ms` for `HalfSecondTask`; if you want true half second behavior, use `500`.

## Viva / Exam Quick Questions
- Difference between extending `Thread` and implementing `Runnable`?
- Why use `start()` instead of directly calling `run()`?
- Why is `finally` useful in exception handling?
- Why create a user-defined exception?
- Why does thread output order change between runs?
