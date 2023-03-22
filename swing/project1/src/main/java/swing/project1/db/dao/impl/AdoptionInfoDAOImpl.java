package swing.project1.db.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dao.AdoptionInfoDAO;
import swing.project1.db.dao.impl.base.BaseDAO_MySql;
import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.db.dto.ShelterDTO;

public class AdoptionInfoDAOImpl extends BaseDAO_MySql implements AdoptionInfoDAO {
	public List<AdoptionInfoDTO> getAllAdoptionInfo(){

		List<AdoptionInfoDTO> resultList = new ArrayList<AdoptionInfoDTO>();
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("Select * From t_adoption_info  limit 7");

			while (rs.next()) {
				resultList.add(new AdoptionInfoDTO(rs));
			}

		}catch(
				SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			closeAll(st, rs);
		}return resultList;

}

}