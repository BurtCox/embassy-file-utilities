package com.embassy.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author e41887 (Burt Cox)
 *
 */
public class IncludeFileSpecFileFilter implements FileFilter {
   List<String> _includeFilters = new ArrayList<>();
   
   public IncludeFileSpecFileFilter(String fileSpec) {
      String[] values = fileSpec.split("\\*");

      for (String value : values) {
         _includeFilters.add(value);
      }
   }
   
   public boolean apply(File file) {
      for (String filter : _includeFilters) {
         if (!file.getName().contains(filter)) {
            return false;
         }
      }
      
      return true;
   }
}
