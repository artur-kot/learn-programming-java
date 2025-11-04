# Java Course for `learnp` CLI

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an educational Java course repository designed to teach Java fundamentals through hands-on exercises. The project uses a structured approach where learners complete exercises by implementing classes and methods, then running tests to verify their solutions.

## Contributing
Contributions to improve exercises, add new ones, or enhance documentation are welcome! Please follow standard open source contribution practices (fork, branch, PR).
### Using AI
When using AI tools like Claude or GitHub Copilot, ensure that the generated code aligns with the learning objectives of the exercises. Avoid relying solely on AI-generated solutions; instead, use them as a guide to understand concepts better and revise exercises afterward.

## Repository Structure

```
learn-programming-java/
├── course.json           # Course metadata (name, description, author, version)
├── Roadmap.md           # Exercise roadmap showing progression and completion status
├── progress.db          # SQLite database tracking user progress
└── exercises/
  └── XXX-exercise-name/
    ├── src/
    │   └── XXX-exercise-name.java       # Exercise implementation file
    ├── test/
    │   └── XXX-exercise-nameTest.java  # Test file using JUnit
    ├── README.md                        # Exercise instructions
    ├── pom.xml                          # Maven configuration
    └── exercise.json                    # Optional - override default exercise metadata
```

Example exercise.json metadata:
```json
{
  "title": "Array Manipulation",
  "description": "Learn to work with arrays and common operations",
  "test_command": "mvn test",
  "setup_command": "mvn install",
  "context_files": ["src/XXX-exercise-name.java"],
  "context_patterns": ["src/**/*.java", "test/**/*.java"]
}
```
where:
- `title`: Exercise title
- `description`: Brief exercise description
- `test_command`: Command to run tests (default: `mvn test`)
- `setup_command`: Command to set up dependencies (default: `mvn install`)
- `context_files`: List of files to include as context in ollama requests
- `context_patterns`: Glob patterns to include additional files as context

## Running Exercises

Each exercise is self-contained in its own directory. To work with an exercise:

**Compile and run the exercise code:**
```bash
cd exercises/001-hello-world
javac src/001-hello-world.java
java -cp src 001-hello-world
```

**Run tests for an exercise:**
```bash
cd exercises/001-hello-world
mvn test
```

## Testing Framework

Exercises use JUnit 5 for testing. Tests verify the correctness of implemented methods through assertions.

Test structure:
- Uses `org.junit.jupiter.api.Test` and `org.junit.jupiter.api.Assertions`
- Tests use methods like `assertEquals()`, `assertTrue()`, and `assertThrows()`
- Tests capture output using `System.setOut()` for console verification

## Code Conventions

- **Package structure**: Exercise code uses package naming (e.g., `exercises.exercise001`)
- **Naming**: Exercise files follow the pattern `XXX-exercise-name.java` where XXX is a zero-padded number (e.g., `001-hello-world.java`)
- **Class naming**: Classes use PascalCase (e.g., `HelloWorld`)
- **Method exports**: Exercise methods are public for testing accessibility
- **Learning-first approach**: Code includes TODO comments to guide learners on what to implement

## Important Notes

- **Maven required**: Exercises use Maven for dependency management and test execution
- **Autocompletion guidance**: Exercise READMEs instruct learners to disable autocompletion tools (GitHub Copilot, etc.) to maximize hands-on learning
- **Java version**: Exercises require Java 11+ installed
- **JDK setup**: Ensure JAVA_HOME environment variable is properly configured

## Exercise README conventions
- **keep it concise**: Exercise READMEs focus on essential instructions only
- **keep it simple**: Learner is probably new to programming - avoid jargon or explain it clearly
- **code snippets**: Include code snippets for compiling, running exercises, and executing tests
- **explanations**: Provide brief explanations of concepts being taught