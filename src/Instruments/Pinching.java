package Instruments;

import java.io.Serializable;

public class Pinching extends Instrument implements Serializable {
   public enum guitarFormation{Standart, Reduced, Increased}

   public int stringsAmount;
   public boolean IsElectric;
   public guitarFormation formation;

   public Pinching(){

   }

   public void toString(Pinching pin) {
      System.out.println(pin.IsElectric + " " + pin.stringsAmount);
   }

   public Pinching(int amount, boolean isElectric, guitarFormation formation){
      this.setType(InstrumentType.String);
      this.stringsAmount = amount;
      this.IsElectric = isElectric;
      this.formation = formation;
   }

}
