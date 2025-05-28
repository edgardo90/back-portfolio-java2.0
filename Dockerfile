# -------------------------
# ETAPA 1: Compilación
# -------------------------

# Usamos una imagen oficial de Maven con Java 8 (para compilar el proyecto)
FROM maven:3.8.7-eclipse-temurin-8 AS builder

# Copiamos todo el contenido del proyecto al contenedor (código fuente, pom.xml, etc.)
COPY . /app

# Definimos la carpeta de trabajo dentro del contenedor
WORKDIR /app

# Ejecutamos Maven para compilar el proyecto y generar el .jar
# -DskipTests saltea los tests para que compile más rápido
RUN ./mvnw clean package -DskipTests


# -------------------------
# ETAPA 2: Imagen final liviana
# -------------------------

# Usamos una imagen más liviana solo con Java 8 (sin Maven)
FROM eclipse-temurin:8-jdk

# Definimos la carpeta donde vivirá la app
WORKDIR /app

# Copiamos el .jar que se generó en la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Indicamos que el contenedor expone el puerto 8080 (Spring Boot por defecto)
EXPOSE 8080

# Comando que se ejecuta cuando arranca el contenedor: inicia la app
ENTRYPOINT ["java", "-jar", "app.jar"]
