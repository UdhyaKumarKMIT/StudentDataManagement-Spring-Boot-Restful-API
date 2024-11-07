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

## Setup and Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/student-data-management-api.git
```

### Step 2: Check if your JDK version is suitable for the running the  project
if not upgrade your JDK to JDK 23


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

Select Endpoint which you want to test and click Try this , provide the inputs and click Try this.

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




# API Testing Endpoints

This API allows for the management of student profiles, including retrieval, creation, updating, and deletion. Below are the endpoints available for testing, along with example requests and expected responses.

---

## 1. Get All Students

**Method:** GET  
**Endpoint:** `http://localhost:8080/students`  
**Response:** A list of all students in the database, with each student record containing the following fields:  
- `id` (auto-generated)
- `name`
- `age`
- `course`
- `marks`
- `feesPaid`

**Copy Endpoint**: `http://localhost:8080/students`

---

## 2. Get Student by ID

**Method:** GET  
**Endpoint:** `http://localhost:8080/students/{id}`  
**Response:** Details of a specific student identified by their `id`, including the `name`, `age`, `course`, `marks`, and `feesPaid` columns.

**Copy Endpoint**: `http://localhost:8080/students/{id}`

---

## 3. Add New Student

**Method:** POST  
**Endpoint:** `http://localhost:8080/students`  
**Request Body Example:**
```json
{
  "name": "John Doe",
  "age": 20,
  "course": "Computer Science",
  "marks": 80,
  "feesPaid": 5000
}
```
**Response:** The newly created student record with an auto-generated `id`.

**Copy Endpoint**: `http://localhost:8080/students`

---

## 4. Update Student Data

**Method:** PUT  
**Endpoint:** `http://localhost:8080/students/{id}`  
**Request Body Example:**
```json
{
  "name": "John Doe Updated",
  "age": 21,
  "course": "Computer Science",
  "marks": 90,
  "feesPaid": 5500
}
```
**Response:** The updated student record.

**Copy Endpoint**: `http://localhost:8080/students/{id}`

---

## 5. Delete Student

**Method:** DELETE  
**Endpoint:** `http://localhost:8080/students/{id}`  
**Response:** Confirmation of the deletion of the specified student profile.

**Copy Endpoint**: `http://localhost:8080/students/{id}`

--- 

Each endpoint should be tested individually to ensure proper CRUD functionality.
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

This `README.md` provides clear instructions on setting up the project, running the API, and using Swagger to interact with the endpoints. It also includes details on configuring the database, testing the endpoints, and accessing the Swagger UI.
