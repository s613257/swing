package swing.project1.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import swing.project1.db.dao.AdoptionInfoDAO;
import swing.project1.db.dao.ShelterDAO;
import swing.project1.db.dao.impl.AdoptionInfoDAOImpl;
import swing.project1.db.dao.impl.ShelterDAOImpl;
import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.db.dto.ShelterDTO;
import swing.project1.model.QueryCondition;
import swing.project1.model.QueryItem;
import swing.project1.model.ShelterListItem;
import swing.project1.model.io.IFileFactory;
import swing.project1.model.io.impl.CSVFileFactory;
import swing.project1.model.io.impl.FileIOFactory;
import swing.project1.model.io.impl.JsonFileFactory;
import swing.project1.model.io.impl.XmlFileFactory;
import swing.project1.view.components.MyComboBox;
import swing.project1.view.components.MyRadioButton;
import swing.project1.view.components.MyRadioGroup;
import swing.project1.view.listener.QueryBtnListener;

public class MainFrame extends JFrame {

	private MainFrame thisMF;
	private JPanel contentPane;
	private JPanel panelQueryResultList;
	private static List<AdoptionInfoDTO> currQueryItems;
	private static List<ShelterDTO> shelterList = null;

	// Kind
	MyRadioGroup btnGroupKind;
	MyRadioButton radioBtnCat;
	MyRadioButton radioBtnDog;
	MyRadioButton radioBtnOtherType;
	MyRadioButton radioBtnAllType;

	// Sex
	MyRadioGroup btnGroupSex;
	MyRadioButton radioBtnMale;
	MyRadioButton radioBtnFemale;
	MyRadioButton radioBtnAllSex;
	// Sheelter
	private MyComboBox<ShelterListItem> cbxShelter;

