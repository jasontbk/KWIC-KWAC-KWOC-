import java.util.Collections;
import java.util.Vector;

public class Kwik {
	private Vector<LineInterface> lines;
	private Vector<String> allStrings;
	private Vector<String> ignoreWords;

	public static void main(String[] args) {
		Kwik myKwik = new Kwik();
		
		myKwik.readLines();
		myKwik.readIgnoreWords();
		myKwik.shiftLines();
		myKwik.ignoreLines();
		
		
		//debug ---------------
		for(LineInterface l : myKwik.lines){
			System.out.println(l);
		}
		//-----------------------
		
		//myKwik.sortStrings();
		//myKwik.printOutput();

	}

	private void readLines() {
		lines = ReadInput.readLine();
	}

	private void readIgnoreWords() {
		ignoreWords = ReadInput.readIgnoreWords();
	}

	private void shiftLines() {
		lines = LineShifter.shiftLine(lines);
	}
	
	private void ignoreLines(){
		lines = LineIgnorer.ignoreLine(lines, ignoreWords);
	}

	private void sortStrings() {

		Collections.sort(allStrings, String.CASE_INSENSITIVE_ORDER);

	}

	/*
	private Boolean checkIgnored(String curr){
		for(int j=0;j<ignoreWords.length;j++){
			if (curr.startsWith(ignoreWords[j])) return false;
		}
		return true;

	}
	
	private void printOutput() {
		for (int i = 0; i < allStrings.size(); i++) {
			String curr = allStrings.get(i);
			if (checkIgnored(curr))
				System.out.println(curr);
		}
	}
	*/
}
