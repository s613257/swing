package swing.project1.model.io.impl;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.io.IFileFactory;

public class JsonFileFactory implements IFileFactory {

	@SuppressWarnings("unchecked")
	@Override
	public void writeFile(List<AdoptionInfoDTO> dataList) {
		String outFile = IFileFactory.OUT_FILE_FULL_NAME + ".json";
		JSONArray jsonArr = new JSONArray();
		for (AdoptionInfoDTO aiDto : dataList) {
			jsonArr.add(aiDto.toJSONObject());
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			writer.write(jsonArr.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<AdoptionInfoDTO> readFile(String fileFullName) {
		List<AdoptionInfoDTO> resultList = new ArrayList<>();
		try {
			JSONArray jsArr = (JSONArray) new JSONParser().parse(new FileReader(fileFullName));
			for (int i = 0; i < jsArr.size(); i++) {
				resultList.add(new AdoptionInfoDTO((JSONObject) jsArr.get(i)));
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
