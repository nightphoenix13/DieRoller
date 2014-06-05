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
	private JMenu character,
				  exit;
	private JMenuItem newChar,
					  quit;
	
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
		exit = new JMenu("Exit");
		newChar = new JMenuItem("New Character");
		quit = new JMenuItem("Quit Program");
		
		// component properties
		character.setMnemonic('C');
		exit.setMnemonic('x');
		newChar.setMnemonic('N');
		quit.setMnemonic('Q');
		
		// adding components to panel
		menuBar.add(character);
		menuBar.add(exit);
		character.add(newChar);
		exit.add(quit);
		
		// event handlers
		newChar.addActionListener(new ActionListener() // anonymous inner class
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				createNewChar();
			}
		});
		quit.addActionListener(new ActionListener() // anonymous inner class
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
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
		int attackBonus = userAttackBonus();
		int baseAttack = userBaseAttack();
		int confirmBonus = userConfirmBonus();
		int damageDice = userDamageDice();
		int damageBonus = userDamageBonus();
		int critOn = userCritOn();
		toon = new Character(name, attackBonus, baseAttack, confirmBonus, damageDice, damageBonus,
				critOn);
		updateCharPanel();
	} // createNewChar method end
	
	// userAttackBonus method gets the attack bonus from user
	private int userAttackBonus() // userAttackBonus method start
	{
		// local variables
		boolean valid = false;
		int ab = 0;
		
		while (!valid)
		{
			try
			{
				ab = Integer.parseInt(JOptionPane.showInputDialog("Enter the attack bonus:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return ab;
	} // userAttackBonus method end
	
	// userBaseAttack method gets the base attack from user
	private int userBaseAttack() // userBaseAttack method start
	{
		// local variables
		boolean valid = false;
		int ba = 0;
		
		while (!valid)
		{
			try
			{
				ba = Integer.parseInt(JOptionPane.showInputDialog("Enter the base attack:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return ba;
	} // userBaseAttack method end
	
	// userConfirmBonus method gets the bonus to confirm critical attacks from user
	private int userConfirmBonus() // userConfirmBonus method start
	{
		// local variables
		boolean valid = false;
		int cb = 0;
		
		while (!valid)
		{
			try
			{
				cb = Integer.parseInt(JOptionPane.showInputDialog("Enter bonus to confirm critical attacks:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return cb;
	} // userConfirmBonus method end
	
	// userDamageDice method gets the damage dice from user
	private int userDamageDice() // userDamageDice method start
	{
		// local variables
		boolean valid = false;
		int dd = 0;
		
		while (!valid)
		{
			try
			{
				dd = Integer.parseInt(JOptionPane.showInputDialog("Enter the damage di(c)e:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return dd;
	} // userDamageDice method end
	
	// userDamageBonus method gets damage bonus from user
	private int userDamageBonus() // userDamageBonus method start
	{
		// local variables
		boolean valid = false;
		int db = 0;
				
		while (!valid)
		{
			try
			{
				db = Integer.parseInt(JOptionPane.showInputDialog("Enter the damage bonus:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return db;
	} // userDamageBonus method end
	
	// userCritOn method gets the lowest value in critical range from user
	private int userCritOn() // userCritOn method start
	{
		boolean valid = false;
		int co = 0;
		
		while (!valid)
		{
			try
			{
				co = Integer.parseInt(JOptionPane.showInputDialog("Enter the lowest value in critical hit range:"));
				valid = true;
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You must an integer. Try again.", "Not a Number", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // end while
		
		return co;
	} // userCritOn method end
	
	// updateCharPanel method updates the charPanel
	private void updateCharPanel() // updateCharPanel method start
	{
		nameLabel.setText(toon.getName());
	} // updateCharPanel method end
	
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
