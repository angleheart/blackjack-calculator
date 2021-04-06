public class CSM extends DrawPile{

    public CSM(int numberOfDecks){
        super(numberOfDecks * 52);
        addDeck(numberOfDecks);
    }

}
