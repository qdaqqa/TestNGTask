package PageobjectwithTestng;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path path = Paths.get("geckodriver-v0.26.0-win64\\geckodriver.exe");
		Path realPath = path.toAbsolutePath();
		String paths = realPath.toString();
    	String gecko = paths.replace("\\", "\\\\");
    	System.setProperty("webdriver.gecko.driver",gecko);
    	System.out.println(gecko);
		
	}

}
