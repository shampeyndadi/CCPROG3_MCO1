import java.util.Scanner;

public class Execute{
    private Hotels HRS;
    private ManageHotel HotelManager;
    private Scanner sc;
    private Interface layout;
    

    public Execute(){
        this.HRS = new Hotels();
        this.HotelManager = new ManageHotel(HRS);
        this.sc = new Scanner(System.in);
        this.layout = new Interface();
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    public void ManageHotel(){
        boolean run = true;
        int option;
    
        do{
            layout.ManageHotel();
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    HotelManager.AddRooms();
                    break;
                case 2:
                    HotelManager.changeHotelName();
                    break;
                case 6: 
                    run = false;
                    clearConsole();
                    break; 
            }
        } while (run != false);
    }

    public void execute(){
        boolean run = true;
        int option;
        
        do{
            layout.MainMenu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    HRS.createHotel();
                    break;
                case 2:
                    clearConsole();
                    ManageHotel();
                    break;
                case 5: 
                    run = false;
                    clearConsole();
                    System.out.println("[Program End]");
                    break; 
            }
        } while (run != false);
        
    }
}   