public class Hand {

    private int value;
    private boolean soft;
    private boolean splittable;

    private Card[] cards;
    private int totalCards;
    private DrawPile drawPile;

    public Hand(DrawPile drawPile){
        this.drawPile = drawPile;
    }

    public void deal(){
        cards = new Card[32];
        totalCards = 0;

        cards[0] = hit();
        cards[1] = hit();

        if(cards[0].icon == cards[1].icon)
            splittable = true;
    }

    //Pass card for first position in cases where we split
    public void deal(Card card){
        cards = new Card[32];
        totalCards = 1;
        cards[0] = card;
        cards[1] = hit();

        if(cards[0].icon == cards[1].icon)
            splittable = true;

    }

    public Card hit(){
        Card newCard = drawPile.draw();
        cards[totalCards++] = newCard;
        return newCard;
    }

    public Hand[] split(){
        Hand newHand = new Hand(drawPile);
        newHand.deal(cards[1]);
        cards[1] = hit();
        totalCards--;
        return new Hand[] {this, newHand};
    }
    

    public int getHandValue(){



    }


    private void computeValue(){



    }





}
