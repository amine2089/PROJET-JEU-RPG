package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Play02GUI extends JFrame {

    // Game elements
    private Personnage joueur, guerrier, mage, voleur, Beast, Robot, chevalier;
    private Personnage[] allCharacters;
    
    // UI components
    private JLabel playerNameLabel, enemyNameLabel, playerHealthLabel, enemyHealthLabel;
    private JTextArea actionArea;
    private JButton attackButton, specialButton, healButton, skipButton;
    private JProgressBar playerHealthBar, enemyHealthBar;
    private JComboBox<String> enemySelectBox;
    private JPanel actionPanel, topPanel, bottomPanel;
    private CardLayout cardLayout;
    private JPanel mainPanel, gamePanel, characterSelectionPanel;
    
    public Play02GUI() {
        // Initialize characters
        guerrier = new Guerrier("Thor");
        mage = new Mage("Gandalf");
        voleur = new Voleur("Loki");
        Beast = new Beast("Chimera");
        Robot = new Robot("Optimus Prime");
        chevalier = new Chevalier("Alexander");

        allCharacters = new Personnage[] {guerrier, mage, voleur, Beast, Robot, chevalier};
        
        // Window setup
        setTitle("Combat Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CardLayout for switching between panels (Character Selection and Game)
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Character selection screen
        characterSelectionPanel = createCharacterSelectionPanel();
        mainPanel.add(characterSelectionPanel, "Character Selection");

        // Game screen
        gamePanel = createGamePanel();
        mainPanel.add(gamePanel, "Game");
        
        add(mainPanel);
    }

    // Method to create the character selection screen
    private JPanel createCharacterSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        
        JLabel title = new JLabel("Choose Your Character", JLabel.CENTER);
        panel.add(title);
        
        for (Personnage p : allCharacters) {
            JButton button = new JButton(p.getNom());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startGame(p);
                    cardLayout.show(mainPanel, "Game");
                }
            });
            panel.add(button);
        }
        
        return panel;
    }

    // Method to create the game screen
    private JPanel createGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Top Panel (Player and Enemy health and names)
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));

        // Player Health
        JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playerNameLabel = new JLabel("Player: ");
        playerHealthLabel = new JLabel("HP: ");
        playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setStringPainted(true);
        playerPanel.add(playerNameLabel);
        playerPanel.add(playerHealthLabel);
        playerPanel.add(playerHealthBar);

        // Enemy Health
        JPanel enemyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        enemyNameLabel = new JLabel("Enemy: ");
        enemyHealthLabel = new JLabel("HP: ");
        enemyHealthBar = new JProgressBar(0, 100);
        enemyHealthBar.setStringPainted(true);
        enemyPanel.add(enemyNameLabel);
        enemyPanel.add(enemyHealthLabel);
        enemyPanel.add(enemyHealthBar);

        topPanel.add(playerPanel);
        topPanel.add(enemyPanel);

        // Action Log (Game activity updates)
        actionArea = new JTextArea(10, 30);
        actionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(actionArea);

        // Action Buttons
        actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(1, 4));

        attackButton = new JButton("Attack");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction(1);
            }
        });

        specialButton = new JButton("Special");
        specialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction(2);
            }
        });

        healButton = new JButton("Heal");
        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction(3);
            }
        });

        skipButton = new JButton("Skip Turn");
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction(4);
            }
        });

        actionPanel.add(attackButton);
        actionPanel.add(specialButton);
        actionPanel.add(healButton);
        actionPanel.add(skipButton);

        // Character Select for Enemy
        JPanel enemySelectionPanel = new JPanel(new FlowLayout());
        enemySelectionPanel.add(new JLabel("Choose Enemy: "));
        String[] enemyNames = {"Thor", "Gandalf", "Loki", "Chimera", "Optimus Prime", "Alexander"};
        enemySelectBox = new JComboBox<>(enemyNames);
        enemySelectionPanel.add(enemySelectBox);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(enemySelectionPanel, BorderLayout.NORTH);
        bottomPanel.add(actionPanel, BorderLayout.CENTER);
        bottomPanel.add(scrollPane, BorderLayout.SOUTH);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);

        return panel;
    }

    // Start the game after character selection
    public void startGame(Personnage selectedPersonnage) {
        joueur = selectedPersonnage;
        actionArea.setText("The game has started! You are " + joueur.getNom() + ".\n");

        // Set enemy to a default enemy
        updateEnemy(guerrier);
        updateUI();
        
        // Start the game loop
        gameLoop();
    }

    private void updateEnemy(Personnage enemy) {
        enemyNameLabel.setText("Enemy: " + enemy.getNom());
        enemyHealthBar.setValue(enemy.pointsDeVie);
        enemyHealthLabel.setText("HP: " + enemy.pointsDeVie);
    }

    private void updateUI() {
        playerNameLabel.setText("Player: " + joueur.getNom());
        playerHealthBar.setValue(joueur.pointsDeVie);
        playerHealthLabel.setText("HP: " + joueur.pointsDeVie);
    }

    private void performAction(int actionType) {
        switch (actionType) {
            case 1: // Attack
                attack();
                break;
            case 2: // Special Skill
                specialAttack();
                break;
            case 3: // Heal
                heal();
                break;
            case 4: // Skip turn
                skipTurn();
                break;
            default:
                break;
        }
    }

    private void attack() {
        Personnage enemy = allCharacters[enemySelectBox.getSelectedIndex()];
        joueur.attaquer(enemy);
        actionArea.append(joueur.getNom() + " attacks " + enemy.getNom() + ". " + enemy.getNom() + " now has " + enemy.pointsDeVie + " HP.\n");
        updateUI();
        updateEnemy(enemy);
        checkGameOver();
        enemyTurn();
    }

    private void specialAttack() {
        Personnage enemy = allCharacters[enemySelectBox.getSelectedIndex()];
        joueur.utiliserCompetence(enemy);
        actionArea.append(joueur.getNom() + " uses a special skill on " + enemy.getNom() + ".\n");
        updateUI();
        updateEnemy(enemy);
        checkGameOver();
        enemyTurn();
    }

    private void heal() {
        joueur.gagnerpointsdevie(25);
        actionArea.append(joueur.getNom() + " heals. Now has " + joueur.pointsDeVie + " HP.\n");
        updateUI();
        enemyTurn();
    }

    private void skipTurn() {
        actionArea.append(joueur.getNom() + " skips the turn.\n");
        enemyTurn();
    }

    private void enemyTurn() {
        // Simulate a random action by the enemy
        Personnage enemy = allCharacters[enemySelectBox.getSelectedIndex()];
        int action = new Random().nextInt(3);  // Attack, special, or heal
        switch (action) {
            case 0: // Attack
                enemy.attaquer(joueur);
                actionArea.append(enemy.getNom() + " attacks " + joueur.getNom() + ".\n");
                break;
            case 1: // Special
                enemy.utiliserCompetence(joueur);
                actionArea.append(enemy.getNom() + " uses a special skill on " + joueur.getNom() + ".\n");
                break;
            case 2: // Heal
                enemy.gagnerpointsdevie(20);
                actionArea.append(enemy.getNom() + " heals. Now has " + enemy.pointsDeVie + " HP.\n");
                break;
        }
        updateUI();
        checkGameOver();
        gameLoop();
    }

    // Check if the game is over (either player or enemy health <= 0)
    private void checkGameOver() {
        if (joueur.pointsDeVie <= 0) {
            actionArea.append(joueur.getNom() + " has been defeated! Game Over.\n");
            JOptionPane.showMessageDialog(this, "You lose! Game Over.");
            System.exit(0); // End game
        } else if (allCharacters[enemySelectBox.getSelectedIndex()].pointsDeVie <= 0) {
            actionArea.append("You defeated the enemy! You win!\n");
            JOptionPane.showMessageDialog(this, "You win!");
            System.exit(0); // End game
        }
    }

    // Game loop
    private void gameLoop() {
        if (joueur.pointsDeVie > 0 && allCharacters[enemySelectBox.getSelectedIndex()].pointsDeVie > 0) {
            // Continue to alternate turns between player and enemy
            attackButton.setEnabled(true);
            specialButton.setEnabled(true);
            healButton.setEnabled(true);
            skipButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Play02GUI game = new Play02GUI();
                game.setVisible(true);
            }
        });
    }
}
