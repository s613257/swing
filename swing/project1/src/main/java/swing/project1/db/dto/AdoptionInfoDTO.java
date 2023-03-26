package swing.project1.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;

import swing.project1.model.QueryItem;

public class AdoptionInfoDTO {
	int animal_id;
	String animal_kind;
	String animal_Variety;
	String animal_sex;
	String shelter_name;
	String album_file;

	public AdoptionInfoDTO() {
		animal_id = 0;
	}
	
	public AdoptionInfoDTO(int id) {
		animal_id = id;
	}

	public AdoptionInfoDTO(QueryItem qi) {
		this.animal_id = qi.getAnimal_id();
		this.animal_kind = qi.getAnimal_kind();
		this.animal_Variety = qi.getAnimal_Variety();
		this.animal_sex = qi.getAnimal_sex();
		this.shelter_name = qi.getShelter_name();
		this.album_file = qi.getAlbum_file();
	}

	public AdoptionInfoDTO(ResultSet rs) throws SQLException {
		this.animal_id = rs.getInt("animal_id");
		this.animal_kind = rs.getString("animal_kind");
		this.animal_Variety = rs.getString("animal_Variety");
		this.animal_sex = rs.getString("animal_sex");
		this.shelter_name = rs.getString("shelter_name");
		this.album_file = rs.getString("album_file");
	}

	public AdoptionInfoDTO(CSVRecord record) {
		this.animal_id = Integer.parseInt(record.get("animal_id"));
		this.animal_kind = record.get("animal_kind");
		this.animal_Variety = record.get("animal_Variety");
		this.animal_sex = record.get("animal_sex");
		this.shelter_name = record.get("shelter_name");
		this.album_file = record.get("album_file");
	}
	
	public AdoptionInfoDTO(JSONObject jb) {
		this.animal_id = Integer.parseInt(jb.get("animal_id").toString());
		this.animal_kind = jb.get("animal_kind").toString();
		this.animal_Variety = jb.get("animal_Variety").toString();
		this.animal_sex = jb.get("animal_sex").toString();
		this.shelter_name = jb.get("shelter_name").toString();
		this.album_file = jb.get("album_file").toString();
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public String getAnimal_kind() {
		return animal_kind;
	}

	public void setAnimal_kind(String animal_kind) {
		this.animal_kind = animal_kind;
	}

	public String getAnimal_Variety() {
		return animal_Variety;
	}

	public void setAnimal_Variety(String animal_Variety) {
		this.animal_Variety = animal_Variety;
	}

	public String getAnimal_sex() {
		return animal_sex;
	}

	public void setAnimal_sex(String animal_sex) {
		this.animal_sex = animal_sex;
	}

	public String getShelter_name() {
		return shelter_name;
	}

	public void setShelter_name(String shelter_name) {
		this.shelter_name = shelter_name;
	}

	public String getAlbum_file() {
		return album_file;
	}

	public void setAlbum_file(String album_file) {
		this.album_file = album_file;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		result.put("animal_id", animal_id);
		result.put("animal_kind", animal_kind);
		result.put("animal_Variety", animal_Variety);
		result.put("animal_sex", animal_sex);
		result.put("shelter_name", shelter_name);
		result.put("album_file", album_file);
		return result;
	}
	public static String[] getCsvTitle() {
		return ("animal_id,animal_kind,animal_Variety,animal_sex,shelter_name,album_file").split(",");
	}
}
