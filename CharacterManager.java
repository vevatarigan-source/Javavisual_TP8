import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        if (character == null) {
            System.out.println("Karakter tidak boleh null.");
            return;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Karakter dengan nama "
                + character.getName()
                + " sudah ada."
            );
            return;
        }

        characters.add(character);

        System.out.println(
            "Karakter " + character.getName()
            + " berhasil ditambahkan."
        );
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character != null) {
            characters.remove(character);
            System.out.println(
                "Karakter " + name + " berhasil dihapus."
            );
            return true;
        }

        System.out.println(
            "Karakter " + name + " tidak ditemukan."
        );
        return false;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        // Mengembalikan salinan, bukan ArrayList asli.
        return new ArrayList<>(characters);
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    public int getAverageLevel() {
        if (characters.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return totalLevel / characters.size();
    }

    /**
     * Mencari karakter dengan attack power tertinggi.
     *
     * @return karakter terkuat, atau null jika daftar kosong.
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttackPower()
                    > strongest.getAttackPower()) {
                strongest = character;
            }
        }

        return strongest;
    }

    public int countByType(CharacterType type) {
        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
