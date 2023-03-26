package swing.project1.view.components;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import swing.project1.view.components.intface.IComponents;

public class MyRadioGroup extends ButtonGroup implements IComponents {


	public MyRadioGroup() {
	}

	@Override
	public void setEnable(boolean isEnable) {
		for (AbstractButton mab : buttons) {
			mab.setEnabled(isEnable);
		}
	}

	@Override
	public String getValue() {
		for (AbstractButton mab : buttons) {
			if (mab.isSelected()) {
				return Integer.toString(((MyRadioButton)mab).getValue());
			}
		}
		return "-1";
	}

	@Override
	public String getText() {
		for (AbstractButton mab : buttons) {
			if (mab.isSelected()) {
				return mab.getText();
			}
		}
		return "";
	}
}
