package model;

import java.util.Collection;
import java.util.LinkedList;

public class PartyModeGame {
    //list of players
    //player scores
    //round count (how to handle partial?)
    //termination condition (rounds played, first player to X points, when there is X% players voting to end)
    //cards used
    //decks (expansions) being used
    //may need some sort of game builder (hold game data as it is being constructed)

    private final int id;
    Collection<Player> players = new LinkedList<Player>();

    public PartyModeGame(int id){
        this.id = id;
    }

    public synchronized void addPlayer(Player player) {
        players.add(player);
    }

    public boolean startGame() {
        //start the game and notify the players
    }

}
