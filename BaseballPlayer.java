public class BaseballPlayer {

	protected int number;
	protected String lastName;
	protected String firstName;
	protected float average;
	
	public BaseballPlayer (){
		number=0;
		lastName="";
		firstName="";
		average=0.0f;
		//this(0,"","",0.0f);
	}
	public BaseballPlayer(int n, String l, String f, float a){
		if(n<0 || n>99) throw new IllegalPlayerException("Number must be from 1 to 100.");
		if(a<=0 || a>=1) throw new IllegalPlayerException("Average must be between 0 and 1.");
		
		number=n;
		lastName=l;
		firstName=f;
		average=a;
	}
	
	
	public int getNumber(){ 
		return number;
	}
	
	public float getAverage(){
		return average;
	}
	
	public String getlastName(){
		return lastName;
	}
	
	public String getfirstName(){
		return firstName;
	}

	public void setNumber(int n){
		number=n;
	}
	
	public void setAverage(float a){
		average=a;
	}
	
	public void setlastName(String l){
		lastName=l;
	}
	
	public void setfirstName(String f){
		firstName=f;
	}
	
	/*public int compareTo(BaseballPlayer b){
		if((lastName.compareToIgnoreCase(b.getlastName())) > 0) return 1;
		else if((lastName.compareToIgnoreCase(b.getlastName())) == 0) return 0;
		else if((lastName.compareToIgnoreCase(b.getlastName())) < 0) return -1;
		else return 0;
	}*/
	
	public int compareTo(BaseballPlayer other){
		int compareNum = (number - other.number);
		return compareNum; 
	}
	
}
