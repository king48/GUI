import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * The TextTest class will take a users input and square it. Firstly the user
 * will input a value in the first prompt that reads 'input a value'. It will
 * inclue the menus from the previous examples ie about and help. When the User
 * inputs the numbers they would like to compute they will hit the button
 * calculate and the number will be outputted on the bottom lable.
 * 
 * @author JuanDiego Castano
 * @version 1c 29.03.19
 */

public class TextTest extends JPanel {
    /**
     * The TextTest constructor calls the both the inputPrompt and outputResult methods. 
     */
    public TextTest() {
        inputPrompt();
        outputResult();
    }

    /**
     * The inputPrompt method prompt the user to input a number. 
     * 
     * <p>
     * <b>enterValue </b> This creates a JLabel class called 'Enter
     * a value'
     */
    public void inputPrompt() {

        JLabel enterValue = new JLabel("Enter a number");
        enterValue.setFont(new Font("Serif", Font.PLAIN, 16));
        add(enterValue);
    }

    /**
     * The outputResult method is responsible for the main work. It creates 
     * the button 'Calculate', it also creates the lables and will also 
     * square the values that the user inputs. 
     * 
     * <p>
     * <b>calculate </b> This creates a new button called 'Calculate'
     */

    public void outputResult() {
        JButton calculate = new JButton("Calculate");
        JTextField inputField = new JTextField(20);
        JTextField outputField = new JTextField(25);

        add(inputField);
        add(outputField);
        add(calculate);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int number = Integer.parseInt(inputField.getText());
                    outputField.setText("The square is " + Integer.toString((number * number)));
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                    inputField.setText("");
                    outputField.setText("");
                    inputField.requestFocus();
                    inputField.setCaretPosition(0);
                }
            }
        });
    }
}