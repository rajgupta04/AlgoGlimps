=======
# AlgoGlimps: Full-Stack Graph Algorithm Visualizer

AlgoGlimps lets you draw graphs in the browser and watch classic algorithms run step by step. This README is intentionally detailed (yes, long) so beginners can follow along without guessing. All commands are kept; pick the ones that match your OS and preferred workflow.

## Overview
- Build graphs visually (add, move, remove nodes and weighted edges).
- Run BFS, DFS, Dijkstra, Prim MST, and Floyd-Warshall and watch every step.
- Use the REST API directly for scripting or experiments.

## Requirements
- Java 17 (Spring Boot 3.5.x).
- Maven (or just the bundled wrappers: mvnw on macOS/Linux, mvnw.cmd on Windows).
- Git (to clone) or a ZIP download.
- Docker (optional, for container builds).
- A modern browser.

## Clone the project
```bash
git clone https://github.com/rajgupta04/AlgoGlimps.git
cd algoglimps/demo
```
If you downloaded a ZIP, unzip it and open a terminal inside the demo folder.

## Run locally (no Docker)
### Windows (PowerShell or Command Prompt)
```bat
mvnw.cmd spring-boot:run
```
Open http://localhost:8081 in your browser.

### macOS/Linux
```bash
./mvnw spring-boot:run
# or, if Maven is installed globally
mvn spring-boot:run
```
Open http://localhost:8081.

## Build a jar (no Docker)
### Windows
```bat
mvnw.cmd clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

  * **Backend:** **Java**, **Spring Boot**, REST API
  * **Frontend:** HTML Canvas, JavaScript, Tailwind CSS
  * **Tools & DevOps:** Docker, Maven, Git, **Google Cloud Run**

-----

### Getting Started

To run this project locally, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/algoglimps.git
    cd algoglimps
    ```
2.  **Build the Spring Boot application:**
    ```bash
    mvn clean package
    ```
3.  **Build the Docker image:**
    ```bash
    docker build -t algoglimps .
    ```
4.  **Run the Docker container:**
    ```bash
    docker run -p 8081:8081 algoglimps
    ```

The application will be accessible at `http://localhost:8081` in your browser.

## Run with Docker
Build the image (all platforms):
```bash
docker build -t algoglimps .
```
Run the container:
```bash
docker run -p 8081:8081 algoglimps
<<<<<<< HEAD
The application will be accessible at http://localhost:8081 in your browser.
>>>>>>> feature
=======
```
Open http://localhost:8081.

One-liner (if you publish an image):
```bash
docker run --pull=always -p 8081:8081 ghcr.io/your-username/algoglimps:latest
```
Replace the image name with yours.

## Common commands (copy-paste ready)
- Clean build: mvnw.cmd clean package (Windows) or ./mvnw clean package (macOS/Linux)
- Run app: mvnw.cmd spring-boot:run or ./mvnw spring-boot:run
- Run jar: java -jar target/demo-0.0.1-SNAPSHOT.jar
- Build Docker image: docker build -t algoglimps .
- Run Docker container: docker run -p 8081:8081 algoglimps
- Force dependency refresh: mvnw.cmd clean package -U or ./mvnw clean package -U

## Project layout (what lives where)
- src/main/java/com/example/demo — Spring Boot app and algorithm endpoints.
- src/main/resources/static/index.html — browser UI (graph editor + visualizer).
- src/main/resources/application.properties — app config (port defaults to 8081).
- Dockerfile — container build.
- pom.xml — dependencies and Java version.
- mvnw / mvnw.cmd — Maven wrappers.

## REST API (JSON)
Base path: /api/algorithms
- POST /bfs
- POST /dfs
- POST /dijkstra
- POST /mst (Prim)
- POST /floyd-warshall

### Example payload
```json
{
  "nodes": ["A", "B", "C"],
  "edges": [
    {"from": "A", "to": "B", "weight": 1},
    {"from": "B", "to": "C", "weight": 2}
  ],
  "startNode": "A",
  "targetNode": "C"
}
```
Response: ordered list of visualization steps.

### curl examples
#### Windows PowerShell
```powershell
curl -Method Post http://localhost:8081/api/algorithms/bfs \
  -H "Content-Type: application/json" \
  -Body '{"nodes":["A","B"],"edges":[{"from":"A","to":"B","weight":1}],"startNode":"A"}'
```

#### macOS/Linux
```bash
curl -X POST http://localhost:8081/api/algorithms/bfs \
  -H "Content-Type: application/json" \
  -d '{"nodes":["A","B"],"edges":[{"from":"A","to":"B","weight":1}],"startNode":"A"}'
```

## Using the UI
1) Start the app (via Maven, jar, or Docker).
2) Open http://localhost:8081.
3) Add nodes and weighted edges in the canvas.
4) Choose an algorithm (BFS, DFS, Dijkstra, MST, Floyd-Warshall).
5) Click run to watch the step-by-step visualization.

## Configuration
- Port: set server.port=8081 in src/main/resources/application.properties.
- Security: username/password are empty; authentication is effectively off for the demo.

## Tests
Run the test suite:
```bash
./mvnw test
# or on Windows
mvnw.cmd test
```

## Troubleshooting
- Port already in use: change server.port to a free port (e.g., 8085), then rerun.
- Maven wrapper not found: ensure you are inside the demo folder and use mvnw.cmd on Windows or ./mvnw on macOS/Linux.
- Java not found: install JDK 17 and verify with java -version.
- Slow Docker builds: docker build --pull -t algoglimps . to refresh base images.
- Dependency download issues: add -U to force updates (mvnw.cmd clean package -U).

## Cleaning up
- Stop the Spring Boot app with Ctrl+C in the terminal.
- Stop Docker container: docker ps to find the container ID, then docker stop <id>.
- Remove image if needed: docker rmi algoglimps.

Happy learning and experimenting!

