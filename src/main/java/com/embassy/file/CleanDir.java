package com.embassy.file;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author e41887 (Burt Cox)
 *
 *         Description: Delete any files in directory 'path'
 *
 *         Creation Date: Jan 30, 2017
 *
 *         Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class CleanDir {
   private Logger _logger = LoggerFactory.getLogger(getClass().getSimpleName());

   public void clean(String path) {
      List<File> files = FileList.getFiles(Paths.get(path), false);
      for (File file : files) {
         file.delete();
      }
   }
}
