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
        }else if (!(checkHotels(HotelLists))){
            exe.clearConsole();
            System.out.println("\nSorry hotels are still preparing their rooms! They will add in rooms soon");
            exe.pressEnterToContinue();
            exe.clearConsole();
        }else{
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

            while(!(checkInDay <= 31)){
                System.out.print("Error invalid day! Enter day: ");
                checkInDay = sc.nextInt();
            }

            System.out.println();

            exe.clearConsole();

            System.out.println("\nEnter preferred check out day: ");
            System.out.print("*------------------------------------*\n\n");
            System.out.print("Enter day of the month you wish to check out: ");
            int checkOutDay = sc.nextInt();

            while(!(checkOutDay <= 31)){
                System.out.print("Error invalid day! Enter day: ");
                checkOutDay = sc.nextInt();
            }

            System.out.println();

            Date checkIn = new Date(checkInDay);
            Date checkOut = new Date(checkOutDay);

            if (checkIn.after(checkOut)){
                System.out.println("Error: Check-out day must be after check-in day. Please rebook again");

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

    private boolean checkHotels(Hotels hotelLists) {
        for (Hotel hotel : hotelLists.listOfHotels()) {
            if (!(hotel.viewRooms().isEmpty())) {
                return true; 
            }
        }
        return false;
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

}
