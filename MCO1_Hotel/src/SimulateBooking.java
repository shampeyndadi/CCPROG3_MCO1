import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimulateBooking {
    private Hotels HotelLists;
    private Scanner sc;

    public SimulateBooking(Hotels HotelLists){
        this.HotelLists = HotelLists;
        this.sc = new Scanner(System.in);
    }

    public void bookHotel(){
        if (HotelLists.listOfHotels().isEmpty()){
            System.out.println("\nNo hotels yet! Hotels are yet to be built");
        }else{
            Execute exe = new Execute();
            HotelLists.DisplayHotels();

            System.out.print("\nChoose hotel [Enter index]: ");
            int index = sc.nextInt();
            sc.nextLine();

            System.out.println("\nEnter preferred check in date: ");
            System.out.print("*------------------------------------*\n\n");
            System.out.print("Enter month: ");
            String checkInMonth = sc.nextLine();
    
            while (!verifyMonth(checkInMonth)){
                System.out.print("Error invalid month! Enter month: ");
                checkInMonth = sc.nextLine();
            }

            System.out.println();
            
            System.out.print("Enter day: ");
            int checkInDay = sc.nextInt();
            sc.nextLine();

            while(!(checkInDay < 31)){
                System.out.print("Error invalid day! Enter day: ");
                checkInDay = sc.nextInt();
            }

            System.out.println();

            System.out.print("Enter year: ");
            int checkInYear = sc.nextInt();

            while (!(checkInYear <= 2024)){
                System.out.print("Error enter valid year! Enter year: ");
                checkInYear = sc.nextInt();    
            }

            sc.nextLine();
            System.out.println();

            exe.clearConsole();

            System.out.println("\nEnter preferred check out date: ");
            System.out.print("*------------------------------------*\n\n");
            System.out.print("Enter month: ");
            String checkOutMonth = sc.nextLine();

            while (!verifyMonth(checkOutMonth)){
                System.out.print("Error invalid month! Enter month: ");
                checkOutMonth = sc.nextLine();
            }

            System.out.println();

            System.out.print("Enter day: ");
            int checkOutDay = sc.nextInt();

            while(!(checkOutDay < 31)){
                System.out.print("Error invalid day! Enter day: ");
                checkOutDay = sc.nextInt();
            }

            System.out.println();

            System.out.print("Enter year: ");
            int checkOutYear = sc.nextInt();

            while (!(checkOutYear <= 2024)){
                System.out.print("Error enter valid year! Enter year: ");
                checkOutYear = sc.nextInt();    
            }

            System.out.println();

            Date checkIn = new Date(checkInMonth, checkInYear, checkInDay);
            Date checkOut = new Date(checkOutMonth, checkOutYear, checkOutDay);

            if (checkIn.after(checkOut)){
                System.out.println("Error: Check-out date must be after check-in date. Please rebook again");

                exe.pressEnterToContinue();
                exe.clearConsole();
            }else{

                Hotel chosenHotel = HotelLists.listOfHotels().get(index-1);
                ArrayList<Room> roomsOfChosenHotel = chosenHotel.viewRooms();
                ArrayList<Reservation> reservations = chosenHotel.viewReservations();

                System.out.println(chosenHotel.getHotelName()+"'s available rooms on your specified dates\n");
        
                ArrayList<Room> availableRooms = roomAvailable(roomsOfChosenHotel, reservations, checkOut, checkIn);

                for (int i = 0; i < availableRooms.size(); i++){
                    System.out.println(i+1 + ". " + availableRooms.get(i).getRoomName());
                }

                System.out.print("*------------------------------------*\n\n");
                
                System.out.print("Enter room index: ");
                int roomIndex = sc.nextInt();
                sc.nextLine();

                while(!(roomIndex <= availableRooms.size() && roomIndex != 0)){
                    System.out.print("Error room doesn't exist! Enter room index again: ");
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
    
    private ArrayList<Room> roomAvailable(ArrayList<Room> roomsOfChosenHotel, ArrayList<Reservation> reservations, Date checkOut, Date checkIn) {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : roomsOfChosenHotel) {
            boolean isAvailable = true;

            for (Reservation reservation : reservations) {
                if (room.equals(reservation.room())) {
                    if (!(checkOut.before(reservation.checkInDate()) || checkIn.after(reservation.checkOutDate()))) {
                        isAvailable = false;
                    }
                }
            }

            room.changeAvailability(isAvailable);

            if (isAvailable) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    private boolean verifyMonth(String month){
        ArrayList<String> Month = new ArrayList<>(Arrays.asList("January", "February", "March",
                                                                      "April", "May", "June", "July",
                                                                      "August", "September", "October",
                                                                      "November", "December"));

        for (int i = 0; i < Month.size(); i++)
            if (month.equalsIgnoreCase(Month.get(i))){
                return true;
            }
        
        return false;
    }

}
