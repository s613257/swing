package swing.project1.model.io.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.io.IFileFactory;

public class CSVFileFactory implements IFileFactory {

	@Override
	public void writeFile(List<AdoptionInfoDTO> dataList) {
		String outFile = IFileFactory.OUT_FILE_FULL_NAME + ".csv";
		try (BufferedWriter writer = Files
				.newBufferedWriter(Paths.get(outFile));
				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader(AdoptionInfoDTO.getCsvTitle()));) {
			for (AdoptionInfoDTO aiDto : dataList) {
				csvPrinter.printRecord(aiDto.getAnimal_id(), aiDto.getAnimal_kind(), aiDto.getAnimal_Variety(),
						aiDto.getAnimal_sex(), aiDto.getShelter_name(), aiDto.getAlbum_file());
			}
			csvPrinter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AdoptionInfoDTO> readFile(String fileFullName) {
		List<AdoptionInfoDTO> resultList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fileFullName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord record : csvParser) {
				resultList.add(new AdoptionInfoDTO(record));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
