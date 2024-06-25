public class Interface {
    public void MainMenu(){
        System.out.println("=====================================");
        System.out.println("        WELCOME TO HOTEL SYSTEM        ");
        System.out.println("=====================================");
        System.out.println();   
        System.out.println("          [1] Create hotel              ");
        System.out.println("          [2] Manage hotel              ");
        System.out.println("          [3] Simulate booking            ");
        System.out.println("          [4] View hotel details           ");
        System.out.println("          [5] Exit                  ");
    }

    public void ManageHotel(){
        System.out.println("=====================================");
        System.out.println("             MANAGE HOTEL         ");
        System.out.println("=====================================");
        System.out.println();   
        System.out.println("          [1] Add Rooms               ");
        System.out.println("          [2] Change Hotel Name              ");
        System.out.println("          [3] Remove Rooms            ");
        System.out.println("          [4] Update base price          ");
        System.out.println("          [5] Remove reservation            ");
        System.out.println("          [6] Remove Hotel                  ");
        System.out.println("          [7] Exit                 ");
    }

    public void ViewHotel(){
        System.out.println("=====================================");
        System.out.println("              VIEW HOTEL         ");
        System.out.println("=====================================");
        System.out.println();   
        System.out.println("          [1] Basic Information              ");
        System.out.println("          [2] Specific Information            ");
        System.out.println("          [3] Exit                 ");
    }

    public void SpecificInformation(){
        System.out.println("=====================================");
        System.out.println("          SPECIFIC INFORMATION         ");
        System.out.println("=====================================");
        System.out.println();   
        System.out.println("          [1] Room Availability     ");
        System.out.println("          [2] Room Details              ");
        System.out.println("          [3] Reservation Details   ");
        System.out.println("          [4] Exit");
    }
}
