package service;

import dto.Card;
import dto.GameResult;
import dto.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameService {

    public int calculateHandScore(List<Card> hand){
        int score = 0;
        for (Card card : hand){
            score += card.getCost();
        }

        //isBlackJack
        if (hand.size() == 2 && isBalacJack(score)){
            return 21;
        }

        return score;
    }

    private boolean isBalacJack(int score) {
        return score == 22;
    }

    public int getComputerScore(){
        return new Random().nextInt(17,28);
    }

    public List<Card> getComputerHand(Stack<Card> deck){
        List<Card> computerHand = new ArrayList<>();
        int numberOfCard = new Random().nextInt(2, 6);
        for (int i = 0; i < numberOfCard; i++){
            computerHand.add(deck.pop());
        }
        return computerHand;
    }
    public GameResult getGameResult(int pScore, int cScore, Player player){
        int bid = player.getBalance();
        if (pScore > 21 && cScore > 21) {
             bid-= 100;
             player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.LOSE;
        } else if (cScore > 21) {
            bid += 100;
            player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.PLAYER;
        } else if (pScore > 21) {
            bid -= 100;
            player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.COMPUTER;
        } else if (pScore > cScore) {
            bid += 100;
            player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.PLAYER;
        } else if (cScore > pScore){
            bid -= 100;
            player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.COMPUTER;
        } else {
            bid -= 10;
            player.setBalance(bid);
            System.out.println("Your new balance: "+bid);
            return GameResult.DRAW;
        }
    }
}
