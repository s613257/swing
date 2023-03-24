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
import swing.project1.model.QueryCondition;
import swing.project1.model.QueryItem;

public class AdoptionInfoDAOImpl extends BaseDAO_MySql implements AdoptionInfoDAO {
	Connection conn = getConnection();

	@Override
	public List<AdoptionInfoDTO> getAllAdoptionInfo() {
		return getInfoBySql("Select * From t_adoption_info  limit 7");
	}

	@Override
	public List<AdoptionInfoDTO> getInfoByCondition(QueryCondition qc) {
		return getInfoBySql(String.format("SELECT * FROM t_adoption_info%s", qc.toWhereStatemant()));
	}
	
	@Override
	public int updateByQueryItem(QueryItem dataSource) {
		String sql = dataSource.getUpdateSqlCmd();
		System.out.println(sql);
		return executeUpdate(sql);
	}
	
	@Override
	public int deleteById(String animal_id) {
		return executeUpdate(String.format("DELETE FROM t_adoption_info WHERE animal_id = %s;", animal_id));
	}
	
	private List<AdoptionInfoDTO> getInfoBySql(String sql) {
		List<AdoptionInfoDTO> resultList = new ArrayList<AdoptionInfoDTO>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new AdoptionInfoDTO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(st, rs);
		}
		return resultList;
	}
	
	private int executeUpdate(String sql) {
		Statement st = null;
		int effectRow = 0;
		try {
			st = conn.createStatement();
			effectRow = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(st, null);
		}
		return effectRow;
	}
}
