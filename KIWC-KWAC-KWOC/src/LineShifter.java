import java.util.Vector;


public class LineShifter {
	public static Vector<LineInterface> tokenizeLine(Vector<LineInterface> lines){
		String currStr;
		String[] currTokenizedString;
		int currSize;
		
		for(LineInterface myLine : lines){
			currStr=myLine.getOrginalString();
			currTokenizedString = currStr.split(" ");
			currSize=currTokenizedString.length;

			myLine.setTokenizedString(currTokenizedString);
			myLine.setSize(currSize);
		}

		return lines;
	}
		
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
