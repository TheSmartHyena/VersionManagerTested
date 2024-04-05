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

    @Test
    @DisplayName("Test toString")
    void testToString() {
        assertEquals("Version: 1", instance.toString());
    }

    @Test
    @DisplayName("Test update patch")
    void testUpdatePatch() {
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals(2, instance.getVersion());
    }

    @Test
    @DisplayName("Test update mineur")
    void testUpdateMineur() {
        instance.updateVersion(ETypeUpdate.MINEUR);
        assertEquals(11, instance.getVersion());
    }

    @Test
    @DisplayName("Test update majeur")
    void testUpdateMajeur() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        assertEquals(101, instance.getVersion());
    }

    @Test
    @DisplayName("Test update fallback")
    void testUpdateFallback() {
        instance.updateVersion(ETypeUpdate.OTHER);
        assertEquals(1, instance.getVersion());
    }

    @Test
    @DisplayName("Test setVersion")
    void testSetVersion() {
        instance.setVersion(-4);
        assertEquals(-4, instance.getVersion());

        instance.setVersion(0);
        assertEquals(0, instance.getVersion());

        instance.setVersion(4);
        assertEquals(4, instance.getVersion());
    }

    @Test
    @DisplayName("Test multiple update, asc")
    void testMutipleAsc() {
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.MAJEUR);

        assertEquals(112, instance.getVersion());
    }

    @Test
    @DisplayName("Test multiple , desc")
    void testMutipleDesc() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.PATCH);

        assertEquals(112, instance.getVersion());
    }

    @Test
    @DisplayName("Test spam updateVersion")
    void testSpam() {
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);

        assertEquals(4, instance.getVersion());
    }

    @Test
    @DisplayName("Test Update, Rest, Update")
    void test() {
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals(2, instance.getVersion());

        instance.setVersion(18);
        assertEquals(18, instance.getVersion());

        instance.updateVersion(ETypeUpdate.MINEUR);
        assertEquals(28, instance.getVersion());
    }
}