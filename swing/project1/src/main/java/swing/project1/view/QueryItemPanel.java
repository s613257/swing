package swing.project1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import swing.project1.model.QueryItem;
import swing.project1.view.components.ComponentTextField;
import swing.project1.view.components.ImagePanel;
import swing.project1.view.components.MyRadioGroup;
import swing.project1.view.components.intface.IComponents;

public class QueryItemPanel extends JPanel {
	private JPanel panelTitle;
	private JPanel panelContent;
	private JLabel lblIdTitle;
	private JLabel lblIdValue;
	private JButton btnEdit;
	private JButton btnDelete;
	private ImagePanel panelImg;
	private JPanel panelInfo;
	private JLabel lblKindVarietyTitle;
	private JLabel lblSexTitle;

	private JLabel lblShelterTitle;
	private Box horizontalBox;
	private ComponentTextField jtfKindValue;
	private ComponentTextField jtfVarietyValue;

	private MyRadioGroup btnGroupSex;
	private JRadioButton radioBtnMale;
	private JRadioButton radioBtnFemale;
	private ComponentTextField jtfShelter;

	private ArrayList<IComponents> components;

	/**
	 * Create the panel.
	 */
	public QueryItemPanel() {

		initPanel();
		setEnble(false);
	}

	public QueryItemPanel(QueryItem data) {
		initPanel();
		setEnble(false);

		setImage(data.getAlbum_file());
		setKind(data.getAnimal_kind());
		setVariety(data.getAnimal_Variety());
		setSex(data.getAnimal_sex());
		setShelter(data.getShelter_name());
	}

	private void initPanel() {
		setBounds(0, 0, 294, 300);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		components = new ArrayList<IComponents>();

		setLayout(new BorderLayout(0, 0));

		panelTitle = new JPanel();
		add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));

		JPanel panelTitleInfo = new JPanel();
		panelTitle.add(panelTitleInfo, BorderLayout.WEST);

		lblIdTitle = new JLabel("ID: ");
		panelTitleInfo.add(lblIdTitle);

		lblIdValue = new JLabel("000000");
		panelTitleInfo.add(lblIdValue);
		JPanel panelTitleOperation = new JPanel();
		panelTitle.add(panelTitleOperation, BorderLayout.EAST);

		btnEdit = new JButton("編輯");
		panelTitleOperation.add(btnEdit);

		btnDelete = new JButton("刪除");
		panelTitleOperation.add(btnDelete);

		panelContent = new JPanel();
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));

		panelImg = new ImagePanel();
		panelContent.add(panelImg, BorderLayout.CENTER);

		panelInfo = new JPanel();
		panelContent.add(panelInfo, BorderLayout.SOUTH);
		panelInfo.setLayout(new GridLayout(0, 3, 0, 0));

		lblKindVarietyTitle = new JLabel("種類(品種)");
		lblKindVarietyTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		panelInfo.add(lblKindVarietyTitle);

		panelInfo.add(new JSeparator());

		horizontalBox = Box.createHorizontalBox();
		panelInfo.add(horizontalBox);

		jtfKindValue = new ComponentTextField();
		jtfKindValue.setText("狗");
		jtfKindValue.setColumns(10);
		components.add(jtfKindValue);
		horizontalBox.add(jtfKindValue);

		jtfVarietyValue = new ComponentTextField();
		jtfVarietyValue.setText("混種狗");
		jtfVarietyValue.setColumns(10);
		components.add(jtfVarietyValue);
		horizontalBox.add(jtfVarietyValue);

		lblSexTitle = new JLabel("性別");
		lblSexTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		panelInfo.add(lblSexTitle);

		panelInfo.add(new JSeparator());

		Box horizontalBoxSex = Box.createHorizontalBox();
		horizontalBoxSex.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.add(horizontalBoxSex);

		btnGroupSex = new MyRadioGroup();
		radioBtnMale = new JRadioButton("公");
		radioBtnMale.setSelected(true);
		horizontalBoxSex.add(radioBtnMale);
		btnGroupSex.add(radioBtnMale);

		radioBtnFemale = new JRadioButton("母");
		horizontalBoxSex.add(radioBtnFemale);
		btnGroupSex.add(radioBtnFemale);

		components.add(btnGroupSex);

		lblShelterTitle = new JLabel("收容所");
		lblShelterTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		panelInfo.add(lblShelterTitle);

		panelInfo.add(new JSeparator());

		jtfShelter = new ComponentTextField();
		jtfShelter.setText("OX動物之家");
		jtfShelter.setColumns(10);
		components.add(jtfShelter);
		panelInfo.add(jtfShelter);

	}

	public void setEnble(boolean isEnable) {
		for (IComponents component : components) {
			component.setEnable(isEnable);
		}
	}

	public void setImage(String album_file) {
		panelImg.setImage(album_file);
	}

	public void setKind(String animal_kind) {
		jtfKindValue.setText(animal_kind);
	}

	public void setVariety(String animal_Variety) {
		jtfVarietyValue.setText(animal_Variety);
	}

	public void setSex(String animal_sex) {
		// btnGroupSex.setSex(animal_sex);
		if (animal_sex.toUpperCase().equals("F")) {
			radioBtnFemale.setSelected(true);
		} else {
			radioBtnMale.setSelected(true);
		}
	}

	public void setShelter(String shelter_name) {
		jtfShelter.setText(shelter_name);
	}

}
