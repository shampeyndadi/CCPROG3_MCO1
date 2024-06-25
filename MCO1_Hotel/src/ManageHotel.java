import java.util.Scanner;
import java.util.ArrayList;

public class ManageHotel {
    private Scanner sc;
    private Hotels Hotel;

    public ManageHotel(Hotels Hotel){
        this.sc = new Scanner(System.in);
        this.Hotel = Hotel;
    }

    public void AddRooms(){
        if (Hotel.listOfHotels().isEmpty()){
            System.out.println("No hotels present! Please create a hotel first");
        }else{
            System.out.println("[ADD ROOMS]\n");

            Hotel.DisplayHotels();

            System.out.print("\nEnter index: ");
            int index = sc.nextInt();
            sc.nextLine();

            while (index <= 0 || index > Hotel.listOfHotels().size()) {
                
                System.out.print("\nInvalid hotel index. Please enter a valid index: ");
                index = sc.nextInt();
                sc.nextLine();
            }

            if (Hotel.listOfHotels().get(index-1).viewRooms().size() == 50){
                System.out.println("\nThis hotel has already reached the maximum capacity of rooms\n");
            }else{
                Hotel chosenHotel = Hotel.listOfHotels().get(index-1);

                System.out.print("\nEnter number of rooms you wish to add: ");
                int numRooms = sc.nextInt();
                sc.nextLine();

                while (numRooms > 50 || (numRooms + chosenHotel.viewRooms().size()) > 50){
                    if ((numRooms + Hotel.listOfHotels().get(index-1).viewRooms().size()) > 50){
                        System.out.print("\nYour addition is exceeding the 50 room limit! Please enter new number of rooms: ");
                    }else{
                        System.out.print("\nMaximum of 50 rooms only! Please enter new number of rooms: ");
                    }
                    numRooms = sc.nextInt();
                    sc.nextLine();
                }

                int roomCounter = 1 + chosenHotel.viewRooms().size();

                for (int i = 0; i < numRooms; i++) {
                    String roomName = "Room " + roomCounter;
                    while (Hotel.doesRoomExist(chosenHotel, roomName)) {
                        roomCounter++;
                        roomName = "Room " + roomCounter;
                    }

                    chosenHotel.addRoom(new Room(roomName));
                    roomCounter++;
                }

                System.out.println("\nRoom\\s created succesfully!\n");
            }
        }
    }

    public void RemoveRooms(){
        
        if (!(Hotel.checkHotels(Hotel))){
            System.out.println("\nSorry hotels are still preparing their rooms! They will add in rooms soon");
        }else{
            System.out.println("[REMOVE ROOMS]\n");
            Hotel.DisplayHotels();
            System.out.print("\nEnter index: ");
            int index = sc.nextInt();

            while (index <= 0 || index > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty()) {
                if (index <= 0 || index > Hotel.listOfHotels().size()) {
                    System.out.print("\nInvalid hotel index. Please enter a valid index: ");
                } else {
                    System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
                }

                index = sc.nextInt();
                sc.nextLine();
            }

            Hotel chosenHotel = Hotel.listOfHotels().get(index-1);
            ArrayList<Room> removeRooms = Hotel.getRemovableRooms(chosenHotel);

            if (removeRooms.isEmpty()){
                System.out.println("All rooms currently have a booking!\n");
            }else{
                System.out.println("\nRooms that doesn't have an active reservation:");
                System.out.println();

                for (int i = 0; i < removeRooms.size(); i++){
                    System.out.print((i+1) + ". " + removeRooms.get(i).getRoomName() + "| ");

                    if ((i + 1) % 5 == 0) {
                        System.out.println(); 
                    } else {
                        System.out.print(" "); 
                    }
                }
                
                System.out.print("\nEnter room index you wish to remove: ");
                int roomIndex = sc.nextInt();

                while (roomIndex <= 0 || roomIndex > removeRooms.size()){
                    System.out.print("\nError! Room index does not exist. Enter index: ");
                    roomIndex = sc.nextInt();
                }

                chosenHotel.removeRoom(removeRooms.get(roomIndex-1));

                System.out.println("\nRoom successfully removed!\n");
            }
        }

    }

