package Instruments;

import com.company.ConnectToMembrained;

public class Membrained extends SelfSounded implements ConnectToMembrained {

   public int square;
   public boolean containSpring;


//   public String getMembrainedInfo(){
//      String mat = "";
//      if(this.material == Material.Wood){
//         mat = "Wood";
//      }
//      else if(this.material == Material.Plastic){
//         mat = "Plastic";
//      }
//      else if(this.material == Material.Steel){
//         mat = "Steel";
//      }
//
//      String formation = "";
//      if(this.form == Form.Round){
//         formation = "Round";
//      }
//      else if(this.form == Form.Square){
//         formation = "Square";
//      }
//      else if(this.form == Form.Trapezioid){
//         formation = "Trapezioid";
//      }
//
//      return ("Form - " + formation + "\n" + "Material - " + mat + "\n" + "Square - " + this.square + "\n" + "ContainSpring - " + this.containSpring);
//   }

   public Membrained() {

   }

   public Membrained(Material material, Form form, int square, boolean containSpring) {
      super(material, form);
      this.square = square;
      this.containSpring = containSpring;
   }

   @Override
   public String getMembrainedInfo() {
      String mat = "";
      if (this.material == Material.Wood) {
         mat = "Wood";
      } else if (this.material == Material.Plastic) {
         mat = "Plastic";
      } else if (this.material == Material.Steel) {
         mat = "Steel";
      }

      String formation = "";
      if (this.form == Form.Round) {
         formation = "Round";
      } else if (this.form == Form.Square) {
         formation = "Square";
      } else if (this.form == Form.Trapezioid) {
         formation = "Trapezioid";
      }

      return ("Form - " + formation + "\n" + "Material - " + mat + "\n" + "Square - " + this.square + "\n" + "ContainSpring - " + this.containSpring);
   }
}
