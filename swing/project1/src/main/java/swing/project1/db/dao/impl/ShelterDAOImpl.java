package swing.project1.db.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dao.ShelterDAO;
import swing.project1.db.dao.impl.base.BaseDAO_MySql;
import swing.project1.db.dto.ShelterDTO;

public class ShelterDAOImpl extends BaseDAO_MySql implements ShelterDAO {

	public List<ShelterDTO> getAllShelter() {
		List<ShelterDTO> resultList = new ArrayList<ShelterDTO>();
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * From t_shelter");

			while (rs.next()) {
				resultList.add(new ShelterDTO(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(st, rs);
		}
		return resultList;

	}

}
