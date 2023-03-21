package swing.project1.db.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dao.ShelterDAO;
import swing.project1.db.dao.impl.base.BaseDAO_MySql;
import swing.project1.db.dto.ShelterDTO;

public class ShelterDAOImpl extends BaseDAO_MySql implements ShelterDAO {

	public List<ShelterDTO> getAllShelter() {
		List<ShelterDTO> resultList = new ArrayList<ShelterDTO>();
		Connection conn = getConnection();
		// TODO
		return resultList;
	}

}
