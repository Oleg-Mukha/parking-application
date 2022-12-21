package gui;

import database.ParkingServiceMySQL;
import model.Parking;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowCarsOnParkingScreen {
    ImageIcon frameIcon = new ImageIcon("src/resources/frameicons/cars_on_parking.png");

    ShowCarsOnParkingScreen() {
        ArrayList<Parking> parkingCars = (new ParkingServiceMySQL()).showParking();
        StringBuilder stringBuilder = new StringBuilder();

        for (Parking parking : parkingCars) {
            stringBuilder.append(parking);
        }

        JTextArea textArea = new JTextArea(stringBuilder.toString());
        textArea.setFont(new Font("Century Gothic", 0, 16));
        textArea.setSize(650, 550);
        textArea.setBackground(Color.decode("#251f31"));
        textArea.setForeground(Color.decode("#a58bb5"));
        JFrame frame = new JFrame("parking app - cars on parking");
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setIconImage(this.frameIcon.getImage());
        frame.setVisible(true);
        frame.add(textArea);
    }
}
