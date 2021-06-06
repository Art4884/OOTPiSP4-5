package Windows;

import Instruments.Bow;
import Instruments.Instrument;
import Instruments.Pinching;
import com.company.Connection;
import com.company.JSON;
import com.company.plugins.IXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class BowWindow extends Pinching {

   public static guitarFormation stringToFormation(String line) {
      if (line.equals("Standart")) {
         return guitarFormation.Standart;
      } else if (line.equals("Reduced")) {
         return guitarFormation.Reduced;
      } else if (line.equals("Increased")) {
         return guitarFormation.Increased;
      }
      return null;
   }

   public static Bow.Positioning stringToPosition(String line) {
      if (line.equals("Neck")) {
         return Bow.Positioning.Neck;
      } else if (line.equals("Straight")) {
         return Bow.Positioning.Straight;
      }
      return null;
   }

   public BowWindow() {
      JFrame frame = new JFrame("SelfSounded creation");
      frame.setBounds(350, 100, 720, 600);

      JLabel bufLabel1 = new JLabel("Standart");
      JLabel bufLabel2 = new JLabel("Neck");
      JPanel panel = new JPanel();
      panel.setLayout(null);

      JLabel amountOutputLabel = new JLabel("Strings amount:");
      amountOutputLabel.setBounds(330, 20, 300, 30);
      JLabel amOut = new JLabel("");
      amOut.setBounds(330, 60, 300, 30);


      JLabel iselctrOutput = new JLabel("Is electric?");
      iselctrOutput.setBounds(330, 100, 300, 30);
      JLabel isOut = new JLabel("");
      isOut.setBounds(330, 140, 300, 30);

      JLabel formationOutput = new JLabel("Formation:");
      formationOutput.setBounds(330, 180, 300, 30);
      JLabel formOut = new JLabel("");
      formOut.setBounds(330, 220, 300, 30);


      JLabel amountLabel = new JLabel("Strings amount:");
      amountLabel.setBounds(20, 20, 300, 30);

      JTextField strings = new JTextField();
      strings.setBounds(20, 60, 300, 30);

      JLabel iselctr = new JLabel("Is electric?");
      iselctr.setBounds(20, 100, 300, 30);

      JCheckBox box = new JCheckBox();
      box.setBounds(20, 140, 300, 30);

      JLabel formationLabel = new JLabel("Formation:");
      formationLabel.setBounds(20, 180, 300, 30);

      String[] formations = {"Standart", "Reduced", "Increased"};
      JComboBox formBox = new JComboBox(formations);
      formBox.setBounds(20, 220, 300, 30);

      JLabel bowLabel = new JLabel("Bow length:");
      bowLabel.setBounds(20, 260, 300, 30);
      panel.add(bowLabel);
      JTextField bowField = new JTextField();
      bowField.setBounds(20, 300, 300, 30);
      panel.add(bowField);


      JLabel bowOutLabel = new JLabel("Bow length:");
      bowOutLabel.setBounds(330, 260, 300, 30);
      panel.add(bowOutLabel);
      JLabel bowOutField = new JLabel("");
      bowOutField.setBounds(330, 300, 300, 30);
      panel.add(bowOutField);


      JLabel posLabel = new JLabel("Positioning:");
      posLabel.setBounds(20, 340, 300, 30);
      panel.add(posLabel);

      String[] positions = {"Neck", "Straight"};
      JComboBox posBox = new JComboBox(positions);
      posBox.setBounds(20, 380, 300, 30);

      panel.add(posBox);
      formBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JComboBox x = (JComboBox) actionEvent.getSource();
            String choise = (String) formBox.getSelectedItem();
            bufLabel1.setText(choise);
         }
      });

      posBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JComboBox x = (JComboBox) actionEvent.getSource();
            String choise2 = (String) posBox.getSelectedItem();
            bufLabel2.setText(choise2);
         }
      });


      JLabel posOutLabel = new JLabel("Positioning:");
      posOutLabel.setBounds(330, 340, 300, 30);
      panel.add(posOutLabel);

      JLabel posOutField = new JLabel("");
      posOutField.setBounds(330, 380, 300, 30);
      panel.add(posOutField);

      JButton xml = new JButton("XML serialisation");
      xml.setBounds(20, 420, 300, 30);
      xml.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            int stringAmount = Integer.parseInt(strings.getText());
            boolean isElectr = box.isSelected();
            guitarFormation format = stringToFormation(bufLabel1.getText());
            int length = Integer.parseInt(bowField.getText());
            Bow.Positioning pos = stringToPosition(bufLabel2.getText());
            Pinching pin = new Pinching(stringAmount, isElectr, format);
            Instrument instrument = new Bow(pin, length, pos);

            Connection connection = new Bow(new Pinching(stringAmount, isElectr, format));
            connection.connectToBow();

            try {
               Class c = Class.forName("com.company.plugins.XMLClass");
               IXML plugin = (IXML) c.getDeclaredConstructor().newInstance();
               plugin.xmlSave(instrument);
               String output = plugin.readFile();
               JSON json = new JSON(output);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | FileNotFoundException e) {
               e.printStackTrace();
            }
         }
      });


      panel.add(formationOutput);
      panel.add(formOut);
      panel.add(isOut);
      panel.add(iselctrOutput);
      panel.add(amountOutputLabel);
      panel.add(amOut);
      panel.add(xml);
//      panel.add(xmlRead);
//      panel.add(text);
//      panel.add(textRead);
//      panel.add(binary);
//      panel.add(binaryRead);
      panel.add(formationLabel);
      panel.add(formBox);
      panel.add(amountLabel);
      panel.add(strings);
      panel.add(iselctr);
      panel.add(box);

      frame.add(panel);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);

   }

}
