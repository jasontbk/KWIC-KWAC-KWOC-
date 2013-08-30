import java.util.Collections;
import java.util.Vector;

/**
 * This module handles sorting the processed lines into alphabetical order.
 */
public class LineSorter {
	/**
	 * Create a list of sorted lines from the list of circularly shifted lines.
	 * 
	 * @param lines The list of circularly shifted lines to be sorted.
	 * @return A list of sorted lines.
	 */
	public static Vector<String> sortLines(Vector<LineInterface> lines){
		Vector<String> allStrings=new Vector<String>();

		for(LineInterface myLine : lines){
			Vector<Vector<Integer>> indexes=myLine.getIndexes();
			String[] tokenizedString = myLine.getTokenizedString();
			String str="";
			for(Vector<Integer> lineIndex: indexes){
				for(int index: lineIndex){
					str+=(tokenizedString[index]+" ");

				}
				allStrings.add(str);
				str="";
			}

			Collections.sort(allStrings, String.CASE_INSENSITIVE_ORDER);
		}
		return allStrings;
	}
	
}