package gui;

import database.ParkingServiceMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCarFromParkingScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - car removing");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Remove");
    JTextField input = new JTextField();
    JLabel labelMessage = new JLabel("Enter car id you want to delete");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/remove_car.png");

    RemoveCarFromParkingScreen() {
        this.buttonSubmit.setBounds(435, 25, 150, 50);
        this.buttonSubmit.setFont(new Font("Century Gothic", 1, 18));
        this.buttonSubmit.setBackground(Color.decode("#5f3b73"));
        this.buttonSubmit.setForeground(Color.decode("#a58bb5"));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.setFocusPainted(false);
        this.buttonSubmit.addActionListener(this);
        this.buttonSubmit.setOpaque(true);
        this.input.setBounds(50, 25, 360, 50);
        this.input.setBackground(Color.decode("#a58bb5"));
        this.input.setForeground(Color.decode("#5f3b73"));
        this.input.setFont(new Font("Century Gothic", 1, 18));
        this.input.setOpaque(true);
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(200, 100, 650, 70);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.mainPane.setBounds(0, 0, 700, 250);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.input);
        this.mainPane.add(this.labelMessage);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(700, 250);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            new ParkingServiceMySQL().removeCarFromParking(Integer.parseInt(this.input.getText()));

            this.labelMessage.setText("Car with id: " + this.input.getText() + " has been successfully removed!");
            this.labelMessage.setBounds(190, 100, 650, 60);
        }

    }
}
