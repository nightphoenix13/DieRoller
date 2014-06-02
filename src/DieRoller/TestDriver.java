package DieRoller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
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
		rollOutput = new JTextArea("                        ");
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
