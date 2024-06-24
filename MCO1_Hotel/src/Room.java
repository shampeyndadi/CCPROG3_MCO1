class Room {

    private String roomName;
    private double basePrice;
    private boolean availability;

    public Room (String roomName ) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.availability = true;
    }

    public void updateBasePrice (double newPrice) {
        this.basePrice = newPrice;
    }

    public void changeAvailability(boolean status){
        this.availability = status;
    }

    public double getRoomPrice(){
        return basePrice;
    }

    public String getRoomName(){
        return roomName;
    }

    public boolean getAvailability(){
        return availability;
    }
    

}
