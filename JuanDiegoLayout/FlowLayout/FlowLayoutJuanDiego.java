import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program will use the Flow Layout. It will firstly create 7 buttons.
 * These buttons with exception to 'juan' and 'diego' buttons will perferom
 * basic functions of the flow layout class.
 * <p>
 * It will firstly allow the user to move the buttons left or right. Then the
 * user will be able to swap the orders of the buttons. Lastly, the user will be
 * able to increase and or decrese the margins between the buttons.
 * <p>
 * Refrences: Two websites were used to make this function properly
 * https://www.javatpoint.com/FlowLayout
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>FLayout</b> Contains the FlowLayout class.
 * <p>
 * <b>increaseButtonMargins</b> Is the JButton that is responsible for increasing size of the margins between buttons.
 * <p>
 * <b>decreaseButtonMargins</b> Is the JButton that is responsible for decreasing size of the margins between buttons.
 * <p>
 * <b>spacing</b> stores the amount of pixles between buttons.   
 * <p>
 * @author JuanDiego Castano
 * @version 03.29.2019
 */
public class FlowLayoutJuanDiego extends JPanel implements ActionListener {

    FlowLayout FLayout;
    JButton increaseButtonMargins;
    JButton decreaseButtonMargins;
    int spacing = 10;

    /**
     * This constructor will create all the buttons, set the layout, set the spacing
     * between the buttons and allow them to be clicked.
     */
    public FlowLayoutJuanDiego() {
        FLayout = new FlowLayout(FlowLayout.LEFT);
        setLayout(FLayout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        FLayout.setHgap(spacing);
        FLayout.setVgap(spacing);

        JButton juanButton = new JButton("Juan");
        JButton diegoButton = new JButton("Diego");
        JButton buttonReverse = new JButton("Reverse Button Order");
        JButton buttonRight = new JButton("Move Right");
        JButton buttonLeft = new JButton("Move Left");
        increaseButtonMargins = new JButton("Increase Margins");
        decreaseButtonMargins = new JButton("Decrease Margins");

        add(juanButton);
        add(diegoButton);
        add(buttonReverse);
        add(buttonRight);
        add(buttonLeft);
        add(increaseButtonMargins);
        add(decreaseButtonMargins);

        buttonReverse.addActionListener(this);
        buttonRight.addActionListener(this);
        buttonLeft.addActionListener(this);
        increaseButtonMargins.addActionListener(this);
        decreaseButtonMargins.addActionListener(this);
    }

    /**
     * The actionPerfomed method has diffrent if statments for every button it will
     * then re-direct to the appropriate method -- either swapOrder(), moveRight(),
     * moveLeft(), increaseMargin(), and decreaseMargin().
     * 
     * @param ae - is any action event. 
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reverse Button Order")) {
            swapOrder();
        }
        if (ae.getActionCommand().equals("Move Right")) {
            moveRight();
        }
        if (ae.getActionCommand().equals("Move Left")) {
            moveLeft();
        }
        if (ae.getActionCommand().equals("Increase Margins")) {
            increaseMargin();
        }
        if (ae.getActionCommand().equals("Decrease Margins")) {
            decreaseMargin();
        }
        revalidate();
    }

    /**
     * The moveRight method will simply shift all the buttons right 
     * on the screen . 
     */
    private void moveRight() {
        FLayout.setAlignment(FlowLayout.RIGHT);
    }

    /**
     * The move left method will move all the buttons left on the screen.
     */
    private void moveLeft() {
        FLayout.setAlignment(FlowLayout.LEFT);
    }

    /** 
     * The swapOrder method will swap the order of all the buttons 
     * from left to right or from right to left depending on if 
     * the button is pressed and based on the position it is already at. 
    */
    private void swapOrder() {
        if (getComponentOrientation().equals(ComponentOrientation.LEFT_TO_RIGHT)) {
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        } else {
            setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
    }

    /**
     * The increaseMargin method will increse the margin in 
     * both the x and y direction by two pixels when this method 
     * is called. 
     * 
     */
    private void increaseMargin() {
        spacing += 2;
        FLayout.setHgap(spacing);
        FLayout.setVgap(spacing);
    }

    /**
     * The decreseMargin will decrese the margins by two pixels if the
     * margin is greater than 10.
     * 
     */
    private void decreaseMargin() {
        if (spacing > 10) {
            spacing -= 2;
        }
        FLayout.setHgap(spacing);
        FLayout.setVgap(spacing);
    }
}