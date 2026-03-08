# 🪁 Kometa

Kometa is a very lightweight and straightforward daemon for collecting and analyzing metrics from the hardware of the machine where it is hosted.

## Table of Contents

- [Installation](#installation)
- [Documentation](#documentation)
- [Compatibility Matrix](#compatibility-matrix)
- [Contributing](#contributing)
- [License](#license)

## Installation

Check for the latest release on [GitHub Releases](https://github.com/itssimmons/kometrics/releases) and download the appropriate binary for your platform. Follow the installation instructions provided in the release notes.

## Setup and Usage

After installation, you can start the Kometa daemon by running the following command in your terminal:

### Linux

```bash
kometad daemon
```

Or if you have `systemd` installed, you can start the service with:

```bash
sudo systemctl enable kometa
sudo systemctl start kometa
```

### Windows and macOS (Experimental)

For Windows and macOS, you can run the daemon using the command line:

```bash
docker run -d --name kometad -p 8080:8080 itssimmons/kometa:latest
```

Due to the fact that native support for Windows and macOS is still in development, running Kometa in a Docker container is the recommended approach for these platforms, keep in mind that some hardware metrics may not be available or may have limited functionality when running in a containerized environment.

## Documentation

For futher information, please refer to the documentation:

- [Getting Started](docs/getting-started.md)
- [Usage](docs/usage.md)
- [Swagger API](docs/swagger.md)

## Compatibility Matrix

| Kometrics Version | Kotlin Version | Java Version | Gradle Version | Platform    |
| ----------------- | -------------- | ------------ | -------------- | ----------- |
| 0.1.0-SNAPSHOT    | 2.3.10         | 21           | 9.0.0          | linux/amd64 |

## Contributing

I will glad to accept contributions to this project. If you have any ideas or suggestions, please feel free to open an issue or submit a pull request.

> [!NOTE]
> Before anything, please check [CONTRIBUTING.md](CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for guidelines and rules.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
