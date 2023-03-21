package swing.project1.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDTO {
	int area_pkid;
	String area_name;

	public AreaDTO() {

	}

	public AreaDTO(ResultSet rs) throws SQLException {
		this.area_pkid = rs.getInt("area_pkid");
		this.area_name = rs.getString("area_name");
	}

	public int getArea_pkid() {
		return area_pkid;
	}

	public String getArea_name() {
		return area_name;
	}

}
