<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/d3a26fa2-6d02-49b4-bdd2-32f4712dcb00" />
# Bài tập thực hành kiểm thử với JUnit

📋 Thông tin sinh viên
Họ và tên: Lê Trung Hoàng
MSSV: BIT230174
Lớp: 23IT5

## 1. Thông tin chung

* **Chủ đề:** Phân tích dữ liệu điểm số học sinh
* **Ngôn ngữ:** Java
* **Công cụ kiểm thử:** JUnit 5
* **Mục tiêu học tập:**

    * Biết cách viết kiểm thử tự động bằng JUnit.
    * Biết cách tổ chức mã nguồn theo chuẩn Maven (`src/main/java`, `src/test/java`).
    * Biết cách khai thác AI tạo sinh để hỗ trợ lập trình và kiểm thử.

---

## 2. Mô tả bài toán

Xây dựng chương trình Java với lớp **`StudentAnalyzer`** để phân tích dữ liệu điểm số của học sinh.

### 2.1. Yêu cầu chức năng

Lớp `StudentAnalyzer` bao gồm hai phương thức:

```java
public class StudentAnalyzer {
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        // TODO: Sinh viên viết mã tại đây
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        // TODO: Sinh viên viết mã tại đây
    }
}
```

### 2.2. Yêu cầu kỹ thuật

* **Điều kiện 1:** Điểm < 0 hoặc > 10 → bỏ qua (dữ liệu không hợp lệ).
* **Điều kiện 2:** Nếu danh sách rỗng → trả về giá trị mặc định (0).
* **Vòng lặp 1:** Duyệt danh sách để đếm học sinh giỏi (>= 8.0).
* **Vòng lặp 2:** Duyệt danh sách để tính điểm trung bình hợp lệ.

---

## 3. Yêu cầu kiểm thử với JUnit

Sinh viên cần viết **unit test** cho từng phương thức trong `StudentAnalyzer`.

### 3.1. Các trường hợp kiểm thử

* **Trường hợp bình thường:**

    * Danh sách có cả điểm hợp lệ và không hợp lệ.
    * Danh sách toàn bộ điểm hợp lệ.
* **Trường hợp biên:**

    * Danh sách rỗng.
    * Danh sách chỉ chứa 0 hoặc 10.
* **Trường hợp ngoại lệ:**

    * Có điểm < 0 hoặc > 10.

### 3.2. Gợi ý lớp kiểm thử

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {
    @Test
    public void testCountExcellentStudents() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(2, analyzer.countExcellentStudents(
            Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        ));
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCalculateValidAverage() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(8.17, analyzer.calculateValidAverage(
            Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        ), 0.01);
    }
}
```

---

## 4. Cấu trúc thư mục dự án

```text
StudentAnalyzerUnitTest/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           ├── Main.java
│   │           └── StudentAnalyzer.java
│   └── test/
│       └── java/
│           └── org/example/
│               └── StudentAnalyzerTest.java
├── pom.xml
└── README.md
```

---

## 5. Hướng dẫn thực hiện bài tập

### Bước 1: Tạo thư mục

* Tạo thư mục `unit-test` trên repository GitHub.
* Tạo hai thư mục con:

    * `src/` chứa mã nguồn Java.
    * `test/` chứa mã nguồn kiểm thử đơn vị.

### Bước 2: Tạo Issues trên GitHub

Tạo ít nhất 4 issues:

| Tên Issue                         | Mô tả                                           |
| --------------------------------- | ----------------------------------------------- |
| Viết hàm countExcellentStudents() | Xử lý kiểm tra điểm hợp lệ và đếm học sinh giỏi |
| Viết hàm calculateValidAverage()  | Tính trung bình các điểm hợp lệ                 |
| Viết test cho 2 hàm trên          | Dùng JUnit để kiểm thử đầy đủ                   |
| Viết tài liệu README.md           | Mô tả bài toán, cách chạy và test               |

### Bước 3: Commit gắn với Issue

Ví dụ commit message:

```text
feat: implement countExcellentStudents() #1
test: add unit tests for both methods #3
docs: update README with instructions #4
```

Sử dụng `fixes #issue_number` hoặc `closes #issue_number` để tự động đóng issue khi merge vào nhánh chính.

---

## 6. Hướng dẫn chạy chương trình và kiểm thử

### 6.1. Chạy kiểm thử bằng Maven

Mở terminal tại thư mục gốc dự án và chạy:

```bash
mvn test
```

### 6.2. Kết quả mong đợi

* Tất cả test case **PASS**.
* Maven hiển thị `BUILD SUCCESS`.

---

## 7. Kết luận

Bài tập giúp sinh viên làm quen với:

* Viết mã Java có kiểm tra dữ liệu đầu vào.
* Viết kiểm thử đơn vị với JUnit.
* Quản lý mã nguồn và tiến độ bằng GitHub Issues và Commit message.
