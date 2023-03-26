package swing.project1.db.dao;

import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.QueryCondition;
import swing.project1.model.QueryItem;

public interface AdoptionInfoDAO {

	public List<AdoptionInfoDTO> getAllAdoptionInfo();
	public List<AdoptionInfoDTO> getInfoByCondition(QueryCondition qc);
	public int insertByQueryItem(QueryItem data);
	public int insertByQueryItems(List<QueryItem> datas);
	public int updateByQueryItem(QueryItem data);
	public int deleteById(String animal_id);
	
}
