import java.util.Vector;

public class Line implements LineInterface {

	String originalString;
	String[] tokenizedString;
	int size;
	Vector<Vector<Integer>> indexes;

	public Line(String input) {
		originalString = input;
		tokenizedString = input.split(" ");
		size = tokenizedString.length;
		
		indexes = new Vector<Vector<Integer>>();
		for(int i=0; i<size; i++){
			indexes.add(new Vector<Integer>());
		}
	}

	@Override
	public String getOrginalString() {
		return originalString;
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
	public int getSize() {
		return size;
	}
	
	/*
	private void generateIndexes(){
		indexes=new int[size][size];
		for(int i=0;i<size;i++){
			int k=i;
			for(int j=0;j<size;j++){
				indexes[i][j]=k%size;
				k++;
			}
		}
		
	}
	*/

	@Override
	public void setIndexes(Vector<Vector<Integer>> indexes) {
		this.indexes=indexes;
	}
	
	/**
	 * for debug purpose
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
