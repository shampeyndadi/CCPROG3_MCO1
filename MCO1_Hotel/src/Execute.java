import java.util.Scanner;

public class Execute{
    private Hotels HRS;
    private ManageHotel HotelManager;
    private SimulateBooking BookHotel;
    private Scanner sc;
    private Interface layout;
    

    public Execute(){
        this.HRS = new Hotels();
        this.HotelManager = new ManageHotel(HRS);
        this.BookHotel = new SimulateBooking(HRS);
        this.sc = new Scanner(System.in);
        this.layout = new Interface();
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; ++i) 
                System.out.println();
        } 
    }

    public void pressEnterToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
                System.in.read();
           }  
           catch(Exception e)
           {}  
    }

    public void ManageHotel(){
        boolean run = true;
        int option;
    
        do{
            layout.ManageHotel();
            System.out.print("\n          [Enter option]: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    HotelManager.AddRooms();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 2:
                    clearConsole();
                    HotelManager.changeHotelName();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 3:
                    clearConsole();
                    HotelManager.RemoveRooms();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 4:
                    clearConsole();
                    HotelManager.changeBasePrice();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 5:
                    clearConsole();
                    HotelManager.removeReservation();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 6:
                    clearConsole();
                    HotelManager.removeHotel();
                    pressEnterToContinue();
                    clearConsole();
                case 7: 
                    clearConsole();
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
            System.out.print("\n          [Enter option]: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    HRS.createHotel();
                    pressEnterToContinue();
                    clearConsole();
                    break;
                case 2:
                    clearConsole();
                    ManageHotel();
                    break;
                case 3: 
                    clearConsole();
                    BookHotel.bookHotel();
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