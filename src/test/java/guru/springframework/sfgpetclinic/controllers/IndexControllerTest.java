package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test proper View name is returned for index page")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view name returned");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
        });
    }

    @Disabled
    @Test
    void testTimeOutInNewThread() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
        });
    }
}