import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class PrimeNumberTest {


    @BeforeAll
    static void initAll() {
        System.out.println("I print before test's start");
    }

    @BeforeEach
    void init() {
        System.out.println("I print before each test's start");
    }

    @Test
    @DisplayName("One is not a prime number")
    void oneIsNotPrimeTest() {
        assertFalse(PrimeNumber.isPrime(1));
    }

    @Test
    void zeroIsNotPrimeTest() {
        assertFalse(PrimeNumber.isPrime(0));
    }

    @Test
    void negativeNumbersIsNotPrimeTest() {
        assertFalse(PrimeNumber.isPrime(-1));
    }

    @Test
    void positiveIsPrimeTest() {
        assertTrue(PrimeNumber.isPrime(11));
    }

    @Test
    void oddNotIsPrimeTest() {
        assertFalse(PrimeNumber.isPrime(15));
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    void evenNotIsPrimeTest() {
        assertFalse(PrimeNumber.isPrime(16));
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        System.out.println("I am skipped");
    }

    @AfterEach
    void cleanup() {
        System.out.println("I print after each test's end");
    }

    @AfterAll
    static void cleanupAll() {
        System.out.println("I print after all test's end");
    }

}