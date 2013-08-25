import java.util.Vector;


public class LineIgnorer {
	public static Vector<LineInterface> ignoreLine(Vector<LineInterface> lines, Vector<String> ignoreList){	
		for(LineInterface myLine : lines){
			//get all the required information
			Vector<Vector<Integer>> indexes = myLine.getIndexes();
			String[] myTokenizedString = myLine.getTokenizedString();
			Vector<Integer> ignoredWordIndex = new Vector<Integer>();
			int size = myLine.getSize();
			
			//double for loop to scan through all words in myLine for any ignored word.
			for(int i=0; i<size; i++){
				for(int j=0; j<ignoreList.size(); j++){
					if(myTokenizedString[i].equals(ignoreList.get(j))){
						ignoredWordIndex.add(i);
						break;
					}
				}
			}
			
			//start from the last element to prevent infinite loop
			for(int i=indexes.size()-1; i>=0; i--){
				for(int j=0; j<ignoredWordIndex.size(); j++){
					if(indexes.get(i).get(0) == ignoredWordIndex.get(j)){
						indexes.remove(i);
						break;
					}
				}
			}
			
			myLine.setIndexes(indexes);		
		}
		
		return lines;
	}

}
