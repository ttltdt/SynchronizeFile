//Server side 
public class ServerDriver {
    public static void main(String[] args) {
        TCPServerFile fileServer = new TCPServerFile();
        fileServer.createSocket(); // setup server
        fileServer.buildDir(); // recreating directory structure
        System.out.println("Done build\n");
        fileServer.iniSetup(); // initial setup
        while (true) {
            fileServer.syncFile();
        }
    }
}
