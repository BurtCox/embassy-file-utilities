package com.embassy.file;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author e41887 (Burt Cox)
 *
 */
@Component
public class FileFilters {
   private List<String> _include = new ArrayList<>();
   private List<String> _exclude = new ArrayList<>();
   
   public void include(String include) {
      _include.add(include);
   }
   
   public void exclude(String exclude) {
      _exclude.add(exclude);
   }
   
   public List<String> getIncludeFilters() {
      return _include;
   }
   
   public List<String> getExcludeFilters() {
      return _exclude;
   }
}
