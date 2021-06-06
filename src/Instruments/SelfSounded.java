package Instruments;

import java.io.Serializable;

public class SelfSounded extends Instrument implements Serializable {

   private static final long serialVersionUID = 1L;

   public enum Material{Wood, Steel, Plastic}
   public enum Form{Round, Square, Trapezioid}

   public Material material;
   public Form form;


   public String materialToString(Material material){
      if(material == Material.Plastic){
         return "Plastic";
      }
      else if(material == Material.Steel){
         return "Steel";
      }else if(material == Material.Wood){
         return "Wood";
      }
      return null;
   }

   public String formToString(Form form){
      if(form == Form.Round){
         return "Round";
      }
      else if(form == Form.Square){
         return "Square";
      }else if(form == Form.Trapezioid){
         return "Trapezioid";
      }
      return null;
   }

   public SelfSounded(){

   }
   public static SelfSounded.Material stringToMaterial(String material) {
      if (material.equals("Wood")) {
         return SelfSounded.Material.Wood;
      } else if (material.equals("Steel")) {
         return SelfSounded.Material.Steel;
      } else if (material.equals("Plastic")) {
         return SelfSounded.Material.Plastic;
      }
      return null;
   }

   public static SelfSounded.Form stringToForm(String form) {
      if (form.equals("Round")) {
         return SelfSounded.Form.Round;
      } else if (form.equals("Square")) {
         return SelfSounded.Form.Square;
      } else if (form.equals("Trapezioid")) {
         return SelfSounded.Form.Trapezioid;
      }
      return null;
   }

   public SelfSounded(Material material, Form form) {
      this.type = InstrumentType.Percussion;
      this.material = material;
      this.form = form;
   }



}
