# 📝 Öğrenme Notlarım - Student Grades System

> HashMap, Collections Framework ve veri analizi konusundaki anlayışını belgele.

---

## 📅 Proje Zaman Çizelgesi

- **Başlangıç Tarihi:** _____________
- **Bitiş Tarihi:** _____________
- **Toplam Süre:** _____________
- **Kod Satırı Sayısı:** _____________

---

## 🎯 Tamamlanan Görevler

### Temel Özellikler
- [ ] Student sınıfı oluşturuldu
- [ ] HashMap ile ders notları yönetimi
- [ ] StudentManager sınıfı
- [ ] Öğrenci ekleme/silme/arama
- [ ] Not ekleme ve güncelleme
- [ ] Ortalama hesaplama
- [ ] Harf notu hesaplama
- [ ] Main program ve menü sistemi
- [ ] Test senaryoları

### Ekstra Özellikler (Opsiyonel)
- [ ] En yüksek/düşük not bulma
- [ ] Sıralama işlemleri (Comparator)
- [ ] Harf notuna göre filtreleme
- [ ] Detaylı rapor sistemi
- [ ] Hata yönetimi ve doğrulama

---

## 💡 Öğrendiğim Temel Kavramlar

### 1. HashMap Veri Yapısı

**Öğrendiklerim:**
- HashMap, key-value (anahtar-değer) çiftleri ile veri saklar
- Key benzersiz olmalıdır (unique), value tekrar edebilir
- O(1) erişim süresi - çok hızlı arama
- Sıralı değildir (LinkedHashMap sıralı tutar)

**Örnek Kod:**
```java
// HashMap oluşturma
Map<String, Double> grades = new HashMap<>();

// Ekleme - put()
grades.put("Matematik", 85.0);
grades.put("Fizik", 90.0);
grades.put("Kimya", 78.0);

// Erişim - get()
double mathGrade = grades.get("Matematik");  // 85.0

// Kontrol - containsKey()
if (grades.containsKey("Fizik")) {
    System.out.println("Fizik notu var!");
}

// Güncelleme (aynı key ile put)
grades.put("Matematik", 95.0);  // 85.0 → 95.0

// Silme - remove()
grades.remove("Kimya");

// Boyut - size()
int count = grades.size();  // 2
```

**Ne zaman kullanılır:**
- Hızlı arama gerektiğinde
- Key-value ilişkisi olduğunda
- Sıralama önemli değilse

---

### 2. Map İşlemleri ve İterasyonlar

**Öğrendiklerim:**
- keySet() - Tüm anahtarları döndürür
- values() - Tüm değerleri döndürür
- entrySet() - Hem key hem value'ya erişim
- forEach() - Modern iterasyon

**Örnek Kod:**
```java
Map<String, Double> grades = new HashMap<>();
grades.put("Matematik", 85.0);
grades.put("Fizik", 90.0);
grades.put("Kimya", 78.0);

// 1. keySet() ile iterasyon
for (String course : grades.keySet()) {
    System.out.println(course + ": " + grades.get(course));
}

// 2. values() ile iterasyon
double sum = 0;
for (double grade : grades.values()) {
    sum += grade;
}
double average = sum / grades.size();

// 3. entrySet() ile iterasyon (en verimli)
for (Map.Entry<String, Double> entry : grades.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// 4. forEach() ile modern iterasyon
grades.forEach((course, grade) ->
    System.out.println(course + ": " + grade)
);
```

**Performans:**
- `entrySet()` en verimli (tek döngüde hem key hem value)
- `keySet()` + `get()` daha yavaş (her seferinde get() çağrısı)

---

### 3. Sıralama (Sorting) ve Comparator

**Öğrendiklerim:**
- HashMap sıralı değildir, sıralamak için List'e çevirmek gerekir
- Comparator ile özel sıralama kuralları yazılır
- Lambda expression ile kısa ve okunabilir kod

