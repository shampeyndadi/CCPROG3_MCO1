import javax.swing.*;
import java.awt.*;

public class AddRoomsView extends JFrame{
    
    public AddRoomsView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());

        init();

        setSize(360, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        setResizable(false);

    }
      
}
