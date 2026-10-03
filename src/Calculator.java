import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A simple AWT calculator based on the original project.
 * The original layout, labels, menus and calculator style are retained.
 */
class close extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

class cal implements ActionListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    Button b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;

    TextField tf;

    String fv = "";
    String sv = "";
    String op = "";

    double fdv, sdv, tot;

    MenuItem mi1, mi2, mi3, mi4, mi5, mi6;

    private Frame f1;
    private Panel p2;

    cal() {
        f1 = new Frame();
        f1.setBackground(Color.WHITE);
        f1.addWindowListener(new close());
        f1.setBounds(800, 100, 250, 300);
        f1.setTitle("Calculator");

        MenuBar mBar = new MenuBar();

        mi1 = new MenuItem("New Window");
        mi2 = new MenuItem("Scientific");
        mi3 = new MenuItem("Copy");
        mi4 = new MenuItem("Cut");
        mi5 = new MenuItem("Light");
        mi6 = new MenuItem("Dark");

        Menu m1 = new Menu("View");
        m1.add(mi1);
        m1.add(mi2);

        Menu m2 = new Menu("Edit");
        m2.add(mi3);
        m2.add(mi4);

        Menu m3 = new Menu("Theme");
        m3.add(mi5);
        m3.add(mi6);

        mBar.add(m1);
        mBar.add(m2);
        mBar.add(m3);

        f1.setMenuBar(mBar);

        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b10 = new Button("0");
        b11 = new Button(".");
        b12 = new Button("+");
        b13 = new Button("-");
        b14 = new Button("/");
        b15 = new Button("*");
        b16 = new Button("=");
        b17 = new Button("<--");
        b18 = new Button("C");
        b19 = new Button("%");
        b20 = new Button("√");

        Font font1 = new Font("Cambria Math", Font.BOLD, 10);
        Font font2 = new Font("Courier New", Font.BOLD, 11);

        b13.setBackground(Color.YELLOW);
        b12.setBackground(Color.YELLOW);
        b14.setBackground(Color.YELLOW);
        b15.setBackground(Color.YELLOW);
        b17.setBackground(Color.YELLOW);
        b18.setBackground(Color.YELLOW);
        b19.setBackground(Color.YELLOW);
        b20.setBackground(Color.YELLOW);

        Button[] numberButtons = {
            b1, b2, b3, b4, b5, b6, b7, b8, b9, b11
        };
        for (Button button : numberButtons) {
            button.setFont(font1);
        }

        Button[] operationButtons = {
            b12, b13, b14, b15, b16, b17, b18, b19, b20
        };
        for (Button button : operationButtons) {
            button.setFont(font2);
        }

        Button[] allButtons = {
            b1, b2, b3, b4, b5, b6, b7, b8, b9, b10,
            b11, b12, b13, b14, b15, b16, b17, b18, b19, b20
        };
        for (Button button : allButtons) {
            button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            button.addActionListener(this);
        }

        tf = new TextField(20);
        Font font = new Font("Cambria Math", Font.BOLD, 16);
        tf.setFont(font);
        tf.setEditable(false);
        tf.setForeground(Color.BLACK);
        tf.setBackground(Color.WHITE);

        Panel p1 = new Panel();
        p2 = new Panel();

        GridLayout g1 = new GridLayout(5, 4, 5, 7);

        p1.add(tf);
        p2.setLayout(g1);
        p2.setBackground(Color.WHITE);

        p2.add(b18);
        p2.add(b19);
        p2.add(b17);
        p2.add(b12);

        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b14);

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b15);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b13);

        p2.add(b11);
        p2.add(b10);
        p2.add(b16);
        p2.add(b20);

        f1.add(p1, BorderLayout.NORTH);
        f1.add(p2, BorderLayout.CENTER);

        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        f1.setVisible(true);
    }

    private void appendNumber(String value) {
        tf.setText(tf.getText() + value);
    }

    private void selectBinaryOperator(String operator) {
        if (tf.getText().trim().isEmpty()) {
            return;
        }
        fv = tf.getText();
        op = operator;
        tf.setText("");
    }

    private void calculate() {
        if (op == null || op.isEmpty() || fv == null || fv.isEmpty() || tf.getText().isEmpty()) {
            return;
        }

        try {
            sdv = Double.parseDouble(tf.getText());
            fdv = Double.parseDouble(fv);

            switch (op) {
                case "+":
                    tot = fdv + sdv;
                    break;
                case "-":
                    tot = fdv - sdv;
                    break;
                case "/":
                    if (sdv == 0) {
                        showError("Cannot divide by zero");
                        return;
                    }
                    tot = fdv / sdv;
                    break;
                case "*":
                    tot = fdv * sdv;
                    break;
                case "%":
                    tot = fdv / 100.0 * sdv;
                    break;
                default:
                    return;
            }

            tf.setText(formatNumber(tot));
            fv = "";
            sv = "";
            op = "";
        } catch (NumberFormatException ex) {
            showError("Invalid number");
        }
    }

    private String formatNumber(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return Double.toString(value);
        }
        if (value == Math.rint(value)) {
            return String.format("%.0f", value);
        }
        return Double.toString(value);
    }

    private void squareRoot() {
        if (tf.getText().trim().isEmpty()) {
            return;
        }

        try {
            double value = Double.parseDouble(tf.getText());
            if (value < 0) {
                showError("Invalid square root");
                return;
            }
            tf.setText(formatNumber(Math.sqrt(value)));
            fv = "";
            sv = "";
            op = "";
        } catch (NumberFormatException ex) {
            showError("Invalid number");
        }
    }

    private void backspace() {
        String text = tf.getText();
        if (!text.isEmpty()) {
            tf.setText(text.substring(0, text.length() - 1));
        }
    }

    private void copyToClipboard() {
        String text = tf.getText();
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private void cutToClipboard() {
        copyToClipboard();
        tf.setText("");
        fv = "";
        sv = "";
        op = "";
    }

    private void clear() {
        tf.setText("");
        fv = "";
        sv = "";
        op = "";
    }

    private void showError(String message) {
        tf.setText(message);
        fv = "";
        sv = "";
        op = "";
    }

    private void setTheme(boolean dark) {
        if (dark) {
            f1.setBackground(Color.DARK_GRAY);
            tf.setBackground(Color.BLACK);
            tf.setForeground(Color.WHITE);
            p2.setBackground(Color.DARK_GRAY);
        } else {
            f1.setBackground(Color.WHITE);
            tf.setBackground(Color.WHITE);
            tf.setForeground(Color.BLACK);
            p2.setBackground(Color.WHITE);
        }
        f1.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent d) {
        Object o = d.getSource();

        if (o.equals(b1)) {
            appendNumber(b1.getLabel());
        } else if (o.equals(b2)) {
            appendNumber(b2.getLabel());
        } else if (o.equals(b3)) {
            appendNumber(b3.getLabel());
        } else if (o.equals(b4)) {
            appendNumber(b4.getLabel());
        } else if (o.equals(b5)) {
            appendNumber(b5.getLabel());
        } else if (o.equals(b6)) {
            appendNumber(b6.getLabel());
        } else if (o.equals(b7)) {
            appendNumber(b7.getLabel());
        } else if (o.equals(b8)) {
            appendNumber(b8.getLabel());
        } else if (o.equals(b9)) {
            appendNumber(b9.getLabel());
        } else if (o.equals(b10)) {
            appendNumber(b10.getLabel());
        } else if (o.equals(b11)) {
            // Prevent more than one decimal point in the current number.
            if (!tf.getText().contains(".")) {
                if (tf.getText().isEmpty()) {
                    tf.setText("0.");
                } else {
                    appendNumber(".");
                }
            }
        } else if (o.equals(b12)) {
            selectBinaryOperator("+");
        } else if (o.equals(b13)) {
            selectBinaryOperator("-");
        } else if (o.equals(b14)) {
            selectBinaryOperator("/");
        } else if (o.equals(b15)) {
            selectBinaryOperator("*");
        } else if (o.equals(b19)) {
            selectBinaryOperator("%");
        } else if (o.equals(b20)) {
            squareRoot();
        } else if (o.equals(b16)) {
            calculate();
        } else if (o.equals(b17)) {
            backspace();
        } else if (o.equals(b18)) {
            clear();
        } else if (o.equals(mi3)) {
            copyToClipboard();
        } else if (o.equals(mi4)) {
            cutToClipboard();
        } else if (o.equals(mi1)) {
            new cal();
        } else if (o.equals(mi2)) {
            // The original menu contained this item but did not implement it.
            // Keep it available without crashing the calculator.
            tf.setText("Scientific mode");
        } else if (o.equals(mi5)) {
            setTheme(false);
        } else if (o.equals(mi6)) {
            setTheme(true);
        }
    }
}

public class Calculator {

    public static void main(String[] args) {
        new cal();
    }
}
