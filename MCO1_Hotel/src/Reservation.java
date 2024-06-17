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
        this.totalPrice = 1299.0;
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
        return listOfRooms;
    }

    public Room room(){
        return room; // what room customer books
    }


}
