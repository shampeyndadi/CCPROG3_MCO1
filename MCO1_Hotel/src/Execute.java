import java.util.Scanner;
public class Execute{
    private Hotels HRS;
    private ManageHotel HotelManager;
    private SimulateBooking BookHotel;
    private Scanner sc;
    private Interface layout;
    private ViewHotel hotelFinder;
    

    public Execute(){
        this.HRS = new Hotels();
        this.HotelManager = new ManageHotel(HRS);
        this.BookHotel = new SimulateBooking(HRS);
        this.sc = new Scanner(System.in);
        this.layout = new Interface();
        this.hotelFinder = new ViewHotel(HRS);
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

    private void ManageHotel(){
        boolean run = true;
        int option;
    
        do{
            layout.ManageHotel();
            System.out.print("\n          [Enter option]: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.AddRooms();
                        pressEnterToContinue();
                        clearConsole();
                    }else{ 
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                    break;
                case 2:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.changeHotelName();
                        pressEnterToContinue();
                        clearConsole();
                    }else{
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                    break;
                case 3:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.RemoveRooms();
                        pressEnterToContinue();
                        clearConsole();
                    }else{
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                    break;
                case 4:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.changeBasePrice();
                        pressEnterToContinue();
                        clearConsole();
                    }else{
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                    break;
                case 5:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.removeReservation();
                        pressEnterToContinue();
                        clearConsole();
                    }else{
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                    break;
                case 6:
                    if (!HRS.listOfHotels().isEmpty()){
                        clearConsole();
                        HotelManager.removeHotel();
                        pressEnterToContinue();
                        clearConsole();
                    }else{
                        clearConsole();
                        System.out.println("\nNo hotels yet! Hotels are yet to be built");
                        pressEnterToContinue();
                        clearConsole();
                    }
                case 7: 
                    clearConsole();
                    run = false;
                    clearConsole();
                    break; 
            }
        } while (run != false);
    }

    private void ViewHotel(){
        boolean run = true;
        int option;
    
        do{
            layout.ViewHotel();
            System.out.print("\n          [Enter option]: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    hotelFinder.displayHighInformation();
                    break;
                case 2:
                    clearConsole();
                    SpecificInformation();
                    break;
                case 3: 
                    clearConsole();
                    run = false;
                    clearConsole();
                    break; 
            }
        } while (run != false);
    }

    private void SpecificInformation(){
        boolean run = true;
        int option;
    
        do{
            layout.SpecificInformation();
            System.out.print("\n          [Enter option]: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    hotelFinder.displayHotelInformation();
                    break;
                case 2:
                    clearConsole();
                    hotelFinder.displayRoomInformation();
                    break;
                case 3:
                    clearConsole();
                    hotelFinder.displayReservationInformation();
                    break;
                case 4: 
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
                case 4: 
                    clearConsole();
                    ViewHotel();
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