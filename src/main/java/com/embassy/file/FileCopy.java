package com.embassy.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author e41887 (Burt Cox)
 *
 * Description:
 *
 * Creation Date: Jan 26, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
@Service
public class FileCopy {
   private Logger _logger = LoggerFactory.getLogger(getClass().getSimpleName());

   public void copy(List<File> files, Path target) {
      for (File file : files) {
         try {
            Runtime.getRuntime().exec("cp " + file.getPath() + " " + target.toString());
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }         
      }
   }
   
   public void copyAndUncompress(List<File> files, Path target) {
      Runtime runtime = Runtime.getRuntime();
      Process subprocess;
      
      for (File file : files) {
         try {
            subprocess = runtime.exec("cp " + file.getPath() + " " + target.toString());
            try {
               subprocess.waitFor();
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
            if (file.getName().endsWith(".gz")) {
               subprocess = runtime.exec("gzip -d -v " + target.toString() + File.separator + file.getName());
               try {
                  subprocess.waitFor();
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }         
      }
   }
}
