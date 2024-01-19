# Description

This is the backend microservice for the game Schack-Schack, that i am currently developing using Java Spring Boot
It includes the usage of Redis cache, Rest and WebSocket APIs

# Architecture

This section will soon be enhanced with diagrams using PlantUML.
The architecture will be kept simple as the development of the game should be fast and not much time-consuming.

# How to run

you need to install Docker on your local machine first [`docker-download-page`](https://www.docker.com/products/docker-desktop/)

### Run a RedisCache locally

```bash
docker run -d --name redis-stack-server -p 6379:6379 redis/redis-stack-server:latest
```

### Start the service locally
This should be easy for you, as you have here directly a maven wrapper provided.
If you are not using IntelliJ they you will need to start the jar file created by maven package using the command line

# ChangeLog
## [0.0.1] - 2024-01-19
- Update: added the first snapshot to the git repository and included a readme.md
