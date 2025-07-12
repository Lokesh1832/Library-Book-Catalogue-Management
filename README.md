# 📚 Library Book-Catalogue Management System (Java + Spring Boot)

This repository contains **two versions** of a Java-based Library Book Management System using Spring Boot:

---

## 🔀 Project Versions

### ✅ 1. Simple Version (In-Memory using List & Map)
- Stores book data using in-memory structures like `HashMap` and `List`.
- No external database required.
- Perfect for demonstrating object-oriented principles and RESTful API design.

### ✅ 2. SQL Version (JPA + MySQL + Hibernate)
- Uses a MySQL database with Spring Data JPA.
- Demonstrates real-world backend design using persistence.
- Automatically manages table creation via JPA entities.

---

## 🚀 Running Either Version Locally

### 📂 Step 1: Import the Project into Eclipse
1. Clone or download the GitHub repository.
2. Open Eclipse → `File` → `Import` → `Existing Maven Projects`.
3. Select the root folder.
4. Choose the version you want to run (`simple-version` or `sql-version`).
5. Let Maven build the project.

---

## 🔗 Postman Collection Links

- **Simple Version**: [👉 Postman Collection Link](https://lokeshsingh-3934226.postman.co/workspace/Lokesh-Singh's-Workspace~f28af21e-41e0-4607-8e76-e48966d26f0c/collection/45893954-6ca73e1b-f3bb-4a90-9dab-1533a09356fc?action=share&creator=45893954)
- **SQL Version**: [👉 Postman Collection Link](https://lokeshsingh-3934226.postman.co/workspace/Lokesh-Singh's-Workspace~f28af21e-41e0-4607-8e76-e48966d26f0c/collection/45893954-38ba208f-a1ea-4821-b11c-2905fe7508ac?action=share&creator=45893954)

---

## 📥 How to Open Postman Collection

1. Click on the above Postman link.
2. It will open in your browser → Click **"Run in Postman"**.
3. Postman will launch and import the full collection.
4. You can now run each request by selecting it from the left pane and clicking **Send**.
5. For POST request, you have to provide input from Postman:
   - Select `Body` option just below the tab where we put URL.
   - Select `raw` then on the right side select the format from dropdown `JSON`
   - Now provide the input in the JSON format in the below space, for example- <br>
     {
       "title": "To Kill a Mockingbird",
       "author": "Harper Lee",
       "isbn": "9780061120084",
       "availability": true
     }
6. For Providing Multiple books at a time , then enclose all the books in `[ ]`.
---

## 🧪 Simple Version (In-Memory) – How to Use

### ✅ Run the Project:
- Port used: `8080`
- No need to create a database or table.
- Just run the Spring Boot app, right click on `src/main/java` then select Run As-Java Application.

### 📋 Sample API Usage:

| Action | Method | URL | Sample Input | Sample Output |
|--------|--------|-----|---------------|----------------|
| Add Single Book | POST | `http://localhost:8080/books` | `{ "title": "Clean Code", "author": "Robert C. Martin", "isbn": "9780132350884", "availability": true }` | `"Book added with ID: 1"` |
| Add Multiple Books | POST | `http://localhost:8080/books/batch` | `[{ "title": "Working Effectively with Legacy Code", "author": "Michael Feathers", "isbn": "9780131177055", "availability": true },{ "title": "Test-Driven Development: By Example", "author": "Kent Beck", "isbn": "9780321146533", "availability": true }]` | `"2 books added successfully"` |
| Get All Books | GET | `http://localhost:8080/books` | — | List of All books |
| Get Book by ID | GET | `http://localhost:8080/books/1` | — | Details of a specific book by ID |
| Update Availability | PATCH | `http://localhost:8080/books/1/availability?available=false` | — | `"Availability updated for book ID: 1"` |
| Delete Book | DELETE | `http://localhost:8080/books/1` | — | `"Book deleted successfully"` |

---

## 🧪 SQL_version (MySql, JPA, Hibernate) – How to Use

### ✅ Run the Project:
- Port used: `8081` (Port is changed to easily run and test the two projects separately on different ports)

### ✅ How to create Database on your machine and connect it to Springboot:
🧾 Step 1: Create Database in MySQL Workbench
- Open MySQL Workbench.
- Connect to your local server.
- Click on the “+” button next to “MySQL Connections” (if not already added).

In the Query Editor, paste and run the following SQL command:
- CREATE DATABASE library_db; <br>
✅ This will create a database named library_db that Spring Boot will use to create the book table automatically.

⚙️ Step 2: Configure application.properties
Go to the file:
- src/main/resources/application.properties

Replace or add the following properties:

server.port=8081 <br>
spring.datasource.url=jdbc:mysql://localhost:3306/library_db <br>
spring.datasource.username=your_mysql_username <br>
spring.datasource.password=your_mysql_password <br>
spring.jpa.hibernate.ddl-auto=update <br>
spring.jpa.show-sql=true <br>

🔑 Replace your_mysql_username and your_mysql_password with your actual MySQL credentials (for example: root and 1234).

⚙️ Step 3: Run the project
- Just run the Spring Boot app, right click on `src/main/java` then select Run As-Java Application.

### 📋 Sample API Usage:

| Action | Method | URL | Sample Input | Sample Output |
|--------|--------|-----|---------------|----------------|
| Add Single Book | POST | `http://localhost:8080/books` | `{ "title": "Clean Code", "author": "Robert C. Martin", "isbn": "9780132350884", "availability": true }` | `"Book added with ID: 1"` |
| Add Multiple Books | POST | `http://localhost:8080/books/batch` | `[{ "title": "Head First Design Patterns", "author": "Eric Freeman", "isbn": "9780596007126", "availability": true },{ "title": "Domain-Driven Design", "author": "Eric Evans", "isbn": "9780321125217", "availability": true }]` | `"2 books added successfully"` |
| Get All Books | GET | `http://localhost:8080/books` | — | List of All books |
| Get Book by ID | GET | `http://localhost:8080/books/1` | — | Details of a specific book by ID |
| Update Availability | PATCH | `http://localhost:8080/books/1/availability?available=false` | — | `"Availability updated for book ID: 1"` |
| Delete Book | DELETE | `http://localhost:8080/books/1` | — | `"Book deleted successfully"` |

---

# ✅ Verify the Table and Data in MySQL
Now on running the project, you can perform the above APIs to manipulate the database (e.g., add, update, delete books) using Postman.

### To verify the data in MySQL Workbench:
- Open your SQL query window in MySQL Workbench.
- Run the following commands step by step:
1. USE library_db;
2. SHOW TABLES; <br>
✅ You will see a table named: book
3. Now fetch all data inside the table using: <br>
SELECT * FROM book; <br>
<br>
📌 You’ll see that all the books added using Postman (via POST requests) are now stored in the table.

---

# 📦 Summary
This project demonstrates a complete Java-based RESTful API implementation for managing a library’s book catalog using Spring Boot. To provide flexibility and showcase different backend approaches, the project is implemented in two versions:

## 🔹 Version A: Simple In-Memory (List + Map)
- No database is used.
- All book data is stored temporarily in memory using a HashMap.
- Demonstrates core Java concepts like:
- Object-Oriented Programming (OOP)
- Interfaces and Implementations
- Encapsulation and Service Layer architecture
- Fully testable via Postman, with support for:
   - Adding single or multiple books
   - Fetching all books or by ID
   - Deleting books
   - Updating availability (PATCH)

#### 👉 Ideal for lightweight demonstrations and beginner-level backend practice.

## 🔹 Version B: MySQL + Spring Data JPA
- Uses a real MySQL database with automatic table creation via @Entity.
- Demonstrates:
- Full integration with a relational database
- Use of Spring Data JPA (JpaRepository)
- Real-world database-backed REST API practices
- Requires a one-time database setup in MySQL Workbench
- Application reads from and writes to the library_db database
- All operations are persisted — data stays even after server restarts

### 👉 Ideal for realistic backend simulations and production-like structure.

## Postman Collection
Both versions include a Postman Collection with all API requests:
- POST (Add book/s)
- GET (Fetch all / by ID)
- PATCH (Update availability)
- DELETE (Remove book)
