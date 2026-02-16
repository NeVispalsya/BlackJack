package service;

import dto.Card;
import dto.Rank;
import dto.Suit;
import exception.DeckException;

import java.util.Collections;
import java.util.Stack;

public class DeckService {
    private Stack<Card> deck = new Stack<>();

    public void createDeck(int deckNumber) throws DeckException {
        deck.clear();

        if (deckNumber < 1 || deckNumber > 8){
            throw  new DeckException("Number og deck must be between 1 to 8");
        }

        for (int i = 0; i < deckNumber; i++){
            for (Rank rank : Rank.values()){
                for (Suit suit : Suit.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Stack<Card> getDeck(){
        return deck;
    }

    public int getCardCount(){
        return deck.size();
    }

    public Card dealCard(){
        return deck.pop();
    }

}
