import java.util.Scanner;
import java.util.ArrayList;

public class ViewHotel {
    private Hotels Hotel;
    private Scanner sc;

    public ViewHotel(Hotels Hotel){
        this.sc = new Scanner(System.in);
        this.Hotel = Hotel;
    }

    public void displayHighInformation(){
        Execute exe = new Execute();

        Hotel.DisplayHotels();

        System.out.print("Enter hotel index: ");
        int hotelIndex = sc.nextInt();

        System.out.println();

        while (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(hotelIndex - 1).viewRooms().isEmpty()) {
            if (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size()) {
                System.out.print("\nInvalid hotel hotelIndex. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            hotelIndex = sc.nextInt();
            sc.nextLine();
        }

        Hotel chosenHotel = Hotel.listOfHotels().get(hotelIndex - 1);

        exe.clearConsole();

        System.out.println("*----------------------------------------------*");
        System.out.println("Hotel Name: " +  chosenHotel.getHotelName());
        System.out.println("Total Rooms: " + chosenHotel.viewRooms().size());
        System.out.println("Estimated Monthly Earnings: " +  chosenHotel.getTotalEarnings());

        System.out.println();

        exe.pressEnterToContinue();
        exe.clearConsole();
    }

    public void displayHotelInformation(){
        Execute exe = new Execute();

        Hotel.DisplayHotels();

        System.out.print("Enter hotel index: ");
        int hotelIndex = sc.nextInt();

        while (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(hotelIndex - 1).viewRooms().isEmpty()) {
            if (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size()) {
                System.out.print("\nInvalid hotel hotelIndex. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            hotelIndex = sc.nextInt();
            sc.nextLine();
        }

        exe.clearConsole();

        System.out.println("Select date");
        System.out.println("*------------------------*");
        System.out.print("Enter day of the month you wish to check in: ");
        int checkInDay = sc.nextInt();
        sc.nextLine();

        while(!(checkInDay <= 31)){
            System.out.print("Error invalid day! Enter day: ");
            checkInDay = sc.nextInt();
        }

        System.out.println();

        System.out.println("Select date");
        System.out.println("*------------------------*");
        System.out.print("Enter day of the month you wish to check out: ");
        int checkOutDay = sc.nextInt();

        while(!(checkOutDay <= 31)){
            System.out.print("Error invalid day! Enter day: ");
            checkOutDay = sc.nextInt();
        }

        System.out.println();

        exe.clearConsole();

        Date checkIn = new Date(checkInDay);
        Date checkOut = new Date(checkOutDay);
        Hotel chosenHotel = Hotel.listOfHotels().get(hotelIndex - 1);

        if (checkIn.after(checkOut)){
            System.out.println("Error: Check-out day must be after check-in day. Please enter valid dates");
        }else{
            int bookedRooms = roomsOnDate(chosenHotel, checkIn, checkOut);

            System.out.println("Hotel name: " + chosenHotel.getHotelName());
            System.out.println("*-------------------------*");
            System.out.println("Total booked rooms: " + bookedRooms + " | Available rooms: " + (chosenHotel.viewRooms().size() - bookedRooms));

            System.out.println();

            exe.pressEnterToContinue();
            exe.clearConsole();
        }
    }

    public void displayRoomInformation(){
        Execute exe = new Execute();

        Hotel.DisplayHotels();

        System.out.print("Enter hotel index: ");
        int hotelIndex = sc.nextInt();

        System.out.println();

        while (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(hotelIndex - 1).viewRooms().isEmpty()) {
            if (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size()) {
                System.out.print("\nInvalid hotel index. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            hotelIndex = sc.nextInt();
            sc.nextLine();
        }

        Hotel chosenHotel = Hotel.listOfHotels().get(hotelIndex - 1);

        System.out.println("Available rooms in this hotel: ");

        for (int i = 0; i < chosenHotel.viewRooms().size(); i++) {
            System.out.print((i + 1) + ". " + chosenHotel.viewRooms().get(i).getRoomName());
            if ((i + 1) % 5 == 0) {
                System.out.println(); 
            } else {
                System.out.print(" "); 
            }
        }
        
        System.out.println(); 
        
        System.out.print("\nEnter room index: ");
        int roomIndex = sc.nextInt();

        while (roomIndex <= 0 || roomIndex > chosenHotel.viewRooms().size()){
            System.out.print("Invalid room index. Enter a new index: ");

            roomIndex = sc.nextInt();
            sc.nextLine();
        }

        exe.clearConsole();

        Room chosenRoom = chosenHotel.viewRooms().get(roomIndex-1);
        ArrayList<Reservation> reserve = chosenHotel.viewReservations();

        ArrayList<Integer> datesAvailable = getDatesAvailable(chosenRoom, reserve);

        System.out.println(chosenRoom.getRoomName() + "'s available dates for booking ");

        if (datesAvailable.isEmpty()){
            System.out.println("\n" + chosenRoom.getRoomName() + " is fully booked for the month");
        }else {
            for (int i = 0; i < datesAvailable.size(); i++){
                System.out.print(datesAvailable.get(i) + " ");

                if ((i + 1) % 5 == 0) {
                    System.out.println(); 
                } else {
                    System.out.print(" "); 
                }
            }
        }

        System.out.println();
        
        System.out.println("\nRoom name: " + chosenRoom.getRoomName());
        System.out.println("\nPrice per night: " + chosenRoom.getRoomPrice());

        System.out.println();

        exe.pressEnterToContinue();
        exe.clearConsole();

    }

    public void displayReservationInformation(){
        Execute exe = new Execute();
        
        Hotel.DisplayHotels();

        System.out.print("Enter hotel index: ");
        int hotelIndex = sc.nextInt();

        while (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(hotelIndex - 1).viewRooms().isEmpty()) {
            if (hotelIndex <= 0 || hotelIndex > Hotel.listOfHotels().size()) {
                System.out.print("\nInvalid hotel index. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            hotelIndex = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();
        
        Hotel chosenHotel = Hotel.listOfHotels().get(hotelIndex - 1);
        ArrayList<Reservation> hotelsReserved = chosenHotel.viewReservations();

        for (int i = 0; i < hotelsReserved.size(); i++){
            System.out.print((i+1) + ". Reservation");

            if ((i + 1) % 5 == 0) {
                System.out.println(); 
            } else {
                System.out.print(" "); 
            }
        }

        System.out.println();

        System.out.print("Enter reservation index to view: ");
        int reservationIndex = sc.nextInt();
        
        while (reservationIndex <= 0 || reservationIndex > hotelsReserved.size() || hotelsReserved.isEmpty()) {
            if (reservationIndex <= 0 || reservationIndex > hotelsReserved.size()) {
                System.out.print("\nInvalid reservation index. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            reservationIndex = sc.nextInt();
            sc.nextLine();
        }

        exe.clearConsole();

        Reservation reserved = hotelsReserved.get(reservationIndex-1);

        System.out.println(reserved.displayConfirmation(reserved));

        exe.pressEnterToContinue();
        exe.clearConsole();
        
    }

    private ArrayList<Integer> getDatesAvailable(Room room, ArrayList<Reservation> reservations) {
        ArrayList<Integer> availableDates = new ArrayList<>();

        for (int day = 1; day <= 31; day++) {
            boolean isAvailable = true;

            for (Reservation reservation : reservations) {
                if (reservation.room().equals(room)) {
                    int checkInDay = reservation.checkInDate().getDay(); 
                    int checkOutDay = reservation.checkOutDate().getDay(); 

                    if (day >= checkInDay && day <= checkOutDay) {
                        isAvailable = false;

                    }
                }
            }

            if (isAvailable) {
                availableDates.add(day);
            }
        }

        return availableDates;
    }
    private int roomsOnDate(Hotel chosenHotel, Date checkIn, Date checkOut){

        int bookedRooms = 0;    

        ArrayList<Reservation> reserved = chosenHotel.viewReservations();

        for (Reservation reservation : reserved) {
            Date reservationCheckIn = reservation.checkInDate();
            Date reservationCheckOut = reservation.checkOutDate();

            if (!(checkOut.before(reservationCheckIn) || checkIn.after(reservationCheckOut))) {
                bookedRooms++;
            }
        }

        return bookedRooms;
    }
}