**Örnek Kod:**
```java
// Öğrencileri ortalamaya göre sırala
List<Student> studentsList = new ArrayList<>(students.values());

// Comparator ile sıralama (azalan sıra)
studentsList.sort((s1, s2) ->
    Double.compare(s2.calculateAverage(), s1.calculateAverage())
);

// Alternatif: Comparator.comparing()
studentsList.sort(
    Comparator.comparingDouble(Student::calculateAverage).reversed()
);

// İlk 3 öğrenciyi al
for (int i = 0; i < 3 && i < studentsList.size(); i++) {
    System.out.println(studentsList.get(i));
}
```

**Lambda Expression Açıklaması:**
```java
// Eski yöntem (Anonymous Class)
studentsList.sort(new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.calculateAverage(), s1.calculateAverage());
    }
});

// Yeni yöntem (Lambda)
studentsList.sort((s1, s2) ->
    Double.compare(s2.calculateAverage(), s1.calculateAverage())
);
```

---

### 4. Stream API ve Filtreleme

**Öğrendiklerim:**
- Stream API ile fonksiyonel programlama
- filter() ile koşula göre filtreleme
- count(), collect() gibi terminal operasyonlar

**Örnek Kod:**
```java
// Harf notu 'A' olan öğrenci sayısı
long countA = students.values().stream()
    .filter(s -> s.getLetterGrade().equals("A"))
    .count();

// Ortalaması 80'in üzerinde olan öğrenciler
List<Student> topStudents = students.values().stream()
    .filter(s -> s.calculateAverage() >= 80)
    .collect(Collectors.toList());

// En yüksek ortalama
double maxAverage = students.values().stream()
    .mapToDouble(Student::calculateAverage)
    .max()
    .orElse(0.0);
```


---

## 🐛 Hatalar ve Çözümler

### Hata #1
**Problem:**
```
Karşılaştığın hatayı buraya yaz
```

**Çözüm:**
```
Nasıl çözdüğünü açıkla
```

**Öğrendiklerim:**
-

---

## ❓ Sorular ve Cevaplar

### Soru 1: HashMap vs ArrayList - Ne zaman hangisini kullanmalıyım?
**S:** HashMap ve ArrayList arasındaki fark nedir?

**A:**
- **ArrayList:** Sıralı liste, index ile erişim, sıra önemli
- **HashMap:** Key-value çiftleri, hızlı arama, sıra önemsiz
- **Örnek:** Öğrenci listesi → ArrayList, Öğrenci ID → Öğrenci → HashMap

---

### Soru 2: Comparator nasıl çalışır?
**S:** Lambda expression ile Comparator nasıl yazılır?

**A:**
```java
// Artan sıra
list.sort((a, b) -> a.compareTo(b));

// Azalan sıra
list.sort((a, b) -> b.compareTo(a));

// Double karşılaştırma
list.sort((a, b) -> Double.compare(a.getValue(), b.getValue()));
```

---

## 🔥 Karşılaştığım Zorluklar

1. **Zorluk:**
   **Nasıl aştım:**

2. **Zorluk:**
   **Nasıl aştım:**

---

## 📊 Günlük İlerleme Kaydı

### Gün 1 - Tarih: ___________
**Yaptıklarım:**
-
-

**Harcanan Süre:** ___ saat

**Zorluklar:**
-

---

### Gün 2 - Tarih: ___________
**Yaptıklarım:**
-
-

**Harcanan Süre:** ___ saat

**Zorluklar:**
-

---

## 🚀 Sonraki Adımlar

**Bir sonraki proje için hatırlamak istediğim:**
-
-

**Geliştirmem gereken beceriler:**
-
-

---

## 📚 Kullandığım Kaynaklar

- [ ] Resmi Java Dokümantasyonu
- [ ] HashMap Tutorial
- [ ] Comparator ve Lambda Expressions
- [ ] Stack Overflow
- [ ] Diğer: ___________

---

## 💭 Genel Düşünceler

**İyi giden şeyler:**
-

**Geliştirilebilecek şeyler:**
-

**Genel değerlendirme:** ⭐⭐⭐⭐⭐ (1-5 yıldız)

