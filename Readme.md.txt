Follow the below command to run image in docker:
aaa
docker run -p 3307:3306 mysql:5.7   ----------this will fetch the image from docker repo
mvn clean package ------------------this will create the image of our code
docker run --name employee-information --publish 5001:5000 --link mysql:mysql 162997/employeeinformation:0.0.1-SNAPSHOT  -----------this will create link with between application and mysql

