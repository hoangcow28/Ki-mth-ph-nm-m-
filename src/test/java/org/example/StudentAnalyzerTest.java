package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    // =====================================
    // TEST CHO countExcellentStudents
    // =====================================

    /**
     * Kiểm tra số sinh viên có điểm xuất sắc (>= 8.0)
     * Áp dụng cho nhiều tình huống khác nhau
     */
    @ParameterizedTest
    @MethodSource("provideScoresForExcellentCount")
    public void testCountExcellentStudents(
            List<Double> scores,
            int expected
    ) {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(expected, analyzer.countExcellentStudents(scores));
    }

    static Stream<Arguments> provideScoresForExcellentCount() {
        return Stream.of(
                // Trường hợp bình thường: có điểm hợp lệ và không hợp lệ
                Arguments.of(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0), 2),

                // Trường hợp toàn bộ hợp lệ
                Arguments.of(Arrays.asList(8.0, 9.0, 10.0), 3),

                // Trường hợp toàn bộ không hợp lệ
                Arguments.of(Arrays.asList(-5.0, 11.0, 20.0), 0),

                // Trường hợp danh sách rỗng
                Arguments.of(Collections.emptyList(), 0)
        );
    }

    // =====================================
    // TEST CHO calculateValidAverage
    // =====================================

    /**
     * Kiểm tra điểm trung bình của các điểm hợp lệ (0–10)
     */
    @ParameterizedTest
    @MethodSource("provideScoresForAverage")
    public void testCalculateValidAverage(
            List<Double> scores,
            double expected
    ) {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(expected, analyzer.calculateValidAverage(scores), 0.01);
    }

    static Stream<Arguments> provideScoresForAverage() {
        return Stream.of(
                // Trường hợp bình thường: có điểm hợp lệ và không hợp lệ
                Arguments.of(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0), 8.17),

                // Trường hợp toàn bộ điểm hợp lệ
                Arguments.of(Arrays.asList(6.0, 8.0, 10.0), 8.0),

                // Trường hợp biên: toàn bộ 0
                Arguments.of(Arrays.asList(0.0, 0.0, 0.0), 0.0),

                // Trường hợp biên: toàn bộ 10
                Arguments.of(Arrays.asList(10.0, 10.0), 10.0),

                // Trường hợp toàn bộ không hợp lệ
                Arguments.of(Arrays.asList(-2.0, 12.0, 100.0), 0.0),

                // Trường hợp danh sách rỗng
                Arguments.of(Collections.emptyList(), 0.0)
        );
    }
}
