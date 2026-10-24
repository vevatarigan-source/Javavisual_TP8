import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            manager.addCharacter(
                new Character("Aragorn", CharacterType.WARRIOR, 5));
            manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 8));
            manager.addCharacter(
                new Character("Legolas", CharacterType.ARCHER, 6));
            manager.addCharacter(
                new Character("Gandalf", CharacterType.MAGE, 7));
            manager.addCharacter(
                new Character("Thorin", CharacterType.WARRIOR, 10));

            // Periksa apakah data sudah masuk
            System.out.println("Total karakter: "
                    + manager.getTotalCharacters());

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
