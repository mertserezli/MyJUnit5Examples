import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    @Test
    void firstFibonaciNumberTest() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void negativeParameterTest() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }

}
