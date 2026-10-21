/* Create a program that randomly selects four cards from a deck of cards */
public class DeckOfCards {
    /** Fills up a deck of four different suits */
    private static int[] fillDeck() {
        int[] deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }
        return deck;
    }
    private static int[] shuffleDeck(int[] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));

            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        return deck;
    }
    /* Shuffles a deck of 52 cards */
    private static int[] buildDeck() {
        int[] deck = fillDeck();
        int[] shuffledDeck = shuffleDeck(deck);
        return shuffledDeck;
    }
    private static String getRank(int card) {
        switch (card % 13) {
            case 0 -> { return "Ace"; }
            case 1 -> { return "2"; }
            case 2 -> { return "3"; }
            case 3 -> { return "4"; }
            case 4 -> { return "5"; }
            case 5 -> { return "6"; }
            case 6 -> { return "7"; }
            case 7 -> { return "8"; }
            case 8 -> { return "9"; }
            case 9 -> { return "10"; }
            case 10 -> { return "Jack"; }
            case 11 -> { return "Queen"; }
            case 12 -> { return "King"; }
        }
        return null;
    }
    private static String getSuit(int card) {
        switch (card / 13) {
            case 0 -> { return "Spades"; }
            case 1 -> { return "Hearts"; }
            case 2 -> { return "Diamomds"; }
            case 3 -> { return "Clubs"; }
        }
        return null;
    }
    /* Picks four cards */
    private static void pickCards(int[] deck) {
        for (int i = 0; i < 4; i++) {
            int card = deck[i];
            System.out.printf("Card number %d is the %s of %s\n", card, getRank(card), getSuit(card));
        }
    }
    public static void main(String[] args) {
        int[] shuffledDeck = buildDeck();
        pickCards(shuffledDeck);
    }
}
