# **Student Data Management API** using Spring Boot with Swagger UI
---

## Description

This project provides a simple RESTful API for managing student profiles, marks, and fees. It uses Spring Boot for the backend and integrates **Swagger UI** for easy API documentation and testing.

---

## Developer

👨‍💻 **Developer**: Udhya Kumar K.  
🏢 **Department**: Department of Computer Technology  

**View my profile**: [UdhyaKumarKMIT](https://github.com/UdhyaKumarKMIT)  
**Leetcode**: [udhyak2004](https://leetcode.com/u/udhyak2004/)  

✉️ **Email**: udhyak2004@gmail.com  
📞 **Phone**: +91 9150653370

---

## Prerequisites
- **Java Version**: 1.8.0_401
- **JDK Version**: 23
- **Spring Boot Version**: v3.3.5
- **IDE**: IntelliJ IDEA .

## Technologies Used

- Java
- Spring Boot
- Swagger UI

## Student Data Fields

  - `id` (auto-generated int)     Unique Id
- `name`  string                  Not Null and Not blank
- `age`    int                    Non-negative
- `course` string                 Not Null
- `marks` int                     Between 0 and 100 (incl)
- `feesPaid`  boolean             valid boolean

## Setup and Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/UdhyaKumarKMIT/StudentDataManagement-Spring-Boot-Restful-API.git
```

### Step 2: Check if your JDK version is suitable for the running the  project
if not upgrade your JDK to JDK 23 and Spring Boot version V3.3.5.
Ensure that you have all dependencies installed

### Step 3: Run the Application

You can run the application directly from your IDE (IntelliJ IDEA) by running the `main` method in the `StudentDataManagementApplication.java` class.

Alternatively, run the following Maven command:

```bash
mvn spring-boot:run
```

The application will start, and you can access the API and Swagger UI at:



### Step 5: Access Swagger UI

Once the application is running, you can open the Swagger UI to see and test all the available endpoints:

1. Open a web browser.
2. Enter  ```bash
http://localhost:8080/swagger-ui/index.html```
3. You should see an interactive Swagger UI page with all available endpoints listed.

### Step 6: Testing Endpoints

Select Endpoint which you want to test and click Try this .

- **GET /students**: Retrieve all students.
- **POST /students**: Create a new student profile.
- **GET /students/{id}**: Retrieve a specific student profile by ID.
- **PUT /students/{id}**: Update a student profile.
- **DELETE /students/{id}**: Delete a student profile.

# API Testing Endpoints
---

### 1. GET/students

- **Method**: GET
- **Endpoint**: `/students`
- **Response**: List of all students in the database.

### 2. GET /students/{id}

- **Method**: GET
- **Endpoint**: `/students/{id}`
- **Response**:Retrieve a specific student by id
  
### 3. Add New Student

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
  ``**Response:** New Student record is created with an auto-generated `id`.
### 4. Update Student Data

- **Method**: PUT
- **Endpoint**: `/students/{id}`
- **Request Body**:
  ```json
  {
  "name": "Vijay Kumar ",
  "age": 49,
  "course": "Electronics",
  "marks": 98,
  "feesPaid": true
}
  ```

### 5. Delete Student

- **Method**: DELETE
- **Endpoint**: `/students/{id}`
- **Response**: Delete the student with specific id.


---

This `README.md` provides clear instructions on setting up the project, running the API, and using Swagger to interact with the endpoints. It also includes details on configuring the database, testing the endpoints, and accessing the Swagger UI.
