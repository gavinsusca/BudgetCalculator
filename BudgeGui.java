package Budget;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


import javax.swing.*;



public class BudgeGui extends JFrame implements ActionListener, KeyListener {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Expense> eList = new ArrayList<Expense>(); 
	 JButton okButton, addButton, editButton, breakdownButton;
	 JTextField name, save, expense, cost, salary; 
	 JLabel errorLabel, breakdownLabel2, breakdownLabel3, breakdownLabel4, breakdownLabel5, breakdownLabel6, errorLabel2; 
	 int salaryPay = 0, saveAmount = 0, freeCash = 0, expenseTotal = 0, temp = 0; 
	 String personName; 
	 JTextArea expenseTextBox;
	 final String newline = "\n";
	 JFrame frame9; 
	 
	 
	 //start
	 JPanel listPanel, wholePanel;
		GridBagConstraints con;
		JLabel[] eLabels;
		JLabel theLabels; //errorLabel3 
		JTextField[] eTexts; 
		JTextField theText;
		JButton updateButton;
	 //finish
	 
	 
	 
	 /* 	CONSTRUCTOR TO BUILD MAIN FRAME
	  * 	Main frame: frame/thePanel
	  */
	 
	 BudgeGui(){
		//Create Frame with thePanel
		JFrame frame = new JFrame("Calculator Frame"); 
		JPanel thePanel = new JPanel();
		thePanel.setSize(700, 460);
		frame.add(thePanel); 
		BorderLayout borderLay = new BorderLayout(); 
		thePanel.setLayout(borderLay);
		

		
		
		JPanel leftPanel = new JPanel(new BorderLayout()); 
		JPanel rightPanel = new JPanel(new BorderLayout()); 
		
		
		/* 
********** Create Input Panel  
		 */ //The inputPanel: 3Labels/3 Text fields, 1 Button, errorLabel
		
		JPanel inputPanel = new JPanel(new GridBagLayout()); 
		GridBagConstraints con = new GridBagConstraints(); 
		inputPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Info"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	
		
		
		
		/*
		* 	Create and add label/text field for name
		*/
		JLabel nameLabel = new JLabel("Enter Name : ");
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.gridwidth = GridBagConstraints.RELATIVE; 
		inputPanel.add(nameLabel, con); 
		
		
		name = new JTextField(15); 
		name.setText("Gavin");
		name.addKeyListener(this);
		con.anchor = GridBagConstraints.EAST;
		con.insets = new Insets(3,0,0,0);
		con.ipady = 5; 
		con.gridwidth = GridBagConstraints.REMAINDER; 
		inputPanel.add(name, con); 
		
		//End
		
		
		
		/*
		* 	Create and add label/text field for salary 
		*/
		JLabel salaryLabel = new JLabel("Paycheck Amount : ");
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.gridwidth = GridBagConstraints.RELATIVE; 
		con.ipady = 0;
		inputPanel.add(salaryLabel, con); 
		
	
		
		salary = new JTextField(15); 
		salary.setText("1000");
		salary.addKeyListener(this);
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.ipady = 5;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		inputPanel.add(salary, con);

		//End

		/*
		* 	Create and add label/test field for save amount. 
		*/
		
		JLabel saveLabel = new JLabel("Amout to Save (per Check) : ");
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.ipady = 0;
		con.gridwidth = GridBagConstraints.RELATIVE; 
		inputPanel.add(saveLabel, con); 
		
												
				
		save = new JTextField(15); 
		save.setText("");
		save.addKeyListener(this);
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.ipady = 5;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		inputPanel.add(save, con); 
		
		//End
	 
		
		
		errorLabel = new JLabel(""); 
		errorLabel.setForeground(Color.RED);
		con.anchor = GridBagConstraints.EAST; 
		con.gridwidth = GridBagConstraints.RELATIVE;
		con.insets = new Insets(3,0,0,0);
		inputPanel.add(errorLabel, con); 
		
		/*
		 * Ok button of input panel
		 */
		
	//	okButton = new JButton("Ok");
		okButton = new JButton(); 
		okButton.setText("Ok");
		okButton.addActionListener(this);
		
		con.anchor = GridBagConstraints.EAST; 
		con.ipady = 0;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		con.insets = new Insets(3,0,0,0);
		inputPanel.add(okButton,con); 
		
		//End
		//End of input Panel
		
		
		
		
		
	/*
****** BREAKDOWN LABEL PANEL 	
	 */ // BreakDown panel:
		// breakdownPanel2(gridBag): 6 labels and a button. 
		// breakdownpanel(borderLayout) adds breakdownpanel2.
		
		JPanel breakdownPanel = new JPanel(new BorderLayout()); 
		JPanel breakdownPanel2 = new JPanel(new GridBagLayout());
		
		con.anchor = GridBagConstraints.WEST; 
		con.gridwidth = GridBagConstraints.REMAINDER; 
		con.insets = new Insets(13,0,0,0);
		
		JLabel breakdownLabel = new JLabel("Money Breakdown"); 
		breakdownPanel2.add(breakdownLabel, con);
		con.insets = new Insets(3,0,0,0);
		
	
		
		 breakdownLabel2 = new JLabel("You make $" + "xxxx" + " per month."); 
		 breakdownPanel2.add(breakdownLabel2, con); 

		 breakdownLabel3 = new JLabel("Your expenses are $" + "xxxx" + " dollars a month."); 
		 breakdownPanel2.add(breakdownLabel3, con); 
		
		 breakdownLabel4 = new JLabel("You wish to save $" + "xxxx" + " dollars per month.");
		 breakdownPanel2.add(breakdownLabel4, con); 

		 breakdownLabel5 = new JLabel("You have $" + "xxxx" + " dollars in free cash per month.");
		 breakdownPanel2.add(breakdownLabel5, con); 
		
		 breakdownLabel6 = new JLabel("You have $" + "xxxx" + " dollars in free per paycheck."); 
		 breakdownPanel2.add(breakdownLabel6, con); 
		
		
		breakdownButton = new JButton("BreakDown"); 
		breakdownButton.addActionListener(this);
		
		con.anchor = GridBagConstraints.BELOW_BASELINE; 
		con.ipady = 0;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		con.insets = new Insets(13,0,0,0);
		breakdownPanel2.add(breakdownButton,con); 
		
		breakdownPanel.add(breakdownPanel2, BorderLayout.PAGE_START); 
		
		// END BREAKDOWN LABEL/PANEL
		
		
		/* EXPENSE PANEL BEGIN
*********** 2 text/2label fields 
		 * one button 
		 * 1 large test box to show expense list.
		 * expense button
		 */
		
		JPanel expensePanel = new JPanel(new GridBagLayout()); 
		expensePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Monthly Expenses"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel expenseLabel = new JLabel("Expense Description : ");
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.gridwidth = GridBagConstraints.RELATIVE; 
		con.ipady = 0;
		expensePanel.add(expenseLabel, con); 
		
		
		expense = new JTextField(10); 
		expense.addKeyListener(this);
		expense.setText("Rent");
		con.anchor = GridBagConstraints.EAST;
		con.insets = new Insets(3,0,0,0);
		con.ipady = 5; 
		con.gridwidth = GridBagConstraints.REMAINDER; 
		expensePanel.add(expense, con); 
		
		
		JLabel costLabel = new JLabel("Cost : ");
		con.anchor = GridBagConstraints.EAST; 
		con.insets = new Insets(3,0,0,0);
		con.gridwidth = GridBagConstraints.RELATIVE; 
		con.ipady = 0;
		expensePanel.add(costLabel, con); 
		
		
		cost = new JTextField(10); 
		cost.addKeyListener(this);
		cost.setText("250");
		con.anchor = GridBagConstraints.EAST;
		con.insets = new Insets(3,0,0,0);
		con.ipady = 5; 
		con.gridwidth = GridBagConstraints.REMAINDER; 
		expensePanel.add(cost, con); 
		
		
	
		//Add error label for max size of expenses to be added
		errorLabel2 = new JLabel();
		con.gridwidth = GridBagConstraints.RELATIVE;
		errorLabel2.setForeground(Color.red);
		expensePanel.add(errorLabel2, con); 
		
		//errorLabel2.setText("No more expenses can be added");
		//end of add errorLabel
		
		
		
		/*
		 * Add button of expense panel
		 */
		
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		
		con.anchor = GridBagConstraints.EAST; 
		con.ipady = 0;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		con.insets = new Insets(3,0,0,0);
		expensePanel.add(addButton,con); 
		
		//End
		
		
		/*
		 * Scroll pane/text box for expense panel
		 */
		expenseTextBox = new JTextArea(); 
		expenseTextBox.setLineWrap(true);
		expenseTextBox.setWrapStyleWord(true);
		expenseTextBox.setEditable(false);
		
		
		JScrollPane expenseScroll = new JScrollPane(expenseTextBox); 
		expenseScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		expenseScroll.setPreferredSize(new Dimension(250, 250)); 
		
		
		con.insets = new Insets(3,0,0,0);
		con.gridwidth = GridBagConstraints.REMAINDER;
	
		expensePanel.add(expenseScroll, con);
		
		//End 
		
		
		/*
		 * Edit button of expense panel
		*/
	
		editButton = new JButton("Edit Expenses");
		editButton.addActionListener(this);
		
		con.anchor = GridBagConstraints.EAST; 
		con.ipady = 0;
		con.gridwidth = GridBagConstraints.REMAINDER; 
		con.insets = new Insets(3,0,0,0);
		expensePanel.add(editButton,con); 
		
		//End
		
		
		//End of expense panel
		
		
		
		/*
		 * add all the panels. put it all together'
		 * 
		 *  
		 */
		
		leftPanel.add(inputPanel, BorderLayout.PAGE_START); 
		leftPanel.add(breakdownPanel, BorderLayout.CENTER); 
		
		rightPanel.add(expensePanel, BorderLayout.PAGE_START);

		
		thePanel.add(leftPanel, BorderLayout.LINE_START);		
		thePanel.add(rightPanel, BorderLayout.LINE_END);
		/*
		 * Make frame info last to left everything be put together first
		 */
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(700, 460);
		//frame.pack(); 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	} //end constructor 
	
	 
	 
	
	public void actionPerformed(ActionEvent e){ 
		
		
		//OK BUTTON
		/*
		 * OK button sets Name, salaryPay, saveAmount..
		 */
		if (e.getSource() == okButton){
			
			if((!name.getText().equals("")) && (!salary.getText().equals("")) && (!save.getText().equals(""))){
				//Handle Error erasing// 
				errorLabel.setText(""); 
				name.setBackground(Color.white);
				salary.setBackground(Color.white);
				save.setBackground(Color.white);
				//END Handle Error erasing// 
				
				personName = name.getText(); 
				salaryPay = Integer.parseInt(salary.getText()); 
				temp = Integer.parseInt(save.getText()); 
				
				if(salaryPay >= temp){
					saveAmount = temp; 
					save.setBackground(Color.white);
					errorLabel.setText("");
					}
				else{
					save.setBackground(Color.red);
					errorLabel.setText("Can't save more than you make"); 
				} 
			} else { 
				//check name field
				if(name.getText().equals("")){
					name.setBackground(Color.red);
					errorLabel.setText("Invalid Blank"); } 
				else {
					name.setBackground(Color.white); }
				//end name check	
					
				
				//salary check field
				if (salary.getText().equals("")){
					salary.setBackground(Color.red);
					errorLabel.setText("Invalid Blank"); }
				else {
					salary.setBackground(Color.white); }
				//end salary check field
					
					
				if (save.getText().equals("")){
					save.setBackground(Color.red);
					errorLabel.setText("Invalid Blank"); }
				else {
					save.setBackground(Color.white);  }
					
			}//end of blank check 	
					
	
			}//END OF OK BUTTON 
			
	
			

			//BREAKDOWN BUTTON!! 
		
		if (e.getSource() == breakdownButton){
		
			
			
		if(errorLabel.getText().equals("")){
			if (salaryPay > 0){
			breakdownLabel2.setText("You make $" + (salaryPay * 2)  + " per month."); }

			
			if (expenseTotal != 0){
			breakdownLabel3.setText("Your expenses are $" + expenseTotal + " dollars per month."); }

			if (saveAmount != 0){
			breakdownLabel4.setText("You wish to save $" + (saveAmount*2) + " dollars per month."); }
	
			if (salaryPay != 0){
				freeCash = (salaryPay*2) - ((saveAmount*2) + expenseTotal); 
				breakdownLabel5.setText("You have $" + freeCash + " dollars in free cash per month"); }
			
			if (salaryPay != 0){
			freeCash = (salaryPay) - (saveAmount + (expenseTotal/2)); 
			breakdownLabel6.setText("You have $" + (freeCash) + " dollars in free cash per paycheck"); }  

		}//ERROR CHECK  
		}// END OF BREAKDOWN BUTTON
		
		
		
		
		//ADD BUTTON
		if (e.getSource() == addButton){ 
			int  tempEAmount; 
			String tempEName; 
			
			
			//Wrap whole thing is a Max size check.
			if (eList.size() <= 69){
			
			
			
			//check if either field is blank.. if so do not accept add to ArrayList 

			if(expense.getText().equals("") || cost.getText().equals("")){
				
					if(expense.getText().equals("")){ expense.setBackground(Color.red);}
					else {expense.setBackground(Color.white);}
				
					if(cost.getText().equals(""))	{ cost.setBackground(Color.red);}
					else {cost.setBackground(Color.white);}
					
			} else {
					//if both fields have an input add to the eLIst 
					expense.setBackground(Color.white);
					cost.setBackground(Color.white);
				
					tempEName = expense.getText(); 
					tempEName = "(" + (eList.size() + 1) + ") " + tempEName; 
				
				
					tempEAmount = Integer.parseInt(cost.getText()); 
					eList.add( new Expense (tempEName, tempEAmount)); 
					
					//reset text for input boxes. 
					expense.setText("");
					cost.setText("");
					
			} 
			
			//make sure there was no error before refreshing text area.
			if(expense.getBackground().equals(Color.white) && cost.getBackground().equals(Color.white)){
				if(eList.size() != 0)
					//call the method to fill out text area box.
					eBreakdown(); 
				else
					expenseTextBox.setText("empty" + newline + "yeah"); 
			}//error check
			
			
			
		}else{
			errorLabel2.setText("No more expenses can be added");
		} //end of max size check.
			
		
		}//end of add button 
		
		
		/*
		 *  In the edit button the pop up frame9/thePanel9 is created.
		 *  ThePanel9: listPanel(gridBag)
		 *  listPanel: wrapped in scrollPane, label/text field for all expenses, updateButton.
		 */
		
		//EDIT BUTTON
		if (e.getSource() == editButton){ 
			if (eList.size() > 0){

	

				 
				frame9 = new JFrame();
				JPanel thePanel9 = new JPanel(new BorderLayout()); 
				eLabels = new JLabel[70];
		
				//add scroll pane, and button. 
				wholePanel = new JPanel(new GridBagLayout()); 
		
		
		
		
		
				listPanel = new JPanel(new GridBagLayout()); 
				con = new GridBagConstraints(); 
				con.ipady = 5;
				con.insets = new Insets(3,0,0,0);
		
		
				JScrollPane ePane = new JScrollPane(listPanel); 
		
				ePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				ePane.setPreferredSize(new Dimension(250, 150)); 
				con.insets = new Insets(3,0,0,0);
				con.gridwidth = GridBagConstraints.REMAINDER;

		
		
		
		
				createLabels();		
		 
				//ADD and fill all fields that are sent in current list. 
				for (int i = 0; i< eList.size(); i++){
		
				con.gridwidth = GridBagConstraints.RELATIVE;
				listPanel.add(eLabels[i], con); 
		
				con.gridwidth = GridBagConstraints.REMAINDER;
				listPanel.add(eTexts[i],con); 
		
				eLabels[i].setText(eList.get(i).getEName()+ "   ");
		
				String tempString = ""+ eList.get(i).getEAmount(); 
				eTexts[i].setText(tempString); 

				}//end of for loop 
		

	
		
				updateButton = new JButton("Update");
				updateButton.addActionListener(this);

		
				wholePanel.add(ePane, con);
				con.insets = new Insets(13,0,0,0);
				wholePanel.add(updateButton, con);
		
		
		
		
				thePanel9.add(wholePanel, BorderLayout.PAGE_START);
				frame9.add(thePanel9); 
				frame9.setSize(300, 280);
				frame9.setLocationRelativeTo(null);
				frame9.setVisible(true);
				/***************************
				 *** END OF ENTIRE EDIT EXPENSE FRAME
				 ****************************/				
					
					
					
				} //End of if size > 0 check or isEmpty check 
				
	
				

					
		
			} // END OF EDIT BUTTON 
			

		
			

			//addded for new window listening. Need to add close on button click.
			if (e.getSource() == updateButton){

				//loop through and update the edit amounts.
				for (int i = 0; i < eList.size(); i++ ){
					
					if(!eTexts[i].getText().equals("") ){
							int tempAmount = Integer.parseInt(eTexts[i].getText());
							eList.get(i).setEAmount(tempAmount); }
				} //end of for loop update.
				
				eBreakdown(); 
				frame9.dispose();
				
			} //END OF UPDATE BUTTON

			
			
			
		} //end of action performed method
		
		

	
	//MEthod for filling the new frame and listing the expenses
	//Method to create the JLabels!
	//intialize all the labels and text fields. 
	private void createLabels(){
		
		eLabels = new JLabel [70];
		eTexts = new JTextField[70];
		
		
		for (int i = 0; i <= 69; i++){
			eLabels[i] = new JLabel(); 
			eTexts[i] = new JTextField();
			eTexts[i].setPreferredSize(new Dimension(55,20));
			eTexts[i].addKeyListener(this);
		}

	} // end JLAbel create method

	
	
	
	



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		char c = arg0.getKeyChar(); 
		
		//CONSUMER INCORRECT KEYS FOR FIELDS
		if(arg0.getSource() == name || arg0.getSource() == expense){ 
				if( (!Character.isAlphabetic(c))){
					arg0.consume();}
		} else{
				if( !(Character.isDigit(c))) { /*|| (c== KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE*/
					arg0.consume();}
		 }
		//END CONSUME
		
		
		//ENTER KEY FUNCTIONALITY FOR LAST TEXT FIELDS 
		//(OK BUTTON AND ADD BUTTON)
		if (arg0.getSource() == cost && c==KeyEvent.VK_ENTER){
			addButton.doClick();
		}
		
		if ( arg0.getSource() == save && c==KeyEvent.VK_ENTER){
			okButton.doClick();
		}
		//END ENTER FUNCTIONAILTY 
		
		
	}
	
	
	public void eBreakdown(){ 
		String temp, temp2, finalString, finalString2; 
		expenseTotal = 0; //reset to flush old values
		
		//text box header. 
		expenseTextBox.setText("--------------------------------------------------------" + newline +
				" -         Expenses          -"+ newline + "--------------------------------------------------------" );
		
		//lists expenses with format
			for (int i =0; i < eList.size(); i++){	
				temp = eList.get(i).getEName().toUpperCase().substring(0, 1); 
				temp2 = temp + eList.get(i).getEName().substring(1, eList.get(i).getEName().length());
				expenseTotal = expenseTotal + eList.get(i).getEAmount(); 
				finalString = String.format( " %-15s:" + " $%d.%s", temp2, eList.get(i).getEAmount(), newline );
				expenseTextBox.append(newline + finalString);
			}//end of for loop

		//text box footer for totals. 
		finalString2 = String.format( "%55s :  " + " $%d.\n", "Total", expenseTotal );
		expenseTextBox.append(newline + "--------------------------------------------------------" + 
				newline + finalString2 + "--------------------------------------------------------");
			
	
	}
	
	
	

}//end of class 

