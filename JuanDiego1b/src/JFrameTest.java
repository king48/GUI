
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * The JFrameTest class creates the application window, menu bar, File menu and
 * the Quit File menu ite. It then adds the menu item to the File menu and the
 * File menu to the menubar. It also ensures that the window will close if the
 * user clicks the 'x' button.
 * 
 * @author JuanDiego Castano
 * @version 1b 29.03.19
 */

public class JFrameTest extends JFrame implements ActionListener {

    /**
     * The class constructor passes a String title when it c eates the superclass
     * objcet. It then creates the application window, menu ar, File menu and the
     * Quit File menu ite. It then adds the menu item to the File menu and the menu
     * to the menubar. It sets the size of the Frame to 400x400, and ensures it will
     * be visible. It also ensures that the window will close if the user clicks the
     * 'x' button.
     * <p>
     * <b>Local variables: </b>
     * <p>
     * <b>quitItem </b> This creates an instance of the JMenuItem class called
     * "Quit".
     * <p>
     * <b>helpItem </b> This creates an instance of the JMenuItem class called
     * "Help".
     * <p>
     * <b>fileMenu </b> This creates an instance of the JMenu class called "File".
     * <p>
     * <b>helpMenu </b> This creates an instance of the JMenu class called "Help".
     * <p>
     * <b>myMenus </b> This creates an instance of the JMenuBar class.
     */

    public JFrameTest() {
        super("JFrame Test");
        JMenuItem quitItem = new JMenuItem("Quit");
        JMenuItem helpItem = new JMenuItem("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        fileMenu.add(quitItem);
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);

        JMenuBar myMenus = new JMenuBar();

        myMenus.add(fileMenu);
        myMenus.add(helpMenu);

        setJMenuBar(myMenus);

        quitItem.addActionListener(this);
        helpItem.addActionListener(this);
        aboutItem.addActionListener(this);

        setSize(400, 400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * The actionPerformed method will close the window when the user clicks "Quit"
     * on the tab. It will also allow for the user to clock on "Help" tab and the
     * "About" tab. The method that corresponds will then be called.
     *
     * @param ae is any action event
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Quit")) {
            dispose();
        }
        if (ae.getActionCommand().equals("Help")) {
            helpDialog();
        }
        if (ae.getActionCommand().equals("About")) {
            aboutDialog();
        }
    }

    /**
     * The helpDialog method is called when the user presses the "Help" tab. When it
     * is pressed the user will get a new window pop up called help me, with a
     * button that will close the window when pressed. The window cannot be resized
     * and is 100 by 100 pixles.
     *
     */
    private void helpDialog() {
        JDialog myDialog = new JDialog(this, "Help me");
        myDialog.setSize(100, 100);
        myDialog.setResizable(false);
        myDialog.setLayout(new FlowLayout());
        JButton helpButton = new JButton("Close Window");
        myDialog.add(helpButton);

        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myDialog.dispose();
            }
        });
        myDialog.setLocationRelativeTo(this);
        myDialog.setVisible(true);
    }

    /**
     * The method aboutDialog method will open a new window called about me. There
     * is text that says a thing you my not know about me. The window is resizeable
     * and it is 750 by 100 pixles. There is a button that says "Close About Me"
     * that will close the window.
     * 
     */
    private void aboutDialog() {
        JDialog aboutMeDialog = new JDialog(this, "About Me");
        aboutMeDialog.setSize(750, 100);
        aboutMeDialog.setResizable(true);
        aboutMeDialog.setLayout(new FlowLayout());
        JButton aboutButton = new JButton("Close About Me");

        JLabel text = new JLabel(
                "One thing you may not know about me (which also happens to be a secret) is that I occasionally really enojoy programming.",
                JLabel.CENTER);
        text.setAlignmentX(0);
        text.setAlignmentY(0);
        aboutMeDialog.add(text);

        aboutMeDialog.add(aboutButton);

        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutMeDialog.dispose();
            }
        });
        aboutMeDialog.setLocationRelativeTo(this);
        aboutMeDialog.setVisible(true);
    }
}