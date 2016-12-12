package com.embassy.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class GenericCsvWriter {
	
	public void write(String fullyQualifiedFileName, Collection<String[]> records) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fullyQualifiedFileName));
		String outputBuffer = null;
		
		for (String[] record : records) {
			outputBuffer = new String();
			
			for (int field=0; field<record.length; field++) {
				if (field > 0) {
					outputBuffer = outputBuffer.concat(",");
				}
				
				if (record[field] != null) {
					outputBuffer = outputBuffer.concat(record[field]);					
				}
			}
			
			writer.write(outputBuffer);
			writer.newLine();
		}
		
		writer.close();
	}

}
