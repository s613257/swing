package swing.project1.view.components;

import javax.swing.JTextField;

import swing.project1.view.components.intface.IComponents;

public class ComponentTextField extends JTextField implements IComponents {

	@Override
	public void setEnable(boolean isEnable) {
		setEnabled(isEnable);
	}

	@Override
	public String getText() {
		return super.getText();
	}

	@Override
	public String getValue() {
		return super.getText();
	}

}
