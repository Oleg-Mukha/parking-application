package gui;

import database.CarServiceMySQL;
import database.ParkingServiceMySQL;
import model.Car;
import model.Parking;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowCarsFromCarListScreen {
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/car_list.png");

    ShowCarsFromCarListScreen() {
        ArrayList<Car> carList = (new CarServiceMySQL().showCarList());
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carList) {
            stringBuilder.append(car).append("");
        }

        JTextArea textArea = new JTextArea(stringBuilder.toString());
        textArea.setFont(new Font("Century Gothic", 0, 16));
        textArea.setSize(650, 550);
        textArea.setBackground(Color.decode("#251f31"));
        textArea.setForeground(Color.decode("#a58bb5"));
        JFrame frame = new JFrame("parking app - car list");
        frame.setResizable(false);
        frame.setSize(750, 800);
        frame.setIconImage(this.frameIcon.getImage());
        frame.setVisible(true);
        frame.add(textArea);
    }
}
