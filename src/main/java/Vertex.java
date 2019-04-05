
/**
 * @author  ntobekomkhize@yahoo.com || mkhizenj@gmail.com
 * <p>
 */
public class Vertex {

    private int x;
    private int y;
    private int dist;

    Vertex( int y, int x,int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
}
