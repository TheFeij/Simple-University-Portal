package Gui;

import Gui.StudentPage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IncreaseBalance extends StudentPage {

    private JLabel label, cardNumberLabel, passwordLabel, moneyLabel;
    private JTextField cardNumber, money;
    private JPasswordField password;
    private JButton addButton;

    public IncreaseBalance(String username){
        super(username);

        label = new JLabel("Increase Balance");
        label.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        label.setBorder(border);
        label.setOpaque(true);
        label.setFont(new Font("serif", Font.BOLD, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        cardNumberLabel = new JLabel(" Card Number");
        passwordLabel = new JLabel(" Password: ");
        moneyLabel = new JLabel(" How Much?");

        password = new JPasswordField();
        cardNumber = new JTextField(16);
        money = new JTextField();

        addButton = new JButton("Charge");

        JLabel balance = new JLabel(String.format("Current Balance: %sR", "1500000"));
        balance.setBackground(Color.LIGHT_GRAY);
        balance.setBorder(border);
        balance.setOpaque(true);
        balance.setFont(new Font("serif", Font.BOLD, 20));
        balance.setHorizontalAlignment(SwingConstants.CENTER);


        addComponent(balance, 8, 5, 7, 2);
        addComponent(label, 8, 10, 7, 3);
        addComponent(moneyLabel, 8, 13, 2, 2);
        addComponent(money, 10, 13, 5, 2);
        addComponent(cardNumberLabel, 8, 15, 2, 2);
        addComponent(cardNumber, 10, 15, 5, 2);
        addComponent(passwordLabel, 8, 17, 2, 2);
        addComponent(password, 10, 17, 5, 2);
        addComponent(addButton, 8, 19, 7, 2);

    }

}
