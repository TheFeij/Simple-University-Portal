package Gui;

import Gui.StudentPage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncreaseBalance extends StudentPage {

    private JLabel label, cardNumberLabel, passwordLabel, moneyLabel, balanceLabel;
    private JTextField cardNumberField, moneyField;
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
        cardNumberField = new JTextField(16);
        moneyField = new JTextField();

        addButton = new JButton("Charge");

        balanceLabel = new JLabel();
        balanceLabel.setBackground(Color.LIGHT_GRAY);
        balanceLabel.setBorder(border);
        balanceLabel.setOpaque(true);
        balanceLabel.setFont(new Font("serif", Font.BOLD, 20));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Handler handler = new Handler();

        moneyField.addActionListener(handler);
        cardNumberField.addActionListener(handler);
        password.addActionListener(handler);
        addButton.addActionListener(handler);

        addComponent(balanceLabel, 8, 5, 7, 2);
        addComponent(label, 8, 10, 7, 3);
        addComponent(moneyLabel, 8, 13, 2, 2);
        addComponent(moneyField, 10, 13, 5, 2);
        addComponent(cardNumberLabel, 8, 15, 2, 2);
        addComponent(cardNumberField, 10, 15, 5, 2);
        addComponent(passwordLabel, 8, 17, 2, 2);
        addComponent(password, 10, 17, 5, 2);
        addComponent(addButton, 8, 19, 7, 2);

    }

    /**
     * A method to set balance
     * @param balance balance to be set
     */
    public void setBalance(int balance){
        balanceLabel.setText(String.format("Current Balance: %dT", balance));
    }


    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                String cardNumber = cardNumberField.getText();
                int part1 = Integer.parseInt(cardNumber.substring(0,3));
                int part2 = Integer.parseInt(cardNumber.substring(4,7));
                int part3 = Integer.parseInt(cardNumber.substring(8,11));
                int part4 = Integer.parseInt(cardNumber.substring(12,15));
                int money = Integer.parseInt(moneyField.getText());
                int cardPassword = Integer.parseInt(String.valueOf(password.getPassword()));
                System.out.println(money);
                System.out.println(cardNumber.length());
                System.out.println(Math.log10(cardPassword) + 1);
                if(money > 50000 || cardNumber.length() != 16 || (int)(Math.log10(cardPassword) + 1) != 4){
                    JOptionPane.showMessageDialog(null, "Inputs are not valid", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                getController().increseBalance(getUsername(), money);
                setBalance(getController().getBalance(getUsername()));
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Inputs are not valid", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }

}