	static JDialog jd;

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
		jd = new JDialog(this);
		jd.setBounds(200, 200, 400, 500);
		jd.add(new InsertItemPanel(this, jd));
		mntmNew1Record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jd.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNew1Record);

		JMenuItem mntmImportRecords = new JMenuItem("匯入資料");
		// TODO
		mntmImportRecords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("檔案", "csv", "json", "xml");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChooser.setFileFilter(filter);
				int option = fileChooser.showOpenDialog(thisMF);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					String fileFullName = f.getAbsolutePath();
					String fileType = FilenameUtils.getExtension(fileFullName);
					
					if ((fileType != null) && !fileType.isEmpty()) {
						IFileFactory fileFac = null;
						switch (fileType) {
						case "csv":
							fileFac = new CSVFileFactory();
							break;
						case "json":
							fileFac = new JsonFileFactory();
							break;
						case "xml":
							fileFac = new XmlFileFactory();
							break;
						default:
							fileFac = new CSVFileFactory();
							break;
						}
						FileIOFactory fioFac = new FileIOFactory(fileFac);
						AdoptionInfoDAO aid = new AdoptionInfoDAOImpl();
						aid.insertByQueryItems(fioFac.getDatasInFile(fileFullName));
						
						JOptionPane.showMessageDialog(thisMF,
								String.format("輸入成功!(%s)", IFileFactory.HOME_DOWNLOADS_FOLDER));
					}
				}
			}
		});

		mnNewMenu.add(mntmImportRecords);

		JMenuItem mntmExportResult = new JMenuItem("匯出查詢結果");
		mnNewMenu.add(mntmExportResult);
		mntmExportResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currQueryItems.isEmpty()) {
					JOptionPane.showMessageDialog(thisMF, "無搜尋結果輸出!", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String[] possibilities = { "csv", "json", "xml" };
				String fileType = (String) JOptionPane.showInputDialog(thisMF, "匯出檔案格式", "匯出檔案",
						JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[0]);

				if ((fileType != null) && !fileType.isEmpty()) {
					IFileFactory fileFac = null;
					switch (fileType) {
					case "csv":
						fileFac = new CSVFileFactory();
						break;
					case "json":
						fileFac = new JsonFileFactory();
						break;
					case "xml":
						fileFac = new XmlFileFactory();
						break;
					default:
						fileFac = new CSVFileFactory();
						break;
					}
					FileIOFactory fioFac = new FileIOFactory(fileFac);
					fioFac.writeDataToFile(currQueryItems);
					JOptionPane.showMessageDialog(thisMF,
							String.format("輸出成功!(%s)", IFileFactory.HOME_DOWNLOADS_FOLDER));
				}
			}
		});

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

		btnGroupKind = new MyRadioGroup();
		radioBtnCat = new MyRadioButton("貓", 0);
		radioBtnCat.setSelected(true);
		horizontalBoxType.add(radioBtnCat);
		btnGroupKind.add(radioBtnCat);

		radioBtnDog = new MyRadioButton("狗", 1);
		horizontalBoxType.add(radioBtnDog);
		btnGroupKind.add(radioBtnDog);

		radioBtnOtherType = new MyRadioButton("其他", 2);
		horizontalBoxType.add(radioBtnOtherType);
		btnGroupKind.add(radioBtnOtherType);

		radioBtnAllType = new MyRadioButton("不限", 3);
		horizontalBoxType.add(radioBtnAllType);
		btnGroupKind.add(radioBtnAllType);

		Box horizontalBoxSex = Box.createHorizontalBox();
		horizontalBoxSex.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCondition.add(horizontalBoxSex);

		JLabel lblSex = new JLabel("性別:");
		horizontalBoxSex.add(lblSex);

		btnGroupSex = new MyRadioGroup();
		radioBtnMale = new MyRadioButton("公", 0);
		radioBtnMale.setSelected(true);
		horizontalBoxSex.add(radioBtnMale);
		btnGroupSex.add(radioBtnMale);

		radioBtnFemale = new MyRadioButton("母", 1);
		horizontalBoxSex.add(radioBtnFemale);
		btnGroupSex.add(radioBtnFemale);

		radioBtnAllSex = new MyRadioButton("不限", 2);
		horizontalBoxSex.add(radioBtnAllSex);
		btnGroupSex.add(radioBtnAllSex);

		Box horizontalBoxShelter = Box.createHorizontalBox();
		horizontalBoxShelter.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCondition.add(horizontalBoxShelter);

		JLabel lblShelter = new JLabel("收容所:");
		horizontalBoxShelter.add(lblShelter);

		cbxShelter = new MyComboBox<ShelterListItem>();
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

		currQueryItems = new ArrayList<AdoptionInfoDTO>();
		this.thisMF = this;
	}

	public void showQueryResult(List<AdoptionInfoDTO> queryItems) {
		currQueryItems.clear();
		panelQueryResultList.removeAll();
		for (int i = 0; i < queryItems.size(); i++) {
			currQueryItems.add(queryItems.get(i));
			panelQueryResultList.add(new QueryItemPanel(this, new QueryItem(queryItems.get(i))));
			if (i >= 7) {
				break;
			}
		}
		revalidate();
		repaint();
	}

	public void listShelter(List<ShelterDTO> shelterList) {
		cbxShelter.removeAllItems();
		ShelterListItem allShelter = new ShelterListItem();
		cbxShelter.addItem(allShelter);
		if (shelterList != null && !shelterList.isEmpty()) {
			for (ShelterDTO shelter : shelterList) {
				cbxShelter.addItem(new ShelterListItem(shelter));
			}
		}
	}

	public QueryCondition getQueryCondition() {
		QueryCondition qc = new QueryCondition();
		qc.setKind(Integer.parseInt(btnGroupKind.getValue()));
		qc.setSex(Integer.parseInt(btnGroupSex.getValue()));
		qc.setShelterIdx(((ShelterListItem) cbxShelter.getSelectedItem()).getShelter_pkid());
		qc.setShelterName(((ShelterListItem) cbxShelter.getSelectedItem()).getShelter_name());
		return qc;
	}

	public static List<ShelterDTO> getShelterList() {
		if (shelterList == null) {
			ShelterDAO shelterDAO = new ShelterDAOImpl();
			shelterList = shelterDAO.getAllShelter();
		}
		return shelterList;
	}

}
