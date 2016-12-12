package com.embassy.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author e41887 (Burt Cox)
 *
 */
public class FormattedDataFileWriter {

   public void write(String fullyQualifiedFileName, String data) throws IOException {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fullyQualifiedFileName));
      writer.write(data);
      writer.close();
   }
}
