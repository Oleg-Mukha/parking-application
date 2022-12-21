package gui;

import database.ParkingServiceMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarOnParkingScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - adding car to parking");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Add");
    JTextField inputParkingSpot = new JTextField();
    JTextField inputCarId = new JTextField();
    JTextField inputOwnerId = new JTextField();
    JLabel searchResult = new JLabel();
    JLabel labelForParkingSpot = new JLabel("Enter parking spot: ");
    JLabel labelForCarId = new JLabel("Enter car id: ");
    JLabel labelForOwnerId = new JLabel("Enter owner id: ");
    JLabel labelMessage = new JLabel("Enter data car what do you want to add to parking");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/adding_car.png");

    AddCarOnParkingScreen() {
        this.buttonSubmit.setBounds(435, 140, 150, 50);
        this.buttonSubmit.setFont(new Font("Century Gothic", 1, 18));
        this.buttonSubmit.setBackground(Color.decode("#5f3b73"));
        this.buttonSubmit.setForeground(Color.decode("#a58bb5"));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.setFocusPainted(false);
        this.buttonSubmit.addActionListener(this);
        this.buttonSubmit.setOpaque(true);
        this.inputParkingSpot.setBounds(50, 50, 360, 50);
        this.inputParkingSpot.setBackground(Color.decode("#a58bb5"));
        this.inputParkingSpot.setForeground(Color.decode("#5f3b73"));
        this.inputParkingSpot.setFont(new Font("Century Gothic", 1, 18));
        this.inputParkingSpot.setOpaque(true);
        this.inputCarId.setBounds(50, 140, 360, 50);
        this.inputCarId.setBackground(Color.decode("#a58bb5"));
        this.inputCarId.setForeground(Color.decode("#5f3b73"));
        this.inputCarId.setFont(new Font("Century Gothic", 1, 18));
        this.inputCarId.setOpaque(true);
        this.inputOwnerId.setBounds(50, 230, 360, 50);
        this.inputOwnerId.setBackground(Color.decode("#a58bb5"));
        this.inputOwnerId.setForeground(Color.decode("#5f3b73"));
        this.inputOwnerId.setFont(new Font("Century Gothic", 1, 18));
        this.inputOwnerId.setOpaque(true);
        this.searchResult.setFont(new Font("Century Gothic", 0, 16));
        this.searchResult.setBounds(25, 250, 650, 100);
        this.searchResult.setForeground(Color.decode("#a58bb5"));
        this.searchResult.setBackground(Color.decode("#251f31"));
        this.searchResult.setOpaque(true);
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(90, 250, 650, 100);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.labelForParkingSpot.setFont(new Font("Century Gothic", 0, 16));
        this.labelForParkingSpot.setBounds(50, 5, 650, 50);
        this.labelForParkingSpot.setForeground(Color.decode("#a58bb5"));
        this.labelForParkingSpot.setBackground(Color.decode("#251f31"));
        this.labelForParkingSpot.setOpaque(true);
        this.labelForCarId.setFont(new Font("Century Gothic", 0, 16));
        this.labelForCarId.setBounds(50, 95, 650, 50);
        this.labelForCarId.setForeground(Color.decode("#a58bb5"));
        this.labelForCarId.setBackground(Color.decode("#251f31"));
        this.labelForCarId.setOpaque(true);
        this.labelForOwnerId.setFont(new Font("Century Gothic", 0, 16));
        this.labelForOwnerId.setBounds(50, 185, 650, 50);
        this.labelForOwnerId.setForeground(Color.decode("#a58bb5"));
        this.labelForOwnerId.setBackground(Color.decode("#251f31"));
        this.labelForOwnerId.setOpaque(true);
        this.mainPane.setBounds(0, 0, 650, 800);
        this.mainPane.add(this.inputParkingSpot);
        this.mainPane.add(this.inputCarId);
        this.mainPane.add(this.inputOwnerId);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.labelMessage);
        this.mainPane.add(this.labelForParkingSpot);
        this.mainPane.add(this.labelForCarId);
        this.mainPane.add(this.labelForOwnerId);
        this.mainPane.add(this.searchResult);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(650, 370);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            (new ParkingServiceMySQL()).addCarOnParking(Integer.parseInt(this.inputParkingSpot.getText()), Integer.parseInt(this.inputCarId.getText()), Integer.parseInt(this.inputOwnerId.getText()));

            this.labelMessage.setBounds(10, 250, 650, 100);
            this.labelMessage.setText("Car with id'" + this.inputCarId.getText() + "' successfully added to parking spot #" + this.inputParkingSpot.getText());


        }
    }
}
