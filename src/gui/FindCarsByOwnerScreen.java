package gui;

import database.ParkingServiceMySQL;
import model.Parking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindCarsByOwnerScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - find cars by owner");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Search");
    JTextField input = new JTextField();
    JLabel labelMessage = new JLabel("Enter owner full name what do you want to find");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/adding_car.png");

    FindCarsByOwnerScreen() {
        this.buttonSubmit.setBounds(500, 25, 150, 50);
        this.buttonSubmit.setFont(new Font("Century Gothic", 1, 18));
        this.buttonSubmit.setBackground(Color.decode("#5f3b73"));
        this.buttonSubmit.setForeground(Color.decode("#a58bb5"));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.setFocusPainted(false);
        this.buttonSubmit.addActionListener(this);
        this.buttonSubmit.setOpaque(true);
        this.input.setBounds(100, 25, 360, 50);
        this.input.setBackground(Color.decode("#a58bb5"));
        this.input.setForeground(Color.decode("#5f3b73"));
        this.input.setFont(new Font("Century Gothic", 1, 18));
        this.input.setOpaque(true);
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(180, 75, 800, 70);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.mainPane.setBounds(0, 0, 800, 500);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.input);
        this.mainPane.add(this.labelMessage);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(750, 500);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            ArrayList<Parking> list = (new ParkingServiceMySQL()).findCarsByOwner(this.input.getText());
            StringBuilder stringBuilder = new StringBuilder();

            for (Parking parking : list) {
                stringBuilder.append(parking).append("\n");
            }

            JTextArea searchResult = new JTextArea(stringBuilder.toString());
            searchResult.setFont(new Font("Century Gothic", 0, 16));
            searchResult.setBounds(20, 140, 800, 500);
            searchResult.setForeground(Color.decode("#a58bb5"));
            searchResult.setBackground(Color.decode("#251f31"));
            searchResult.setOpaque(true);
            this.mainPane.add(searchResult);
            if (list.isEmpty()) {
                this.labelMessage.setText("There are no owners with name: " + this.input.getText());
                this.labelMessage.setBounds(180, 75, 650, 70);
            } else {
                this.labelMessage.setText("Found according to your request: ");
                this.labelMessage.setBounds(180, 75, 650, 70);
            }
        }

    }
}
