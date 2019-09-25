package project1;

/**
 * This class implements a scan tool that read all directory from "home"
 * @author Tung Thai
 * Date: 10/11/18
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScanTool {
	private static ObjectOutputStream output; // outputs data to file
//	private static ObjectInputStream input; // inputs data to read info

	/**
	 * A method that open a file to write info
	 * @precondition user is allow to open or create file
	 */
	public void openFile(Path path) {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(path));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		}
	}

	/**
	 * This method finds all the directory and files inside home (including
	 * subdirectory) and write store information in a FileInfo object
	 * 
	 * @param path
	 *            path to home directory
	 * @throws IOException
	 * @precondition open files before scan
	 */
	public void scan(Path path) throws IOException {
		if (Files.exists(path)) // if path exists, output info about it
		{
			FileInfo newFile = new FileInfo(path.getFileName(), path, Files.size(path),
					Files.getLastModifiedTime(path));
			
			if(!newFile.getPath().equals("")) {
				output.writeObject(newFile);				
			}
			if (Files.isDirectory(path)) // search all files in the subdirectory using DFS
			{
				//set directory boolean to true
				// object for iterating through a directory's contents
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

				for (Path p : directoryStream)
					scan(p);
			}
		} else // not file or directory, output error message
		{
			System.out.printf("%s does not exist%n", path);
		}
	}
	
	

	/**
	 * Close File
	 */
	public void closeFile() {
		if (output != null)
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Read object and output to the screen
	 * 
	 * @throws IOException
	 * @precondition file exist
	 */
//	public void readFile(Path path,TCPClientFile fileClient) throws IOException {
//
//		input = new ObjectInputStream(Files.newInputStream(path));
//
//		try {
//			while (true) // loop until there is an EOFException
//			{
//				FileInfo record = (FileInfo) input.readObject();
//
//				// display record contents
//				System.out.printf("%-20s%-50s%-5d%s%n", record.getFileName(), record.getPath(), record.getSize(),
//						record.getLastModified());
//				
//				if(record.getIsDir()) {
//					fileClient.sendDir(record.getPath());
//				}else{
//					fileClient.sendFile(record.getAbsPath());
//				}
//				
//			}
//		} catch (EOFException endOfFileException) {
//			// System.out.printf("%nNo more records%n");
//		} catch (ClassNotFoundException classNotFoundException) {
//			System.err.println("Invalid object type. Terminating.");
//		}
//	}
}
