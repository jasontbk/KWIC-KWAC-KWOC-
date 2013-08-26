import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	private static String inputLines;
	private static String ignoreWords;
	public static Vector<String> inputDisplay(){

		final JLabel inputLabel=new JLabel("Input Text:");

		final JTextArea inputField = new JTextArea(5,20);
		inputField.setBorder(BorderFactory.createLineBorder(Color.black));

		final JLabel ignoreLabel=new JLabel("Ignore Words");

		final JTextField ignoreField = new JTextField();

		final JComponent[] inputPaneComponents = new JComponent[] { inputLabel,inputField,ignoreLabel,ignoreField };

		//create option pane and dialog
		final JOptionPane inputPane = new JOptionPane(inputPaneComponents,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
		final JDialog dialog = new JDialog();

		//set some variables
		dialog.setTitle("KWIK-KWAK-KWOC Input");
		dialog.setContentPane(inputPane);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);

		dialog.setContentPane(inputPane);
		dialog.setLocation(450, 80);


		inputPane.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e) {

				if (dialog.isVisible() 
						&& (e.getSource() == inputPane)){
					int result=(int) inputPane.getValue();
					switch(result){
					case JOptionPane.OK_OPTION: {
						inputLines= inputField.getText();
						ignoreWords=ignoreField.getText();

						System.out.println(inputLines+"\n"+ignoreWords);
						dialog.dispose();
						break;
					}

					case JOptionPane.CANCEL_OPTION:  {

						System.out.println("User clicked on cancel button");
						dialog.setVisible(false);
						break;
					}
					case JOptionPane.CLOSED_OPTION:{
						System.out.println("User clicked on close button");
						dialog.setVisible(false);
						break;
					}

					}
				}
			}
		});

		dialog.pack();
		dialog.setVisible(true);

		Vector<String> inputs=new Vector<String>();
		inputs.add(inputLines);
		inputs.add(ignoreWords);
		return inputs;
	}

		
	public static void outputPrinter(Vector<String> sortedStrings){
		String output="";
		for(int i=0;i<sortedStrings.size();i++){
			output+=(sortedStrings.get(i)+"\n");
		}
		
		final JLabel outputLabel=new JLabel("Output:");

		final JTextArea outputField = new JTextArea(5,sortedStrings.size());
		outputField.setEditable(false);
		outputField.setText(output);
		outputField.setMargin(new Insets(10,10,10,10));
		BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5));

		final JComponent[] outputPaneComponents = new JComponent[] { outputLabel,outputField};
		
		JOptionPane.showMessageDialog(null,
				outputPaneComponents,
			    "KWIK-KWAK-KWOC Output",
			    JOptionPane.PLAIN_MESSAGE);


	}

}
