package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Student Class - Öğrenci sınıfı
 *
 * Öğrenme Hedefleri:
 * - HashMap kullanımı (key-value pairs)
 * - Map işlemleri
 * - Ortalama hesaplama
 */
public class Student {

    private String id;
    private String name;
    private Map<String, Double> grades;

    /**
     * Constructor - Öğrenci oluşturur
     * @param id Öğrenci numarası
     * @param name Öğrenci adı
     */
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    /**
     * Ders notu ekler
     * @param course Ders adı
     * @param grade Not (0-100 arası)
     */
    public void addGrade(String course, double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.put(course, grade);
            System.out.println(course + " dersi için " + grade + " notu eklendi.");
        } else {
            System.out.println("Hata: Not 0-100 arasında olmalıdır!");
        }
    }

    /**
     * Mevcut ders notunu günceller
     * @param course Ders adı
     * @param grade Yeni not
     */
    public void updateGrade(String course, double grade) {
        if (grade >= 0 && grade <= 100) {
            if (grades.containsKey(course)) {
                grades.put(course, grade);
                System.out.println(course + " dersi notu " + grade + " olarak güncellendi.");
            } else {
                System.out.println("Hata: " + course + " dersi bulunamadı!");
            }
        } else {
            System.out.println("Hata: Not 0-100 arasında olmalıdır!");
        }
    }

    /**
     * Belirli bir dersin notunu getirir
     * @param course Ders adı
     * @return Not değeri (yoksa null)
     */
    public Double getGrade(String course) {
        return grades.get(course);
    }

    /**
     * Tüm derslerin ortalamasını hesaplar
     * @return Ortalama not
     */
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    /**
     * Ortalamaya göre harf notu döndürür
     * @return Harf notu (A, B, C, D, F)
     */
    public String getLetterGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Kaç ders aldığını döndürür
     * @return Ders sayısı
     */
    public int getCourseCount() {
        return grades.size();
    }

    /**
     * Tüm ders isimlerini yazdırır
     */
    public void displayAllCourses() {
        System.out.println("Dersler:");
        for (String course : grades.keySet()) {
            System.out.println("- " + course + ": " + grades.get(course));
        }
    }

    /**
     * En yüksek notu döndürür
     * @return En yüksek not
     */
    public double getHighestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double highest = 0;
        for (double grade : grades.values()) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    /**
     * En düşük notu döndürür
     * @return En düşük not
     */
    public double getLowestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double lowest = 100;
        for (double grade : grades.values()) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    // Getter ve Setter metodları
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Double> grades) {
        this.grades = grades;
    }

    /**
     * Öğrenci bilgilerini string olarak döndürür
     * @return Öğrenci bilgileri
     */
    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', average=%.2f, letterGrade='%s', courses=%d}",
                id, name, calculateAverage(), getLetterGrade(), getCourseCount());
    }
}
