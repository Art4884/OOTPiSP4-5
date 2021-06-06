package com.company;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {
   public static int PRETTY_PRINT_INDENT_FACTOR = 4;

   public JSON(String string){
      try {
         JSONObject xmlJSONObj = XML.toJSONObject(string);
         String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
         File outputFile = new File("output.json");
         try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(jsonPrettyPrintString);
            writer.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
//         System.out.println(jsonPrettyPrintString);
      } catch (JSONException je) {
         System.out.println(je.toString());
      }
   }
}
