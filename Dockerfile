FROM archlinux:latest

RUN pacman -Syu --noconfirm && \
    pacman --noconfirm -S jdk21-openjdk unzip zip curl

RUN curl -s "https://get.sdkman.io" | bash && \
    source "$HOME/.sdkman/bin/sdkman-init.sh" && \
    sdk install kotlin && \
    sdk install gradle 9.0.0

HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=1 \
    CMD ( java -version || exit 1 ) && \
        ( kotlinc -version || exit 1 ) && \
        ( gradle -version || exit 1 )
