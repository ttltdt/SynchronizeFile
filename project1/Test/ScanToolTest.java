package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class ScanToolTest {

    @Test
    void testOpenFile() {
        ScanTool sc = new ScanTool();
        Path path = Paths.get("output.ser");
        sc.openFile(path);
        assertTrue(Files.exists(path));

    }

    @Test
    void testScan() {
        ScanTool sc = new ScanTool();
        Path output = Paths.get("output.ser");
        sc.openFile(output);
        Path path = Paths.get("home");
        try {
            sc.scan(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assertNotEquals(0,Files.size(output));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sc.closeFile();
    }

    @Test
    void testCloseFile() {
    }


}
