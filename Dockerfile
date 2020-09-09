# 需要依赖jdk
FROM openjdk:8
#将jar包传大docker上
ADD web-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]