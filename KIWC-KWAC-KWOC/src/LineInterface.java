import java.util.Vector;

public interface LineInterface {

	/*
	 * This method returns the original string input
	 */
	public String getOrginalString();

	/*
	 * This method returns the array of tokenized words from the string input
	 */
	public String[] getTokenizedString();

	/*
	 * This method reutnrs the array of indexes
	 */
	public Vector<Vector<Integer>> getIndexes();
	
	/*
	 * This method set the array of indexes
	 */
	public void setIndexes(Vector<Vector<Integer>> indexes);

	/*
	 * This array returns the no of words in the string input
	 */
	public int getSize();
	
	/*
	 * for debug
	 */
	public String toString();
	

}
