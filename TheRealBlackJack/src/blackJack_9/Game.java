package blackJack_9;

public class Game {

	    private Deck deck = new Deck();
	    private Player player = new Player("Gamer");
	    private Dealer dealer = new Dealer(deck);
	    
	    public void startGame() {
	    	player.reset();
	    	dealer.reset();
	    	
	    	//take cards
	        for (int i = 0; i < 2; i++) {
	            player.hit(deck);
	            dealer.hit(deck);
	    	
	    	//Input name of player? Clean hands. Deal cards?
	    }
}
	    //-----------------------------------------------------------
	    public String checkWinner() {
	        int p = player.getScore(), d = dealer.getScore();
	        	if (p > 21) {
	        		return "Player Busts! Dealer Wins!";
	        	}
	        	if (d > 21) {
	        		return "Dealer Busts! Player Wins!";
	        	}
	        	if (p == d) {
	        		return "It's a Tie!";
	        	}
	        	
	        return (p > d) ? "Player Wins!" : "Dealer Wins!";
	    }
	    
	    public void playerHit() {
	        player.hit(deck);
	    }

	    public void dealerTurn() {
	        dealer.autoPlay(player);
	    }

	    public int getPlayerScore() {
	        return player.getScore();
	    }

	    public int getDealerScore() {
	        return dealer.getScore();
	    }

	    public java.util.List<Card> getPlayerCards() {
	        return player.getHand();
	    }

	    public java.util.List<Card> getDealerCards() {
	        return dealer.getHand();
	    }

	    public boolean isPlayerBusted() {
	        return player.getScore() > 21;
	    }

	    public boolean isDealerBusted() {
	        return dealer.getScore() > 21;
	    }
}
	
