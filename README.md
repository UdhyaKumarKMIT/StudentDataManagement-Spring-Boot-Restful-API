# **Student Data Management API** using Sprint Boot with Swagger UI

## Description

This project provides a simple RESTful API for managing student profiles, marks, and fees. It uses Spring Boot for the backend and integrates **Swagger** for API documentation and testing.

## Prerequisites

- **JDK Version**: 11 or later
- **Spring Boot Version**: 2.x (preferably 2.7.x or later)
- **IDE**: IntelliJ IDEA or any IDE that supports Java development.

## Technologies Used

- Java
- Spring Boot
- Swagger for API documentation

## Setup and Run

### Step 1: Clone the Repository

Clone the repository using the following Git command:

```bash
git clone https://github.com/your-username/student-data-management-api.git
```

### Step 2: Check if your JDK version is {}  for the project
if not upgrade your JDK 
```


### Step 3: Run the Application

You can run the application directly from your IDE (IntelliJ IDEA) by running the `main` method in the `StudentDataManagementApplication.java` class.

Alternatively, run the following Maven command:

```bash
mvn spring-boot:run
```

The application will start, and you can access the API and Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

### Step 5: Access Swagger UI

Once the application is running, you can open the Swagger UI to see and test all the available endpoints:

1. Open a web browser.
2. Type `http://localhost:8080/swagger-ui/index.html`.
3. You should see an interactive Swagger UI page with all available endpoints listed.

### Step 6: Testing Endpoints

Select Endpoint which you want to test and click Try this , provide the inputs and click execute.

Swagger UI provides a simple interface to test the API. You can click on any endpoint to expand it and see options to:

- **Execute**: Send a request to the endpoint.
- **Copy**: Copy the cURL command to run the request from a terminal.

Here are some sample endpoints that you can test:

- **GET /students**: Retrieve all students.
- **POST /students**: Create a new student profile.
- **GET /students/{id}**: Retrieve a specific student profile by ID.
- **PUT /students/{id}**: Update a student profile.
- **DELETE /students/{id}**: Delete a student profile.


## Example Endpoints

Here are some of the available API endpoints:

### 1. Get All Students

- **Method**: GET
- **Endpoint**: `/students`
- **Response**: List of all students in the database.

### 2. Get Student by ID

- **Method**: GET
- **Endpoint**: `/students/{id}`
- **Response**: A specific student by ID.

### 3. Add New Student

- **Method**: POST
- **Endpoint**: `/students`
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "marks": 80,
    "fees": 5000
  }
  ```

### 4. Update Student Data

- **Method**: PUT
- **Endpoint**: `/students/{id}`
- **Request Body**:
  ```json
  {
    "name": "John Doe Updated",
    "marks": 90,
    "fees": 5500
  }
  ```

### 5. Delete Student

- **Method**: DELETE
- **Endpoint**: `/students/{id}`

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

This `README.md` provides clear instructions on setting up the project, running the API, and using Swagger to interact with the endpoints. It also includes details on configuring the database, testing the endpoints, and accessing the Swagger UI.
