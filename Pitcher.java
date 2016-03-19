
public class Pitcher extends BaseballPlayer{
	
	protected float ERA;

/**
 * Creates a baseball player of position pitcher.
 * @param number  Player's number.
 * @param lastName  Player's last name.
 * @param firstName  Player's first name.
 * @param average  Player's average.
 * @param e  Player's ERA.
 */
	public Pitcher(int number, String lastName, String firstName, float average, float e){
		super(number,lastName,firstName,average);
		if(number<0 || number>99) throw new IllegalPlayerException("Number must be from 1 to 100.");
		if(average<=0 || average>=1) throw new IllegalPlayerException("Average must be between 0 and 1.");
		ERA = e;
	}
	
	public float getERA(){
		return ERA; 
	}
	
	public void setERA(float era){
		ERA = era; 
	}

/**
 * Takes a Pitcher and returns its parameters as a string.
 */
	public String toString(){
		String info = number + "   " + lastName + ", " + firstName + "  " + average + "  " + ERA + "\n";
		return info;
	}
}
