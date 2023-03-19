package swing.project1.model.dto;

public class ShelterDTO {
	int shelter_pkid;
	String shelter_name;

	public ShelterDTO() {
		this.shelter_pkid = 0;
		this.shelter_name = "不限";
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
}
