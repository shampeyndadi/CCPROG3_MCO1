import javax.swing.*;
import java.awt.*;

public class CreateHotelView extends JFrame{

    private JTextField text;
    private JTextField numRooms;

    public CreateHotelView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());

        init();

        setSize(360, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        setResizable(false);

    }

    private void init(){
        JPanel topPanel = new JPanel();

        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.decode("#FFFFFF"));

        JLabel topLabel = new JLabel();

        topLabel.setText("Create Hotel");
        topLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        topLabel.setForeground(Color.decode("#800080"));
        
        topPanel.add(topLabel);

        this.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new FlowLayout());

        this.add(centerPanel, BorderLayout.WEST);

        JPanel centerMidPanel = new JPanel();

        centerMidPanel.setLayout(new GridLayout(2, 1, 1, 1));
        centerMidPanel.setBackground(Color.decode("#FFFFFF"));

        centerPanel.add(centerMidPanel, BorderLayout.NORTH);

        JLabel indicator = new JLabel();
        indicator.setText("Enter hotel name: ");
        indicator.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        indicator.setForeground(Color.decode("#800080"));
        text = new JTextField(15);
        text.setPreferredSize(new Dimension(20, 20));

        JLabel indicator2 = new JLabel();
        indicator2.setText("Enter number of rooms: ");
        indicator2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        indicator2.setForeground(Color.decode("#800080"));
        numRooms =  new JTextField(2);

        centerMidPanel.add(indicator);
        centerMidPanel.add(text);
        centerMidPanel.add(indicator2);
        centerMidPanel.add(numRooms);
      
    }
}