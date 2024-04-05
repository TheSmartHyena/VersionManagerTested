import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionManagerTest {
    private static VersionManager instance = null;

    @BeforeAll
    static void beforeAll() {
        instance = new VersionManager();
    }

    @BeforeEach
    void setUp() {
        instance.setVersion(1);
    }

    @Test
    @DisplayName("Test initialisation à 1")
    void testInit() {
        assertEquals(1, instance.getVersion());
    }
}