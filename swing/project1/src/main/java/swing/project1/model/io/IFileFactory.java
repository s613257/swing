package swing.project1.model.io;

import java.util.List;

import swing.project1.db.dto.AdoptionInfoDTO;

public interface IFileFactory {
	public static final String HOME_DOWNLOADS_FOLDER = System.getProperty("user.home") +"/Downloads/";
	public static final String OUT_FILE_NAME = "outFile";
	public static final String OUT_FILE_FULL_NAME = HOME_DOWNLOADS_FOLDER + OUT_FILE_NAME;
	public void writeFile(List<AdoptionInfoDTO> dataList);
	public List<AdoptionInfoDTO> readFile(String fileFullName);
}

