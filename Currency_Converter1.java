import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Currency_Converter1 extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public Currency_Converter1() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        amountField = new JTextField(10);
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "GBP"});
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "GBP"});
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(new JLabel("Enter amount: "));
        add(amountField);
        add(new JLabel("From currency: "));
        add(fromCurrencyComboBox);
        add(new JLabel("To currency: "));
        add(toCurrencyComboBox);
        add(convertButton);
        add(resultLabel);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double conversionRate = getConversionRate((String) fromCurrencyComboBox.getSelectedItem(), (String) toCurrencyComboBox.getSelectedItem());
            double result = amount * conversionRate;
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid amount.");
        }
    }

    private double getConversionRate(String fromCurrency, String toCurrency) {
        // You should implement a method to fetch the actual conversion rate.
        // For simplicity, I'm using a fixed conversion rate of 1.0 for the same currency.
        if (fromCurrency.equals(toCurrency)) {
            return 1.0;
        }
        // You should fetch the real conversion rate based on external data or API.
        // Here, I'm just providing some example conversion rates.
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.85;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("JPY")) {
            return 110.0;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            return 0.73;
        } // Add more conversion rates as needed.

        // Return a default rate if no match is found.
        return 1.0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Currency_Converter1 converter = new Currency_Converter1();
                converter.setVisible(true);
            }
        });
    }
}
