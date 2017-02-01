package com.embassy.file;

import java.io.File;
import java.io.IOException;

/**
 * @author e41887 (Burt Cox)
 *
 * Description: Create the directories specified by path
 *
 * Creation Date: Jan 30, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class CreateDir {

   public void create(String path) throws IOException, InterruptedException {
      String[] pathParts = path.split(File.separator);
      String newPathString = new String();
      Runtime runtime = Runtime.getRuntime();
      Process subprocess;
      
      for (String pathPart : pathParts) {
         newPathString = newPathString + File.separator + pathPart;
         File newPath = new File(newPathString);
         
         if (!newPath.exists()) {
            subprocess = runtime.exec("mkdir " + newPath.getPath());
            subprocess.waitFor();
         }
      }
   }
}
