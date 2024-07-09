import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class ViewHotelView extends JFrame{
    
    private JButton btnSelect1;
    private JButton btnSelect2;
    private JButton btnSelect3;

    public ViewHotelView(){
        super("Hotel Resevation System");
        setLayout(new BorderLayout());
        setSize(360, 500);

        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();

        label.setText("Manage Hotel");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 32));
        label.setForeground(Color.decode("#800080"));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#FFFFFF"));
        panel.add(label);   

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        
        btnSelect1 = new JButton("Basic Information");
        btnSelect2 = new JButton("Specific Information");
        btnSelect3 = new JButton("Exit");

        btnSelect1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSelect3.setFont(new Font("Times New Roman", Font.BOLD, 20));

        btnSelect1.setForeground(Color.decode("#800080"));
        btnSelect2.setForeground(Color.decode("#800080"));
        btnSelect3.setForeground(Color.decode("#800080"));
        
        btnSelect1.setBackground(Color.decode("#FFFFFF"));
        btnSelect2.setBackground(Color.decode("#FFFFFF"));
        btnSelect3.setBackground(Color.decode("#FFFFFF"));
       
        btnSelect1.setBorderPainted(false);
        btnSelect2.setBorderPainted(false);
        btnSelect3.setBorderPainted(false);
       
        buttonPanel.add(btnSelect1);
        buttonPanel.add(btnSelect2);
        buttonPanel.add(btnSelect3);

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.NORTH);

    }
}
