package swing.project1.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing.project1.model.QueryItem;
import swing.project1.model.dto.AdoptionInfoDTO;
import swing.project1.model.dto.ShelterDTO;
import swing.project1.model.listener.QueryBtnListener;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelQueryResultList;
	private JComboBox<String> cbxShelter;

	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		setTitle("動物認領養");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 900);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("檔案");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNew1Record = new JMenuItem("新增單筆資料");
		mnNewMenu.add(mntmNew1Record);

		JMenuItem mntmImportRecords = new JMenuItem("匯入資料");
		mnNewMenu.add(mntmImportRecords);

		JMenuItem mntmExportResult = new JMenuItem("匯出查詢結果");
		mnNewMenu.add(mntmExportResult);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCondition = new JPanel();
		contentPane.add(panelCondition, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 20, 5);
		panelCondition.setLayout(fl_panel);

		JLabel lblCondition = new JLabel("查詢條件:");
		panelCondition.add(lblCondition);

		Box horizontalBoxType = Box.createHorizontalBox();
		horizontalBoxType.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCondition.add(horizontalBoxType);

		JLabel lblType = new JLabel("種類:");
		horizontalBoxType.add(lblType);

		MyRadioGroup btnGroupType = new MyRadioGroup();
		MyRadioButton radioBtnCat = new MyRadioButton("貓", 0);

		horizontalBoxType.add(radioBtnCat);
		btnGroupType.add(radioBtnCat);

		MyRadioButton radioBtnDog = new MyRadioButton("狗", 1);
		horizontalBoxType.add(radioBtnDog);
		btnGroupType.add(radioBtnDog);

		MyRadioButton radioBtnOtherType = new MyRadioButton("其他", 2);
		horizontalBoxType.add(radioBtnOtherType);
		btnGroupType.add(radioBtnOtherType);

		MyRadioButton radioBtnAllType = new MyRadioButton("不限", 3);
		horizontalBoxType.add(radioBtnAllType);
		btnGroupType.add(radioBtnAllType);

		Box horizontalBoxSex = Box.createHorizontalBox();
		horizontalBoxSex.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCondition.add(horizontalBoxSex);

		JLabel lblSex = new JLabel("性別:");
		horizontalBoxSex.add(lblSex);

		MyRadioGroup btnGroupSex = new MyRadioGroup();
		MyRadioButton radioBtnMale = new MyRadioButton("公", 0);
		horizontalBoxSex.add(radioBtnMale);
		btnGroupSex.add(radioBtnMale);

		MyRadioButton radioBtnFemale = new MyRadioButton("母", 1);
		horizontalBoxSex.add(radioBtnFemale);
		btnGroupSex.add(radioBtnFemale);

		MyRadioButton radioBtnAllSex = new MyRadioButton("不限", 2);
		horizontalBoxSex.add(radioBtnAllSex);
		btnGroupSex.add(radioBtnAllSex);

		Box horizontalBoxShelter = Box.createHorizontalBox();
		horizontalBoxShelter.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCondition.add(horizontalBoxShelter);

		JLabel lblShelter = new JLabel("收容所:");
		horizontalBoxShelter.add(lblShelter);

		cbxShelter = new JComboBox<String>();
		listShelter(getShelterList());
		horizontalBoxShelter.add(cbxShelter);

		JButton btnQuery = new JButton("查詢");
		btnQuery.addActionListener(new QueryBtnListener(this));
		panelCondition.add(btnQuery);

		JPanel panelQueryResult = new JPanel();
		contentPane.add(panelQueryResult, BorderLayout.CENTER);
		panelQueryResult.setLayout(new BorderLayout(0, 0));

		JSeparator sepr1 = new JSeparator();
		panelQueryResult.add(sepr1, BorderLayout.NORTH);

		panelQueryResultList = new JPanel();
		panelQueryResult.add(panelQueryResultList);
		panelQueryResultList.setLayout(new GridLayout(0, 4, 0, 0));
	}

	public void showQueryResult(ArrayList<AdoptionInfoDTO> queryItems) {
		panelQueryResultList.removeAll();
		for (int i = 0; i < queryItems.size(); i++) {
			panelQueryResultList.add(new QueryItemPanel(new QueryItem(queryItems.get(i))));
			if(i >= 7) {
				break;
			}
		}
		revalidate();
		repaint();
	}

	public void listShelter(ArrayList<ShelterDTO> shelterList) {
		cbxShelter.removeAllItems();
		ShelterDTO allShelter = new ShelterDTO();
		cbxShelter.addItem(allShelter.getText());
		if (shelterList != null && !shelterList.isEmpty()) {
			for (ShelterDTO shelter : shelterList) {
				cbxShelter.addItem(shelter.getText());
			}
		}
	}
	
	private ArrayList<ShelterDTO> getShelterList(){
		ArrayList<ShelterDTO> shelterList = new ArrayList<ShelterDTO>();
		// TODO 
		
		return shelterList;
	}

}
