import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLevelLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        // Pengaturan jendela
        setTitle("Character Manager");
        setSize(850, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "DAFTAR KARAKTER",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        // Panel daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );
        characterPanel.setBackground(Color.WHITE);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // Scroll untuk daftar karakter
        JScrollPane scrollPane = new JScrollPane(characterPanel);

        // Label statistik rata-rata level
        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );
        averageLevelLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        // Tombol untuk memperbarui tampilan
        JButton refreshButton = new JButton("Refresh Data");
        refreshButton.addActionListener(e -> displayCharacters());

        // Panel bawah: statistik dan tombol
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(averageLevelLabel, BorderLayout.CENTER);
        bottomPanel.add(refreshButton, BorderLayout.EAST);

        // Menambahkan komponen ke jendela
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Menampilkan data saat aplikasi dibuka
        displayCharacters();
    }

    private void displayCharacters() {
        // Membersihkan daftar lama
        characterPanel.removeAll();

        // Menampilkan semua karakter dari CharacterManager
        for (Character character : manager.getAllCharacters()) {
            JLabel characterLabel = new JLabel(character.toString());

            characterLabel.setFont(
                    new Font("Arial", Font.PLAIN, 14)
            );
            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            characterLabel.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    )
            );

            characterPanel.add(characterLabel);
            characterPanel.add(Box.createVerticalStrut(5));
        }

        // Pesan jika belum ada karakter
        if (manager.getTotalCharacters() == 0) {
            JLabel emptyLabel = new JLabel(
                    "Belum ada karakter yang ditambahkan."
            );
            characterPanel.add(emptyLabel);
        }

        // Menghitung dan menampilkan rata-rata level
        double average = manager.getAverageLevel();

        averageLevelLabel.setText(
                String.format(
                        Locale.US,
                        "Rata-rata Level: %.2f",
                        average
                )
        );

        // Memperbarui tampilan
        characterPanel.revalidate();
        characterPanel.repaint();
        averageLevelLabel.revalidate();
        averageLevelLabel.repaint();
    }
}
