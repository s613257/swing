package swing.project1.test;

import java.util.List;

import swing.project1.db.dao.ShelterDAO;
import swing.project1.db.dao.impl.ShelterDAOImpl;
import swing.project1.db.dto.ShelterDTO;

public class DaoTesting {
	public static void testShelterDAO() {
		ShelterDAO sd = new ShelterDAOImpl();
		List<ShelterDTO> shelterList = sd.getAllShelter();
		for (ShelterDTO s : shelterList) {
			System.out.println(s.toString());
		}
	}

}
