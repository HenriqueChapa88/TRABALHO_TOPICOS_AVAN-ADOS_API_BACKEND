# Etapa 1: Build da aplicação
FROM maven:3-eclipse-temurin-25-alpine AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Imagem final (somente o jar)
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

# Copia apenas o JAR gerado
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão (opcional)
EXPOSE 8081

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]