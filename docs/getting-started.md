# Getting started

## Prerequisites

Before you can use Kometa, make sure you have the following prerequisites installed on your system:

1. **Java 21**: Kometa is built using Kotlin, which runs on the Java Virtual Machine (JVM). You can download Java 21 from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or use a package manager like `sdkman` or `homebrew`, depending on your operating system.
2. **Kotlin 2.x**: Kotlin is managed by Gradle, so you don't need to install it manually. It will be downloaded automatically when you build the project.
3. **Gradle 9+**: You can use the included Gradle wrapper, so you don't need to install Gradle globally. However, if you prefer to have Gradle installed on your system, you can download it from the [official Gradle website](https://gradle.org/install/).
4. **Operating System**: Kometa is designed to run on Linux for now, it can also be run on Windows and macOS using WSL or Docker, but native support for these platforms is planned for the future.
5. **Docker** (optional): If you prefer to run Kometa in a containerized environment, you can install Docker from the [official Docker website](https://www.docker.com/get-started).
6. **Systemd** (optional): If you want to run Kometa as a system service on Linux, make sure you have `systemd` installed and configured on your system.

## Installation

To install Kometa, check the [releases page](https://github.com/itssimmons/kometa/releases) for the latest version and download the appropriate package for your operating system. Follow the installation instructions provided in the release notes.

## Running the Daemon (in development)

After installation, you can start the Kometa daemon by running the following command in your terminal:

```bash
kometad daemon
```

Or if you have `systemd` installed, you can start the service with:

```bash
sudo systemctl enable kometa
sudo systemctl start kometa
```

## Configuration (in development)

The default configuration file is located at `~/.kometa/config.yaml`. You can edit this file to customize the behavior of the daemon. For example, you can set the port it listens on, enable or disable certain features, and configure logging.

## Using the CLI (in development)

Kometa also provides a command-line interface (CLI) for interacting with the daemon. You can use the following commands:

- `kometad status`: Check the status of the daemon.
- `kometad stop`: Stop the daemon.
- `kometad restart`: Restart the daemon.
