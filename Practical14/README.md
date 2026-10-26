# MiniBank — Practical 14 Final Capstone

Requirements: JDK 17 or later. The source uses standard Java only; JUnit tests are provided separately as a Maven test setup.

## Compile and run on Windows CMD

```bat
cd Practical14
if not exist out mkdir out
javac -d out src\main\java\model\annotation\*.java src\main\java\model\*.java src\main\java\exception\*.java src\main\java\util\*.java src\main\java\repository\*.java src\main\java\service\*.java src\main\java\MiniBank.java
java -cp out MiniBank
```

## Build runnable JAR

```bat
jar --create --file MiniBank.jar --main-class MiniBank -C out .
java -jar MiniBank.jar
```

The program saves state and transaction logs under `data/`. Do not commit generated `data/`, `out/`, or JAR files unless your faculty explicitly requests them.

Menu: open account, deposit, withdraw, transfer, statement, list accounts, report, batch deposits, exit. Use account numbers shown after opening an account. Data is saved when changes are made and when the program exits.
