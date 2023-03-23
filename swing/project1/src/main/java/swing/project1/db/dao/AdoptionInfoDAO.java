package swing.project1.db.dao;

import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.QueryCondition;

public interface AdoptionInfoDAO {

	public List<AdoptionInfoDTO> getAllAdoptionInfo();
	public List<AdoptionInfoDTO> getInfoByCondition(QueryCondition qc);
}
