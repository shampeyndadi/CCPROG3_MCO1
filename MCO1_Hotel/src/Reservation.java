/* 
   
 */

import java.util.ArrayList;

class Reservation {

    private String guestName;
    private Date  checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private Room room;
    private ArrayList<Room> listOfRooms;

    public Reservation(String guestName, Date checkInDate, Date checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = (checkInDate.getDay() - checkInDate.getDay()) * room.getRoomPrice();
        this.room = room;
    }

    public double TotalPrice() {
        return totalPrice; // to be fixed
    }

    public String guestName(){
        return guestName; // customer name 
    }

    public Date checkInDate(){
        return checkInDate; // check in date 
    }

    public Date checkOutDate(){
        return checkOutDate; // check out date 
    }

    public ArrayList<Room> rooms(){
        return listOfRooms; // list of rooms 
    }

    public Room room(){
        return room; // what room customer books
    }

    public String displayConfirmation(Reservation reserved){
        return "Customer name: " + reserved.guestName()
            + "\nSuite: " + reserved.room().getRoomName()
            + "\nCheck in: " + reserved.checkInDate.getMonth() + " | " + reserved.checkInDate.getDay() + " | " + reserved.checkInDate.getYear() 
            + "\nExpected check out: " + reserved.checkOutDate().getMonth() + " | " + reserved.checkOutDate.getDay() + " | " + reserved.checkOutDate.getYear()
            + "\n*-----------------------------------*\n"
            + "Total price: " + reserved.TotalPrice();

    }


}
