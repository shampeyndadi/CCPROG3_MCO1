class Room {

    private String roomName ;
    private double basePrice;

    public Room (String roomName ) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
    }

    public void updateBasePrice (double newPrice) {
        this.basePrice = newPrice;
    }

    public double getRoomPrice(){
        return basePrice;
    }

    public String getRoomName(){
        return roomName;
    }



}
