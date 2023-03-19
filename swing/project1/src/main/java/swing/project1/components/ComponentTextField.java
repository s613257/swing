package swing.project1.components;

import javax.swing.JTextField;

import swing.project1.components.intface.IComponents;

public class ComponentTextField extends JTextField implements IComponents {

	public void setEnable(boolean isEnable) {
		setEnabled(isEnable);
	}

	public String getValue() {

		return getText();
	}

}
