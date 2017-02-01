package com.embassy.file;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author e41887 (Burt Cox)
 *
 *         Description: Create the directories specified by path
 *
 *         Creation Date: Jan 30, 2017
 *
 *         Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class CleanDir {
   private Logger _logger = LoggerFactory.getLogger(getClass().getSimpleName());

   public void clean(String path) throws IOException, InterruptedException {
      Runtime runtime = Runtime.getRuntime();
      Process subprocess;

      File newPath = new File(path);

      _logger.info("Path={}{}", newPath, newPath.canWrite()); 
      if (newPath.canWrite()) {
         _logger.info("rm -rf " + newPath.getPath());
         subprocess = runtime.exec("rm " + newPath.getPath() + File.separator + "*");
         subprocess.waitFor();
      }
   }

}
