package swing.project1.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShelterDTO {
	int shelter_pkid;
	String shelter_name;

	public ShelterDTO() {
		this.shelter_pkid = 0;
		this.shelter_name = "不限";
	}
	
	public ShelterDTO(ResultSet rs) throws SQLException {
		this.shelter_pkid = rs.getInt("shelter_pkid");
		this.shelter_name = rs.getString("shelter_name");
	}

	public int getShelter_pkid() {
		return shelter_pkid;
	}

	public String getShelter_name() {
		return shelter_name;
	}
	public String getText() {
		return String.format("%d,%s",this.shelter_pkid,this.shelter_name);
	}
	
	@Override
	public String toString() {
		return String.format("shelter_pkid = %d, shelter_name = %s", shelter_pkid, shelter_name);
	}
}
