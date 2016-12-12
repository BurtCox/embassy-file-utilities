package com.embassy.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author e41887 (Burt Cox)
 *
 */
public class FileSet {
   private FileSpec _fileSpec;
   private List<File> _files;
   protected RecordProcessor _recordProcessor;

   public FileSpec getFileSpec() {
      return _fileSpec;
   }

   public void setFileSpec(FileSpec fileSpec) {
      _fileSpec = fileSpec;
      _files = FileList.getFiles(_fileSpec.getPath(), _fileSpec.isRecurse(), _fileSpec.getFileFilters());
   }
   
   public void processFileSet() throws IOException {
      for (File file : _files) {
         processFile(file);
      }
   }
   
   public void setRecordProcessor(RecordProcessor recordProcessor) {
      _recordProcessor = recordProcessor;
   }
   
   private void processFile(File file) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      while ((line = reader.readLine()) != null) {
         processLine(line);
      }

      reader.close();
   }

   private void processLine(String line) {
      _recordProcessor.process(line);
   }
   
   public int getFileCount() {
      return _files.size();
   }
   
   public int getRecordCount() {
      return _recordProcessor.getRecordCount();
   }
}
