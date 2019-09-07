package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public interface ModelBaseTest {

    @BeforeEach
    default void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("I run test with name: " + testInfo.getTestMethod().get().getName() + " and repetition number " + repetitionInfo.getCurrentRepetition() + " from the default before method in the interface");
    }
}
