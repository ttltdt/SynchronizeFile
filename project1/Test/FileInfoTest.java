package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class FileInfoTest {
    FileInfo example;
    Path path;
    @Test
    void testFileInfo() {
        path = Paths.get("FileInfoTestExample");
        try {
            example = new FileInfo(path.getFileName(), path, Files.size(path),
                    Files.getLastModifiedTime(path));
        } catch (IOException e) {
            fail("Cannot create FileInfo");
        }

    }

    @Test
    void testGetFileName() {
        path = Paths.get("FileInfoTestExample");
        try {
            example = new FileInfo(path.getFileName(), path, Files.size(path),
                    Files.getLastModifiedTime(path));
        } catch (IOException e) {
            fail("Cannot create FileInfo");
        }

        assertEquals(example.getFileName(),"FileInfoTestExample");
    }

    @Test
    void testGetPath() {
        path = Paths.get("FileInfoTestExample");
        try {
            example = new FileInfo(path.getFileName(), path, Files.size(path),
                    Files.getLastModifiedTime(path));
        } catch (IOException e) {
            fail("Cannot create FileInfo");
        }

        assertEquals(example.getPath(),"FileInfoTestExample");
    }

    @Test
    void testGetSize() {
        path = Paths.get("FileInfoTestExample");
        try {
            example = new FileInfo(path.getFileName(), path, Files.size(path),
                    Files.getLastModifiedTime(path));
        } catch (IOException e) {
            fail("Cannot create FileInfo");
        }

        assertEquals(example.getSize(),0);
        //fail("Not yet implemented");
    }

    @Test
    void testGetLastModified() {
        path = Paths.get("FileInfoTestExample");
        try {
            example = new FileInfo(path.getFileName(), path, Files.size(path),
                    Files.getLastModifiedTime(path));
        } catch (IOException e) {
            fail("Cannot create FileInfo");
        }

        assertEquals(example.getLastModified(),"2018-10-15T15:39:26.228573Z");
    }

}
