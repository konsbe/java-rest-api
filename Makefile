IMAGE=sci-tech-city-microservice-java-rest
IMGTAR=${IMAGE}.tar
HOST_PORT=8081

# Build the Docker image from the Dockerfile
build-img:
	sudo docker build -t java-rest:17-jdk-alpine .


# Run the Docker container locally
run:
	sudo docker run -it -dp 8081:8081 --network host java-rest:17-jdk-alpine

# Stop and remove the Docker container if it's already running
clean:
	docker stop java-rest || true
	docker rm java-rest || true
