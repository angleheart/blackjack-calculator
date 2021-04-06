public class Shoe extends DrawPile {

    private int cutCard;

    public Shoe(int numberOfDecks, double cutPercentage){
        super(numberOfDecks * 52);
        addDeck(numberOfDecks);

        //Approximate percentage dealt before cutting in decimal form
        cutCard = (int) cutPercentage*(numberOfDecks*52);
    }

    @Override
    public Card draw(){
        if(getPosition() > cutCard)
            setShuffleRequired(true);
        return super.draw();
    }




}
