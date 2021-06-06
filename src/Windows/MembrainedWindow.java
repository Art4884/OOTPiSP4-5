package Windows;

import Instruments.Instrument;
import Instruments.Membrained;
import Instruments.SelfSounded;
import com.company.ConnectToMembrained;
import com.company.JSON;
import com.company.plugins.IXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import static Instruments.SelfSounded.stringToForm;
import static Instruments.SelfSounded.stringToMaterial;

public class MembrainedWindow{

   public MembrainedWindow(){
      JFrame frame = new JFrame("SelfSounded creation");
      frame.setBounds(750, 300, 720, 500);

      JPanel panel = new JPanel();
      panel.setLayout(null);

      JLabel outputMLabel = new JLabel("Material:");
      outputMLabel.setBounds(330, 20, 300, 30);

      JLabel outputMaterialLabel = new JLabel("");
      outputMaterialLabel.setBounds(330, 60, 300, 30);


      JLabel outputFLabel = new JLabel("Form:");
      outputFLabel.setBounds(330, 100, 300, 30);
      JLabel outputFormLabel = new JLabel("");
      outputFormLabel.setBounds(330, 140, 300, 30);


      JLabel bufLabel1 = new JLabel("Wood");
      JLabel bufLabel2 = new JLabel("Round");

      JLabel materialLabel = new JLabel("Material:");
      materialLabel.setBounds(20, 20, 300, 30);

      String[] materialItems = {"Wood", "Steel", "Plastic"};
      JComboBox materialBox = new JComboBox(materialItems);
      materialBox.setBounds(20, 60, 300, 30);

      materialBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JComboBox box = (JComboBox) actionEvent.getSource();
            String choise = (String) materialBox.getSelectedItem();
            bufLabel1.setText(choise);
         }
      });

      JLabel formLabel = new JLabel("Form:");
      formLabel.setBounds(20, 100, 300, 30);

      String[] formItems = {"Round", "Square", "Trapezioid"};
      JComboBox formBox = new JComboBox(formItems);
      formBox.setBounds(20, 140, 300, 30);

      formBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JComboBox box = (JComboBox) actionEvent.getSource();
            String choise = (String) formBox.getSelectedItem();
            bufLabel2.setText(choise);
         }
      });
      JLabel squareLabel = new JLabel("Square:");
      squareLabel.setBounds(20, 180, 300, 30);
      JTextField square = new JTextField();
      square.setBounds(20, 220, 300, 30);

      JLabel checkLabel = new JLabel("Contain spring?");
      checkLabel.setBounds(20, 260, 300, 20);

      JCheckBox check = new JCheckBox();
      check.setBounds(20, 300, 20, 20);

      JLabel outputSLabel = new JLabel("Square:");
      outputSLabel.setBounds(330,180,300,30);

      JLabel outputSquareLabel = new JLabel();
      outputSquareLabel.setBounds(330,220,300,30);

      JLabel spring = new JLabel("Contain spring?");
      spring.setBounds(330,260,300,20);
      JLabel spr = new JLabel("");
      spr.setBounds(330,300,300,20);

      JButton jsonButton = new JButton("To json");
      jsonButton.setBounds(20, 340, 300, 30);
      jsonButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            SelfSounded.Material material = stringToMaterial(bufLabel1.getText());
            SelfSounded.Form form = stringToForm(bufLabel2.getText());
            int squareField = Integer.parseInt(square.getText());
            boolean hasSpring = check.isSelected();
            Instrument instrument = new Membrained(material, form, squareField, hasSpring);
            ConnectToMembrained con = new Membrained(material, form, squareField, hasSpring);
            String out = con.getMembrainedInfo();
            System.out.println(out);
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

      panel.add(spr);
      panel.add(spring);
      panel.add(outputSquareLabel);
      panel.add(outputSLabel);
      panel.add(outputFLabel);
      panel.add(outputFormLabel);
      panel.add(outputMLabel);
      panel.add(outputMaterialLabel);
      panel.add(squareLabel);
      panel.add(square);
      panel.add(check);
      panel.add(checkLabel);
      panel.add(jsonButton);
//      panel.add(xmlRead);
//      panel.add(binary);
//      panel.add(binaryRead);
//      panel.add(text);
//      panel.add(textRead);
      panel.add(materialLabel);
      panel.add(materialBox);
      panel.add(formLabel);
      panel.add(formBox);

      frame.add(panel);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);

   }

}
