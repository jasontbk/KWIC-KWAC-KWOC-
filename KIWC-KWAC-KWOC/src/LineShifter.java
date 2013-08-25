import java.util.Vector;


public class LineShifter {
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
