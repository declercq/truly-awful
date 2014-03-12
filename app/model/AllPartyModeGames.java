package model;

import java.util.HashMap;

public class AllPartyModeGames {

    private static HashMap<Integer, PartyModeGame> allGames = new HashMap<Integer, PartyModeGame>();
    private static int nextID= 1;

    //may take more game parameters later
    public static boolean createGame(int playerID) {
        if (nextID<0) {
            return false; //wrapped - YAY!! more than 2 billion users!!
        }
        synchronized(AllPartyModeGames.class) {
            allGames.put(nextID, new PartyModeGame(nextID));
            nextID++;
        }
        return true;
    }

    public static boolean invitePlayer(int gameID, int playerID) {
        boolean found;
        synchronized (AllPartyModeGames.class) {
            found = (allGames.containsKey(gameID));
        }
        if (found) {
            <send invite to playerID>
            return true;
        }
        return false;
    }

    public static boolean acceptInvitation(int gameID, int playerID) {
        PartyModeGame game;
        synchronized (AllPartyModeGames.class) {
            game = allGames.get(gameID);
        }
        if (game != null) {
            Player player = AllPlayers.getPlayer(playerID);
            if (player != null) {
                game.addPlayer(player);
                <update game creator (and all other players )>
                return true;
            }
        }
        return false;
    }

    public static boolean startGame(int gameID) {
        PartyModeGame game;
        synchronized (AllPartyModeGames.class) {
            game = allGames.get(gameID);
        }
        if (game != null) {
            <start game logic>
            <notify all players>
            return true;
        }
        return false;
    }

}
