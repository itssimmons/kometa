FROM archlinux:latest

RUN pacman -Syu --noconfirm && \
    pacman --noconfirm -S jdk21-openjdk unzip zip curl

RUN curl -sLO https://github.com/JetBrains/kotlin/releases/download/v2.3.10/kotlin-compiler-2.3.10.zip && \
    unzip kotlin-compiler-2.3.10.zip -d /usr/local/ && \
    rm kotlin-compiler-2.3.10.zip

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"
ENV PATH="$PATH:/usr/local"

WORKDIR /package

COPY . .

RUN ./gradlew build --no-daemon --quiet --console=plain

HEALTHCHECK --interval=1m --timeout=5s --start-period=5s --retries=1 \
    CMD ( java -version || exit 1 ) && \
        ( kotlinc -version || exit 1 )

ENTRYPOINT [ "./gradlew" ]

CMD [ "run", "--quiet", "--console=plain" ]
