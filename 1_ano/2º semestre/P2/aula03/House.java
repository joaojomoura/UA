import static java.lang.System.*;

public class House {
    private String type;
    private Room [] div, newdiv;
    private int size = 0, ndiv = 8;

    /**Constructor house with a single string */
    House (String type) {
        if(this.type.equalsIgnoreCase("apartment") || this.type.equalsIgnoreCase("house"))
            this.type = type;
        else {
            err.println("Nome Invalido");
            exit(1);
        }
        div = new Room [ndiv];
        
    }
    /** Constructor House with a string, one int of inicial memory to store, and another
     * int for additional memory space
     * @param String type
     * @param int div_i
     * @param int div_f
     */
    House (String type, int div_i, int div_f) {
        if(type.equalsIgnoreCase("apartment") || type.equalsIgnoreCase("house"))
            this.type = type;
        else {
            err.println("Nome Invalido");
            exit(1);
        }
        div = new Room [div_i];
        newdiv = new Room [div_i + div_f];
    }
    //Method to add a room and increases the size of rooms in the house. it returns the size value
    public int addRoom (Room n) {
        if(size < div.length) {
            div[size] = n;
            out.println(div[size].area());
            size++;
            return size;
        }
        if (size == div.length) {
            for (int i = 0; i < div.length;i++)
                newdiv[i] = div[i];
        }
        newdiv[size] = n;
        size ++;
            
        return size;
    }

    /**Returns the room in question @return newdiv[n] or @return div[n] */
    public Room room (int n) {
        if(size < div.length)
            return div[n];
        return newdiv[n];
    }
    /**Sum of all the areas of the house, @return area */
    public double area() {
        double area = 0;
        if(size < div.length){
            for(int i = 0; i < size; i++)
                area += div[i].area();
            return area;}

        for(int i = 0; i < size; i++){
            area += newdiv[i].area();}
        
        return area;
    }
    /**@return String type  */
    public String type() {
        return type;
    }
    /**@return int size */
    public int size () {
        return size;
    }
    /**returns the max size of the house @return div.lenght or @return newdiv.length */
    public int maxSize() {
        if(size < div.length)
            return div.length;
        return newdiv.length;
    }

    public RoomTypeCount [] getRoomTypeCounts() {
        RoomTypeCount [] r = new RoomTypeCount [size];
        if(size < div.length) {
            for (int i = 0; i < size;i++) {
                RoomTypeCount room = new RoomTypeCount();
                room.roomType = div[i].roomType();
                room.count = 1; 
                for(int j = i+1; j < size; j++)
                    if(room.roomType.equals(div[j].roomType()))
                        room.count++;
                r[i] = room;
            }
            return r;
        }
        
        
        for (int i = 0; i < size;i++) {
            RoomTypeCount room = new RoomTypeCount();
            room.roomType = newdiv[i].roomType();
            room.count = 0;
            
            for(int j = i; j < size; j++)
                if(room.roomType.equals(newdiv[j].roomType())){
                    room.count++;
                }
            
            r[i] = room;
        }
        return r;
    }

    public double averageRoomDistance() {
        double media = 0;
        int sum;
        for (int i = 0; i < size; i++)
            sum += newdiv[i].geomCenter();

        return media;
    }
}