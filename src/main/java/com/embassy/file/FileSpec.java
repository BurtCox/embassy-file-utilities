package com.embassy.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author e41887 (Burt Cox)
 *
 */
public class FileSpec {
   private Path _path;
   private boolean _recurse;
   private String _nameLike;
   private FileFilters _fileFilters = new FileFilters();
   
   public FileSpec(String path, String recurse) {
      super();
      _path = Paths.get(path);
      _recurse = new Boolean(recurse).booleanValue();
   }
   
   public FileSpec(String path, boolean recurse) {
      super();
      _path = Paths.get(path);
      _recurse = recurse;
   }

   public FileSpec(String path) {
      super();
      _path = Paths.get(path);
      _recurse = false;
   }
   
   public void nameLike(String nameLike) {
         _fileFilters.include(nameLike);
   }
   
   public void exclude(String exclude) {
      _fileFilters.exclude(exclude);
   }

   public Path getPath() {
      return _path;
   }

   public boolean isRecurse() {
      return _recurse;
   }

   public String getNameLike() {
      return _nameLike;
   }

   public FileFilters getFileFilters() {
      return _fileFilters;
   }
}
