FROM openjdk:11
COPY "./target/CuadraturaPMM_WMS_JOB-0.0.1-SNAPSHOT.jar" "jobCuadratura.jar"
EXPOSE 9001
ENTRYPOINT  ["java","-jar","jobCuadratura.jar"]