package swing.project1.model;

import swing.project1.db.dto.AdoptionInfoDTO;

public class QueryItem {
	int animal_id;
	String album_file;
	String animal_kind;
	String animal_Variety;
	String animal_sex;
	String shelter_name;

	public QueryItem(int animal_id) {
		this.animal_id = animal_id;
	}

	public QueryItem(AdoptionInfoDTO aiDto) {
		this.animal_id = aiDto.getAnimal_id();
		setAlbum_file(aiDto.getAlbum_file());
		setAnimal_kind(aiDto.getAnimal_kind());
		setAnimal_Variety(aiDto.getAnimal_Variety());
		setAnimal_sex(aiDto.getAnimal_sex());
		setShelter_name(aiDto.getShelter_name());
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

}
