import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeographyQuiz extends JFrame{
    private JPanel mainPanel;
    private JTextField question1TextField;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel scorePanel;
    private JTextField question2TextField;
    private JTextField question3TextField;
    private JButton backButton;
    private JButton nextButton;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel scoreLabel;

    private int page = 0;
    private JPanel[] panels;
    private JTextField[] fields;
    private String[] answers = {"Paris", "Tokyo", "Berlin"};

    public GeographyQuiz() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Geography Quiz");

        panels = new JPanel[]{panel1, panel2, panel3, panel4};
        fields = new JTextField[]{question1TextField, question2TextField, question3TextField};

        setVisible(true);
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);

        listener();

    }

    private void checkAnswers(){
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            String userAnswer = fields[i].getText().trim();

            if (answers[i].equalsIgnoreCase(userAnswer)) {
                score++;
            }
        }

        scoreLabel.setText(String.valueOf(score));
    }

    private void changePage(int newPage) {

        if (newPage < 0 || newPage >= panels.length) return;

        page = newPage;

        // Hide all panels
        for (JPanel p : panels) p.setVisible(false);

        // Show selected panel
        panels[page].setVisible(true);

        if (page == 0 || page == panels.length - 1) {
            backButton.setEnabled(false);   // hide on first & last
        } else {
            backButton.setEnabled(true);    // visible only in middle pages
        }

        nextButton.setEnabled(page < panels.length - 1);

        if (page == panels.length - 1) {
            checkAnswers();
        }

    }

    private void listener() {

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                changePage(--page);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                changePage(++page);
            }
        });

    }

    public static void main() {
        new GeographyQuiz();
    }
}
