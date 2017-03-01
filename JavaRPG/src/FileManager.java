import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	public FileManager(){
		
	}
	File getFile(String fileName){
		File file = null;
		//Not sure what this line of code does honestly
		ClassLoader classLoader = getClass().getClassLoader();
		
		//tries to locate said file. If the file isn't found file remains null
		try{
			file = new File(classLoader.getResource(fileName).getFile());
		} catch(NullPointerException e){
			System.out.println("File wasn't found2");
		}
		return file;
	}
	Scanner setUpScanner(File file){
		Scanner input = null;
		if(file != null){
			//tries to point the scanner to the file
			try {
				input = new Scanner(file);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			//this else isn't necessarily worth being here
			//this is just an backup case
			//might change it to load a default map
			System.out.println("File wasn't found1");
			System.out.println("Please enter a valid file name");
			Scanner felix = new Scanner(System.in);
			file = getFile(felix.nextLine());
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				felix.close();
				return null;
			}
			felix.close();
		}
		return input;
	}
}
