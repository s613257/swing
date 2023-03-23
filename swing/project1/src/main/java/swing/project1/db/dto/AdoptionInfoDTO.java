package swing.project1.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class AdoptionInfoDTO {
	int animal_id;
	int animal_shelter_pkid;
	String animal_kind;
	String animal_Variety;
	String animal_sex;
	String animal_update;
	Date animal_createtime;
	String shelter_name;
	String album_file;
	String album_update;
	String cDate;

	public AdoptionInfoDTO() {

	}

	public AdoptionInfoDTO(ResultSet rs) throws SQLException {
		this.animal_id = rs.getInt("animal_id");
		this.animal_shelter_pkid = rs.getInt("animal_shelter_pkid");
		this.animal_kind = rs.getString("animal_kind");
		this.animal_Variety = rs.getString("animal_Variety");
		this.animal_sex = rs.getString("animal_sex");
		this.animal_update = rs.getString("animal_update");
		this.animal_createtime = rs.getDate("animal_createtime");
		this.shelter_name = rs.getString("shelter_name");
		this.album_file = rs.getString("album_file");
		this.album_update = rs.getString("album_update");
		this.cDate = rs.getString("cDate");
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}

	public int getAnimal_shelter_pkid() {
		return animal_shelter_pkid;
	}

	public void setAnimal_shelter_pkid(int animal_shelter_pkid) {
		this.animal_shelter_pkid = animal_shelter_pkid;
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

	public String getAnimal_update() {
		return animal_update;
	}

	public void setAnimal_update(String animal_update) {
		this.animal_update = animal_update;
	}

	public Date getAnimal_createtime() {
		return animal_createtime;
	}

	public void setAnimal_createtime(Date animal_createtime) {
		this.animal_createtime = animal_createtime;
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

	public String getAlbum_update() {
		return album_update;
	}

	public void setAlbum_update(String album_update) {
		this.album_update = album_update;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	@Override
	public String toString() {
		return "AdoptionInfoDTO [animal_id=" + animal_id + ", animal_shelter_pkid=" + animal_shelter_pkid
				+ ", animal_kind=" + animal_kind + ", animal_Variety=" + animal_Variety + ", animal_sex=" + animal_sex
				+ ", animal_update=" + animal_update + ", animal_createtime=" + animal_createtime + ", shelter_name="
				+ shelter_name + ", album_file=" + album_file + ", album_update=" + album_update + ", cDate=" + cDate
				+ "]";
	}

	public String getUpdateStament() {
		// TODO
//		String sql = "update t_adoption_info set shelter_name= ? where animal_id = ?";
		return String.format("%s,%d",shelter_name,animal_id);
	}

	public String getInsertStament() {
		// TODO
//		String sql = "insert into t_adoption_info values(?,?,?,?,?,?,?,?,?,?,?)";
		return String.format("%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s)", animal_id,
				animal_shelter_pkid, animal_kind, animal_Variety, animal_sex, animal_update, animal_createtime,
				shelter_name, album_file, album_update, cDate);

	}
}
