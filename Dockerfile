#Uygulamanın çalışabilmesi için jdk lazım
#Abi bana java lazım
#FROM amazoncorretto:17
FROM openjdk:17
#Projemizin Jar dosyasınınn konumu

ARG JAR_FILE=target/*.jar

#Projenin Jar halini dockerın içine şu isimle kopyala,Büyük harf kullanma isimlendirmede
COPY ${JAR_FILE} devops-hello-app.jar
#terminalden çalıştırmak istediğin  komutları CMD ile kullaniyorsunuz.
CMD apt-get update
CMD apt-get upgrade -y

#iç portu sabitlemek için bunu sabitlemen lazım önemli
EXPOSE 5757
#uygulamanın çalışacağı komut
ENTRYPOINT ["java","-jar","devops-hello-app.jar"]


