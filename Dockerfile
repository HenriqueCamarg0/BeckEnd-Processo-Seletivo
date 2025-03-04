# Primeira etapa: Compilação
FROM maven:3.8.4-openjdk-17 AS build

# Copia todo o projeto
COPY . /app/

# Define o diretório de trabalho
WORKDIR /app

# Executa o Maven para compilar o projeto
RUN mvn clean package -DskipTests

# Segunda etapa: Runtime
FROM eclipse-temurin:17-jre-focal

# Copia apenas o JAR compilado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Informa que a aplicação usa a porta 8080
EXPOSE 8080

# Comando para executar a aplicação com debug ativado
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]