package blackJack_9;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGUI extends JFrame {

    private Game game = new Game();

    private JTextArea display = new JTextArea(15, 30);
    private JButton startBtn = new JButton("Start");
    private JButton hitBtn = new JButton("Hit");
    private JButton standBtn = new JButton("Stand");

    public GameGUI() {
        super("BLACKJACK V1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(display), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
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
            } else {
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
        display.setText("");

        List<Card> playerCards = game.getPlayerCards();
        List<Card> dealerCards = game.getDealerCards();

        display.append("Dealer: ");
        for (int i = 0; i < dealerCards.size(); i++) {
            if (!revealDealer && i == 1) {
                display.append("[Hidden] ");
            } else {
                display.append(dealerCards.get(i).shortName() + " ");
            }
        }
        display.append("\n");

        display.append("Player: ");
        for (Card c : playerCards) {
            display.append(c.shortName() + " ");
        }
        display.append("\n");

        display.append("\nScores: ");
        display.append("Player " + game.getPlayerScore());
        display.append(", Dealer " + (revealDealer ? game.getDealerScore() : "??"));
        display.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI();
            gui.setVisible(true);
        });
    }
}
