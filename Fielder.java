public class Fielder extends BaseballPlayer {
	
/**
 * Creates a baseball player of position fielder.
 * @param number  Player's number.
 * @param lastName  Player's last name.
 * @param firstName  Player's first name.
 * @param average  Player's average.
 */
	public Fielder (int number, String lastName, String firstName, float average){
		super(number,lastName,firstName,average);
	}

/**
 * Takes a Fielder and returns its parameters as a string.
 */
	public String toString(){
		String info = number + "  " + lastName + ", " + firstName + "  " + average + "\n";
		return info;
	}

}