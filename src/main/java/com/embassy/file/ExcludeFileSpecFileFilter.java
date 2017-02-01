package com.embassy.file;

import java.io.File;

/**
 * @author e41887 (Burt Cox)
 *
 * Description:
 *
 * Creation Date: Jan 27, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class ExcludeFileSpecFileFilter implements FileFilter {
   private String _excludeFilter;
   
   public ExcludeFileSpecFileFilter(String excludeFilter) {
      _excludeFilter = excludeFilter;
   }
   
   @Override
   public boolean apply(File file) {
      if (file.getName().contains(_excludeFilter)) {
         return false;
      }

      return true;
   }

}
