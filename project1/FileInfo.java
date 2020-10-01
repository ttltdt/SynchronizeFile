import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

/**
 * An object that contain infomation about a directory or file
 * 
 * @author Tung Thai Date: 10/11/18
 */
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName; // file name
    private String path; // file path
    private long size; // file size
    private String lastModified;// last modified
    private String absPath;


    private static String base;

    /**
     * Constructor
     * 
     * @param fileName
     *            file name
     * @param path
     *            file path
     * @param size
     *            file size
     * @param lastModified
     *            file last modified
     */
    public FileInfo(Path fileName, Path path, long size, FileTime lastModified) {
        this.fileName = fileName.toString();
        this.path = new File(base).toURI().relativize(new File(path.toString()).toURI()).getPath().toString();
        this.size = size;
        this.lastModified = lastModified.toString();
        this.absPath = path.toAbsolutePath().toString();
    }

    /**
     * Get file name
     * 
     * @return file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * get file path
     * 
     * @return file path
     */
    public String getPath() {
        return path;
    }

    /**
     * get file size
     * 
     * @return file size
     */
    public long getSize() {
        return size;
    }

    /**
     * get last modified
     * 
     * @return last modified
     */
    public String getLastModified() {
        return lastModified;
    }

    public String getAbsPath() {
        return absPath;
    }

    public static void setBase(String newBase) {
        base = newBase;
    }


}
