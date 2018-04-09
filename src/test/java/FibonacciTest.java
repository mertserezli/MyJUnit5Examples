import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

public class FibonacciTest {

    @Tag("Standard test")
    @Test
    void firstFibonaciNumberTest() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Tag("Standard test")
    @Test
    void negativeParameterTest() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }

    @Test
    void assumptionTest() {
        assumingThat("CI".equals(System.getenv("ENV")),
            () -> {
                // perform these assertions only on the CI server
                assertEquals(2, 2);
            });
    }

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")), () -> "Aborting test: not on CI workstation");
        Assertions.assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")), () -> "Aborting test: not on developer workstation");
        Assertions.assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")), () -> assertEquals(1, Fibonacci.fibonacci(1)));
        // perform these assertions in all environments
        assertEquals(1, Fibonacci.fibonacci(2));
    }

    @EnabledOnOs({ LINUX, MAC })
    @DisabledOnOs(WINDOWS)
    @Test
    void operatingSystemDependentTest(){
        System.out.println("I only work on linux and mac computers");
    }

    @Test
    @EnabledIf("2 * 3 == 6")
    void willBeExecuted() {
        System.out.println("I will be executed");
    }


}
