package dk.bringlarsen.tdd.levenshteindistance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevenshteinDistanceTest {

    @ParameterizedTest()
    @CsvSource({
            "A,A", "a,a"
    })
    void givenEqualCharExpectZeroDistance() {
        int distance = new LevenshteinDistance("A", "A").getDistance();

        assertEquals(0, distance);
    }

    @ParameterizedTest()
    @CsvSource({
            "A,B", "B,A", "a,A", ",A", "A,"
    })
    void givenNonEqualCharExpectNonZeroDistance(String first, String second) {
        int distance = new LevenshteinDistance(first,second).getDistance();

        assertEquals(1, distance);
    }

    @ParameterizedTest()
    @CsvSource({
            "kitten,kitten"
    })
    void givenEqualWordsExpectNonZeroDistance(String first, String second) {
        int distance = new LevenshteinDistance(first,second).getDistance();

        assertEquals(0, distance);
    }

    @ParameterizedTest()
    @CsvSource({
            "kitten,sitting,3",
            "given when then,arrange act assert,17"
    })
    void givenNonEqualWordsExpectNonZeroDistance(String first, String second, int expectedDistance) {
        int distance = new LevenshteinDistance(first,second).getDistance();

        assertEquals(expectedDistance, distance);
    }
}