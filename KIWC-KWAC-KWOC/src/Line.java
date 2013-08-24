public class Line implements LineInterface {

	String originalString;
	String[] tokenizedString;
	int size;
	int[][] indexes;

	public Line(String input) {
		originalString = input;
		tokenizedString = input.split(" ");
		size = tokenizedString.length;
		generateIndexes();
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
	public int[][] getIndexes() {
		return indexes;
	}

	@Override
	public int getSize() {
		return size;
	}
	
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

}
