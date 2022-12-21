package gui;

import database.CarServiceMySQL;
import database.ParkingServiceMySQL;
import model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarToListScreen implements ActionListener {
    JFrame frame = new JFrame("parking app - adding car to car list");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton("Add");
    JTextField inputCarBrand = new JTextField();
    JTextField inputCarNumber = new JTextField();
    JTextField inputCarBody = new JTextField();
    JTextField inputCarFuel = new JTextField();
    JTextField inputEngineVolume = new JTextField();
    JLabel searchResult = new JLabel();
    JLabel labelForCarBrand = new JLabel("Enter car brand:");
    JLabel labelForCarNumber = new JLabel("Enter car number:");
    JLabel labelForCarBody = new JLabel("Enter car body:");
    JLabel labelForCarFuel = new JLabel("Enter car fuel:");
    JLabel labelForEngineVolume = new JLabel("Enter engine volume:");
    JLabel labelMessage = new JLabel("Enter car data what do you want to add to car list");
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/adding_car.png");

    AddCarToListScreen() {
        this.buttonSubmit.setBounds(435, 230, 150, 50);
        this.buttonSubmit.setFont(new Font("Century Gothic", 1, 18));
        this.buttonSubmit.setBackground(Color.decode("#5f3b73"));
        this.buttonSubmit.setForeground(Color.decode("#a58bb5"));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.setFocusPainted(false);
        this.buttonSubmit.addActionListener(this);
        this.buttonSubmit.setOpaque(true);
        this.inputCarBrand.setBounds(50, 50, 360, 50);
        this.inputCarBrand.setBackground(Color.decode("#a58bb5"));
        this.inputCarBrand.setForeground(Color.decode("#5f3b73"));
        this.inputCarBrand.setFont(new Font("Century Gothic", 1, 18));
        this.inputCarBrand.setOpaque(true);
        this.inputCarNumber.setBounds(50, 140, 360, 50);
        this.inputCarNumber.setBackground(Color.decode("#a58bb5"));
        this.inputCarNumber.setForeground(Color.decode("#5f3b73"));
        this.inputCarNumber.setFont(new Font("Century Gothic", 1, 18));
        this.inputCarNumber.setOpaque(true);
        this.inputCarBody.setBounds(50, 230, 360, 50);
        this.inputCarBody.setBackground(Color.decode("#a58bb5"));
        this.inputCarBody.setForeground(Color.decode("#5f3b73"));
        this.inputCarBody.setFont(new Font("Century Gothic", 1, 18));
        this.inputCarBody.setOpaque(true);
        this.inputCarFuel.setBounds(50, 320, 360, 50);
        this.inputCarFuel.setBackground(Color.decode("#a58bb5"));
        this.inputCarFuel.setForeground(Color.decode("#5f3b73"));
        this.inputCarFuel.setFont(new Font("Century Gothic", 1, 18));
        this.inputCarFuel.setOpaque(true);
        this.inputEngineVolume.setBounds(50, 410, 360, 50);
        this.inputEngineVolume.setBackground(Color.decode("#a58bb5"));
        this.inputEngineVolume.setForeground(Color.decode("#5f3b73"));
        this.inputEngineVolume.setFont(new Font("Century Gothic", 1, 18));
        this.inputEngineVolume.setOpaque(true);
        this.searchResult.setFont(new Font("Century Gothic", 0, 16));
        this.searchResult.setBounds(25, 250, 650, 100);
        this.searchResult.setForeground(Color.decode("#a58bb5"));
        this.searchResult.setBackground(Color.decode("#251f31"));
        this.searchResult.setOpaque(true);
        this.labelMessage.setFont(new Font("Century Gothic", 0, 16));
        this.labelMessage.setBounds(100, 440, 650, 100);
        this.labelMessage.setForeground(Color.decode("#a58bb5"));
        this.labelMessage.setBackground(Color.decode("#251f31"));
        this.labelMessage.setOpaque(true);
        this.labelForCarBrand.setFont(new Font("Century Gothic", 0, 16));
        this.labelForCarBrand.setBounds(50, 5, 650, 50);
        this.labelForCarBrand.setForeground(Color.decode("#a58bb5"));
        this.labelForCarBrand.setBackground(Color.decode("#251f31"));
        this.labelForCarBrand.setOpaque(true);
        this.labelForCarNumber.setFont(new Font("Century Gothic", 0, 16));
        this.labelForCarNumber.setBounds(50, 95, 650, 50);
        this.labelForCarNumber.setForeground(Color.decode("#a58bb5"));
        this.labelForCarNumber.setBackground(Color.decode("#251f31"));
        this.labelForCarNumber.setOpaque(true);
        this.labelForCarBody.setFont(new Font("Century Gothic", 0, 16));
        this.labelForCarBody.setBounds(50, 185, 650, 50);
        this.labelForCarBody.setForeground(Color.decode("#a58bb5"));
        this.labelForCarBody.setBackground(Color.decode("#251f31"));
        this.labelForCarBody.setOpaque(true);
        this.labelForCarFuel.setFont(new Font("Century Gothic", 0, 16));
        this.labelForCarFuel.setBounds(50, 275, 650, 50);
        this.labelForCarFuel.setForeground(Color.decode("#a58bb5"));
        this.labelForCarFuel.setBackground(Color.decode("#251f31"));
        this.labelForCarFuel.setOpaque(true);
        this.labelForEngineVolume.setFont(new Font("Century Gothic", 0, 16));
        this.labelForEngineVolume.setBounds(50, 365, 650, 50);
        this.labelForEngineVolume.setForeground(Color.decode("#a58bb5"));
        this.labelForEngineVolume.setBackground(Color.decode("#251f31"));
        this.labelForEngineVolume.setOpaque(true);
        this.mainPane.setBounds(0, 0, 650, 800);
        this.mainPane.add(this.inputCarBrand);
        this.mainPane.add(this.inputCarNumber);
        this.mainPane.add(this.inputCarBody);
        this.mainPane.add(this.inputCarFuel);
        this.mainPane.add(this.inputEngineVolume);
        this.mainPane.add(this.buttonSubmit);
        this.mainPane.add(this.labelMessage);
        this.mainPane.add(this.labelForCarBrand);
        this.mainPane.add(this.labelForCarNumber);
        this.mainPane.add(this.labelForCarBody);
        this.mainPane.add(this.labelForCarFuel);
        this.mainPane.add(this.labelForEngineVolume);
        this.mainPane.add(this.searchResult);
        this.frame.getContentPane().setBackground(Color.decode("#251f31"));
        this.frame.setSize(650, 600);
        this.frame.setResizable(false);
        this.frame.setIconImage(this.frameIcon.getImage());
        this.frame.setVisible(true);
        this.frame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.buttonSubmit) {
            Car car = new Car(Integer.parseInt(this.inputCarBrand.getText()),
                    this.inputCarNumber.getText(),
                    Integer.parseInt(this.inputCarBody.getText()),
                    Integer.parseInt(this.inputCarFuel.getText()),
                    Float.parseFloat(this.inputEngineVolume.getText()));
            (new CarServiceMySQL()).addCarToCarList(car);

            this.labelMessage.setBounds(90, 440, 650, 100);
            this.labelMessage.setText("Car with number '" + this.inputCarNumber.getText() + "' successfully added to car list!");


        }
    }
}
