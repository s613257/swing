package swing.project1.test;

import java.util.List;

import swing.project1.db.dao.AdoptionInfoDAO;
import swing.project1.db.dao.ShelterDAO;
import swing.project1.db.dao.impl.AdoptionInfoDAOImpl;
import swing.project1.db.dao.impl.ShelterDAOImpl;
import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.db.dto.ShelterDTO;

public class DaoTesting {
	public static void testShelterDAO() {
		ShelterDAO sd = new ShelterDAOImpl();
		List<ShelterDTO> shelterList = sd.getAllShelter();
		for (ShelterDTO s : shelterList) {
			System.out.println(s.toString());
		}
	}
			
	public static void testAdoptionInfoDAO() {
		AdoptionInfoDAO aid = new AdoptionInfoDAOImpl();
		List<AdoptionInfoDTO> adoptionList = aid.getAllAdoptionInfo();
		for (AdoptionInfoDTO ai : adoptionList) {
			System.out.println(ai.toString());
		}
	}

}
