package DieRoller;

import javax.swing.JOptionPane;

import DieRoller.Race.Size;

public class Human extends Race
{
	private String[] ability = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdon", "Charisma"};
	
	// constructor start
	public Human()
	{
		super("Human", 0, 0, 0, 0, 0, 0, 30, Size.MEDIUM);
		
		// Allows user to choose ability to receive racial bonus
		String a = (String) JOptionPane.showInputDialog(null, "Select ability to receive +2 bonus:",
				"Select Ability", JOptionPane.QUESTION_MESSAGE, null, ability, ability[0]);
		int index = getIndex(a);
		
		switch (index)
		{
			case 0: setStr(2);
				break;
			case 1: setDex(2);
				break;
			case 2: setCon(2);
				break;
			case 3: setInt(2);
				break;
			case 4: setWis(2);
				break;
			case 5: setCha(2);
				break;
		} // end switch
	} // constructor end
	
	// getIndex method returns the index of the selected ability
	private int getIndex(String a) // getIndex method start
	{
		// local variable
		int index = 0;
			
		for (int x = 0; x < ability.length; x++)
		{
			if (a.equals(ability[x]))
			{
				index = x;
			} // end if
		} // end for
			
		return index;
	} // getIndex method end
}
