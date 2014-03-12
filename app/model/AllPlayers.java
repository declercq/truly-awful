package model;

import java.util.Collection;
import java.util.HashMap;

public class AllPlayers {
    //Player database
    //really just a hashmap - will be a database later
    //need it to be a singleton now - like how db will be used

    private static int nextID= 1;
    private static HashMap<Integer, Player> allPlayers = new HashMap<Integer, Player>();

    public static boolean createPlayer(String name) {
        if (nextID<0) {
            return false; //wrapped - YAY!! more than 2 billion users!!
        }
        synchronized(AllPlayers.class) {
            allPlayers.put(nextID, new Player(nextID, name));
            nextID++;
        }
        return true;
    }

//IGNORE LOCATION FOR CLOSED BETA!!!
//    public static void setLocation(int id, Location location) {
//        synchronized (AllPlayers.class) {
//            allPlayers.get(id).location = location;
//        }
//    }
//
//    //return a collection of the closest players, sorted by distance
//    public static Collection<Player> findNearby(Location location, int maxDistance, int maxPlayers) {
//        //IMPLEMENT
//        return null;
//    }

    public static boolean alterPlayer(int id, String name) {
        Player p;
        synchronized (AllPlayers.class) {
            p = allPlayers.get(id);
        }
        if (p != null) {
            p.name = name;
            return true;
        }
        return false;
    }

    //return a list of players so that they can be invited to a game
    //keep it simple for now (closed beta)
    public static Collection<Player> getPlayers() {
        synchronized (AllPlayers.class) {
            return allPlayers.values();
        }
    }

    //null if not found
    public static Player getPlayer(int playerID) {
        synchronized (AllPlayers.class) {
            return allPlayers.get(playerID);
        }
    }
}