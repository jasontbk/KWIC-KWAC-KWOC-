import java.util.Vector;


public class Kwik {
	private Vector<LineInterface> lines;
	private Vector<String> ignoreWords;
	private Vector<String> sortedStrings;

	public static void main(String[] args) {
				
		Kwik myKwik = new Kwik();
		myKwik.getGUIInput();
		//myKwik.readLines();
		//myKwik.readIgnoreWords();
		myKwik.shiftLines();
		myKwik.ignoreLines();
		myKwik.sortStrings();
		myKwik.printOutput();
		
		
		//debug ---------------
/*		for(LineInterface l : myKwik.lines){
			System.out.println(l);
		}*/
		//-----------------------
		
		//myKwik.sortStrings();
		//myKwik.printOutput();

	}

	private void getGUIInput(){
		Vector<String> inputs = GUI.inputDisplay();
		lines = InputProcesser.processLines(inputs.get(0));
		ignoreWords = InputProcesser.processIgnoreWords(inputs.get(1));
	}
	
/*	private void readLines() {
		lines = ReadInput.readLine();
	}

	private void readIgnoreWords() {
		ignoreWords = ReadInput.readIgnoreWords();
	}*/

	private void shiftLines() {
		lines = LineShifter.tokenizeLine(lines);
		lines = LineShifter.shiftLine(lines);
	}
	
	private void ignoreLines(){
		lines = LineIgnorer.ignoreLine(lines, ignoreWords);
	}

	private void sortStrings() {
		sortedStrings=LineSorter.sortLines(lines);
	}

	private void printOutput(){
		OutputPrinter.printOutput(sortedStrings);
		GUI.outputPrinter(sortedStrings);
	}
}
