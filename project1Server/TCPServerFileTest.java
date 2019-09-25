package project1Server;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class TCPServerFileTest {

	@Test
	void testIniSetup() {
//		fail("Not yet implemented");
		assertTrue(Files.exists(Paths.get("E:/backup_home")));
	}

}
