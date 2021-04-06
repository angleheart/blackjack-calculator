import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class DrawPile {

    private Card[] cards;
    private int position;
    private boolean shuffleRequired;
    private int cardsLeft;

    public DrawPile(int size) {
        cards = new Card[size];
        shuffleRequired = true;
    }

    public Card draw() {
        cardsLeft--;
        return cards[position++];
    }

    public boolean addDeck(int numDecks){

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
        cards[cardsLeft++] = card;
        return true;
    }

    public int getPosition(){
        return position;
    }

    public void setShuffleRequired(boolean setting){
        shuffleRequired = setting;
    }

    public boolean shuffleRequired(){
        return shuffleRequired;
    }

    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();

        for(int j = 0; j < 3; j++){
            for (int i = cards.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                var a = cards[index];
                cards[index] = cards[i];
                cards[i] = a;
            }
        }
        position = 0;
        shuffleRequired = false;
        System.out.println("The draw pile has been shuffled");
    }

}
