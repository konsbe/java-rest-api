IMAGE=sci-tech-city-microservice-java-rest
IMGTAR=${IMAGE}.tar
HOST_PORT=8081

# Build the Docker image from the Dockerfile
build-img:
	sudo docker build -t sci-tech-city-java-rest:17-jdk-alpine .


# Run the Docker container locally
run:
	sudo docker run --name sci_tech_city_java_rest -it -p 8081:8081 --network host sci-tech-city-java-rest:17-jdk-alpine

# Stop and remove the Docker container if it's already running
clean:
	docker stop sci_tech_city_java_rest || true
	docker rm sci_tech_city_java_rest || true
