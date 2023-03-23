package swing.project1.db.dao;

import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;

public interface AdoptionInfoDAO {

	public List<AdoptionInfoDTO> getAllAdoptionInfo();
//	public List<AdoptionInfoDTO> getInfoByStatement(String sq);
}
