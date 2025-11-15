import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderSystem extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> pizzaSizeChoice; // edit this to <String>
    private JLabel toppingsLabel;
    private JComboBox<String> pizzaToppingsChoice; // edit this to <String>
    private JLabel sizeLabel;
    private JComboBox<String> extraCheeseChoice; // edit this to <String>
    private JButton calculateButton;
    private JLabel totalLabel;

    private int total;

    public PizzaOrderSystem(){

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        listeners();

        setVisible(true);

    }

    private void listeners(){
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                total = switch (pizzaSizeChoice.getSelectedIndex()){
                    case 0 -> total = 10;
                    case 1 -> total = 15;
                    case 2 -> total = 20;
                    default -> total = 0;
                };

                total += 2;

                if(extraCheeseChoice.getSelectedIndex() == 0){
                    total += 3;
                }

                totalLabel.setText(String.format("%d", total));
            }
        });

    }

    public static void main() {
        new  PizzaOrderSystem();
    }

}
