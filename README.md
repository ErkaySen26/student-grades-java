# 🎓 Student Grades Management System

> A Java application demonstrating **HashMap**, **Collections Framework**, and **data analysis** through a comprehensive student grade management system.

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## 📖 About The Project

This project showcases the power of Java's HashMap data structure by implementing a student grade management system with features like grade tracking, statistical analysis, and student performance reporting.

### 🎯 Learning Objectives

- ✅ **HashMap Mastery** - Key-value pair operations (course → grade mapping)
- ✅ **Map Operations** - put(), get(), keySet(), values(), containsKey()
- ✅ **Data Analysis** - Average calculation, highest/lowest grade finding
- ✅ **Sorting & Filtering** - Comparator usage, stream operations
- ✅ **Encapsulation** - Private fields with controlled access

---

## 🚀 Features

### Student Management
- ➕ Add new students with unique IDs
- 🗑️ Remove students from the system
- 🔍 Search students by ID
- 📋 List all students with their statistics

### Grade Operations
- 📝 Add grades for multiple courses
- 📊 Calculate student averages
- 🏆 Find top-performing students
- 🔤 Filter students by letter grade (A, B, C, D, F)

### Reporting & Analytics
- 📈 Detailed system reports
- 📉 Grade distribution analysis
- 🎯 Class average calculation
- 📊 Letter grade distribution

---

## 📂 Project Structure

```
04-student-grades/
├── src/
│   ├── Main.java                     # Entry point with interactive menu
│   ├── model/
│   │   └── Student.java              # Student class (HashMap usage)
│   └── manager/
│       └── StudentManager.java       # Student management operations
├── .gitignore
├── LICENSE
├── README.md
└── NOTES.md
```

---

## 💻 How to Run

### Prerequisites
- Java Development Kit (JDK) 17 or higher

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/ErkaySen26/student-grades-java.git
   cd student-grades-java
   ```

2. **Compile the project**
   ```bash
   javac -encoding UTF-8 -d bin src/model/*.java src/manager/*.java src/Main.java
   ```

3. **Run the application**
   ```bash
   java -cp bin Main
   ```

---

## 📸 Demo

```
📚 Örnek veriler yükleniyor...

✅ Öğrenci eklendi: Ahmet Yılmaz (ID: 2021001)
✅ Öğrenci eklendi: Ayşe Demir (ID: 2021002)
✅ Öğrenci eklendi: Mehmet Kaya (ID: 2021003)

============================================================
🎓 ÖĞRENCİ NOT YÖNETİM SİSTEMİ
============================================================
1. 👤 Öğrenci Ekle
2. 🗑️  Öğrenci Sil
3. 📝 Not Ekle
4. 🔍 Öğrenci Ara
5. 📋 Tüm Öğrencileri Listele
6. 🏆 En Başarılı Öğrenciler
7. 📊 Detaylı Rapor Göster
8. 🔤 Harf Notuna Göre Filtrele
9. 🚪 Çıkış
============================================================
```

---

## 🧪 Code Examples

### Creating a Student and Adding Grades
```java
// Create new student
Student student = new Student("2021001", "John Doe");

// Add course grades
student.addGrade("Mathematics", 85.5);
student.addGrade("Physics", 92.0);
student.addGrade("Chemistry", 78.5);

// Calculate average
double average = student.calculateAverage();
System.out.println("Average: " + average);  // Output: 85.33

// Get letter grade
String letterGrade = student.getLetterGrade();
System.out.println("Letter Grade: " + letterGrade);  // Output: B
```

### HashMap Usage in Student Class
```java
private Map<String, Double> grades = new HashMap<>();

public void addGrade(String course, double grade) {
    if (grade >= 0 && grade <= 100) {
        grades.put(course, grade);
        System.out.println(course + " grade added: " + grade);
    } else {
        System.out.println("Error: Grade must be between 0-100!");
    }
}
```

### Sorting Students by Average
```java
public void getTopStudents(int n) {
    List<Student> studentsList = new ArrayList<>(students.values());

    // Sort by average (descending)
    studentsList.sort((s1, s2) ->
        Double.compare(s2.calculateAverage(), s1.calculateAverage())
    );

    // Display top n students
    for (int i = 0; i < n && i < studentsList.size(); i++) {
        System.out.println(studentsList.get(i));
    }
}
```

---

## 📚 Key Concepts Demonstrated

### 1. HashMap Data Structure
- **Key-Value Pairs**: Course name → Grade mapping
- **O(1) Access Time**: Fast lookups and insertions
- **Dynamic Sizing**: Automatically grows as needed

### 2. Collections Framework
- **Map Interface**: put(), get(), containsKey(), keySet(), values()
- **List Interface**: ArrayList for sorting and filtering
- **Comparator**: Custom sorting logic

### 3. Object-Oriented Design
- **Encapsulation**: Private fields with public methods
- **Single Responsibility**: Each class has one clear purpose
- **Data Validation**: Input checking and error handling

### 4. Practical Applications
- **Statistical Analysis**: Average, highest, lowest calculations
- **Sorting Algorithms**: Comparator-based sorting
- **Filtering**: Stream operations and predicates
- **User Interaction**: Scanner-based menu system

---

## 🎨 Design Patterns Used

### Repository Pattern
The `StudentManager` class acts as a repository for student data:
```java
private Map<String, Student> students = new HashMap<>();

public void addStudent(Student student) {
    students.put(student.getId(), student);
}

public Student findStudent(String id) {
    return students.get(id);
}
```

---

## 🤝 Contributing

Suggestions and improvements are welcome!

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/NewFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## 📝 License

Distributed under the MIT License. See `LICENSE` for more information.

---

## 👤 Author

**Erkay Sen**

- GitHub: [@ErkaySen26](https://github.com/ErkaySen26)

---

## 🙏 Acknowledgments

- Part of my Java OOP learning series
- Demonstrates real-world data structure usage
- Foundation for understanding Spring Boot's data management

---

## 🔗 Related Projects

- [Person Management](https://github.com/ErkaySen26/person-management-java) - Classes & Encapsulation
- [Zoo System](https://github.com/ErkaySen26/zoo-system-java) - Inheritance & Polymorphism
- [Payment System](https://github.com/ErkaySen26/payment-system-java) - Interfaces & Strategy Pattern

---

**⭐ If you found this helpful, please give it a star!**
