import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuanDiegoGroupLayout extends JPanel implements ActionListener {

    JComponent componentReplaceable;
    JButton buttonHorizontal;
    JButton buttonVertical;
    GroupLayout gLayout;

    public JuanDiegoGroupLayout() {
        gLayout = new GroupLayout(this);
        setLayout(gLayout);
        gLayout.setAutoCreateGaps(true);

        buttonHorizontal = new JButton("Make Horizontal Parallel");
        buttonVertical = new JButton("Make Vertical Parallel");

        buttonHorizontal.addActionListener(this);
        buttonVertical.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Make Horizontal Parallel")) {

            buttonHorizontal.setText("Make Horizontal");
        } else if (e.getActionCommand().equals("Make Horizontal")) {

            buttonHorizontal.setText("Make Horizontal Parallel");
        } else if (e.getActionCommand().equals("Make Vertical Parallel")) {

            buttonVertical.setText("Make Vertical");
        } else if (e.getActionCommand().equals("Make Vertical")) {

            buttonVertical.setText("Make Vertical Parallel");
        }
        revalidate();
    }
}