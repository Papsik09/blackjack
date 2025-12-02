package blackJack_9;

import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};   
        
        // TODO: Create loops to adjust values for ranks.
	    //First loop will be suits, then ranks. It will give each rank a  suit. Add math value to ranks.
	    // Also should be a logic dealCard(), which also will delete card from list.
	    for (String suit : suits) {
	    	for(String rank : ranks) { // Nested loop creates 52 cards
	    		int value = 0;
	    		if(rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
	    			value = 10;
	    		
	    		}else if(rank.equals("A")) {
	    			value = 11;//check ace
	    			
	    		}else { //regular numbers
	    			 value = Integer.valueOf(rank); //example "1" -> 1
	    		}
	    		cards.add(new Card(suit, rank, value)); 
	    		
	    	}
	    }
	    shuffle();
    }
    
//Shuffle deck
public void shuffle() { 
	Collections.shuffle(cards); 
	}
//Deal card
 public Card dealCard() {
	 return cards.remove(0);
 	}
}