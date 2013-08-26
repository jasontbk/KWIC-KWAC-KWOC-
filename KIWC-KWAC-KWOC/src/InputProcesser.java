import java.util.Vector;


public class InputProcesser {
	public static Vector<LineInterface> processLines(String input){
		Vector<LineInterface> myLineVector = new Vector<LineInterface>();
		String[] linesArr = input.split("\\n");

		//loop through all lines and add it to myLineVector.
		for(int i=0; i<linesArr.length; i++){
			LineInterface currLineInterface = new Line(linesArr[i]);
			myLineVector.add(currLineInterface);
		}
		return myLineVector;

	}

	public static Vector<String> processIgnoreWords(String ignoreWords){
		String[] ignoreWordsArr = ignoreWords.split("\\s+");
		Vector<String> ignoredList = new Vector<String>();
		for(int i=0; i<ignoreWordsArr.length; i++){
			ignoredList.add(ignoreWordsArr[i]);
		}
		return ignoredList;
	}
}
