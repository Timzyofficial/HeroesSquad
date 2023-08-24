# Hero-Squad Project

Author: Timothy Karanja

## Description
The Hero-Squad project is a web application that allows users to create and manage squads of superheroes. Users can create squads, add heroes to them, and view squad information. The project is implemented using Java with the Spark framework and incorporates various features such as BDD testing, session management, and RESTful routing.

## Features
- User-friendly web interface for creating squads and managing heroes.
- BDD testing using JUnit for ensuring code functionality.
- Branching and version control for organized feature development.
- Persistent user data storage using sessions.
- Utilizes Spark's RESTful routing for seamless page navigation.
- Handles exceptions to enhance user experience.
- Deployed on Heroku for easy access and showcasing.

## Setup Instructions
1. Clone the repository: `git clone https://github.com/Timzyofficial/HeroesSquad.git`.
2. Navigate to the project directory: `cd Hero-Squad`.
3. Compile the Java code: `javac -cp "path/to/spark/library/*:." src/main/java/Main.java`.
4. Run the compiled code: `java -cp "path/to/spark/library/*:." Main`.
5. Open your web browser and access `http://localhost:8085` to interact with the application.

## Branching Strategy
- `master`: The main development branch.
- `feature/hero `: Creation of hero class
- `feature/squad `: The squad class
- `feature/Unittest `: Implementation of unit tests
- `feature/webinterface`: Implementation of website pages and rest handler

- ...

## Testing
- Unit tests are written using BDD practices.
- Run tests using `mvn test`.

## Exception Handling
- Proper exception handling ensures smooth user experience.
- Displays user-friendly error messages.

## Deployment
The project is deployed on Heroku and can be accessed at: [Heroku App Link](https://heroessquad.herokuapp.com/)

## Technologies Used
- Java
- Spark Framework
- JUnit
- Maven

## License
This project is licensed under the [MIT License](LICENSE).
Timzy® Official™ 

