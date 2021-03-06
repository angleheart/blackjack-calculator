import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class DrawPile {

    private Card[] cards;
    private int position;
    private int cardsLeft;

    public DrawPile(int size) {
        cards = new Card[size];
        position = 0;
    }

    public Card draw() {
        if(cardsLeft == 0){
            System.out.println("The draw pile is empty!");
            return null;
        }
        cardsLeft--;
        return cards[position++];
    }

    public boolean addDeck(int numDecks){

        if(cardsLeft + (52*numDecks) >= cards.length){
            System.out.println("The draw pile is full!");
            return false;
        }

        for(int i = numDecks; i > 0; i--){
            for (Suit suit : Suit.values()) {
                for (Icon icon : Icon.values()) {
                    addCard(new Card(icon, suit));
                }
            }
        }

        return true;
    }

    public boolean addCard(Card card){

        if(cardsLeft >= cards.length){
            System.out.println("The draw pile is full!");
            return false;
        }

        cards[cardsLeft++] = card;
        return true;
    }

    public void Shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = cards.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            var a = cards[index];
            cards[index] = cards[i];
            cards[i] = a;
        }
    }

}
