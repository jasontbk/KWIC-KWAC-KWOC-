public interface LineInterface {

	/**
	 * @param args
	 */

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
	public int[][] getIndexes();

	/*
	 * This array returns the no of words in the string input
	 */
	public int getSize();
	

}
