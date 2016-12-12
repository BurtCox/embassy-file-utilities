package com.embassy.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenericCsvReader {

   public List<String[]> read(String fullyQualifiedFileName, String fieldSeparator) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(fullyQualifiedFileName));
      String line = null;
      List<String[]> fieldList = new ArrayList<>();

      while ((line = reader.readLine()) != null) {
         String fields[] = line.split(fieldSeparator);
         fieldList.add(fields);
      }

      reader.close();
      return fieldList;
   }

}
