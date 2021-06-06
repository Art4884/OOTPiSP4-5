package Instruments;

public class Instrument {
   enum InstrumentType {String, Percussion, Wind}

   public InstrumentType type;

   public void setType(InstrumentType type) {
      this.type = type;
   }

   public Instrument(){

   }

   public static InstrumentType stringToType(String type) {
      if (type.equals("String")) {
         return InstrumentType.String;
      } else if (type.equals("Percussion")) {
         return InstrumentType.Percussion;
      } else if (type.equals("Wind")) {
         return InstrumentType.Wind;
      }
      return null;
   }

   protected String typeToString(InstrumentType type){
      if(type == InstrumentType.Wind){
         return "Wind";
      }
      else if(type == InstrumentType.String){
         return "String";
      }else if(type == InstrumentType.Percussion){
         return "Percussion";
      }
      return null;
   }

}
