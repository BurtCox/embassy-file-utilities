package com.embassy.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author e41887 (Burt Cox)
 *
 */
public class FileFilters {
   private List<FileFilter> _fileFilters = new ArrayList<>();
   
   public void add(FileFilter fileFilter) {
      _fileFilters.add(fileFilter);
   }
   
   public void remove(Object filter) {
      if (filter.getClass().isInstance(FileFilter.class))
      {
         FileFilter fileFilter = (FileFilter)filter;
         
         if (_fileFilters.contains(fileFilter)) {
            _fileFilters.remove(fileFilter);
         }
      }
   }
   
   public boolean apply(File file) {
      for (FileFilter fileFilter : _fileFilters) {
         if (fileFilter.apply(file) == false) {
            return false;
         }
      }
      
      return true;
   }
}
