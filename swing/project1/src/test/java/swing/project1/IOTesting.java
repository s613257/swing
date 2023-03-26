package swing.project1;

import java.util.ArrayList;
import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.QueryItem;
import swing.project1.model.io.IFileFactory;
import swing.project1.model.io.impl.CSVFileFactory;
import swing.project1.model.io.impl.FileIOFactory;
import swing.project1.model.io.impl.JsonFileFactory;
import swing.project1.model.io.impl.XmlFileFactory;

public class IOTesting {

	public static void reader() {
		// FileIOFactory fioFac = new FileIOFactory(new CSVFileFactory());
		// List<QueryItem> dataList =
		// fioFac.getDatasInFile(IFileFactory.HOME_DOWNLOADS_FOLDER + "outFile.csv");
//		FileIOFactory fioFac = new FileIOFactory(new JsonFileFactory());
//		List<QueryItem> dataList = fioFac
//				.getDatasInFile(IFileFactory.HOME_DOWNLOADS_FOLDER + IFileFactory.OUT_FILE_NAME + ".json");
		FileIOFactory fioFac = new FileIOFactory(new XmlFileFactory());
		List<QueryItem> dataList = fioFac
				.getDatasInFile(IFileFactory.HOME_DOWNLOADS_FOLDER + IFileFactory.OUT_FILE_NAME + ".xml");
		for (QueryItem qi : dataList) {
			System.out.println(qi.toString());
		}

	}

	public static void writer() {
		List<AdoptionInfoDTO> dataList = getTestDatas();
		FileIOFactory fioFac = new FileIOFactory(new CSVFileFactory());
		fioFac.writeDataToFile(dataList);
		fioFac = new FileIOFactory(new JsonFileFactory());
		fioFac.writeDataToFile(dataList);
		fioFac = new FileIOFactory(new XmlFileFactory());
		fioFac.writeDataToFile(dataList);
	}

	private static List<AdoptionInfoDTO> getTestDatas() {
		List<AdoptionInfoDTO> dataList = new ArrayList<>();
		AdoptionInfoDTO aiDto1 = new AdoptionInfoDTO(0);
		aiDto1.setAlbum_file("filePath1");
		aiDto1.setAnimal_kind("kind1");
		aiDto1.setAnimal_sex("M");
		aiDto1.setAnimal_Variety("Variety1");
		aiDto1.setShelter_name("name1");

		AdoptionInfoDTO aiDto2 = new AdoptionInfoDTO(1);
		aiDto2.setAlbum_file("filePath2");
		aiDto2.setAnimal_kind("kind2");
		aiDto2.setAnimal_sex("F");
		aiDto2.setAnimal_Variety("Variety2");
		aiDto2.setShelter_name("name2");

		AdoptionInfoDTO aiDto3 = new AdoptionInfoDTO(2);
		aiDto3.setAlbum_file("filePath3");
		aiDto3.setAnimal_kind("kind3");
		aiDto3.setAnimal_sex("M");
		aiDto3.setAnimal_Variety("Variety3");
		aiDto3.setShelter_name("name3");

		AdoptionInfoDTO aiDto4 = new AdoptionInfoDTO(3);
		aiDto4.setAlbum_file("filePath4");
		aiDto4.setAnimal_kind("kind4");
		aiDto4.setAnimal_sex("F");
		aiDto4.setAnimal_Variety("Variety4");
		aiDto4.setShelter_name("name4");

		dataList.add(aiDto1);
		dataList.add(aiDto2);
		dataList.add(aiDto3);
		dataList.add(aiDto4);
		return dataList;
	}

}
