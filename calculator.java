import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class calculator {
    public static void main(String[] args) {
        CalculatorFrame frame = new CalculatorFrame();
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.show();
    }
}

class CalculatorFrame extends JFrame {
    private boolean start;
    public CalculatorFrame() {
        setTitle("Calculator");
        setSize(500, 510);

        JTextField answer = new JTextField("0");
        answer.setEditable(false);

        add(answer, "North");

        start = true;
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(start) {
                    answer.setText(((JButton) event.getSource()).getText());
                    start = false;
                } else {
                    answer.setText(answer.getText() + ((JButton) event.getSource()).getText());
                }
            }
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", numberListener, panel);
        addButton("8", numberListener, panel);
        addButton("9", numberListener, panel);
        addButton("+", null, panel);

        addButton("4", numberListener, panel);
        addButton("5", numberListener, panel);
        addButton("6", numberListener, panel);
        addButton("-", null, panel);

        addButton("1", numberListener, panel);
        addButton("2", numberListener, panel);
        addButton("3", numberListener, panel);
        addButton("*", null, panel);

        addButton("0", numberListener, panel);
        addButton(".", numberListener, panel);
        addButton("=", null, panel);
        addButton("/", null, panel);

        add(panel);
    }
    public void addButton(String text, ActionListener listener, JPanel panel) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }
}