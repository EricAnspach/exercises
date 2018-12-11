public class CardDeckApp {

    public static void main(String[] args) {
        System.out.println("DECK");
        String[] deck = getDeck();
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 2;
        System.out.println("HAND OF " + count + " CARDS");
        String[] hand = dealCards(deck, count);
        displayCards(hand);
    }

    private static String[] getDeck() {
        String[] deck = new String[52];

        String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        int count = 0;

        for(int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[count] = ranks[j] + " of " + suits[i];
                count++;
            }
        }
        return deck;
    }

    private static void displayCards(String[] cards) {
        String deckString = "|";
        for(String card:cards) {
            deckString += card + "|";
        }
        System.out.println(deckString);
    }

    private static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length-1);
            String currentCard = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = currentCard;
        }
    }

    private static String[] dealCards(String[] deck, int count) {
        String[] hand = new String[count];
        return hand;
    }
}