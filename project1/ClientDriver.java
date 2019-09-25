package project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientDriver {
	public static void main(String[] args) {

		ScanTool sc1 = new ScanTool();
		TCPClientFile fileClient = new TCPClientFile();
		fileClient.createLogFolder("OldLog", "NewLog"); // create folder to store the information files

		Path homeDir = Paths.get("F:\\Eclipse\\CS260\\home"); // home directory
		Path fileLog = Paths.get("OldLog\\log.ser");
		Path newLog = Paths.get("NewLog\\log.ser");

		sc1.openFile(fileLog);
		FileInfo.setBase(homeDir.toString());
		try {
			sc1.scan(homeDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc1.closeFile();

		fileClient.createSocket(); // connect to server

		try {
			fileClient.buildDirectory(fileLog); // send directory structure
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileClient.iniSendFile(fileLog); // send files
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				// every 10s, finds the new files and create a thread to send that files to
				// server
				sc1.openFile(newLog);
				sc1.scan(homeDir);
				sc1.closeFile();
				fileClient.syncFile(fileLog, newLog);

				Files.delete(fileLog);
				Files.copy(newLog, fileLog);
				// System.out.println(Thread.activeCount());
				Thread.sleep(10 * 1000);

			} catch (IOException e) {

			} catch (InterruptedException ie) {
				System.out.println("Main interrupted");
			}
		}

	}
}
