package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    // ===============================
    // TEST CHO countExcellentStudents
    // ===============================

    /**
     * Trường hợp bình thường:
     * Danh sách có cả điểm hợp lệ và không hợp lệ
     */
    @Test
    public void testCountExcellentStudents_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );

        assertEquals(2, result);
    }

    /**
     * Trường hợp danh sách toàn bộ hợp lệ
     */
    @Test
    public void testCountExcellentStudents_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        int result = analyzer.countExcellentStudents(
                Arrays.asList(8.0, 9.0, 10.0)
        );

        assertEquals(3, result);
    }

    /**
     * Trường hợp biên: danh sách rỗng
     */
    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        int result = analyzer.countExcellentStudents(Collections.emptyList());

        assertEquals(0, result);
    }

    /**
     * Trường hợp ngoại lệ: toàn bộ điểm không hợp lệ
     */
    @Test
    public void testCountExcellentStudents_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        int result = analyzer.countExcellentStudents(
                Arrays.asList(-5.0, 11.0, 20.0)
        );

        assertEquals(0, result);
    }

    // ===============================
    // TEST CHO calculateValidAverage
    // ===============================

    /**
     * Trường hợp bình thường:
     * Có cả điểm hợp lệ và không hợp lệ
     */
    @Test
    public void testCalculateValidAverage_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );

        assertEquals(8.17, average, 0.01);
    }

    /**
     * Trường hợp danh sách toàn bộ hợp lệ
     */
    @Test
    public void testCalculateValidAverage_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(
                Arrays.asList(6.0, 8.0, 10.0)
        );

        assertEquals(8.0, average, 0.01);
    }

    /**
     * Trường hợp biên: danh sách chỉ chứa 0
     */
    @Test
    public void testCalculateValidAverage_AllZero() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(
                Arrays.asList(0.0, 0.0, 0.0)
        );

        assertEquals(0.0, average);
    }

    /**
     * Trường hợp biên: danh sách chỉ chứa 10
     */
    @Test
    public void testCalculateValidAverage_AllTen() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(
                Arrays.asList(10.0, 10.0)
        );

        assertEquals(10.0, average);
    }

    /**
     * Trường hợp ngoại lệ: toàn bộ điểm không hợp lệ
     */
    @Test
    public void testCalculateValidAverage_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(
                Arrays.asList(-2.0, 12.0, 100.0)
        );

        assertEquals(0.0, average);
    }

    /**
     * Trường hợp biên: danh sách rỗng
     */
    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        double average = analyzer.calculateValidAverage(Collections.emptyList());

        assertEquals(0.0, average);
    }
}