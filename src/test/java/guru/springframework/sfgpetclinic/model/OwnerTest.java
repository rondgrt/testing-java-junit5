package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Disabled(value = "ff uitgezet omdat het kan")
    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("123456789");

        assertAll("Person Properties",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joee", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key Westt", owner.getCity(), "City did not match"),
                        () -> assertEquals("123456789", owner.getTelephone())
                ));
    }

}