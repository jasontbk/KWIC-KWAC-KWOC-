import java.util.Vector;

/**
 * This module handles processing of raw user input into suitable data representation for processing.
 */
public class InputProcesser {
	/**
	 * Split user input into individual lines.
	 * 
	 * @param input Raw String of user input.
	 * @return User input separated into individual lines.
	 */
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

	/**
	 * Split user input into individual words.
	 * 
	 * @param ignoreWords Raw String of words to ignore
	 * @return Vector of ignored words.
	 */
	public static Vector<String> processIgnoreWords(String ignoreWords){
		String[] ignoreWordsArr = ignoreWords.split("\\s+");
		Vector<String> ignoredList = new Vector<String>();
		for(int i=0; i<ignoreWordsArr.length; i++){
			ignoredList.add(ignoreWordsArr[i]);
		}
		return ignoredList;
	}
	
	/**
	 * Tokenize lines into individual words.
	 * 
	 * @param lines The list of lines to process.
	 * @return A list of lines after being tokenized.
	 */
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
}
