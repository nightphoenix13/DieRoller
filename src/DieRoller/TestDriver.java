package DieRoller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class TestDriver extends JFrame
{
	// GUI components
	private JPanel charPanel,
				   rollPanel,
				   headerPanel;
	private JLabel nameLabel;
	private JTextArea rollOutput;
	private JButton rollButton;
	private JMenuBar menuBar;
	private JMenu character;
	private JMenuItem newChar;
	
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
		buildHeaderPanel();
		buildCharPanel();
		buildRollPanel();
		
		// adding panels to frame
		setJMenuBar(menuBar);
		add(headerPanel, BorderLayout.NORTH);
		add(charPanel, BorderLayout.WEST);
		add(rollPanel, BorderLayout.EAST);
		
		setVisible(true);
	} // constructor end
	
	public static void main(String[] args) // main method start
	{
		TestDriver td = new TestDriver();
	} // main method end
	
	private void buildHeaderPanel() // buildHeaderPanel method start
	{
		// creating components
		headerPanel = new JPanel();
		menuBar = new JMenuBar();
		character = new JMenu("Character");
		newChar = new JMenuItem("New Character");
		
		// component properties
		character.setMnemonic('C');
		newChar.setMnemonic('N');
		
		// adding components to panel
		menuBar.add(character);
		character.add(newChar);
		
		// event handlers
		newChar.addActionListener(new ActionListener() // anonymous inner class
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				createNewChar();
			}
		});
	} // buildHeaderPanel method end
	
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
		
		// event handlers
		rollButton.addActionListener(new RollButtonHandler());
	} // buildRollPanel method end
	
	// createNewChar gets input from user to create new character
	private void createNewChar() // createNewChar method start
	{
		String name = JOptionPane.showInputDialog("Enter the character's name:");
		try
		{
			int attackBonus = Integer.parseInt(JOptionPane.showInputDialog("Enter the attack bonus:"));
			int baseAttack = Integer.parseInt(JOptionPane.showInputDialog("Enter the base attack:"));
			int confirmBonus = Integer.parseInt(JOptionPane.showInputDialog("Enter bonus to confirm critical attacks:"));
			int damageDice = Integer.parseInt(JOptionPane.showInputDialog("Enter the damage di(c)e:"));
			int damageBonus = Integer.parseInt(JOptionPane.showInputDialog("Enter the damage bonus:"));
			int critOn = Integer.parseInt(JOptionPane.showInputDialog("Enter the lowest value in critical hit range:"));
		} // end try
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null, exception);
		} // end catch
	} // createNewChar method end
	
	private class RollButtonHandler implements ActionListener // RollButtonHandler class start
	{

		@Override
		public void actionPerformed(ActionEvent e) // actionPerformed method start
		{
			int roll = RollDice.roll(20);
			rollOutput.setText("Attack Roll:\n");
			rollOutput.append(String.format("%d + %d = %d\n", roll, toon.getBaseAttack() + toon.getAttackbonus(),
					roll + toon.getBaseAttack() + toon.getAttackbonus()));
			if (roll == 1)
			{
				rollOutput.append("Critical Miss!\nDamage: 0");
			} // end if
			else if (roll >= toon.getCritOn())
			{
				rollOutput.append("Possible Crit!\nConfirmation Roll:\n");
				roll = RollDice.roll(20);
				rollOutput.append(String.format("%d + %d = %d\n", roll, toon.getBaseAttack() + toon.getAttackbonus()
						+ toon.getConfirmBonus(), roll + toon.getBaseAttack() + toon.getAttackbonus() +
						toon.getConfirmBonus()));
				if (roll == 1)
				{
					int damage = RollDice.roll(toon.getDamageDice()) + toon.getDamageBonus();
					rollOutput.append("Crit attempt failed\n");
					rollOutput.append("Damage: " + damage);
				} // end if
				else
				{
					int damage = RollDice.roll(toon.getDamageDice()) + toon.getDamageBonus();
					rollOutput.append("Regular Damage: " + damage + "\n");
					damage += RollDice.roll(toon.getDamageDice()) + toon.getDamageBonus();
					rollOutput.append("Critical Damage: " + damage);
				} // end else
			} // end else if
			else
			{
				int damage = RollDice.roll(toon.getDamageDice()) + toon.getDamageBonus();
				rollOutput.append("Damage: " + damage);
			} // end else
		} // actionPerformed method end
	} // RollButtonHandler class end

} // class end
