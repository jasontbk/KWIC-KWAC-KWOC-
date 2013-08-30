import java.util.Vector;

/**
 * Main control class for KWIK. This class will determine the sequence and modules to execute.
 */
public class Kwik {
	private Vector<LineInterface> lines;
	private Vector<String> ignoreWords;
	private Vector<String> sortedStrings;

	public static void main(String[] args) {
		Boolean result=true;
		while(result){
			Kwik myKwik = new Kwik();
			myKwik.getGUIInput();
			myKwik.processInput();
			myKwik.shiftLines();
			myKwik.ignoreLines();
			myKwik.sortLines();
			result=myKwik.printOutput();
		}
		System.exit(0);
	}

	/**
	 * Get user input.
	 */
	private void getGUIInput(){
		Vector<String> inputs = GUI.inputDisplay();
		lines = InputProcesser.processLines(inputs.get(0));
		ignoreWords = InputProcesser.processIgnoreWords(inputs.get(1));
	}
	
	/**
	 * Process user input into useful representation.
	 */
	private void processInput(){
		lines = InputProcesser.tokenizeLine(lines);
	}

	/**
	 * Circular shift all lines.
	 */
	private void shiftLines() {
		lines = LineShifter.shiftLine(lines);
	}

	/**
	 * Remove lines starting with ignore words.
	 */
	private void ignoreLines(){
		lines = LineIgnorer.ignoreLine(lines, ignoreWords);
	}

	/**
	 * Sort the processed line in alphabetical order.
	 */
	private void sortLines() {
		sortedStrings=LineSorter.sortLines(lines);
	}

	/**
	 * Print out the output
	 * 
	 * @return A boolean value indicating whether program terminates.
	 */
	private Boolean printOutput(){
		return GUI.outputPrinter(sortedStrings);
	}
}
