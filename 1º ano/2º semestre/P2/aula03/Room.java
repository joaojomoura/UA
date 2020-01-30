public class Room {
    private Point i_e = new Point();
    private Point s_d = new Point();
    private String type;

    Room(Point i_e, Point s_d, String type) {
        this.i_e = i_e;
        this.s_d = s_d;
        this.type = type;
    }

    public String roomType() {
        return type.toLowerCase();
    }
    public Point bottomLeft() {
        return i_e;
    }
    public Point topRight() {
        return s_d;
    }
    public Point geomCenter() {
        return i_e.halfWayTo(s_d);
    }
    public double area() {
        return (s_d.x() - i_e.x()) * (s_d.y() - i_e.y());
    }

    
    
}