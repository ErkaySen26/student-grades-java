import manager.StudentManager;
import model.Student;
import java.util.Scanner;

/**
 * Main Class - Öğrenci Not Sistemi
 *
 * Öğrenme Hedefleri:
 * - HashMap kullanımı
 * - Map işlemleri
 * - Sıralama ve filtreleme
 */
public class Main {

    private static StudentManager manager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Örnek öğrenciler ekle (test için)
        loadSampleData();

        // Ana menü döngüsü
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    manager.listAllStudents();
                    break;
                case 6:
                    System.out.print("Kaç öğrenci listelensin? ");
                    int n = getIntInput();
                    manager.getTopStudents(n);
                    break;
                case 7:
                    manager.displayReport();
                    break;
                case 8:
                    filterByLetterGrade();
                    break;
                case 9:
                    System.out.println("\n👋 Programdan çıkılıyor... Görüşmek üzere!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Geçersiz seçenek! Lütfen 1-9 arası bir sayı girin.");
                    break;
            }

            if (running) {
                System.out.println("\nDevam etmek için Enter'a basın...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Menüyü ekrana yazdırır
     */
    private static void printMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎓 ÖĞRENCİ NOT YÖNETİM SİSTEMİ");
        System.out.println("=".repeat(60));
        System.out.println("1. 👤 Öğrenci Ekle");
        System.out.println("2. 🗑️  Öğrenci Sil");
        System.out.println("3. 📝 Not Ekle");
        System.out.println("4. 🔍 Öğrenci Ara");
        System.out.println("5. 📋 Tüm Öğrencileri Listele");
        System.out.println("6. 🏆 En Başarılı Öğrenciler");
        System.out.println("7. 📊 Detaylı Rapor Göster");
        System.out.println("8. 🔤 Harf Notuna Göre Filtrele");
        System.out.println("9. 🚪 Çıkış");
        System.out.println("=".repeat(60));
        System.out.print("Seçiminiz (1-9): ");
    }

    /**
     * Yeni öğrenci ekler
     */
    private static void addStudent() {
        System.out.println("\n--- YENİ ÖĞRENCİ EKLE ---");
        System.out.print("Öğrenci ID: ");
        String id = scanner.nextLine();
        System.out.print("Öğrenci Adı: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);
        manager.addStudent(student);
    }

    /**
     * Öğrenci siler
     */
    private static void removeStudent() {
        System.out.println("\n--- ÖĞRENCİ SİL ---");
        System.out.print("Silinecek öğrencinin ID'si: ");
        String id = scanner.nextLine();
        manager.removeStudent(id);
    }

    /**
     * Öğrenciye not ekler
     */
    private static void addGrade() {
        System.out.println("\n--- NOT EKLE ---");
        System.out.print("Öğrenci ID: ");
        String id = scanner.nextLine();
        System.out.print("Ders Adı: ");
        String course = scanner.nextLine();
        System.out.print("Not (0-100): ");
        double grade = getDoubleInput();

        manager.addGrade(id, course, grade);
    }

    /**
     * Öğrenci arar
     */
    private static void findStudent() {
        System.out.println("\n--- ÖĞRENCİ ARA ---");
        System.out.print("Aranacak öğrencinin ID'si: ");
        String id = scanner.nextLine();
        manager.findStudent(id);
    }

    /**
     * Harf notuna göre filtreler
     */
    private static void filterByLetterGrade() {
        System.out.println("\n--- HARF NOTUNA GÖRE FİLTRELE ---");
        System.out.print("Harf Notu (A/B/C/D/F): ");
        String letterGrade = scanner.nextLine().toUpperCase();
        manager.getStudentsByLetterGrade(letterGrade);
    }


    /**
     * Örnek veri yükler
     */
    private static void loadSampleData() {
        System.out.println("📚 Örnek veriler yükleniyor...\n");

        Student s1 = new Student("2021001", "Ahmet Yılmaz");
        s1.addGrade("Matematik", 85.0);
        s1.addGrade("Fizik", 90.0);
        s1.addGrade("Kimya", 78.0);
        manager.addStudent(s1);

        Student s2 = new Student("2021002", "Ayşe Demir");
        s2.addGrade("Matematik", 95.0);
        s2.addGrade("Fizik", 88.0);
        s2.addGrade("Kimya", 92.0);
        manager.addStudent(s2);

        Student s3 = new Student("2021003", "Mehmet Kaya");
        s3.addGrade("Matematik", 72.0);
        s3.addGrade("Fizik", 68.0);
        s3.addGrade("Kimya", 75.0);
        manager.addStudent(s3);

        System.out.println("✅ Örnek veriler yüklendi!\n");
    }

    /**
     * Kullanıcıdan integer input alır
     * @return Girilen sayı
     */
    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("❌ Geçersiz giriş! Lütfen bir sayı girin: ");
            }
        }
    }

    /**
     * Kullanıcıdan double input alır
     * @return Girilen sayı
     */
    private static double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("❌ Geçersiz giriş! Lütfen bir sayı girin: ");
            }
        }
    }
}

