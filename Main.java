
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Character Manager");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
            );

            panel.add(new JLabel("DAFTAR KARAKTER"));
            panel.add(new JLabel(
                "Nama: Aragorn | Tipe: WARRIOR | Level: 5"
            ));
            panel.add(new JLabel(
                "Nama: Merlin | Tipe: MAGE | Level: 8"
            ));
            panel.add(new JLabel(
                "Nama: Legolas | Tipe: ARCHER | Level: 6"
            ));

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