    public void changeBasePrice(){
        if (!(Hotel.checkHotels(Hotel))){
            System.out.println("\nSorry hotels are still preparing their rooms! They will add in rooms soon");
        }else{
            System.out.println("[UPDATE BASE PRICE OF ROOMS]\n");

            Hotel.DisplayHotels();
            System.out.print("\nEnter index: ");
            int index = sc.nextInt();

            while (index <= 0 || index > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty()) {
                if (index <= 0 || index > Hotel.listOfHotels().size()) {
                    System.out.print("\nInvalid hotel index. Please enter a valid index: ");
                } else {
                    System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
                }

                index = sc.nextInt();
                sc.nextLine();
            }

            Hotel chosenHotel = Hotel.listOfHotels().get(index-1);
            
            if (!chosenHotel.viewReservations().isEmpty()){
                System.out.println("This room currently has reservations. You cannot change the price for now\n");
            }else{
                System.out.print("\nEnter new base price for all rooms: ");
                double newPrice = sc.nextDouble();
                
                while (newPrice < 100.0){
                    System.out.print("Error! The new price must be >= 100.0. Enter price: ");
                    newPrice = sc.nextDouble();
                }
        
                for (Room room : chosenHotel.viewRooms()) {
                    room.updateBasePrice(newPrice);
                }

                System.out.println("\nBase price updated successfully!\n");
            }
        }
    }

    public void removeReservation(){
        if (!(Hotel.checkReservation(Hotel))){
            System.out.println("\nSorry hotels haven't received any reservations yet!");
        }else{
            System.out.println("[REMOVE RESERVATION]\n");

            Hotel.DisplayHotels();
            System.out.print("\nEnter index: ");
            int index = sc.nextInt();

            while (index <= 0 || index > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty() || Hotel.listOfHotels().get(index-1).viewReservations().isEmpty()) {
                if (index <= 0 || index > Hotel.listOfHotels().size()) {
                    System.out.print("\nInvalid hotel index. Please enter a valid index: ");
                } else if (Hotel.listOfHotels().get(index-1).viewReservations().isEmpty()) {
                    System.out.print("\nThis hotel currently has no reservations. Please choose another hotel [Enter index]: ");
                } else {
                    System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
                }

                index = sc.nextInt();
                sc.nextLine();
            }

            System.out.println();

            Hotel chosenHotel = Hotel.listOfHotels().get(index - 1);

            if (!(chosenHotel.viewReservations().isEmpty())){
                for (int i = 0; i < chosenHotel.viewReservations().size(); i++){
                    System.out.println("Reservation " + (i + 1));
                    System.out.println("\n" + chosenHotel.viewReservations().get(i).displayConfirmation(chosenHotel.viewReservations().get(i)));
                    System.out.println("*-------------------*\n\n");
                }
                
                System.out.print("Enter reservation index: ");
                int reservationIndex = sc.nextInt();

                chosenHotel.viewReservations().remove(chosenHotel.viewReservations().get(reservationIndex-1));

                System.out.println("\nReservation succesfully voided!\n");
            } else{
                System.out.println("\nThis hotel has no reservations to remove\n");
            }
        }
    }

    public void changeHotelName(){
        System.out.println("[CHANGE HOTEL NAME]\n");

        Hotel.DisplayHotels();
        System.out.print("\nEnter index: ");
        int index = sc.nextInt();
        sc.nextLine();

        while (index <= 0 || index > Hotel.listOfHotels().size()) {
                
            System.out.print("\nInvalid hotel index. Please enter a valid index: ");
            index = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        if (Hotel.doesHotelExist(Hotel.listOfHotels(), newName)){
            System.out.println("\nHotel already exists please choose a new name");
        }else{
            Hotel.listOfHotels().get(index - 1).changeHotelName(newName);
            System.out.println("\nHotel name succesfully changed!\n");
        }
    }

    public void removeHotel(){
        System.out.println("[REMOVE HOTEL]\n");

        Hotel.DisplayHotels();
        System.out.print("\nEnter index: ");
        int index = sc.nextInt();
        sc.nextLine();

        while (index <= 0 || index > Hotel.listOfHotels().size()) {
                
            System.out.print("\nInvalid hotel index. Please enter a valid index: ");
            index = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();

        Hotel chosenHotel = Hotel.listOfHotels().get(index - 1);

        if (!(chosenHotel.viewReservations().isEmpty())){
            System.out.print("This hotel currently has reservations. Are you sure you want to proceed Y/N: ");
            char answer = sc.nextLine().charAt(0);

            while (answer != 'Y' && answer != 'N' && answer != 'y' && answer != 'n'){
                System.out.print("\nInvalid input. Input answer again: ");
                answer = sc.nextLine().charAt(0);
            }

            if (answer == 'Y' && answer == 'y'){
                Hotel.listOfHotels().remove(Hotel.listOfHotels().get(index - 1));
                System.out.println("\nHotel succesfully removed!\n");
            }else 
                System.out.println("\nHotel removal cancelled!\n");
        }else{
            Hotel.listOfHotels().remove(Hotel.listOfHotels().get(index - 1));
            System.out.println("\nHotel succesfully removed!\n");
        }
    }


}
