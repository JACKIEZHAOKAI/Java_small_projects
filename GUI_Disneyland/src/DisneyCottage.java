/*
 *  CIS 35A 6:00-9:50 p.m
 *  lab 6
 *  Due: 3th of August
 *  Date submitted: 1st of August
 *  ZHAOKAI XU
 */
package project6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class DisneyCottage
{
		//properties
		private JFrame frame = new JFrame("Disney Cottages");
		
		//variables
		private int cottagePrice = 0;
		private int boatPrice = 0;
		private calculation theCalculation = new calculation();
		
		//main panel
		private JPanel panel0 = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
		private JPanel panel3 = new JPanel();
		private JPanel panel4 = new JPanel();
		private JPanel panel5 = new JPanel();
		private JPanel panel6 = new JPanel();

	
		//printing the text 
		private JTextField text0 = new JTextField("Enter your traveling date");
		private JTextField text1 = new JTextField("Starting date:\n");
		private JTextField text2 = new JTextField("Month");
		private JTextField text3 = new JTextField("Day");
		private JTextField text4 = new JTextField("Ending date:\n");
		private JTextField text5 = new JTextField("Month");
		private JTextField text6 = new JTextField("Day");
		private JTextField textCottages = new JTextField("Which cottages do you prefer?	");
		private JTextField textBoat = new JTextField("Do you want to rent a boat?");
		private JTextField totalPrice = new JTextField("Total price: ");
		private JTextField Signature = new JTextField("Done by ZHAOKAI XU(JACKIE)");
		
		//Input  from the text file
		private JTextField textStartMonth = new JTextField("",4);
		private JTextField textStartDay = new JTextField("",4);
		private JTextField textEndMonth = new JTextField("",4);
		private JTextField textEndDay = new JTextField("",4);
		
		//option text
		private JCheckBox Check1 = new JCheckBox("One-Bedroom (600/week)");
		private JCheckBox Check2 = new JCheckBox("Two-Bedroom (850/week)");
		private JCheckBox Check3 = new JCheckBox("RowBoat (60/week)");
		
		//button text
		private JButton button = new JButton("SUBMIT");
		
		//text output
		private JTextField price = new JTextField("",10);
		
		//constructor
		public DisneyCottage()
		{
			frame.setSize(500,600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//set texts to be unchangeable
			text0.setEnabled(false);
			text1.setEnabled(false);
			text2.setEnabled(false);
			text3.setEnabled(false);
			text4.setEnabled(false);
			text5.setEnabled(false);
			text6.setEnabled(false);
			textCottages.setEnabled(false);
			textBoat.setEnabled(false);
			totalPrice.setEnabled(false);
			
			//************check the cottage option************
			Check1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) 
				{
					JCheckBox source = (JCheckBox)a.getSource();
					if(source.isSelected())
					{
						cottagePrice = 600;
					}
					else 
					{
						cottagePrice = 0;
					}				
				}
			});
			
			Check2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) 
				{
					JCheckBox source = (JCheckBox)a.getSource();
					if(source.isSelected())
					{
						cottagePrice = 850;
					}
					else
					{
						cottagePrice = 0;
					}
				}
			});
			
			//************check the Boat option**********
			Check3.addActionListener(new ActionListener()
			{
				
				public void actionPerformed(ActionEvent a) {
					JCheckBox source = (JCheckBox)a.getSource();
					if(source.isSelected())
					{
						boatPrice = 60;
					}
					else{
						boatPrice = 0;
					}
				}
			});
			
			//add title
			panel1.add(text0);
			panel2.setLayout(new FlowLayout());
			panel2.add(text1);
			panel2.add(text2);
			panel2.add(textStartMonth);
			panel2.add(text3);
			panel2.add(textStartDay);
			
			//add ending date
			panel3.add(text4);
			panel3.add(text5);
			panel3.add(textEndMonth);
			panel3.add(text6);
			panel3.add(textEndDay);
			
			//add check cottage
			panel4.add(textCottages);
			panel4.add(Check1);
			panel4.add(Check2);
			
			//add check boat
			panel5.add(textBoat);
			panel5.add(Check3);
			
			//add button
			panel6.add(button);
			//add total output
			panel6.add(totalPrice);
			panel6.add(price);
			panel6.add(Signature);
			
			//get data 
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent a)
				{
					int StartMonth = Integer.parseInt(textStartMonth.getText());
					int StartDay = Integer.parseInt(textStartDay.getText());
					int EndMonth = Integer.parseInt(textEndMonth.getText());
					int EndDay = Integer.parseInt(textEndDay.getText());
					
					//get weeks 
					int weeks=theCalculation.getWeek(StartMonth, StartDay, EndMonth, EndDay);				
					
					//calculate total 
					double total=theCalculation.calculateTotal(cottagePrice,boatPrice,weeks);
					
					price.setText(Double.toString(total));
				}
			});
			
			//set panels' color Rainbow
			panel1.setBackground(Color.RED);
			panel2.setBackground(Color.ORANGE);
			panel3.setBackground(Color.YELLOW);
			panel4.setBackground(Color.GREEN);
			panel5.setBackground(Color.BLUE);
			panel6.setBackground(Color.CYAN);
			
			//add panels
			panel0.setLayout(new GridLayout(6,10));	
			panel0.add(panel1);
			panel0.add(panel2);
			panel0.add(panel3);
			panel0.add(panel4);
			panel0.add(panel5);
			panel0.add(panel6);
			
			frame.add(panel0);
			//set visibility
			frame.setVisible(true);
		}
}

