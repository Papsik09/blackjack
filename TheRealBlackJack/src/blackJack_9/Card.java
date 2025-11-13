package blackJack_9;

public class Card {
	//Values from deck
    private String suit;
    private String rank;
    private int value;

    
     public Card(String suit, String rank, int value) {
    	 
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        
    }
     public getValue() {
    	 return value;
     }
}