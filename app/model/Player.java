package model;

public class Player {
    public final int id; //must be unique, doesn't have
    public Location location;
    public String name;
    //boolean isOnline

    @Override
    public boolean equals(Object e) {
        return (e instanceof Player && ((Player)e).id == id);
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}