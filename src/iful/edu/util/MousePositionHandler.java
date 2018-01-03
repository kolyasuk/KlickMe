package iful.edu.util;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MousePositionHandler {

	private int mouseXPosition;
	private int mouseYPosition;
	private int buttonStartXPosition;
	private int buttonEndXPosition;
	private int buttonStartYPosition;
	private int buttonEndYPosition;
	private int difficaltyLevel;
	private JButton button;
	private int paneEndX;
	private int paneEndY;

	public MousePositionHandler(JButton button) {
		this.button = button;
	}

	public void checkMousePosition(MouseEvent arg0, int difficaltyLevel, JPanel panel) {
		buttonStartXPosition = button.getX();
		buttonEndXPosition = buttonStartXPosition+button.getWidth();
		buttonStartYPosition = button.getY();
		buttonEndYPosition = buttonStartYPosition+button.getHeight();
		this.difficaltyLevel = difficaltyLevel;
		
		if(checkXPosition(arg0) && checkYPosition(arg0)) {
			randomButtonLocation(button, panel);
		}
	}
	
	public void randomButtonLocation(JButton button, JPanel pane) {
		paneEndX = pane.getWidth()-button.getWidth();
		paneEndY = pane.getHeight()-button.getHeight();
		int randomX = (int) (Math.random()*paneEndX);
		int randomY = (int) (Math.random()*paneEndY);
		button.setLocation(randomX, randomY);
	}
	
	private boolean checkXPosition(MouseEvent arg0) {
		if( arg0.getX()+difficaltyLevel>=buttonStartXPosition && arg0.getX()-difficaltyLevel<=buttonEndXPosition)
			return true;
		else return false;
	}
	
	private boolean checkYPosition(MouseEvent arg0) {
		if(arg0.getY()+difficaltyLevel>=buttonStartYPosition && arg0.getY()-difficaltyLevel<=buttonEndYPosition) 
			return true;
		else return false;
	}
}
