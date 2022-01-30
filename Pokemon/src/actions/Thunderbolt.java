package actions;

public class Thunderbolt extends Attack {
	
	public Thunderbolt() {
		
		name = "Thunderbolt";
		damage = (int)(Math.random()*(20 - 11) + 10);
	}

}
