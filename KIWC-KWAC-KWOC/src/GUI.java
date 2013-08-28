import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

	public static Vector<String> inputDisplay(){

		final Vector<String> inputs=new Vector<String>(); 
		
		final JLabel inputLabel=new JLabel("Input Text (Seperate each item in the list with a new line) :");

		final JTextArea inputField = new JTextArea(5,20);
		inputField.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 255)));

		final JLabel ignoreLabel=new JLabel("Ignore Words (Seperate each ignore word with a space) : ");

		final JTextField ignoreField = new JTextField();
		ignoreField.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 255)));

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

		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("User click on X button.");
				System.exit(0);
			}
		});
		
		inputPane.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e) {

				if (dialog.isVisible() 
						&& (e.getSource() == inputPane)){
					int result=(int) inputPane.getValue();
					switch(result){
					case JOptionPane.OK_OPTION: {
						
						final String inputLines= inputField.getText();
						final String ignoreWords=ignoreField.getText();

						inputs.add(inputLines);
						inputs.add(ignoreWords);

						System.out.println(inputLines+"\n"+ignoreWords);
						dialog.setVisible(false);
						break;
					}

					case JOptionPane.CANCEL_OPTION:  {

						System.out.println("User clicked on cancel button");
						dialog.setVisible(false);
						System.exit(0);
						break;
					}
					case JOptionPane.CLOSED_OPTION:{
						System.out.println("User clicked on close button");
						dialog.setVisible(false);
						System.exit(0);
						
					}

					}
				}
			}
		});

		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);


		return inputs;
	}

		
	public static Boolean outputPrinter(Vector<String> sortedStrings){
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
		
		Object[] options = {"OK","Retry"};
		int result=JOptionPane.showOptionDialog(null,
				outputPaneComponents,
			    "KWIK-KWAK-KWOC Output",
			    JOptionPane.YES_NO_OPTION, 
			    JOptionPane.PLAIN_MESSAGE,
			    null,
			    options,
			    options[0]);
		
		
		if(result==0) return false;
		else return true;


	}

}
