# **Student Data Management API** using Spring Boot with Swagger UI

This project provides a simple RESTful API for managing student profiles, marks, and fees. It uses Spring Boot for the backend and integrates **Swagger UI** for easy API documentation and testing.

## Developer 👨‍💻

👨‍💻 **Developer**: Udhya Kumar K (2022503051)   
🏢 **Department**: Department of Computer Technology, Madras Institute of Technology   

🌐 **View my profile**: [UdhyaKumarKMIT](https://github.com/UdhyaKumarKMIT)  
💻 **Leetcode**: [udhyak2004](https://leetcode.com/u/udhyak2004/)  

✉️ **Email**: udhyak2004@gmail.com  
📞 **Phone**: +91 9150653370

---

## Prerequisites
- **Java Version**: 1.8.0_401
- **JDK Version**: openjdk-23
- **Spring Boot Version**: v3.3.5
- **IDE**: IntelliJ IDEA

---

## Technologies Used
- Java
- Spring Boot
- Swagger UI

---

## Student Data Fields

- `id` (auto-generated int)
- `name` (string): Not null and not blank
- `age` (int): Non-negative
- `course` (string): Not null
- `marks` (Double): Between 0 and 100 (inclusive)
- `feesPaid` (boolean): Valid boolean

## Validation and Exception Handling

### Validation Rules
The `Student` entity is created with field-level validation annotations to ensure data integrity,

- **Name**: 
  - Cannot be `null` (`@NotNull`).
  - Must have at least one character (`@Size(min = 1)`).

- **Age**: 
  - Must be a Non-negative (`@Positive`).

- **Course**: 
  - Cannot be `null` (`@NotNull`).

- **Marks**:
  - Must be a non-negative value (`@Min(value = 0)`).
  - Cannot exceed 100 (`@Max(value = 100)`).


When a request violates any of these validation rules, a `MethodArgumentNotValidException` is thrown. This exception is handled globally in the `GlobalExceptionHandler`, which formats the validation errors into a structured JSON response. Error messages are displayed in Swagger UI.

### Exception Handling
The `GlobalExceptionHandler` class implements centralized exception handling. This setup ensures that both validation errors and  custom exceptions are communicated effectively to Swagger UI. 

1. **StudentNotFoundException**:
   - Thrown when a requested student is not found 
   - Returns an HTTP `404 Not Found` response with message Student with id {id} is not present.

2. **StudentCreationException**:
   - Thrown when student creation fails.
   - Returns an HTTP `400 Bad Request` response with error message.

3. **StudentDeletionException**:
   - Thrown when a deletion attempt fails.
   - Returns an HTTP `400 Bad Request` response with a error message : Failed to delete Student. Student with ID {id} does not exist.

4. **MethodArgumentNotValidException**:
   - Thrown when validation of fields fails (e.g., due to `@NotNull`, `@Size`, `@Min`, `@Max` constraints).
   - Collects all validation error messages and returns them in a structured JSON format with an HTTP `400 Bad Request` status.

   ```json
   {
     "name": "Name cannot be null",
     "age": "Age must be a positive integer"
     "mark": "Marks must be non-negative or Marks can not exceed 100"
   }
   ```

---


## Setup and Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/UdhyaKumarKMIT/StudentDataManagement-Spring-Boot-Restful-API.git
```

### Step 2: Check if your JDK version is suitable for the running the  project
If not upgrade your JDK to JDK 23 and Spring Boot version V3.3.5.
Ensure that you have all dependencies installed.

### Step 3: Run the Application

You can run the application directly from your IDE (IntelliJ IDEA) by running the `main` method in the `StudentDataManagementApplication.java` class.

1. Navigate to `StudentDataManagementApplication.java`.
2. Press the run ▶️ button or use `Shift + F10` to run.

The application will start running ...

### Step 4: Access Swagger UI

Once the application is running, open a web browser and enter:

```bash
http://localhost:8080/swagger-ui/index.html
```

This will open an interactive Swagger UI page with all available endpoints.
Note : Click Execute button once and verify the output.

---

## API Endpoints

### 1. **GET /students**

- **Method**: GET
- **Endpoint**: `/students`
- **Response**: List of all students in the database.

### 2. **GET /students/{id}**

- **Method**: GET
- **Endpoint**: `/students/{id}`
- **Response**: Retrieves a specific student by ID.

### 3. **GET /students/courses/{course}**

- **Method**: GET
- **Endpoint**: `/students/courses/{course}`
- **Response**: Retrieves Student Studing a specific course


### 4. **POST /students**

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

### 5. **POST /students/bulk**

- **Method**: POST
- **Endpoint**: `/students/bulk`
- **Request Body**:
  ```json
  [
    {
      "name": "Udhya Kumar K",
      "age": 19,
      "course": "Computer Science",
      "marks": 100,
      "feesPaid": true
    },
    {
      "name": "Ram Kumar",
      "age": 20,
      "course": "Electronics",
      "marks": 45,
      "feesPaid": true
    },
    {
      "name": "Keerthy",
      "age": 21,
      "course": "Engineering Maths",
      "marks": 87,
      "feesPaid": true
    },
    {
      "name": "Kamal Hassan",
      "age": 22,
      "course": "Computer Science",
      "marks": 68,
      "feesPaid": true
    },
    {
      "name": "Ranjini Kanth",
      "age": 23,
      "course": "Engineering Physics",
      "marks": 92,
      "feesPaid": false
    },
    {
      "name": "Vijaya Kanth",
      "age": 24,
      "course": "Engineering Chemistry",
      "marks": 53,
      "feesPaid": true
    },
    {
      "name": "Vijay Kumar",
      "age": 20,
      "course": "Environmental Science",
      "marks": 75,
      "feesPaid": false
    },
    {
      "name": "Shankar",
      "age": 22,
      "course": "Literature",
      "marks": 89,
      "feesPaid": true
    },
    {
      "name": "KS Ravi Kumar",
      "age": 23,
      "course": "Biochemistry",
      "marks": 96,
      "feesPaid": false
    },
    {
      "name": "Siva Karthikeyan",
      "age": 21,
      "course": "Computer Science",
      "marks": 34,
      "feesPaid": true
    },
    {
      "name": "Dhoni",
      "age": 19,
      "course": "Electronics",
      "marks": 82,
      "feesPaid": true
    },
    {
      "name": "Virat Kohli",
      "age": 20,
      "course": "Engineering Maths",
      "marks": 71,
      "feesPaid": true
    },
    {
      "name": "Rohit",
      "age": 22,
      "course": "Engineering Physics",
      "marks": 46,
      "feesPaid": false
    },
    {
      "name": "Sachin",
      "age": 24,
      "course": "Engineering Chemistry",
      "marks": 78,
      "feesPaid": true
    },
    {
      "name": "Kapil Dev",
      "age": 23,
      "course": "Environmental Science",
      "marks": 99,
      "feesPaid": false
    },
    {
      "name": "Bumrah",
      "age": 21,
      "course": "Literature",
      "marks": 91,
      "feesPaid": true
    },
    {
      "name": "Shikhar Dhawan",
      "age": 20,
      "course": "Computer Science",
      "marks": 64,
      "feesPaid": false
    },
    {
      "name": "R Ashwin",
      "age": 22,
      "course": "Biochemistry",
      "marks": 48,
      "feesPaid": true
    },
    {
      "name": "Jadeja",
      "age": 21,
      "course": "Computer Science",
      "marks": 85,
      "feesPaid": false
    },
    {
      "name": "Rahul Dravid",
      "age": 23,
      "course": "Electronics",
      "marks": 58,
      "feesPaid": true
    },
    {
      "name": "Anil Kumble",
      "age": 24,
      "course": "Engineering Maths",
      "marks": 77,
      "feesPaid": true
    },
    {
      "name": "VVS Laxman",
      "age": 19,
      "course": "Engineering Physics",
      "marks": 38,
      "feesPaid": true
    },
    {
      "name": "Hardik Pandya",
      "age": 21,
      "course": "Environmental Science",
      "marks": 93,
      "feesPaid": false
    },
    {
      "name": "KL Rahul",
      "age": 20,
      "course": "Engineering Chemistry",
      "marks": 83,
      "feesPaid": true
    },
    {
      "name": "Yuvraj Singh",
      "age": 22,
      "course": "Computer Science",
      "marks": 55,
      "feesPaid": false
    }
  ]
  ```
- **Response**: Creates multiple student records with auto-generated `id`.

### 6. **PUT /students/{id}**

- **Method**: PUT
- **Endpoint**: `/students/{id}`
- **Request Body**:
  ```json
  {
    "name": "Shankar",
    "age": 49,
    "course": "Electronics",
    "marks": 98,
    "feesPaid": true
  }
  ```
- **Response**: Updates the student data with the specified ID.

### 7. **DELETE /students/{id}**

- **Method**: DELETE
- **Endpoint**: `/students/{id}`
- **Response**: Deletes the student with the specified ID.

---

## Additional API Endpoints

1. **GET /students/top/{n}**
   - **Method**: GET
   - **Endpoint**: `/students/top/{n}`
   - **Response**: Fetches Top n High Scorers.

2. **GET /students/marks/lesserthan/{mark}**
   - **Method**: GET
   - **Endpoint**: `/students/marks/lesserthan/{mark}`
   - **Response**: Fetches student who scored less than specified mark(strictly lesser).

3. **GET /students/marks/greaterthan/{mark}**
   - **Method**: GET
   - **Endpoint**: `/students/marks/greaterthan/{mark}`
   - **Response**: Fetches student who scored more than specified mark(strictly greater).

4. **GET /students/marks/between/{minMark}/{maxMark}**
   - **Method**: GET
   - **Endpoint**: `/students/marks/between/{minMark}/{maxMark}`
   - **Response**: Fetches student who scored between minMark and maxMark.

5. **GET /students/fees/paid**
   - **Method**: GET
   - **Endpoint**: `/students/fees/paid`
   - **Response**: Fetches student who has paid fees.

6. **GET /students/fees/notpaid**
   - **Method**: GET
   - **Endpoint**: `/students/fees/notpaid`
   - **Response**: Fetches student who has not paid fees.

7. **GET /students/courses**
   - **Method**: GET
   - **Endpoint**: `/students/courses`
   - **Response**: Retrieves Unique list of courses.



### **To Connect to Mysql Database **

### **1. Replace `application.properties`**
Replace your current `application.properties` file with the provided configuration. Make sure to use this:

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=root

# Hibernate properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

# Debugging
debug=true

# Application properties
spring.application.name=StudentDataManagement

# Swagger configuration
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.url=/v3/api-docs
```

---

### **2. Create the MySQL Database**
To ensure the database is ready:
1. Open a terminal or command prompt.
2. Run the following command to log into MySQL:
   ```bash
   mysql -u root -p -h localhost -P 3306
   ```
3. Once logged in, create the database:
   ```sql
   CREATE DATABASE student;
   ```

---

### **3. Verify MySQL Connection**
After creating the database:
1. Ensure MySQL service is running.
2. Verify the connection using the `spring.datasource.url`, `username`, and `password` provided in the `application.properties`.
3. Optionally, run `SHOW DATABASES;` within MySQL to confirm that the `student` database exists if does not exist create student database.

---
