package Windows;

import com.company.plugins.IArchive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class ZipWindow {

   static String zipDir;
   static String zipFile;

   public ZipWindow(){
      JFrame frame = new JFrame("Zip Window");
      frame.setBounds(350, 100, 720, 600);

      JPanel panel = new JPanel();
      panel.setLayout(null);

      JLabel inputLabel = new JLabel("Choose directory:");
      inputLabel.setBounds(5,20,120,30);

      JButton openButton = new JButton("Open directory");
      openButton.setBounds(5, 55, 120, 30);
      openButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\savva\\IdeaProjects\\OOTPISP41");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle("Choose file");
            int result = fileChooser.showDialog(null, "");
            if (result == JFileChooser.APPROVE_OPTION) {
               zipDir = fileChooser.getSelectedFile().getName();
               zipFile = "Archive.zip";
            }
         }
      });

      JButton zipButton = new JButton("Zip file");
      zipButton.setBounds(5, 90, 120, 30);
      zipButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {

            try {
               Class c = Class.forName("com.company.plugins.ArchiveFile");
               IArchive plugin = (IArchive) c.getDeclaredConstructor().newInstance();
               plugin.Zip(zipDir, zipFile);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | ClassNotFoundException | InvocationTargetException e) {
               e.printStackTrace();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });

      panel.add(inputLabel);
      panel.add(openButton);
      panel.add(zipButton);

      frame.add(panel);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}
