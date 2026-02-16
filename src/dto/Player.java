package dto;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int numberOfGames = 0;
    private int numberOfWins = 0;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", numberOfGames=" + numberOfGames +
                ", numberOfWins=" + numberOfWins +
                ", hand=" + hand +
                '}';
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }
    public void incrementNumberOfWins() {
        numberOfWins++;
    }
    public void clearHand(){
        hand.clear();
    }

}
