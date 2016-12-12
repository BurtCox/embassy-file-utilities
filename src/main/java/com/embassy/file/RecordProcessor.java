package com.embassy.file;

public abstract class RecordProcessor {
   protected int _recordCount = 0;
   
   public abstract void process(String record);
   
   public int getRecordCount() {
      return _recordCount;
   }
}
