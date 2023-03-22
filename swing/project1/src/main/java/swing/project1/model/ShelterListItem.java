package swing.project1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import swing.project1.db.dto.ShelterDTO;

public class ShelterListItem extends ShelterDTO {
	public ShelterListItem() {
		super();
	}

	public ShelterListItem(ResultSet rs) throws SQLException {
		super();
	}

	public ShelterListItem(ShelterDTO sd) {
		this.shelter_pkid = sd.getShelter_pkid();
		this.shelter_name = sd.getShelter_name();
	}

	@Override
	public String toString() {
		return String.format("%d.%s", getShelter_pkid(), getShelter_name());
	}
}
