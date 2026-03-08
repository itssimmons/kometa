# Contributing to Kometrics

Thank you for taking the time to contribute! Whether it's a bug report, a new feature, or a documentation fix — all contributions are welcome.

Before getting started, please read the [Code of Conduct](CODE_OF_CONDUCT.md). By participating in this project, you agree to abide by its terms.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Building the Project](#building-the-project)
- [Running Locally](#running-locally)
- [Submitting an Issue](#submitting-an-issue)
- [Submitting a Pull Request](#submitting-a-pull-request)
- [Code Style](#code-style)

## Prerequisites

Make sure you have the following installed before working on the project:

- **Java 21**
- **Kotlin 2.x** (managed by Gradle, no manual install needed)
- **Gradle 9+** (or use the included Gradle wrapper)

## Getting Started

1. **Fork** the repository on GitHub.
2. **Clone** your fork locally:
   ```
   git clone https://github.com/<your-username>/kometrics.git
   cd kometrics
   ```
3. **Create a branch** for your change:
   ```
   git checkout -b feat/your-feature-name
   ```

## Building the Project

Use the Gradle wrapper to build the project:

```
./gradlew build
```

This will compile the source code and produce a fat JAR in `build/libs/`.

## Running Locally

To run the daemon locally after building:

```
java -jar build/libs/kometrics-0.1.0-SNAPSHOT.jar
```

Or run it directly via Gradle:

```
./gradlew run -q --console=plain
```

## Submitting an Issue

If you found a bug or have a feature request, please [open an issue](https://github.com/itssimmons/kometrics/issues) and include:

- A clear and descriptive title.
- Steps to reproduce the problem (for bugs).
- What you expected to happen vs. what actually happened.
- Your environment (OS, Java version, Kometrics version).

## Submitting a Pull Request

1. Make sure your branch is up to date with `main`:
   ```
   git fetch origin
   git rebase origin/main
   ```
2. Keep your changes focused — one PR per feature or fix.
3. Write clear, descriptive commit messages.
4. Open the pull request against the `main` branch and fill in the PR description explaining **what** changed and **why**.
5. A maintainer will review your PR and may request changes before merging.

## Code Style

- Follow standard [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html).
- The project uses `.editorconfig` — make sure your editor respects it.
- Keep functions small and focused.
- Add comments where the intent isn't immediately obvious.

If you have any questions, feel free to reach out at **simonvillafanee@gmail.com**.
