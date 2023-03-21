package swing.project1.db.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dao.AreaDAO;
import swing.project1.db.dao.impl.base.BaseDAO_MySql;
import swing.project1.db.dto.AreaDTO;

public class AreaDAOImpl extends BaseDAO_MySql implements AreaDAO {

	public List<AreaDTO> getAllArea() {
		List<AreaDTO> resultList = new ArrayList<AreaDTO>();
		Connection conn = BaseDAO_MySql.getConnection();
		// TODO
		return resultList;
	}

}
