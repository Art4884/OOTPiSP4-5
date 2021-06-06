package com.company.plugins;

import Instruments.Instrument;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class XMLClass implements IXML {
   public void xmlSave(Instrument instrument) {
      try {
         FileOutputStream fos = new FileOutputStream("test.xml");
         XMLEncoder coder = new XMLEncoder(fos);
         coder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
               System.out.println("Exception: " + e.toString());
            }
         });
         coder.writeObject(instrument);
         coder.close();
         fos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String readFile() throws FileNotFoundException {
      StringBuilder builder = new StringBuilder();
      Scanner sc = new Scanner(new File("test.xml"));
      while(sc.hasNextLine()){
         builder.append(sc.nextLine());
      }
      return builder.toString();
   }

   public XMLClass() {

   }
}
