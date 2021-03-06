public class Shoe extends DrawPile {

    private int deckCount;
    private int cutCard;

    public Shoe(int numberOfDecks, double cutPercentage){
        super(numberOfDecks * 52);
        deckCount = numberOfDecks;
        addDeck(numberOfDecks);

        //Approximate percentage dealt before cutting in decimal form
        cutCard = (int) cutPercentage*(numberOfDecks*52);
    }

}
