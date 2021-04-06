public class Card {

    private final Icon icon;
    private final Suit suit;

    public Card(){
        this.icon = null;
        this.suit = null;
    }

    public Card(Icon icon, Suit suit){
        this.icon = icon;
        this.suit = suit;
    }

    public Icon getIcon(){
        return icon;
    }

    public Suit getSuit(){
        return suit;
    }

    @Override
    public String toString(){
        return this.icon.name + " of " + this.suit.name;
    }


}
