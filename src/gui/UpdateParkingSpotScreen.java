package gui;

import database.ParkingServiceMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateParkingSpotScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - updating parking spot");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Update");
    JTextField inputPriorSpot = new JTextField();
    JTextField inputNewSpot = new JTextField();
    JLabel labelForPriorSpot = new JLabel("Enter previous spot: ");
    JLabel labelForNewSpot = new JLabel("Enter new spot: ");
    JLabel labelMessage = new JLabel("Enter data to update parking spot");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/update_spot.png");

    UpdateParkingSpotScreen() {
        this.buttonSubmit.setBounds(435, 90, 150, 50);
        this.buttonSubmit.setFont(new Font("Century Gothic", 1, 18));
        this.buttonSubmit.setBackground(Color.decode("#5f3b73"));
        this.buttonSubmit.setForeground(Color.decode("#a58bb5"));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.setFocusPainted(false);
        this.buttonSubmit.addActionListener(this);
        this.buttonSubmit.setOpaque(true);
        this.inputPriorSpot.setBounds(50, 50, 360, 50);
        this.inputPriorSpot.setBackground(Color.decode("#a58bb5"));
        this.inputPriorSpot.setForeground(Color.decode("#5f3b73"));
        this.inputPriorSpot.setFont(new Font("Century Gothic", 1, 18));
        this.inputPriorSpot.setOpaque(true);
        this.inputNewSpot.setBounds(50, 140, 360, 50);
        this.inputNewSpot.setBackground(Color.decode("#a58bb5"));
        this.inputNewSpot.setForeground(Color.decode("#5f3b73"));
        this.inputNewSpot.setFont(new Font("Century Gothic", 1, 18));
        this.inputNewSpot.setOpaque(true);
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(160, 170, 650, 100);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.labelForPriorSpot.setFont(new Font("Century Gothic", 0, 16));
        this.labelForPriorSpot.setBounds(50, 5, 650, 50);
        this.labelForPriorSpot.setForeground(Color.decode("#a58bb5"));
        this.labelForPriorSpot.setBackground(Color.decode("#251f31"));
        this.labelForPriorSpot.setOpaque(true);
        this.labelForNewSpot.setFont(new Font("Century Gothic", 0, 16));
        this.labelForNewSpot.setBounds(50, 95, 650, 50);
        this.labelForNewSpot.setForeground(Color.decode("#a58bb5"));
        this.labelForNewSpot.setBackground(Color.decode("#251f31"));
        this.labelForNewSpot.setOpaque(true);
        this.mainPane.setBounds(0, 0, 650, 300);
        this.mainPane.add(this.inputPriorSpot);
        this.mainPane.add(this.inputNewSpot);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.labelMessage);
        this.mainPane.add(this.labelForPriorSpot);
        this.mainPane.add(this.labelForNewSpot);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(650, 300);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            new ParkingServiceMySQL().updateCarOnParking(Integer.parseInt(this.inputPriorSpot.getText()),
                    Integer.parseInt(this.inputNewSpot.getText()));

            this.labelMessage.setBounds(130, 170, 650, 100);
            this.labelMessage.setText("Parking spot has been successfully updated!");


        }
    }
}
