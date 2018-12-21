# repo-index
repository index for R programming language

The Application is built using Spring Boot. Please find below the instrucktions to build and run the application -

Note : All commands should be execute from project directory.
1) Build - mvn clean install
2) Once built, the artifact will be generated in ./src/app/target
3) execute -
java -jar target/repo-index-0.0.1-SNAPSHOT.jar
4) The Application will be started for use.
5) For simplicity of setup, I have used H2 embedded db in the project.
Note : This db is in memory database. So once you restart the application, your data would be deleted. To understand more about the db table constraints please refer /src/resources/schema.sql

6) Now Please bring your front-end up.