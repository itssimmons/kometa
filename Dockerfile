FROM archlinux/archlinux:base

ENV VERSION=0.1.0-SNAPSHOT
ENV ROOT_PROJECT_NAME=kometa

RUN echo 'DisableSandbox' >> /etc/pacman.conf && \
		pacman -Syu --noconfirm && \
		pacman --noconfirm -S jdk21-openjdk

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"
ENV PATH="$PATH:/usr/local"

WORKDIR /package

COPY . .

RUN ./gradlew build --no-daemon --console=plain --no-watch-fs --stacktrace

HEALTHCHECK --interval=1m --timeout=5s --start-period=5s --retries=1 \
	CMD ( java -version || exit 1 ) && \
			( ./gradlew --version || exit 1 )

CMD [ "sh", "-c", "java -jar build/libs/${ROOT_PROJECT_NAME}-${VERSION}.jar" ]
