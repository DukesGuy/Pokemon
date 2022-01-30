package actions;

public class QuickAttack extends Attack {
	
	public QuickAttack() {
		
		name = "Quick Attack";
		damage = (int)(Math.random()*(10 - 6) + 5);
	}

}
