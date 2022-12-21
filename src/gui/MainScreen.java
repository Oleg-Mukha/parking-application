package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen implements ActionListener, MouseListener, KeyListener {
    JFrame mainFrame = new JFrame("parking - main menu");
    JLayeredPane mainPane = new JLayeredPane();
    JLabel mainLabelImg = new JLabel();
    JLabel mainLabel = new JLabel();
    JPanel bgPanel = new JPanel();
    JButton showParking = new JButton("show parking");
    JButton findByOwner = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>find car<br>by owner</div>");
    JButton addToCarParking = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>adding car<br>to parking</div>");
    JButton addToCarList = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>adding car<br>to car list</div>");
    JButton showCarList = new JButton("show car list");
    JButton carFilter = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>filter cars<br>by region</div>");
    JButton carUpdate = new JButton("update spot");
    JButton removeCar = new JButton("remove car");
    ImageIcon mainFrameIcon = new ImageIcon("src/resources/frameicons/main_car.png");

    public MainScreen() {
        this.bgPanel.setBackground(Color.decode("#251f31"));
        this.bgPanel.setBounds(0, 0, 1500, 700);
        this.showParking.setBackground(Color.decode("#5f3b73"));
        this.showParking.setBounds(50, 50, 200, 200);
        this.showParking.setFocusable(false);
        this.showParking.setFocusPainted(false);
        this.showParking.setHorizontalTextPosition(0);
        this.showParking.setVerticalTextPosition(3);
        this.showParking.setFont(new Font("Century Gothic", 1, 18));
        this.showParking.setForeground(Color.decode("#a58bb5"));
        this.showParking.addActionListener(this);
        this.showParking.addMouseListener(this);
        this.showParking.setCursor(Cursor.getPredefinedCursor(12));
        this.findByOwner.setBackground(Color.decode("#5f3b73"));
        this.findByOwner.setBounds(300, 50, 200, 200);
        this.findByOwner.setFocusable(false);
        this.findByOwner.setFocusPainted(false);
        this.findByOwner.setHorizontalTextPosition(0);
        this.findByOwner.setVerticalTextPosition(3);
        this.findByOwner.setFont(new Font("Century Gothic", 1, 18));
        this.findByOwner.setForeground(Color.decode("#a58bb5"));
        this.findByOwner.addActionListener(this);
        this.findByOwner.addMouseListener(this);
        this.findByOwner.setCursor(Cursor.getPredefinedCursor(12));
        this.addToCarParking.setBackground(Color.decode("#5f3b73"));
        this.addToCarParking.setBounds(550, 50, 200, 200);
        this.addToCarParking.setFocusable(false);
        this.addToCarParking.setFocusPainted(false);
        this.addToCarParking.setHorizontalTextPosition(0);
        this.addToCarParking.setVerticalTextPosition(3);
        this.addToCarParking.setFont(new Font("Century Gothic", 1, 18));
        this.addToCarParking.setForeground(Color.decode("#a58bb5"));
        this.addToCarParking.addActionListener(this);
        this.addToCarParking.addMouseListener(this);
        this.addToCarParking.setCursor(Cursor.getPredefinedCursor(12));
        this.addToCarList.setBackground(Color.decode("#5f3b73"));
        this.addToCarList.setBounds(800, 50, 200, 200);
        this.addToCarList.setFocusable(false);
        this.addToCarList.setFocusPainted(false);
        this.addToCarList.setHorizontalTextPosition(0);
        this.addToCarList.setVerticalTextPosition(3);
        this.addToCarList.setFont(new Font("Century Gothic", 1, 18));
        this.addToCarList.setForeground(Color.decode("#a58bb5"));
        this.addToCarList.addActionListener(this);
        this.addToCarList.setCursor(Cursor.getPredefinedCursor(12));
        this.addToCarList.addMouseListener(this);
        this.addToCarList.addMouseListener(this);
        this.addToCarList.setCursor(Cursor.getPredefinedCursor(12));
        this.showCarList.setBackground(Color.decode("#5f3b73"));
        this.showCarList.setBounds(50, 300, 200, 200);
        this.showCarList.setFocusable(false);
        this.showCarList.setFocusPainted(false);
        this.showCarList.setHorizontalTextPosition(0);
        this.showCarList.setVerticalTextPosition(3);
        this.showCarList.setFont(new Font("Century Gothic", 1, 18));
        this.showCarList.setForeground(Color.decode("#a58bb5"));
        this.showCarList.addActionListener(this);
        this.showCarList.addMouseListener(this);
        this.showCarList.setCursor(Cursor.getPredefinedCursor(12));
        this.carFilter.setBackground(Color.decode("#5f3b73"));
        this.carFilter.setBounds(300, 300, 200, 200);
        this.carFilter.setFocusable(false);
        this.carFilter.setFocusPainted(false);
        this.carFilter.setHorizontalTextPosition(0);
        this.carFilter.setVerticalTextPosition(3);
        this.carFilter.setFont(new Font("Century Gothic", 1, 18));
        this.carFilter.setForeground(Color.decode("#a58bb5"));
        this.carFilter.addActionListener(this);
        this.carFilter.addMouseListener(this);
        this.carFilter.setCursor(Cursor.getPredefinedCursor(12));
        this.carUpdate.setBackground(Color.decode("#5f3b73"));
        this.carUpdate.setBounds(550, 300, 200, 200);
        this.carUpdate.setFocusable(false);
        this.carUpdate.setFocusPainted(false);
        this.carUpdate.setHorizontalTextPosition(0);
        this.carUpdate.setVerticalTextPosition(3);
        this.carUpdate.setFont(new Font("Century Gothic", 1, 18));
        this.carUpdate.setForeground(Color.decode("#a58bb5"));
        this.carUpdate.addActionListener(this);
        this.carUpdate.addMouseListener(this);
        this.carUpdate.setCursor(Cursor.getPredefinedCursor(12));
        this.removeCar.setBackground(Color.decode("#5f3b73"));
        this.removeCar.setBounds(800, 300, 200, 200);
        this.removeCar.setFocusable(false);
        this.removeCar.setFocusPainted(false);
        this.removeCar.setHorizontalTextPosition(0);
        this.removeCar.setVerticalTextPosition(3);
        this.removeCar.setFont(new Font("Century Gothic", 1, 18));
        this.removeCar.setForeground(Color.decode("#a58bb5"));
        this.removeCar.addActionListener(this);
        this.removeCar.addMouseListener(this);
        this.removeCar.setCursor(Cursor.getPredefinedCursor(12));
        this.mainLabelImg.setBounds(1150, 130, 256, 256);
        this.mainLabelImg.setBackground(Color.decode("#251f31"));
        this.mainLabelImg.setOpaque(true);
        this.mainLabel.setFont(new Font("Century Gothic", 0, 18));
        this.mainLabel.setBounds(1075, 350, 650, 100);
        this.mainLabel.setForeground(Color.decode("#a58bb5"));
        this.mainLabel.setBackground(Color.decode("#251f31"));
        this.mainLabel.setOpaque(true);
        this.mainPane.setBounds(0, 0, 1500, 700);
        this.mainPane.addMouseListener(this);
        this.mainPane.add(this.showParking);
        this.mainPane.add(this.findByOwner);
        this.mainPane.add(this.addToCarParking);
        this.mainPane.add(this.addToCarList);
        this.mainPane.add(this.showCarList);
        this.mainPane.add(this.carFilter);
        this.mainPane.add(this.carUpdate);
        this.mainPane.add(this.removeCar);
        this.mainPane.add(this.mainLabel);
        this.mainPane.add(this.mainLabelImg);
        this.mainFrame.setDefaultCloseOperation(3);
        this.mainFrame.setIconImage(this.mainFrameIcon.getImage());
        this.mainFrame.setSize(1500, 600);
        this.mainFrame.setResizable(false);
        this.mainFrame.getContentPane().setBackground(Color.decode("#251f31"));
        this.mainFrame.setVisible(true);
        this.mainFrame.addKeyListener(this);
        this.mainFrame.add(this.mainPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.showParking) {
            new ShowCarsOnParkingScreen();
        }

        if (actionEvent.getSource() == this.findByOwner) {
            new FindCarsByOwnerScreen();
        }

        if (actionEvent.getSource() == this.addToCarParking) {
            new AddCarOnParkingScreen();
        }

        if (actionEvent.getSource() == this.addToCarList) {
            new AddCarToListScreen();
        }

        if (actionEvent.getSource() == this.showCarList) {
            new ShowCarsFromCarListScreen();
        }

        if (actionEvent.getSource() == this.carFilter) {
            new SelectionCarByRegionScreen();
        }

        if (actionEvent.getSource() == this.carUpdate) {
            new UpdateParkingSpotScreen();
        }

        if (actionEvent.getSource() == this.removeCar) {
            new RemoveCarFromParkingScreen();
        }

    }

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == this.showParking) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/cars_on_parking.png"));
            this.mainLabelImg.setBounds(1130, 130, 256, 256);
            this.mainLabel.setText("Show cars from parking");
            this.mainLabel.setBounds(1135, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.findByOwner) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_key.png"));
            this.mainLabelImg.setBounds(1170, 130, 230, 230);
            this.mainLabel.setText("Find cars by owner");
            this.mainLabel.setBounds(1135, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.addToCarParking) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_add.png"));
            this.mainLabelImg.setBounds(1170, 130, 205, 205);
            this.mainLabel.setText("Add car to parking");
            this.mainLabel.setBounds(1165, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.showCarList) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/cars_on_parking.png"));
            this.mainLabelImg.setBounds(1130, 130, 256, 256);
            this.mainLabel.setText("Show car list");
            this.mainLabel.setBounds(1200, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.addToCarList) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_add.png"));
            this.mainLabelImg.setBounds(1170, 130, 205, 205);
            this.mainLabel.setText("Add car to car list");
            this.mainLabel.setBounds(1175, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.carFilter) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_filter.png"));
            this.mainLabelImg.setBounds(1170, 130, 215, 215);
            this.mainLabel.setText("Filter cars by region");
            this.mainLabel.setBounds(1170, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.carUpdate) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_update.png"));
            this.mainLabelImg.setBounds(1170, 130, 230, 230);
            this.mainLabel.setText("Update parking spot");
            this.mainLabel.setBounds(1185, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.removeCar) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/labelicons/car_remove.png"));
            this.mainLabelImg.setBounds(1170, 130, 256, 256);
            this.mainLabel.setText("Remove car from parking");
            this.mainLabel.setBounds(1150, 350, 650, 80);
        }

        if (mouseEvent.getSource() == this.mainPane) {
            this.mainLabelImg.setIcon(new ImageIcon("src/resources/frameicons/signage.png"));
            this.mainLabelImg.setBounds(1130, 130, 256, 256);
            this.mainLabel.setText("<html><style>.name{text-align: center;}</style><div class='name'>Welcome in parking application!<br>Choose desired section</div>");
            this.mainLabel.setBounds(1100, 350, 650, 100);
        }

    }

    public void mousePressed(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 27) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
    }
}
