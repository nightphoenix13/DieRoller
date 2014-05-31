package DieRoller;

import java.awt.*;
import javax.swing.*;

public class TestDriver extends JFrame
{
	// GUI components
	private JPanel charPanel,
				   rollPanel;
	private JLabel nameLabel;
	private JTextArea rollOutput;
	private JButton rollButton;
	
	// test Character
	private Character toon;
	
	// constructor
	public TestDriver()
	{
		super("Test Die Roller");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 300);
		
		// test character
		toon = new Character("Test Toon", 5, 4, 2, 6, 8, 19);
		
		// building panels
		buildCharPanel();
		buildRollPanel();
		
		// adding panels to frame
		add(charPanel, BorderLayout.WEST);
		add(rollPanel, BorderLayout.EAST);
		
		setVisible(true);
	} // constructor end
	
	public static void main(String[] args) // main method start
	{
		TestDriver td = new TestDriver();
	} // main method end
	
	private void buildCharPanel() // buildCharPanel method start
	{
		// creating components
		charPanel = new JPanel();
		nameLabel = new JLabel(toon.getName());
		
		// component properties
		
		
		// adding components to panel
		charPanel.add(nameLabel);
	} // buildCharPanel method end
	
	private void buildRollPanel() // buildRollPanel method start
	{
		// creating components
		rollPanel = new JPanel();
		rollOutput = new JTextArea();
		rollButton = new JButton("Roll");
		
		// component properties
		rollPanel.setLayout(new BorderLayout());
		rollOutput.setEditable(false);
		
		// adding components to panel
		rollPanel.add(rollOutput, BorderLayout.CENTER);
		rollPanel.add(rollButton, BorderLayout.SOUTH);
	} // buildRollPanel method end

} // class end
