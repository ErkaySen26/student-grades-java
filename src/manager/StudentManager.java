package manager;

import model.Student;
import java.util.*;

/**
 * StudentManager Class - Öğrenci yönetimi
 *
 * Öğrenme Hedefleri:
 * - HashMap<String, Student> kullanımı
 * - List sıralama (Comparator)
 * - Collections framework
 */
public class StudentManager {

    private Map<String, Student> students;
    private List<String> courseList;

    /**
     * Constructor - StudentManager oluşturur
     */
    public StudentManager() {
        this.students = new HashMap<>();
        this.courseList = new ArrayList<>();
    }
    /**
     * Yeni öğrenci ekler
     * @param student Eklenecek öğrenci
     */
    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("❌ Hata: Bu öğrenci zaten kayıtlı! ID: " + student.getId());
            return;
        }
        students.put(student.getId(), student);
        System.out.println("✅ Öğrenci eklendi: " + student.getName() + " (ID: " + student.getId() + ")");
    }

    /**
     * Öğrenci siler
     * @param id Silinecek öğrencinin ID'si
     */
    public void removeStudent(String id) {
        if (students.containsKey(id)) {
            Student removed = students.remove(id);
            System.out.println("✅ Öğrenci silindi: " + removed.getName());
        } else {
            System.out.println("❌ Öğrenci bulunamadı: " + id);
        }
    }

    /**
     * ID'ye göre öğrenci bulur
     * @param id Aranacak öğrencinin ID'si
     * @return Bulunan öğrenci (yoksa null)
     */
    public Student findStudent(String id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println("✅ Öğrenci bulundu:");
            System.out.println(student);
        } else {
            System.out.println("❌ Öğrenci bulunamadı: " + id);
        }
        return student;
    }
    /**
     * Öğrenciye ders notu ekler
     * @param studentId Öğrenci ID'si
     * @param course Ders adı
     * @param grade Not
     */
    public void addGrade(String studentId, String course, double grade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.addGrade(course, grade);
            if (!courseList.contains(course)) {
                courseList.add(course);
                System.out.println("📚 Yeni ders eklendi: " + course);
            }
        } else {
            System.out.println("❌ Öğrenci bulunamadı: " + studentId);
        }
    }

    /**
     * Öğrencinin ortalamasını hesaplar
     * @param studentId Öğrenci ID'si
     * @return Ortalama not
     */
    public double getStudentAverage(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            return student.calculateAverage();
        } else {
            System.out.println("❌ Öğrenci bulunamadı: " + studentId);
            return 0.0;
        }
    }
    /**
     * En başarılı n öğrenciyi listeler
     * @param n Listelenecek öğrenci sayısı
     */
    public void getTopStudents(int n) {
        if (students.isEmpty()) {
            System.out.println("❌ Henüz öğrenci kaydı yok!");
            return;
        }

        List<Student> studentsList = new ArrayList<>(students.values());
        studentsList.sort((s1, s2) -> Double.compare(s2.calculateAverage(), s1.calculateAverage()));

        System.out.println("\n🏆 En Başarılı " + Math.min(n, studentsList.size()) + " Öğrenci:");
        System.out.println("=".repeat(60));
        for (int i = 0; i < n && i < studentsList.size(); i++) {
            Student s = studentsList.get(i);
            System.out.printf("%d. %s - Ortalama: %.2f - Harf Notu: %s%n",
                    (i + 1), s.getName(), s.calculateAverage(), s.getLetterGrade());
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Tüm öğrencileri listeler
     */
    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ Henüz öğrenci kaydı yok!");
            return;
        }

        System.out.println("\n📋 Tüm Öğrenciler:");
        System.out.println("=".repeat(60));
        for (Student student : students.values()) {
            System.out.println(student);
        }
        System.out.println("=".repeat(60));
        System.out.println("Toplam öğrenci sayısı: " + students.size());
    }
    /**
     * Detaylı rapor gösterir
     */
    public void displayReport() {
        if (students.isEmpty()) {
            System.out.println("❌ Henüz öğrenci kaydı yok!");
            return;
        }

        System.out.println("\n📊 DETAYLI RAPOR");
        System.out.println("=".repeat(60));
        System.out.println("📚 Toplam Öğrenci Sayısı: " + students.size());
        System.out.println("📖 Toplam Ders Sayısı: " + courseList.size());
        System.out.printf("📈 Genel Ortalama: %.2f%n", calculateGeneralAverage());
        System.out.println("📋 Dersler: " + courseList);
        System.out.println("=".repeat(60));

        // Harf notlarına göre dağılım
        System.out.println("\n📊 Harf Notu Dağılımı:");
        String[] letterGrades = {"A", "B", "C", "D", "F"};
        for (String grade : letterGrades) {
            long count = students.values().stream()
                    .filter(s -> s.getLetterGrade().equals(grade))
                    .count();
            System.out.println(grade + ": " + count + " öğrenci");
        }

        System.out.println("\n🏆 En Başarılı 3 Öğrenci:");
        getTopStudents(3);
    }

    /**
     * Tüm öğrencilerin genel ortalamasını hesaplar
     * @return Genel ortalama
     */
    public double calculateGeneralAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Student student : students.values()) {
            sum += student.calculateAverage();
        }
        return sum / students.size();
    }

    /**
     * Belirli harf notuna sahip öğrencileri listeler
     * @param letterGrade Harf notu (A, B, C, D, F)
     */
    public void getStudentsByLetterGrade(String letterGrade) {
        System.out.println("\n📋 Harf Notu '" + letterGrade + "' Olan Öğrenciler:");
        System.out.println("=".repeat(60));
        boolean found = false;
        for (Student student : students.values()) {
            if (student.getLetterGrade().equals(letterGrade)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu harf notuna sahip öğrenci bulunamadı.");
        }
        System.out.println("=".repeat(60));
    }

    // Getter metodları
    public Map<String, Student> getStudents() {
        return students;
    }

    public List<String> getCourseList() {
        return courseList;
    }
}

