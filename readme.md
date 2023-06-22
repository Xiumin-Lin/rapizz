# RaPizz

## Team
- Xiumin LIN
- Romain LOYER
- Quentin WESSER
- Louis CHEVEREAU

## Requirement
- Java    version 19+
- JavaFX  version 19+
- MySQL
- MySql connector java 8.0.25+

## Launch
1. Update the .env file in `src\main\resources\.env`
```.env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=Rapizz
DB_USER=root
DB_PASSWORD=<YourMySQLPassword>
```
2. In the root folder
```bach
./gradlew run
```