import java.util.Vector;

/**
 * This module handles circular shifting of user input lines.
 */
public class LineShifter {
	/**
	 * Circularly shift each lines for each word in the line.
	 * 
	 * @param lines List of lines to perform the process on.
	 * @return A list of lines that has been circularly shifted.
	 */
	public static Vector<LineInterface> shiftLine(Vector<LineInterface> lines){
		for(LineInterface myLine : lines){
			int size = myLine.getSize();
			
			Vector<Vector<Integer>> indexes = new Vector<Vector<Integer>>();
			for(int i=0; i<size; i++){
				int k=i;
				indexes.add(new Vector<Integer>());
				for(int j=0; j<size; j++){
					indexes.get(i).add(k%size);
					k++;
				}
			}
			
			myLine.setIndexes(indexes);
		}
		return lines;
	}
}
