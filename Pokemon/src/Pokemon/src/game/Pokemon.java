package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pokemon {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	GameDialog dialog = new GameDialog(this, ui, vm);
	
	String nextPosition1, nextPosition2, nextPosition3;

	public static void main(String[] args) {
		
		new Pokemon();

	}
	
	public Pokemon() {
		
		ui.createUI(cHandler);
		dialog.defaultSetup();
		vm.showTitleScreen();
		
	}
	
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "start" : vm.titleToGame(); break;
			case "c1" : dialog.selectPosition(nextPosition1); break;
			case "c2" : dialog.selectPosition(nextPosition2); break;
			case "c3" : dialog.selectPosition(nextPosition3); break;
			case "exit" : System.exit(0); break;
			case "playAgain" : dialog.defaultSetup(); vm.showTitleScreen();
			}
			
		}
		
	}

}
