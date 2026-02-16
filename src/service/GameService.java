package service;

import dto.Card;
import dto.GameResult;

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
    public GameResult getGameResult(int pScore, int cScore){

        if (pScore > 21 && cScore > 21) {
            return GameResult.LOSE;
        } else if (cScore > 21) {
            return GameResult.PLAYER;
        } else if (pScore > 21) {
            return GameResult.COMPUTER;
        } else if (pScore > cScore) {
            return GameResult.PLAYER;
        } else if (cScore > pScore){
            return GameResult.COMPUTER;
        } else {
            return GameResult.DRAW;
        }
    }
}
