import java.util.Arrays;
import java.util.Vector;


public class Kwik {

	private static Vector<LineInterface> lines;
	
	public static void main(String[] args) {
		
		lines=ReadInput.readLine();

		Line line;
		for(int i=0;i<lines.size();i++){
			line=(Line)lines.get(i);
			System.out.println(Arrays.toString(line.getTokenizedString()));
			for (int j=0;j<line.getSize();j++){
				System.out.println(Arrays.toString(line.getIndexes()[j]));
			}

			
		}

	}

}
