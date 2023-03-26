package swing.project1.model;

import swing.project1.db.dto.AdoptionInfoDTO;

public class QueryItem {
	int animal_id;
	String album_file;
	String animal_kind;
	String animal_Variety;
	String animal_sex;
	String shelter_name;

	public QueryItem() {
	}

	public QueryItem(int animal_id) {
		this.animal_id = animal_id;
	}

	public QueryItem(AdoptionInfoDTO aiDto) {
		this.animal_id = aiDto.getAnimal_id();
		setAlbum_file(aiDto.getAlbum_file().trim());
		setAnimal_kind(aiDto.getAnimal_kind().trim());
		setAnimal_Variety(aiDto.getAnimal_Variety().trim());
		setAnimal_sex(aiDto.getAnimal_sex().trim());
		setShelter_name(aiDto.getShelter_name().trim());
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public String getAlbum_file() {
		return album_file;
	}

	public void setAlbum_file(String album_file) {
		this.album_file = album_file;
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

	public String getInsertSqlCmd() {
		return String.format("insert into t_adoption_info "
				+ "( album_file, animal_kind, animal_Variety, animal_sex, shelter_name ) values " + "%s;",
				getInsertValue());
	}

	public String getInsertValue() {
		return String.format("( '%s', '%s', '%s', '%s', '%s')", album_file, animal_kind, animal_Variety,
				animal_sex, shelter_name);
	}

	public String getUpdateSqlCmd() {
		return String.format(
				"UPDATE t_adoption_info SET album_file = '%s',  animal_kind = '%s',  animal_Variety = '%s',  animal_sex = '%s',  shelter_name = '%s' WHERE animal_id = %d",
				album_file, animal_kind, animal_Variety, animal_sex, shelter_name, animal_id);

	}
	
	

	@Override
	public String toString() {
		return "QueryItem [animal_id=" + animal_id + ", album_file=" + album_file + ", animal_kind=" + animal_kind
				+ ", animal_Variety=" + animal_Variety + ", animal_sex=" + animal_sex + ", shelter_name=" + shelter_name
				+ "]";
	}

	public boolean equals(QueryItem item) {
		if (this.animal_id != item.getAnimal_id()) {
			return false;
		}
		if (!this.album_file.trim().equals(item.getAlbum_file().trim())) {
			return false;
		}
		if (!this.animal_kind.trim().equals(item.getAnimal_kind().trim())) {
			return false;
		}
		if (!this.animal_Variety.trim().equals(item.getAnimal_Variety().trim())) {
			return false;
		}
		if (!this.animal_sex.trim().equals(item.getAnimal_sex().trim())) {
			return false;
		}
		if (!this.shelter_name.trim().equals(item.getShelter_name().trim())) {
			return false;
		}
		return true;
	}
}
