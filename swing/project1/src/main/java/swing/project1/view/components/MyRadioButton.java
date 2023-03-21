package swing.project1.view.components;

import javax.swing.JRadioButton;

public class MyRadioButton extends JRadioButton{
	private int value;
	
	public MyRadioButton(String text, int value) {
		super(text);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
