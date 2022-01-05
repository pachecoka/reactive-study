FROM gradle:7.3.1-jdk11

ARG PROJECT_NAME="reactive-study"
ARG PROJECT_VERSION="1.0.0"
ENV PROJECT=${PROJECT_NAME}-${PROJECT_VERSION}.jar

WORKDIR /opt/${PROJECT_NAME}/
COPY ./ ./

RUN gradle clean build -Pversion=${PROJECT_VERSION}
RUN mv ./build/libs/${PROJECT} /opt/${PROJECT_NAME}/

EXPOSE 8080

CMD ["sh", "-c", "java -jar ${PROJECT}"]