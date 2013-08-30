import java.util.Vector;

/**
 * This class stores the information of each line. 
 */
public class Line implements LineInterface {
	private String originalString;
	private String[] tokenizedString;
	private int size;
	private Vector<Vector<Integer>> indexes;

	public Line(String input) {
		originalString = input;
	}

	@Override
	public String getOrginalString() {
		return originalString;
	}

	@Override
	public void setTokenizedString(String[] tokenizedStrArr){
		this.tokenizedString=tokenizedStrArr;
	}

	@Override
	public String[] getTokenizedString() {
		return tokenizedString;
	}

	@Override
	public Vector<Vector<Integer>> getIndexes() {
		return indexes;
	}

	@Override
	public void setSize(int size) {
		this.size=size;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setIndexes(Vector<Vector<Integer>> indexes) {
		this.indexes=indexes;
	}

	/**
	 * Debugging method.
	 */
	public String toString(){
		String str = "O: "+ originalString + "\n";
		for(String s : tokenizedString){
			str = str + "[" + s + "]";
		}
		str = str + "\n";
		for(Vector<Integer> e : indexes){
			for(Integer i : e){
				str = str + "[" + i + "]";
			}
			str = str+"\n";
		}
		return str;
	}
}
