public class Deck extends DrawPile {

    public Deck() {
        super(52);
        addDeck(1);
    }

    public Deck getDeck(){
        return this;
    }

}
