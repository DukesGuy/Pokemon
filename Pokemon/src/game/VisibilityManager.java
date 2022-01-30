package game;

public class VisibilityManager {
	
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		// Show title screen
		ui.titlePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// Hide game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.exitButtonPanel.setVisible(false);
	}
	
	public void titleToGame() {
		
		// Hide title screen
		ui.titlePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		// Show game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		
	}
	
	public void exit() {
		
		// Hide game buttons
		ui.choiceButtonPanel.setVisible(false);
		
		// Show play again and exit buttons
		ui.exitButtonPanel.setVisible(true);
	}


}
