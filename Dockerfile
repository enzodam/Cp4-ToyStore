# Usa uma imagem base para compilar o código
FROM maven:3-openjdk-17-slim AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml para baixar as dependências
COPY pom.xml .

# Baixa as dependências do Maven
RUN mvn dependency:go-offline -B

# Copia o código-fonte da aplicação
COPY src ./src

# Empacota a aplicação em um arquivo .jar
RUN mvn clean package -DskipTests

# --- Início da etapa de execução ---
# Usa uma imagem base menor para a execução do .jar
FROM openjdk:17-slim

# Define o diretório de trabalho
WORKDIR /app

# Cria um grupo e um usuário sem privilégios
RUN groupadd --system spring && useradd --system --gid spring spring

# Copia o arquivo .jar da etapa de build e muda o proprietário para o novo usuário
COPY --from=builder --chown=spring:spring /app/target/*.jar app.jar

# Define o novo usuário para executar a aplicação
USER spring

# Expõe a porta que a aplicação usa
EXPOSE 8080

# Define o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]