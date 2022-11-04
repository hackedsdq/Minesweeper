import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tp1exo1 extends JFrame {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JFrame frame = new JFrame();



    Tp1exo1(){

        // main frame
        frame.setSize(1600,800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        // panel1 function
        addPanel1(panel1);
        addPanel2(panel2);
        // adding panels to the main frame
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
    }

    private void addPanel1(JPanel panel1){
        JMenuBar menu = new JMenuBar();
        menu.setSize(new Dimension(400,500));
        JMenu item1 = new JMenu("Fichier");
        JMenu item2 = new JMenu("Cours");
        JMenu item3 = new JMenu("Etudiants");
        JMenu item4 = new JMenu("Connexion");
        JMenu item5 = new JMenu("A propos");

        // adding items to the menu bar
        menu.setBounds(0,0,400,500);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);

        // adding menu bar to panel1
        panel1.add(menu,BorderLayout.NORTH);
    }
    private void addPanel2(JPanel panel2){
        JInternalFrame subFrame1 = new JInternalFrame();
        subFrame1.setPreferredSize(new Dimension(800,400));
        subFrame1.setVisible(true);
        subFrame1.setLayout(new BorderLayout());
        subFrame1.setLocation(0,0);
        subFrame1.setTitle("ajouter un cours");
        // adding items to internal frame
        addingItemsInterFrame(subFrame1);
        // adding internal frame to panel3
        panel2.add(subFrame1);
    }
    private void coursAdded(){
        JOptionPane.showConfirmDialog(frame,"cours ajout");
    }



    private void addingItemsInterFrame(JInternalFrame internalFrame){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,10,5,10);
        // adding labels :
        JLabel label1 = new JLabel("Id cours :");
        JLabel label2 = new JLabel("Nom du cours :",JLabel.CENTER);
        JLabel label3 = new JLabel("Description du cours :",JLabel.CENTER);
        JLabel label4 = new JLabel("Coeficient du cours :",JLabel.CENTER);
        // adding Buttons
        JButton button1 = new JButton("Ajouter");
        JButton button2 = new JButton("Fermer");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                coursAdded();
            }
        });


        // adding text fields
        JTextField field1 = new JTextField();
        field1.setPreferredSize(new Dimension(200,20));
        JTextField field2 = new JTextField();
        field2.setPreferredSize(new Dimension(200,20));
        JTextField field3 = new JTextField();
        field3.setPreferredSize(new Dimension(200,20));
        JTextField field4 = new JTextField();
        field4.setPreferredSize(new Dimension(200,20));

        // adding items in panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label1,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(field1,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label2,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(field2,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label3,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(field3,gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(label4,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(field4,gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(button1,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(button2,gbc);

        // adding panel to interFrame
        internalFrame.add(panel);
    }
}

