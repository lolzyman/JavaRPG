import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class importCSV {

	public static void main(String[] args) {
		importCSV apple = new importCSV();
	}
	
	public importCSV(){
		
	}
	public int[][] importArray(){
		MultiPurposeStack pear = new MultiPurposeStack(), pear2 = new MultiPurposeStack();
		int[][] array = null;
		String fileName = "map1.csv";
		Scanner input = null;
		int rows = 0, index = 0;
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input.hasNextLine()){
			String something = input.nextLine();
			pear.addEnd(something);
			rows++;
		}
		array = new int[rows][];
		
		while(!pear.isEmpty()){
			String something2 = pear.getHead().getStringValue();
			char[] some = something2.toCharArray();
			for (int i = 0; i < some.length; i++) {
				if(some[i] != ',')
					pear2.addEnd(String.valueOf(some[i]));
			}
			array[index] = new int[pear2.getLength()];
			int microIndex = 0;
			while(!pear2.isEmpty()){
				array[index][microIndex] = Integer.parseInt(pear2.getHead().getStringValue());
				pear2.deleteBeginning();
				microIndex++;
			}
			pear.deleteBeginning();
			index++;
		}
		return array;
	}

}
