package swing.project1.model.io.impl;

import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.QueryItem;
import swing.project1.model.io.IFileFactory;

public class FileIOFactory {
	private IFileFactory factory;
	public FileIOFactory(IFileFactory factory) {
		this.factory = factory;
	}
	
	
	public List<QueryItem> getDatasInFile(String fileFullName) {
		List<QueryItem> resultList = new ArrayList<>();
		List<AdoptionInfoDTO> dataList = factory.readFile(fileFullName);
		for(AdoptionInfoDTO aiDto : dataList) {
			resultList.add(new QueryItem(aiDto));
		}
		return resultList;
	}
	
	public void writeDataToFile(List<AdoptionInfoDTO> dataList) {
		factory.writeFile(dataList);
	}
}
