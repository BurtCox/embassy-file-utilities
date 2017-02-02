package com.embassy.file;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author e41887 (Burt Cox)
 *
 *         Description:
 *
 *         Creation Date: Jan 25, 2017
 *
 *         Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
@Service
public class FileList {
   public static List<File> getFiles(Path path, boolean recursive) {
      FileFilters fileFilters = null;
      return getFiles(path, recursive, fileFilters);
   }

   public static List<File> getFiles(Path path, boolean recursive, FileFilters fileFilters) {
      File file = new File(path.toString());

      if (!file.isDirectory()) {
         throw new PathException("Invalid path: " + path);
      }

      if (!file.canRead()) {
         throw new PathException("Path " + path + " is read-only");
      }

      File[] fileList = new File(path.toString()).listFiles();
      List<File> files = filterFileList(fileList, recursive, fileFilters);
      return files;
   }

   public static List<File> getFiles(Path path, boolean recursive, String fileSpec) {
      FileFilters fileFilters = new FileFilters();
      IncludeFileSpecFileFilter fileSpecFilter = new IncludeFileSpecFileFilter(fileSpec);
      fileFilters.add(fileSpecFilter);
      return getFiles(path, recursive, fileFilters);
   }

   private static List<File> filterFileList(File[] fileArray, boolean recursive, FileFilters fileFilters) {
      List<File> files = new ArrayList<>();

      for (File file : fileArray) {
         if (file.isDirectory() && (!file.getName().equalsIgnoreCase(".snapshot"))) {
            if (recursive) {
               Path path = Paths.get(file.getAbsolutePath());
               File[] fileList = new File(path.toString()).listFiles();
               files.addAll(filterFileList(fileList, recursive, fileFilters));
            }
         } else {
            if (fileFilters == null) {
               files.add(file);
            } else if (fileFilters.apply(file))
               files.add(file);
         }
      }

      return files;
   }
}
