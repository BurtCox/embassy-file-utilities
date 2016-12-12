package com.embassy.file;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileList {
	public static List<File> getFiles(Path path, boolean recursive, FileFilters fileFilters) {
	      File[] fileList = new File(path.toString()).listFiles();
	      List<File> files = processFileList(fileList, recursive, fileFilters);
	      return files;
	   }
	   
	   private static List<File> processFileList(File[] fileArray, boolean recursive, FileFilters fileFilters) {
	      List<File> files = new ArrayList<>();

	      for (File file : fileArray) {
	         if (file.isDirectory()) {
	            if (recursive) {
	               Path path = Paths.get(file.getAbsolutePath());
	               File[] fileList = new File(path.toString()).listFiles();
	               files.addAll(processFileList(fileList, recursive, fileFilters));
	            }
	         }
	         else {
	            if (include(file, fileFilters)) {
	               files.add(file);
	            }
	         }
	      }
	      
	      return files;
	   }
	   
	   private static boolean include(File file, FileFilters fileFilters) {
	      String fileName = file.getName();
	      
	      for (String filter : fileFilters.getIncludeFilters()) {
	         CharSequence filterSequence = filter;
	         
	         if (!fileName.contains(filterSequence)) {
	            return false;
	         }
	      }
	      
	      for (String filter : fileFilters.getExcludeFilters()) {
	         CharSequence filterSequence = filter;
	         
	         if (fileName.contains(filterSequence)) {
	            return false;
	         }
	      }
	      
	      return true;
	   }
}
