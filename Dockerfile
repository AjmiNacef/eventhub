# Étape 1 : Build Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier tout le projet
COPY . .

# Build Spring Boot
RUN mvn package -DskipTests

# Étape 2 : Image finale
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le jar généré
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port 8080
EXPOSE 8080

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
