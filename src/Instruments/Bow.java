package Instruments;

import com.company.Connection;

public class Bow extends Pinching implements Connection {


   public enum Positioning {Neck, Straight}
   private Pinching pinching;


   public int bowLength;
   public Positioning position;

   public Bow(Pinching pinching){
      this.pinching = pinching;
   }

   @Override
   public void connectToBow(){
     this.pinching.toString(pinching);
   }

   public Bow() {

   }

   public Bow(Pinching pinching, int bowLength, Positioning position) {
      super(pinching.stringsAmount, pinching.IsElectric, pinching.formation);
      this.position = position;
      this.bowLength = bowLength;
   }
}
