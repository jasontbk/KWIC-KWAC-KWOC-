import java.util.Vector;

/**
 * Interface of the data to be passed between different modules.
 */
public interface LineInterface {

	/*
	 * This method returns the original string input.
	 */
	public String getOrginalString();

	/*
	 * This method tokenizes the String into its individual words.
	 */	
	public void setTokenizedString(String[] tokenStrArray);
	
	/*
	 * This method returns the array of tokenized words from the string input.
	 */
	public String[] getTokenizedString();
	
	/*
	 * This method set the array of indexes.
	 */
	public void setIndexes(Vector<Vector<Integer>> indexes);
	
	/*
	 * This method returns the array of indexes.
	 */
	public Vector<Vector<Integer>> getIndexes();
	
	/*
	 * This method set the size (number of words) of the Line.
	 */
	public void setSize(int size);
	
	/*
	 * This array returns the no of words in the string input.
	 */
	public int getSize();
	
	/*
	 * For debug purpose.
	 */
	public String toString();

}
