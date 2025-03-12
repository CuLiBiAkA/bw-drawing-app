# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем jar-файл в контейнер
COPY target/*.jar app.jar

# Открываем порт для приложения
EXPOSE 8080

# Запускаем Spring Boot-приложение
ENTRYPOINT ["java", "-jar", "app.jar"]