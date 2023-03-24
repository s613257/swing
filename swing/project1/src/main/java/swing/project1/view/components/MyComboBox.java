package swing.project1.view.components;

import javax.swing.JComboBox;

import swing.project1.db.dto.ShelterDTO;
import swing.project1.view.components.intface.IComponents;

public class MyComboBox<E> extends JComboBox<E> implements IComponents {

	@Override
	public void setEnable(boolean isEnable) {
		setEnabled(isEnable);
	}

	@Override
	public String getValue() {
		return Integer.toString(getSelectedIndex());
	}

	@Override
	public String getText() {
		return ((ShelterDTO)getSelectedItem()).getShelter_name();
	}
	
	
	public void setSelectedItem(String itemText) {
		for(int i = 0;i<dataModel.getSize();i++) {
			if(dataModel.getElementAt(i).equals(itemText)) {
				dataModel.setSelectedItem(dataModel.getElementAt(i));
				break;
			}
		}
	}
}
