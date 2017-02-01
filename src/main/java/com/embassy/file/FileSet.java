package com.embassy.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author e41887 (Burt Cox)
 *
 *         Description: Reads each line from the files in _files and sends them to _recordProcessor
 *
 *         Creation Date: Jan 26, 2017
 *
 *         Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class FileSet {
   private List<File> _files;
   protected RecordProcessor _recordProcessor;
   private File _currentFile;
   private int _currentLine;
   
   public FileSet(List<File> files, RecordProcessor recordProcessor) {
      _files = files;
      _recordProcessor = recordProcessor;
   }

   public void setFiles(List<File> files) {
      _files = files;
   }

   public File getCurrentFile() {
      return _currentFile;
   }
   
   public int getCurrentLine() {
      return _currentLine;
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
      _currentFile = file;
      _currentLine = 0;
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      while ((line = reader.readLine()) != null) {
         processLine(line);
      }

      reader.close();
   }

   private void processLine(String line) {
      _currentLine+=1;
      _recordProcessor.process(line);
   }

   public int getFileCount() {
      return _files.size();
   }

   public int getRecordCount() {
      return _recordProcessor.getRecordCount();
   }
}
