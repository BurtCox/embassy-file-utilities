package com.embassy.file;

import java.io.File;

import org.joda.time.LocalDate;

/**
 * @author e41887 (Burt Cox)
 *
 * Description:
 *
 * Creation Date: Jan 25, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 *
 */
public class IncludeDateRangeFileFilter implements FileFilter {
   private LocalDate _fromDate;
   private LocalDate _toDate;
   
   public IncludeDateRangeFileFilter(String fromDate, String toDate) {
      _fromDate = new LocalDate(fromDate).minusDays(1);
      _toDate = new LocalDate(toDate).plusDays(1);
   }
   
   public IncludeDateRangeFileFilter(LocalDate fromDate, LocalDate toDate) {
      _fromDate = fromDate.minusDays(1);
      _toDate = toDate.plusDays(1);
   }
   
   @Override
   public boolean apply(File file) {
      String fileName = file.getName();
      String[] fileNameParts = fileName.split("\\.");
      String tmpDate = fileNameParts[fileNameParts.length - 1];
      
      if (tmpDate.equalsIgnoreCase("gz")) {
         tmpDate = fileNameParts[fileNameParts.length - 2];
      }
      
      String[] tmpDateParts = tmpDate.split("-");
      LocalDate fileDate;
      
      if (tmpDateParts.length != 4) {
         // this file name does not have a date
         fileDate = new LocalDate();
      }
      else {
         tmpDate = tmpDateParts[0] + "-" + tmpDateParts[1] + "-" + tmpDateParts[2];
         fileDate = new LocalDate(tmpDate);
      }
      
      if (_fromDate.isBefore(fileDate) && _toDate.isAfter(fileDate)) {
         return true;
      }
      
      return false;
   }

   public LocalDate getFromDate() {
      return _fromDate;
   }

   public void setFromDate(LocalDate fromDate) {
      _fromDate = fromDate.minusDays(1);
   }

   public LocalDate getToDate() {
      return _toDate;
   }

   public void setToDate(LocalDate toDate) {
      _toDate = toDate.plusDays(1);
   }

}
