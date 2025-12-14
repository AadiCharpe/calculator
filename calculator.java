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
    private double result;
    private String operation;
    public CalculatorFrame() {
        setTitle("Calculator");
        setSize(500, 510);

        JTextField answer = new JTextField("0");
        answer.setEditable(false);

        add(answer, "North");

        start = true;
        result = 0;
        operation = "=";
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String number = ((JButton) event.getSource()).getText();
                if(start) {
                    answer.setText(number);
                    start = false;
                } else {
                    if(answer.getText().contains(".")) {
                        if(!number.equals("."))
                            answer.setText(answer.getText() + number);
                    } else {
                        answer.setText(answer.getText() + number);
                    }
                }
            }
        };

        ActionListener operationListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(start && ((JButton) event.getSource()).getText().equals("-")) {
                    answer.setText("-");
                    start = false;
                } else {
                    if(answer.getText().matches(".*[1-9].*")) {
                        boolean e = true;
                        if(operation.equals("=")) {result = Double.parseDouble(answer.getText()); e = false;}
                        if(operation.equals("+")) result += Double.parseDouble(answer.getText());
                        if(operation.equals("-")) result -= Double.parseDouble(answer.getText());
                        if(operation.equals("*")) result *= Double.parseDouble(answer.getText());
                        if(operation.equals("/")) result /= Double.parseDouble(answer.getText());

                        operation = ((JButton) event.getSource()).getText();
                        start = true;
                        if(e)
                            answer.setText("" + result);
                        else
                            answer.setText("");
                    }
                }
            }
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", numberListener, panel);
        addButton("8", numberListener, panel);
        addButton("9", numberListener, panel);
        addButton("+", operationListener, panel);

        addButton("4", numberListener, panel);
        addButton("5", numberListener, panel);
        addButton("6", numberListener, panel);
        addButton("-", operationListener, panel);

        addButton("1", numberListener, panel);
        addButton("2", numberListener, panel);
        addButton("3", numberListener, panel);
        addButton("*", operationListener, panel);

        addButton("0", numberListener, panel);
        addButton(".", numberListener, panel);
        addButton("=", operationListener, panel);
        addButton("/", operationListener, panel);

        add(panel);
    }
    public void addButton(String text, ActionListener listener, JPanel panel) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }
}