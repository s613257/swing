package swing.project1.components;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import swing.project1.components.intface.IComponents;

public class MyRadioGroup extends ButtonGroup implements IComponents{
	public void setEnable(boolean isEnable) {
		for (Enumeration<AbstractButton> radios = this.getElements(); radios.hasMoreElements();) {
			AbstractButton radio = radios.nextElement();
			radio.setEnabled(isEnable);
		}
	}

	public String getValue() {
		for (Enumeration<AbstractButton> radios = this.getElements(); radios.hasMoreElements();) {
			AbstractButton radio = radios.nextElement();
			if (radio.isSelected()) {
				return radio.getText();
			}
		}
		return "";
	}
}
