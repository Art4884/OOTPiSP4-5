package Windows;

import Instruments.Instrument;
import Instruments.Pinching;
import com.company.JSON;
import com.company.plugins.IXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class PinchingWindow extends Pinching {

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

   public PinchingWindow() {
      JFrame frame = new JFrame("SelfSounded creation");
      frame.setBounds(750, 300, 720, 500);

      JLabel bufLabel1 = new JLabel("Standart");

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

      formBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JComboBox x = (JComboBox) actionEvent.getSource();
            String choise = (String) formBox.getSelectedItem();
            bufLabel1.setText(choise);
         }
      });

      JButton xml = new JButton("XML serialisation");
      xml.setBounds(20, 260, 300, 30);
      xml.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            int stringAmount = Integer.parseInt(strings.getText());
            boolean isElectr = box.isSelected();
            guitarFormation format = stringToFormation(bufLabel1.getText());
            Instrument instrument = new Pinching(stringAmount, isElectr, format);
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
