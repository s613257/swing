package swing.project1.view.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import swing.project1.view.components.intface.IComponents;

public class MyRadioGroup extends ButtonGroup implements IComponents {
	private List<MyRadioButton> radioList;

	public MyRadioGroup() {
		radioList = new ArrayList<MyRadioButton>();
	}

	public void add(MyRadioButton mab) {
		super.add(mab);
		radioList.add(mab);
	}

	public void setEnable(boolean isEnable) {
		for (MyRadioButton mab : radioList) {
			mab.setEnabled(isEnable);
		}
	}

	public String getValue() {
		for (MyRadioButton mab : radioList) {
			if (mab.isSelected()) {
				return Integer.toString(mab.getValue());
			}
		}
		return "-1";
	}

	public String getText() {
		for (MyRadioButton mab : radioList) {
			if (mab.isSelected()) {
				return mab.getText();
			}
		}
		return "";
	}
}
