package blackJack_9;

public class Player {
	String name;
	Hand hand = new Hand();
	
	public Player(String name) {
		this.name = name; // somehow create input of name?
	}
	
	
	
	
	
	
	
	
	
	
	//------------------------------------
    public int getScore() { 
    	return hand.getTotalValue(); 
    }
    
	public void hit(Deck deck) {
		hand.addCard(deck.dealCard());
	}
	
	public void stand(){
		
	}
	
	public void reset() {
		hand.clear();
	}
	
	public java.util.List<Card> getHand() {
	    return hand.getCards();
	}

	//TODO: buttons for hit,stand,reset. also dui for score???
}
