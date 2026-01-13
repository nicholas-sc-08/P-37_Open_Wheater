# 🌄 P-37_Open_Weather

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=black)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=black)

Spring Boot application that integrates with the **OpenWeather API** to fetch and persist weather data.

## 🧮 Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/weather` | Returns all weather records previously saved in the database. |
| **GET** | `/weather/{city}` | Fetches real-time data for a specific city and saves it to `tbl_weather`. |

## 🔑 Prerequisite: OpenWeather API Key

To use this application, you need an API Key from OpenWeather:
1. Register at [OpenWeatherMap](https://openweathermap.org/api).

2. Generate your free API Key.

3. Add it to your `application.properties` and `compose.yaml`:
```properties
openweather.api.key=YOUR_API_KEY_HERE
```

## 🐋 Configurations of Docker

1. **Configure Environment Variables:**
   Update the `compose.yaml` file with your MySQL credentials:

```yaml
SPRING_DATASOURCE_USERNAME: root
SPRING_DATASOURCE_PASSWORD: your_password
SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/db_weather?createDatabaseIfNotExist=true
```

2. Application Properties: Ensure the src/main/resources/application.properties matches these credentials.

3. Run the Application: Open your terminal in the root folder and run:

```bash
docker compose up --build
```

Note: Make sure Docker Desktop is running before starting the containers.

## 🧪 Documentation (Swagger)

Once the application is running, you can explore and test the API through Swagger UI:

- http://localhost:8080/swagger-ui.html