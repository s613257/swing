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
		AdoptionInfoDAO sd = new AdoptionInfoDAOImpl();
		List<AdoptionInfoDTO> adoptionList = sd.getAllAdoptionInfo();
		for (AdoptionInfoDTO s : adoptionList) {
			System.out.println(s.toString());
		}
	}

}
