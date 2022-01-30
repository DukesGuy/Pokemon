package actions;

public class Tackle extends Attack {
	
	public Tackle() {
		
		name = "Tackle";
		damage = (int)(Math.random()*(5 - 2) + 1);
	}

}
