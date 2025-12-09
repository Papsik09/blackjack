package blackJack_9;

import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGUI extends JFrame {
	

    private Game game = new Game();
    //Title
    private JPanel titlePanel = new JPanel();
    private JTextArea display = new JTextArea(15, 30);
    //Buttons
    private JButton startBtn = new JButton("Start");
    private JButton hitBtn = new JButton("Hit");
    private JButton standBtn = new JButton("Stand");
    //Players panel
    private JPanel dealerPanel = new JPanel();
    private JPanel playerPanel = new JPanel(); 
    //Dealer stats
    private JLabel dealerLabel = new JLabel("Dealer");
    private JLabel dealerTotalLabel = new JLabel("Total: 0");
    //Player Stats
    private JLabel playerNameLabel = new JLabel("Player");
    private JLabel playerTotalLabel = new JLabel("Total: 0");
    private JLabel winsLabel = new JLabel("Wins: 0");
    private JLabel lossesLabel = new JLabel("Loses: 0");

    public GameGUI() {
        super("BLACKJACK V2");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());
        dealerPanel.setBackground(new Color(0, 128, 0));
        playerPanel.setBackground(new Color(0, 128, 0));
        //----------------------------------------------
        // TOP TITLE
        titlePanel.setBackground(Color.WHITE);
        JLabel titleBlack = new JLabel("=BLACK ");
        titleBlack.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        titleBlack.setForeground(Color.BLACK);
        
        JLabel titleJack = new JLabel("JACK=");
        titleJack.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
        titleJack.setForeground(Color.RED);
        titlePanel.add(titleBlack);
        titlePanel.add(titleJack);
        //
        add(titlePanel, BorderLayout.NORTH);
        //-------------------------------------------------
        
        
        dealerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        display.setOpaque(false);
        display.setForeground(Color.WHITE);
        
        JScrollPane scroll = new JScrollPane(display);
        scroll.getViewport().setBackground(new Color(0, 60, 0));
        scroll.setBackground(new Color(0, 60, 0));
        
        //Cards Display
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(0, 128, 0));
//---------------------------------------------------------------
     // ===== DEALER INFO =====
        JPanel dealerInfoPanel = new JPanel();
        dealerInfoPanel.setBackground(new Color(0, 128, 0));
        dealerInfoPanel.setLayout(new BoxLayout(dealerInfoPanel, BoxLayout.Y_AXIS));

        // label styles
        dealerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        dealerLabel.setForeground(Color.WHITE);
        dealerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        dealerTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        dealerTotalLabel.setForeground(Color.WHITE);
        dealerTotalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // add to info panel
        dealerInfoPanel.add(dealerLabel);
        dealerInfoPanel.add(dealerTotalLabel);

        // wrapper for dealer info + cards
        JPanel dealerSection = new JPanel(new BorderLayout());
        dealerSection.setBackground(new Color(0, 128, 0));
        dealerSection.add(dealerInfoPanel, BorderLayout.NORTH);
        dealerSection.add(dealerPanel, BorderLayout.CENTER);

        // add to center panel
        centerPanel.add(dealerSection, BorderLayout.NORTH);

//-----------------PROGRESS^^
     // ===== PLAYER INFO (Player + Total) =====(copy of dealer)
        JPanel playerInfoPanel = new JPanel();
        playerInfoPanel.setBackground(new Color(0, 128, 0));
        playerInfoPanel.setLayout(new BoxLayout(playerInfoPanel, BoxLayout.Y_AXIS));
        

        playerNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        playerTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        playerTotalLabel.setForeground(Color.WHITE);
        playerTotalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

     // add to info panel
        playerInfoPanel.add(playerNameLabel);
        playerInfoPanel.add(playerTotalLabel);

     // ===== SCORE PANEL (Wins / Loses) =====
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBackground(new Color(0, 128, 0));

        winsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        winsLabel.setForeground(Color.ORANGE);
        winsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lossesLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lossesLabel.setForeground(Color.ORANGE);
        lossesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scorePanel.add(winsLabel);
        scorePanel.add(lossesLabel);

        // ===== PLAYER SECTION (info + cards) =====
        JPanel playerSection = new JPanel(new BorderLayout());
        playerSection.setBackground(new Color(0, 128, 0));

        playerSection.add(playerInfoPanel, BorderLayout.NORTH);
        playerSection.add(playerPanel, BorderLayout.CENTER);

        // Add score panel inside player section
        playerSection.add(scorePanel, BorderLayout.EAST);

        // Add player section to center panel
        centerPanel.add(playerSection, BorderLayout.CENTER);
        

//-------------------------------------------------------------------
        
        centerPanel.add(scroll, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        //bUTTON PANELS
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 128, 0));
        buttonPanel.add(startBtn);
        buttonPanel.add(hitBtn);
        buttonPanel.add(standBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initially only Start is enabled
        hitBtn.setEnabled(false);
        standBtn.setEnabled(false);

        // Button actions
        startBtn.addActionListener(e -> {
            game.startGame();
            startBtn.setEnabled(false);
            hitBtn.setEnabled(true);
            standBtn.setEnabled(true);
            refreshDisplay(false);
        });

        hitBtn.addActionListener(e -> {
            game.playerHit();
            
            if (game.isPlayerBusted()) {
                game.dealerTurn();
                refreshDisplay(true);
                display.append("\n" + game.checkWinner() + "\n");
                hitBtn.setEnabled(false);
                standBtn.setEnabled(false);
                startBtn.setEnabled(true);
            } 
            else {
                refreshDisplay(false);
            }
        });

        standBtn.addActionListener(e -> {
            game.dealerTurn();
            refreshDisplay(true);
            display.append("\n" + game.checkWinner() + "\n");
            hitBtn.setEnabled(false);
            standBtn.setEnabled(false);
            startBtn.setEnabled(true);
        });
    }

    private void refreshDisplay(boolean revealDealer) {
    	dealerPanel.removeAll();//clears cards
    	playerPanel.removeAll();

       

        List<Card> playerCards = game.getPlayerCards();
        List<Card> dealerCards = game.getDealerCards();

 
        for (int i = 0; i < dealerCards.size(); i++) {
        	//pictures of card
        	JLabel img;
        	
            // hide only the second card if dealer should stay hidden
            if (!revealDealer && i == 1) {
            	img = new JLabel(loadScaledImage("/images/BACK.png"));

            } else {
            	img = new JLabel(loadCardImage(dealerCards.get(i)));
            }
            dealerPanel.add(img);
        }
        

     // Player cards
        for (Card c : playerCards) {
            JLabel img = new JLabel(loadCardImage(c));
            playerPanel.add(img);
        }
        //Updates score for dealer on left side
        if (revealDealer) {
            dealerTotalLabel.setText("Total: " + game.getDealerScore());
        } else {
            dealerTotalLabel.setText("Total: ??");
        }

        // Update panels
        dealerPanel.revalidate();
        dealerPanel.repaint();
        playerPanel.revalidate();
        playerPanel.repaint();
    }
    
    //build a file for scaler and call card image
    private ImageIcon loadCardImage(Card c) {
        String fileName = "/images/" + c.getImageName();
        
        return loadScaledImage(fileName);
    }
    
    //scale picture for proper size
    private ImageIcon loadScaledImage(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        
        Image scaled = icon.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH); // scaled to 70.100
        return new ImageIcon(scaled);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI();
            gui.setVisible(true);
        });
        
    }
}
