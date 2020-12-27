package domain;

public class Punt2D {
    private int X, Y;

    public Punt2D(int X, int Y){
        setX(X);
        setY(Y);

    }
    public Punt2D(){
        setX(0);
        setY(0);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        if (x < 0){
            throw new IllegalArgumentException("x moet groter zijn dan 0");
        }
        else {
            X = x;
        }
    }

    public void setY(int y) {
        if (y < 0){
            throw new IllegalArgumentException("x moet groter zijn dan 0");
        }
        else {
            Y = y;
        }
    }
    public Punt2D moveHorizontaal(int move){

        return new Punt2D(X + move,Y);
    }
    public Punt2D moveVerticaal(int move){
        return new Punt2D(X,Y + move);
    }
    public boolean ligtLinksVan(Punt2D punt1){
        if(punt1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            return (this.X < punt1.X);
        }
    }
    public boolean ligtRechtsVan(Punt2D punt1){
        if(punt1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            return (this.X > punt1.X);
        }
    }
    public boolean ligtHoger(Punt2D punt1){
        if(punt1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            return (this.Y < punt1.Y);
        }
    }
    public boolean ligtLager(Punt2D punt1){
        if(punt1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            return (this.Y > punt1.Y);
        }
    }
    public boolean heeftZelfdeCoordinatenAls(Punt2D punt1){
        if(punt1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            return (this.X == punt1.X) && (this.Y == punt1.Y);
        }
    }
    public int berekenAfstandTot(Punt2D p1){
        if(p1 == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        }else {
            int result;
            if (((int) Math.pow(this.X - p1.X, 2) - (int) Math.pow(this.Y - p1.Y, 2)) > ((int) Math.pow(this.Y - p1.Y, 2)- (int) Math.pow(this.X - p1.X, 2))) {

                result = (int) Math.sqrt((int)Math.pow(this.X - p1.X, 2) + (int)Math.pow(this.Y - p1.Y, 2));
                return result;
            } else {
                result = (int) Math.sqrt((int)Math.pow(this.Y - p1.Y, 2) + (int)Math.pow(this.X - p1.X, 2));
                return result;
            }
        }
    }
    public String format() {
        return "(" + this.X + " , " + this.Y + ")";
    }
}

