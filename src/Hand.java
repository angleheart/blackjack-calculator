import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;
    private double betAmount;
    private boolean doubledDown;
    private boolean wasStood;

    public Hand(){
        cards = new ArrayList<>();
    }

    public Hand(double betAmount){
        cards = new ArrayList<>();
        this.betAmount = betAmount;
    }

    public void dealCard(Card card){
        cards.add(card);
    }

    public PlayerHand getIdentity(){
        boolean soft = false;
        int hardAces = 0;
        int value = 0;

        for(Card card : cards){
            value += card.getIcon().bjValue;
            if(card.getIcon() == Icon.ACE)
                hardAces++;
        }

        while(hardAces > 0 && value > 21){
            value -= 10;
            hardAces--;
        }

        if(hardAces > 0)
            soft = true;

        //If it is a pair
        if(cards.size() == 2 && cards.get(0).getIcon() == cards.get(1).getIcon()){
            for(PlayerHand playerHand : PlayerHand.values()){
                if(playerHand.tag == 'P' && playerHand.value == value)
                    return playerHand;
            }
        }

        //If it is soft
        if(soft){
            for(PlayerHand playerHand : PlayerHand.values()){
                if(playerHand.tag == 'S' && playerHand.value == value)
                    return playerHand;
            }
        }

        for(PlayerHand playerHand : PlayerHand.values()){
            if(playerHand.tag == 'H' && playerHand.value == value)
                return playerHand;
        }

        if(value > 21)
            return PlayerHand.BUSTED;

        return PlayerHand.NOT_APPLICABLE;
    }


    public List<Card> getCards(){
        return cards;
    }

    public boolean isDoubledDown(){
        return doubledDown;
    }

    public boolean isComplete(){
        return wasStood;
    }

    public void setComplete(){
        wasStood = true;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getIdentity());
        str.append("\n\t\tBet: ");
        str.append(betAmount);
        for(Card card : cards){
            str.append("\n\t\t\t");
            str.append(card);
        }
        return str.toString();
    }


    }
