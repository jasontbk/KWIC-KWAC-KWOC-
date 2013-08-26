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
			for(int i=0; i<size; i++){	//cycle through tokenized word
				int j;
				for(j=0; j<ignoreList.size(); j++){	//cycle through all ignore word
					if(myTokenizedString[i].equalsIgnoreCase(ignoreList.get(j))){
						ignoredWordIndex.add(i);
						break;
					}
				}
				
				if(j==ignoreList.size()){
					myTokenizedString[i] = Character.toUpperCase(myTokenizedString[i].charAt(0)) + myTokenizedString[i].substring(1);
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
