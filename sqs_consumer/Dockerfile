FROM bellsoft/liberica-openjdk-alpine-musl:15.0.1

MAINTAINER nizamiislamovs@gmail.com

VOLUME /tmp
EXPOSE 8080

ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.sqs_consumer.SqsConsumerApplication"]