package swing.project1.test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IOTesting {

	    public static byte[] exportCSV(List<LinkedHashMap<String, Object>> exportData) {
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        BufferedWriter buffCvsWriter = null;
	        try {
	        	buffCvsWriter = new BufferedWriter(buffCvsWriter);
	            for (Iterator<LinkedHashMap<String, Object>> iterator = exportData.iterator(); iterator.hasNext(); ) {
	                fillDataToCsv(buffCvsWriter, iterator.next());
	                if (iterator.hasNext()) {
	                    buffCvsWriter.newLine();
	                }
	            }
	            buffCvsWriter.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (buffCvsWriter != null) {
	                try {
	                    buffCvsWriter.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return out.toByteArray();
	    }

	    private static void fillDataToCsv(BufferedWriter buffCvsWriter, LinkedHashMap row) throws IOException {
	        Map.Entry propertyEntry;
	        for (Iterator<Map.Entry> propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext(); ) {
	            propertyEntry = propertyIterator.next();
	            buffCvsWriter.write("\"" + propertyEntry.getValue().toString() + "\"");
	            if (propertyIterator.hasNext()) {
	                buffCvsWriter.write(",");
	            }
	        }
	    }
	}

