package gui;

import database.CarServiceMySQL;
import database.ParkingServiceMySQL;
import model.Car;
import model.Parking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectionCarByRegionScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - filter cars by region");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Search");
    JTextField input = new JTextField();
    JLabel labelMessage = new JLabel("Enter region symbols that you want to find");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/filter.png");

    SelectionCarByRegionScreen() {
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
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(170, 120, 650, 70);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.mainPane.setBounds(0, 0, 700, 700);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.input);
        this.mainPane.add(this.labelMessage);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(700, 700);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            ArrayList<Car> list = (new CarServiceMySQL()).filterCarsByRegion(this.input.getText());
            StringBuilder stringBuilder = new StringBuilder();

            for (Car car : list) {
                stringBuilder.append(car).append("\n");
            }

            JTextArea searchResult = new JTextArea(stringBuilder.toString());
            searchResult.setFont(new Font("Century Gothic", 0, 16));
            searchResult.setBounds(20, 200, 650, 550);
            searchResult.setForeground(Color.decode("#a58bb5"));
            searchResult.setBackground(Color.decode("#251f31"));
            searchResult.setOpaque(true);
            this.mainPane.add(searchResult);
            if (list.isEmpty()) {
                this.labelMessage.setText("There are no car from region that start on '" + this.input.getText() + "'!");
                this.labelMessage.setBounds(170, 120, 650, 70);
            } else {
                this.labelMessage.setText("Found according to your request: ");
                this.labelMessage.setBounds(200, 120, 650, 60);
            }
        }

    }
}
