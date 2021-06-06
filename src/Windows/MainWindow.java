package Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

   private static MainWindow instance;

   public static MainWindow getInstance(){
      if(instance == null){
         instance = new MainWindow();
      }
      return instance;
   }


   private MainWindow(){
      JFrame frame = new JFrame("OOTPISP3");
      frame.setBounds(650,300,360,400);

      JPanel panel = new JPanel();
      panel.setLayout(null);

      JButton[] buttons = new JButton[5];
      for(int i = 0; i < 5; i++){
         buttons[i] = new JButton();
         buttons[i].setBounds(20, i*50 + 5, 300, 40);
         panel.add(buttons[i]);
      }
      buttons[0].setText("SelfSounded");
      buttons[0].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            SelfSoundedWindow window = new SelfSoundedWindow();
         }
      });
      buttons[1].setText("Membrained");
      buttons[1].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            MembrainedWindow window = new MembrainedWindow();
         }
      });
      buttons[2].setText("Pinching");
      buttons[2].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            PinchingWindow window = new PinchingWindow();
         }
      });
      buttons[3].setText("Bow");
      buttons[3].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            BowWindow window = new BowWindow();
         }
      });
      buttons[4].setText("Zip file");
      buttons[4].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            ZipWindow window = new ZipWindow();
         }
      });
      frame.add(panel);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}
