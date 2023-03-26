package swing.project1.model.io.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.io.IFileFactory;

public class XmlFileFactory implements IFileFactory {

	@Override
	public void writeFile(List<AdoptionInfoDTO> dataList) {
		String outFile = IFileFactory.OUT_FILE_FULL_NAME + ".xml";
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			doc.appendChild(doc.createElement("AdoptionInfos"));
			Node rootNode = doc.getDocumentElement();
			
			for(AdoptionInfoDTO aiDto : dataList) {
				Element ai = doc.createElement("AdoptionInfo");
				ai.setAttribute("animal_id", Integer.toString(aiDto.getAnimal_id()));
				Element kind = doc.createElement("animal_kind");
				kind.setTextContent(aiDto.getAnimal_kind());
				
				Element Variety = doc.createElement("animal_Variety");
				Variety.setTextContent(aiDto.getAnimal_Variety());
				
				Element sex = doc.createElement("animal_sex");
				sex.setTextContent(aiDto.getAnimal_sex());
				
				Element name = doc.createElement("shelter_name");
				name.setTextContent(aiDto.getShelter_name());
				
				Element file = doc.createElement("album_file");
				file.setTextContent(aiDto.getAlbum_file());
				
				ai.appendChild(kind);
				ai.appendChild(Variety);
				ai.appendChild(sex);
				ai.appendChild(name);
				ai.appendChild(file);
				rootNode.appendChild(ai);
			}


			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			FileWriter writer = new FileWriter(new File(outFile));
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
		} catch (ParserConfigurationException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AdoptionInfoDTO> readFile(String fileFullName) {
		List<AdoptionInfoDTO> result = new ArrayList<>();
		try {
			File fXmlFile = new File(fileFullName);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("AdoptionInfo");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					AdoptionInfoDTO aiDto = new AdoptionInfoDTO(Integer.parseInt(eElement.getAttribute("animal_id")));
					aiDto.setAnimal_kind(eElement.getElementsByTagName("animal_kind").item(0).getTextContent());
					aiDto.setAnimal_Variety(eElement.getElementsByTagName("animal_Variety").item(0).getTextContent());
					aiDto.setAnimal_sex(eElement.getElementsByTagName("animal_sex").item(0).getTextContent());
					aiDto.setShelter_name(eElement.getElementsByTagName("shelter_name").item(0).getTextContent());
					aiDto.setAlbum_file(eElement.getElementsByTagName("album_file").item(0).getTextContent());
					result.add(aiDto);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
