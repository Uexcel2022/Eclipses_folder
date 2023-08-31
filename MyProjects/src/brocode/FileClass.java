package brocode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

// FileReader = read the contents of a file as a stream of characters. One by one read()
// returns an int value which contains the byte value when read() -1, There is no more data to read

public class FileClass {
	public static void main(String[] args) {

		
	}

	public static void checkFile() {
		File file = new File("src/BroCode/Udoka.txt");
		if (file.exists()) {
			System.out.println("true");
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.isFile());
			file.delete();
		} else
			System.out.println("false");
	}

	public static void fileWriter() {
		try {
			FileWriter writer = new FileWriter("src/BroCode/test.txt");
			writer.write("Roses are Red\nThe sky is blue\nFelling the shower of the" + " sun\nRocking everywhere.");
			writer.append("\n(A poem by me)");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void reader() {
		try {
			FileReader reader = new FileReader("src/BroCode/test.txt");
			try {
				int data = reader.read();
				while (data != -1) {
					System.out.print((char) data);
					data = reader.read();
				}
				reader.close();

			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
	}

}
