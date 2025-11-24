package blackJack_9;

import java.util.*;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<>();
	
	public int getTotalValue() {
	    int score = 0;
	    for (Card card : cards) {
	        score += card.getValue();
	    }
	    return score;
	}
    public void addCard(Card card) { 
    	cards.add(card); 
    	}
    public void clear() {
    	cards.clear();
    }
    //------------------------
    public java.util.List<Card> getCards() {
        return cards;
    }

    
   
}
