package com.embassy.file;

@SuppressWarnings("serial")
public class PathException extends RuntimeException {
   private String _message;
   
   public PathException(String message) {
      _message = message;
   }
   
   public String getMessage(){
      return _message;
   }
}
