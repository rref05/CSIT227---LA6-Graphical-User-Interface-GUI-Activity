import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame {
    private JButton decreaseButton;
    private JButton increaseButton;
    private JLabel countLabel;
    private JPanel mainPanel;

    private int count = 0;

    public NumberCounter() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listeners();

        this.setVisible(true);
    }

    // listeners
    void listeners(){

        // increaseButton
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText(Integer.toString(count));
            }
        });

        // decreaseButton
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                countLabel.setText(Integer.toString(count));
            }
        });


    }

    public static void main(String[] args) {
        NumberCounter app = new NumberCounter();
    }
}
