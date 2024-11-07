# **Student Data Management API** using Spring Boot with Swagger UI

This project provides a simple RESTful API for managing student profiles, marks, and fees. It uses Spring Boot for the backend and integrates **Swagger UI** for easy API documentation and testing.

## Developer

👨‍💻 **Developer**: Udhya Kumar K.  
🏢 **Department**: Department of Computer Technology  

🌐**View my profile**: [UdhyaKumarKMIT](https://github.com/UdhyaKumarKMIT)  
💻**Leetcode**: [udhyak2004](https://leetcode.com/u/udhyak2004/)  

✉️ **Email**: udhyak2004@gmail.com  
📞 **Phone**: +91 9150653370

## Prerequisites
- **Java Version**: 1.8.0_401
- **JDK Version**: 23
- **Spring Boot Version**: v3.3.5
- **IDE**: IntelliJ IDEA

## Technologies Used
- Java
- Spring Boot
- Swagger UI

## Student Data Fields

- `id` (auto-generated int): Unique ID
- `name` (string): Not null and not blank
- `age` (int): Non-negative
- `course` (string): Not null
- `marks` (int): Between 0 and 100 (inclusive)
- `feesPaid` (boolean): Valid boolean

## Setup and Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/UdhyaKumarKMIT/StudentDataManagement-Spring-Boot-Restful-API.git
```

### Step 2: Verify JDK and Spring Boot Versions
Ensure your JDK is updated to version 23 and Spring Boot version is set to v3.3.5.

### Step 3: Run the Application

You can run the application directly from your IDE (IntelliJ IDEA) by running the `main` method in the `StudentDataManagementApplication.java` class.

1. Navigate to `StudentDataManagementApplication.java`.
2. Press the run ▶️ button or use `Shift + F10` to run.

The application will start, and you can access the API and Swagger UI as follows.

### Step 4: Access Swagger UI

Once the application is running, open a web browser and enter:

```http://localhost:8080/swagger-ui/index.html```

This will open an interactive Swagger UI page with all available endpoints.

### Step 5: Testing Endpoints

Select an endpoint you wish to test in Swagger and click "Try it out."

# API Testing Endpoints
---

### 1. GET /students

- **Method**: GET
- **Endpoint**: `/students`
- **Response**: List of all students in the database.

### 2. GET /students/{id}

- **Method**: GET
- **Endpoint**: `/students/{id}`
- **Response**: Retrieves a specific student by ID.

### 3. POST /students

- **Method**: POST
- **Endpoint**: `/students`
- **Request Body**:
  ```json
  {
    "name": "Udhya Kumar K",
    "age": 19,
    "course": "Computer Science",
    "marks": 100,
    "feesPaid": true
  }
  ```
- **Response**: Creates a new student record with an auto-generated `id`.

### 4. PUT /students/{id}

- **Method**: PUT
- **Endpoint**: `/students/{id}`
- **Request Body**:
  ```json
  {
    "name": "Vijay Kumar",
    "age": 49,
    "course": "Electronics",
    "marks": 98,
    "feesPaid": true
  }
  ```
- **Response**: Updates the student data with the specified ID.

### 5. DELETE /students/{id}

- **Method**: DELETE
- **Endpoint**: `/students/{id}`
- **Response**: Deletes the student with the specified ID.

---

This `README.md` provides clear instructions on setting up the project, running the API, and using Swagger to interact with the endpoints. It also includes details on configuring the database, testing the endpoints, and accessing the Swagger UI.
