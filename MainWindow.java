
package model.view;

import javax.swing.*;
import java.awt.*;

import model.Character;
import model.CharacterManager;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLevelLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel(
                "DAFTAR KARAKTER", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10));

        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(new Font("Arial", Font.BOLD, 15));
        averageLevelLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JButton refreshButton = new JButton("Refresh Data");
        refreshButton.addActionListener(e -> displayCharacters());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(averageLevelLabel, BorderLayout.CENTER);
        bottomPanel.add(refreshButton, BorderLayout.EAST);

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        displayCharacters();
    }

    private void displayCharacters() {
        characterPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            JLabel characterLabel = new JLabel(character.toString());
            characterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 8, 8, 8));

            characterPanel.add(characterLabel);
        }

        double average = manager.getAverageLevel();
        averageLevelLabel.setText(
                String.format(
                        java.util.Locale.US,
                        "Rata-rata Level: %.2f",
                        average));

        characterPanel.revalidate();
        characterPanel.repaint();
        averageLevelLabel.revalidate();
        averageLevelLabel.repaint();
    }
}

