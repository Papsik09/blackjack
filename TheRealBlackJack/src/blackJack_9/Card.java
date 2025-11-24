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
     
     public int getValue() {
    	 return value;
     }
     
     
  // In Card.java -------------------------------------
     public String shortName() {
         String sym;
         switch (suit) {
             case "Hearts": sym = "♥"; break;
             case "Diamonds": sym = "♦"; break;
             case "Clubs": sym = "♣"; break;
             case "Spades": sym = "♠"; break;
             default: sym = suit;
         }
         return rank + sym;
     }

}