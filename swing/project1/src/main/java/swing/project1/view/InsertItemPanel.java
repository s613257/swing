package swing.project1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import swing.project1.db.dto.ShelterDTO;
import swing.project1.model.ShelterListItem;
import swing.project1.view.components.ComponentTextField;
import swing.project1.view.components.ImagePanel;
import swing.project1.view.components.MyComboBox;
import swing.project1.view.components.MyRadioGroup;

public class InsertItemPanel extends JPanel {
	private JDialog parent;
	
	private JPanel panelTitle;
	private JPanel panelContent;
	private JLabel lblIdTitle;
	private JLabel lblIdValue;
	private JButton btnSumit;
	private JButton btnCancel;
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
	private MyComboBox<ShelterListItem> cbxShelter;

	/**
	 * Create the panel.
	 */
	public InsertItemPanel(JDialog parent) {
		this.parent = parent;
		initPanel();
	}

	private void initPanel() {
		setBounds(0, 0, 295, 300);
		setBorder(new LineBorder(new Color(0, 0, 0)));

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

		btnSumit = new JButton("新增");
		// TODO addActionListener{dao.update(getQueryItem())}
		panelTitleOperation.add(btnSumit);
		
		

		btnCancel = new JButton("取消");
		panelTitleOperation.add(btnCancel);
		// TODO addActionListener{dao.delete(getQueryItem())}
				
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(false);
			}
		});
		
		panelContent = new JPanel();
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));

		panelImg = new ImagePanel();
		panelImg.setEditable(true);
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
		jtfKindValue.setText("");
		jtfKindValue.setColumns(10);
		horizontalBox.add(jtfKindValue);

		jtfVarietyValue = new ComponentTextField();
		jtfVarietyValue.setText("");
		jtfVarietyValue.setColumns(10);
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
		horizontalBoxSex.add(radioBtnMale);
		btnGroupSex.add(radioBtnMale);

		radioBtnFemale = new JRadioButton("母");
		horizontalBoxSex.add(radioBtnFemale);
		btnGroupSex.add(radioBtnFemale);

		lblShelterTitle = new JLabel("收容所");
		lblShelterTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		panelInfo.add(lblShelterTitle);

		panelInfo.add(new JSeparator());

		cbxShelter = new MyComboBox<ShelterListItem>();
		listShelter(MainFrame.getShelterList());
		panelInfo.add(cbxShelter);
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
		// jtfShelter.setText(shelter_name);
		cbxShelter.setSelectedItem(shelter_name);
	}

	public void listShelter(List<ShelterDTO> shelterList) {
		cbxShelter.removeAllItems();
		if (shelterList != null && !shelterList.isEmpty()) {
			for (ShelterDTO shelter : shelterList) {
				cbxShelter.addItem(new ShelterListItem(shelter));
			}
		}
	}
}
