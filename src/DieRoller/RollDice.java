// This class of static methods is used to simulate the rolling of multiple sided di(c)e.
// Written by Zack Phoenix

package DieRoller;

import java.util.Random;

public class RollDice
{
	
	// Creating Random object
	static Random ranNum = new Random();
			
	// method roll for one argument. Rolls only one die.
	public static int roll(int sides) // 1Dx format (Example: 1D8 = roll(8))
	{ // roll method start
		// returns random number between 1 and sides variable
		if (sides > 1) // input validation
			return (1 + ranNum.nextInt(sides));
		else // throw exception
			throw new IllegalArgumentException("sides must be greater than 1.");
	} // roll method end
	
	// method roll for two arguments. Rolls number of dice in "dice" argument.
	public static int roll(int dice, int sides) // xDx format (Example: 4D6 = roll(4, 6))
	{ // roll method start
		// local variable
		int total = 0; // used to add total of individual dice rolls.
		
		if (dice == 1) // use one argument method if dice is 1
		{
			total = roll(sides);
		}
		else if (dice < 1) // input validation
		{ // throw exception
			throw new IllegalArgumentException("dice must be a positive number.");
		}
		else
		{
			// for loop to roll "dice" number of dice
			for (int x = 0; x < dice; x++)
			{
				total += (1 + ranNum.nextInt(sides)); // adds individual die result to total in each iteration.
			}
		}				
		// returns total of all dice rolled
		return total;
	} // roll method end
} // RollDice class end
