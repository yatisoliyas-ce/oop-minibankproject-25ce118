# Verification notes

- Practicals 01–13: compiled separately with `javac --release 17 MiniBank.java` and ran without errors.
- Practical 14: compiled with `javac --release 17` using its package folders; tested open-account, deposit, statement, batch-deposit, list, report, and exit flow.
- The provided JUnit 5 test source is in `Practical14/src/test/java/BankServiceTest.java`. Running JUnit requires Maven and access to download JUnit dependencies. Maven was not installed in the build environment, so the JUnit suite was not executed here.
- Runtime files under `Practical14/data/` are generated when the program runs and should not be committed.
