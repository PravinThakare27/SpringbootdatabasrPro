From openjdk:17
MAINTAINER pravin27@gmail.com
copy target/LibraryProject.jar LibraryProject.jar
ENTRYPOINT ["java","-jar","LibraryProject.jar"]
