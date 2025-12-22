<<<<<<< HEAD

### AlgoGlimps: A Full-Stack Graph Algorithm Visualizer

AlgoGlimps is an interactive, full-stack web application designed to visualize and teach fundamental graph algorithms. The project provides a dynamic platform for users to build custom graphs and observe the step-by-step execution of algorithms in real-time.

-----

### Features

  * **Interactive Graph Editor:** Create and manipulate custom graphs by adding, moving, and removing nodes and edges with weights.
  * **Real-Time Visualization:** Watch the live execution of algorithms like BFS, DFS, Dijkstra's, Floyd-Warshall, and Minimum Spanning Tree (Prim's).
  * **AI-Powered Learning:** Integrate the **Gemini API** to provide on-demand, context-aware explanations of each algorithm and its logic.
  * **Cloud-Native Deployment:** The application is containerized with **Docker** and deployed on **Google Cloud Run** for a scalable, portable, and reproducible environment.

-----

### Technology Stack

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
=======
AlgoGlimps: A Full-Stack Graph Algorithm Visualizer
AlgoGlimps is an interactive, full-stack web application designed to visualize and teach fundamental graph algorithms. The project provides a dynamic platform for users to build custom graphs and observe the step-by-step execution of algorithms in real-time.

Features
Interactive Graph Editor: Create and manipulate custom graphs by adding, moving, and removing nodes and edges with weights.

Real-Time Visualization: Watch the live execution of algorithms like BFS, DFS, Dijkstra's, Floyd-Warshall, and Minimum Spanning Tree (Prim's).

AI-Powered Learning: Integrate the Gemini API to provide on-demand, context-aware explanations of each algorithm and its logic.

Cloud-Native Deployment: The application is containerized with Docker and deployed on Google Cloud Run for a scalable, portable, and reproducible environment.

Technology Stack
Backend: Java, Spring Boot, REST API

Frontend: HTML Canvas, JavaScript, Tailwind CSS

Tools & DevOps: Docker, Maven, Git, Google Cloud Run

Getting Started
To run this project locally, follow these steps:

Clone the repository:

Bash

git clone https://github.com/engineerrajgupta/AlgoGlimps.git
cd algoglimps
Build the Spring Boot application:

Bash

mvn clean package
Build the Docker image:

Bash

docker build -t algoglimps .
Run the Docker container:

Bash

docker run -p 8081:8081 algoglimps
The application will be accessible at http://localhost:8081 in your browser.
>>>>>>> feature
