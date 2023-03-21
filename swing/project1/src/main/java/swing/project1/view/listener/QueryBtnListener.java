package swing.project1.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.view.MainFrame;

public class QueryBtnListener implements ActionListener{
	private MainFrame parent;
	
	public QueryBtnListener(MainFrame parent) {
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		ArrayList<AdoptionInfoDTO> queryItems = getQueryResult();
		parent.showQueryResult(queryItems);
	}
	
	private ArrayList<AdoptionInfoDTO> getQueryResult(){
		// TODO parent.getQueryStatement();
		ArrayList<AdoptionInfoDTO> queryItems = new ArrayList<AdoptionInfoDTO>();
		AdoptionInfoDTO aid1 = new AdoptionInfoDTO();
		aid1.setAlbum_file("");
		aid1.setAnimal_kind("貓");
		aid1.setAnimal_Variety("混種貓");
		aid1.setAnimal_sex("公");
		aid1.setShelter_name("動物之家1");

		AdoptionInfoDTO aid2 = new AdoptionInfoDTO();
		aid2.setAlbum_file("");
		aid2.setAnimal_kind("貓");
		aid2.setAnimal_Variety("混種貓1");
		aid2.setAnimal_sex("公");
		aid2.setShelter_name("動物之家2");

		AdoptionInfoDTO aid3 = new AdoptionInfoDTO();
		aid3.setAlbum_file("");
		aid3.setAnimal_kind("貓");
		aid3.setAnimal_Variety("混種貓2");
		aid3.setAnimal_sex("公");
		aid3.setShelter_name("動物之家3");

		AdoptionInfoDTO aid4 = new AdoptionInfoDTO();
		aid4.setAlbum_file("");
		aid4.setAnimal_kind("貓");
		aid4.setAnimal_Variety("混種貓3");
		aid4.setAnimal_sex("公");
		aid4.setShelter_name("動物之家4");

		AdoptionInfoDTO aid5 = new AdoptionInfoDTO();
		aid5.setAlbum_file("");
		aid5.setAnimal_kind("貓");
		aid5.setAnimal_Variety("混種貓4");
		aid5.setAnimal_sex("公");
		aid5.setShelter_name("動物之家5");

		AdoptionInfoDTO aid6 = new AdoptionInfoDTO();
		aid6.setAlbum_file("");
		aid6.setAnimal_kind("貓");
		aid6.setAnimal_Variety("混種貓5");
		aid6.setAnimal_sex("公");
		aid6.setShelter_name("動物之家6");

		AdoptionInfoDTO aid7 = new AdoptionInfoDTO();
		aid7.setAlbum_file("");
		aid7.setAnimal_kind("貓");
		aid7.setAnimal_Variety("混種貓6");
		aid7.setAnimal_sex("公");
		aid7.setShelter_name("動物之家7");

		queryItems.add(aid1);
		queryItems.add(aid2);
		queryItems.add(aid3);
		queryItems.add(aid4);
		queryItems.add(aid5);
		queryItems.add(aid6);
		queryItems.add(aid7);
		
		return queryItems;
	}

}
