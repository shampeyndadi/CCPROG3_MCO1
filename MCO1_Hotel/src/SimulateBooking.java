import java.util.ArrayList;
import java.util.Scanner;

public class SimulateBooking {
    private Hotels HotelLists;
    private Scanner sc;

    public SimulateBooking(Hotels HotelLists){
        this.HotelLists = HotelLists;
        this.sc = new Scanner(System.in);
    }

    public void bookHotel(){
        Execute exe = new Execute();

        if (HotelLists.listOfHotels().isEmpty()){
            exe.clearConsole();
            System.out.println("\nNo hotels yet! Hotels are yet to be built");
            exe.pressEnterToContinue();
            exe.clearConsole();
        }else if (!(HotelLists.checkHotels(HotelLists))){
            exe.clearConsole();
            System.out.println("\nSorry hotels are still preparing their rooms! They will add in rooms soon");
            exe.pressEnterToContinue();
            exe.clearConsole();
        }else{
            System.out.println("[BOOK A RESERVATION]\n");

            HotelLists.DisplayHotels();

            System.out.print("\nChoose hotel [Enter index]: ");
            int index = sc.nextInt();
            sc.nextLine();

            while (index <= 0 || index > HotelLists.listOfHotels().size() || HotelLists.listOfHotels().get(index - 1).viewRooms().isEmpty()) {
                if (index <= 0 || index > HotelLists.listOfHotels().size()) {
                    System.out.print("\nInvalid hotel index. Please enter a valid index: ");
                } else {
                    System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
                }

                index = sc.nextInt();
                sc.nextLine();
            }
            
            System.out.println("\nEnter preferred check in day: ");
            System.out.print("*------------------------------------*\n\n");
            System.out.print("Enter day of the month you wish to check in: ");
            int checkInDay = sc.nextInt();
            sc.nextLine();

            while(checkInDay < 1 || checkInDay > 31){
                System.out.print("\nError invalid day! Enter day: ");
                checkInDay = sc.nextInt();
            }

            System.out.println();

            System.out.println("\nEnter preferred check out day: ");
            System.out.print("*------------------------------------*\n\n");
            System.out.print("Enter day of the month you wish to check out: ");
            int checkOutDay = sc.nextInt();

            while(checkOutDay < 1 || checkOutDay > 31){
                System.out.print("\nError invalid day! Enter day: ");
                checkOutDay = sc.nextInt();
            }

            System.out.println();

            exe.clearConsole();

            Date checkIn = new Date(checkInDay);
            Date checkOut = new Date(checkOutDay);

            if (checkIn.after(checkOut) || checkIn.equals(checkOut)){
                System.out.println("Error: Check-out day must be after check-in day. Please rebook again");

                exe.pressEnterToContinue();
                exe.clearConsole();
            }else{
                Hotel chosenHotel = HotelLists.listOfHotels().get(index-1);
                ArrayList<Room> roomsOfChosenHotel = chosenHotel.viewRooms();
                ArrayList<Reservation> reservations = chosenHotel.viewReservations();

                System.out.println(chosenHotel.getHotelName()+"'s available rooms on your specified dates\n");
        
                ArrayList<Room> availableRooms = chosenHotel.roomAvailable(roomsOfChosenHotel, reservations, checkOut, checkIn);

                for (int i = 0; i < availableRooms.size(); i++){
                    System.out.print((i+1) + ". " + availableRooms.get(i).getRoomName() + "| ");
                    if ((i + 1) % 5 == 0) {
                        System.out.println(); 
                    } else {
                        System.out.print(" "); 
                    }
                }

                System.out.println();

                System.out.print("*------------------------------------*\n\n");
                
                System.out.print("Enter room index: ");
                int roomIndex = sc.nextInt();
                sc.nextLine();

                while(!(roomIndex <= availableRooms.size() && roomIndex != 0)){
                    System.out.print("Error! room doesn't exist. Enter room index again: ");
                    roomIndex = sc.nextInt();
                    sc.nextLine();
                }

                System.out.println();

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.println();

                Room chosenRoom = availableRooms.get(roomIndex-1);

                Reservation reserved = new Reservation(name, checkIn, checkOut, chosenRoom);
                chosenHotel.viewReservations().add(reserved);

                exe.clearConsole();

                System.out.println("\nThank you for choosing " + chosenHotel.getHotelName() + ", your reservation was succesfully booked!");
                System.out.println("*-------------------------------*");
                
                System.out.println(reserved.displayConfirmation(reserved));

                System.out.println();

                exe.pressEnterToContinue();
                exe.clearConsole();
            }
        }
    }

}
