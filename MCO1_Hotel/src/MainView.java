import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class MainView extends JFrame{
    
    private JButton btnSelect1;
    private JButton btnSelect2;
    private JButton btnSelect3;
    private JButton btnSelect4;
    private JButton btnSelect5;

    public MainView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());
        setSize(360, 500);

        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();

        label.setText("Hotel Reservation System");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 32));
        label.setForeground(Color.decode("#800080"));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#FFFFFF"));
        panel.add(label);   

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 8, 8));
        
        btnSelect1 = new JButton("Create Hotel");
        btnSelect2 = new JButton("Manage Hotel");
        btnSelect3 = new JButton("Simulate Booking");
        btnSelect4 = new JButton("View Hotel Details");
        btnSelect5 = new JButton("Exit");

        btnSelect1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect5.setFont(new Font("Times New Roman", Font.BOLD, 20));

        btnSelect1.setForeground(Color.decode("#800080"));
        btnSelect2.setForeground(Color.decode("#800080"));
        btnSelect3.setForeground(Color.decode("#800080"));
        btnSelect4.setForeground(Color.decode("#800080"));
        btnSelect5.setForeground(Color.decode("#800080"));

        btnSelect1.setBackground(Color.decode("#FFFFFF"));
        btnSelect2.setBackground(Color.decode("#FFFFFF"));
        btnSelect3.setBackground(Color.decode("#FFFFFF"));
        btnSelect4.setBackground(Color.decode("#FFFFFF"));
        btnSelect5.setBackground(Color.decode("#FFFFFF"));

        btnSelect1.setBorderPainted(false);
        btnSelect2.setBorderPainted(false);
        btnSelect3.setBorderPainted(false);
        btnSelect4.setBorderPainted(false);
        btnSelect5.setBorderPainted(false);

        buttonPanel.add(btnSelect1);
        buttonPanel.add(btnSelect2);
        buttonPanel.add(btnSelect3);
        buttonPanel.add(btnSelect4);
        buttonPanel.add(btnSelect5);

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.NORTH);

    }
}