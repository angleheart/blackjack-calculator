import java.util.*;

public class Table {

    private DrawPile drawPile;
    private TableRules rules;
    private List<Player> playersAtTable;
    private Map<Player, Double> playersInRound = new HashMap<>();
    private Hand dealerHand;
    private int numberOfPlayers;
    private List<Card> visibleCards;
    private int roundNumber;

    public Table(TableRules rules, List<Player> players) {
        drawPile = new Shoe(rules.getNumberOfDecks(), rules.getPercentOfShoeDealt());
        numberOfPlayers = players.size();
        this.rules = rules;
        this.playersAtTable = players;
        visibleCards = new ArrayList<>();
        for (Player player : this.playersAtTable)
            player.setTable(this);
    }

    public void getPlayerBets() {
        for (Player player : playersAtTable)
            playersInRound.put(player, player.getBet());
    }

    public void dealRound() {
        if (drawPile.shuffleRequired()) {
            drawPile.shuffle();
            visibleCards = new ArrayList<>();
        }

        dealerHand = new Hand();
        Card card = drawPile.draw();
        visibleCards.add(card);
        dealerHand.dealCard(card);
        dealerHand.dealCard(drawPile.draw());

        for (Player player : playersAtTable) {
            if (!playersInRound.containsKey(player))
                continue;
            player.getHands().add(new Hand(playersInRound.get(player)));
            card = drawPile.draw();
            visibleCards.add(card);
            player.getHands().get(0).dealCard(card);
            card = drawPile.draw();
            visibleCards.add(card);
            player.getHands().get(0).dealCard(card);
        }
    }

    public void offerSurrender() {
        List<Action> availableActions = new ArrayList<>();
        availableActions.add(Action.SURRENDER);
        for (Player player : playersAtTable) {
            if (!playersInRound.containsKey(player))
                continue;
            if (player.requestAction(availableActions, player.getHands().get(0)) == Action.SURRENDER) {
                player.collect(playersInRound.get(player) / 2);
                playersInRound.remove(player);
            }
        }
    }

    public void checkBlackJack(){
        for(Player player : playersAtTable){
            if(!playersInRound.containsKey(player))
                continue;

            if(player.getHands().get(0).getIdentity().value == 21){

                if(dealerHand.getIdentity().value != 21){
                    player.pay(playersInRound.get(player)*rules.getBjMultipler());
                    playersInRound.remove(player);
                }else
                    playersInRound.remove(player);

            }
        }
    }

    public void finishPlayerHands(){
        for(Player player : playersAtTable){
            if(!playersInRound.containsKey(player))
                continue;

            int totalSplits = 0;
            boolean acesAlreadySplit = false;
            
            Iterator<Hand> iter = player.getHands().iterator();

            while(iter.hasNext()){
                Hand hand = iter.next();
                PlayerHand identity = hand.getIdentity();
                List<Action> availableActions = new ArrayList<>();
                availableActions.add(Action.HIT);
                availableActions.add(Action.STAND);

                if(identity.tag == 'P')
                    if(totalSplits < rules.getPermittedSplitCount())
                        availableActions.add(Action.SPLIT);

                Card newCard;

                switch(player.requestAction(availableActions, hand)){

                    case HIT:
                        newCard = drawPile.draw();
                        visibleCards.add(newCard);
                        hand.dealCard(newCard);
                        if(hand.getIdentity() == PlayerHand.BUSTED)
                            hand.setComplete();
                        break;
                    case STAND:
                        hand.setComplete();
                        break;
                    case DOUBLE_DOWN:
                        newCard = drawPile.draw();
                        visibleCards.add(newCard);
                        hand.dealCard(newCard);
                        hand.setComplete();
                    case SPLIT:
                        Hand hand1 = new Hand(playersInRound.get(player));
                        Hand hand2 = new Hand(playersInRound.get(player));
                        hand1.dealCard(hand.getCards().get(0));
                        hand2.dealCard(hand.getCards().get(1));
                        newCard = drawPile.draw();
                        visibleCards.add(newCard);
                        hand1.dealCard(newCard);
                        newCard = drawPile.draw();
                        visibleCards.add(newCard);
                        hand2.dealCard(newCard);

                        if(hand.getIdentity() == PlayerHand.PAIR_OF_ACES)
                            acesAlreadySplit = true;
                        totalSplits++;

                        iter.remove();
                        iter.
                        player.addHand(hand1);
                        player.addHand(hand2);
                }

            }
        }
    }

    public Card getDealerUpCard() {
        return dealerHand.getCards().get(0);
    }

    public TableRules getRules() {
        return rules;
    }

    public DrawPile getDrawPile() {
        return drawPile;
    }

    public List<Card> getVisibleCards() {
        return visibleCards;
    }


    public void printStatus() {
        System.out.println("------[Table Status]------");
        System.out.println();
        System.out.println("Drawpile");
        System.out.println("--------");
        System.out.println("Number of decks: " + rules.getNumberOfDecks());
        System.out.println("Cards dealt since last shuffle: " + drawPile.getPosition());
        System.out.println();
        System.out.println("Dealer Hand");
        System.out.println("-----------");
        System.out.println(dealerHand.getIdentity());
        for (Card card : dealerHand.getCards()) {
            if (card == getDealerUpCard())
                System.out.println("\t" + card + " (Initial Up Card)");
            else
                System.out.println("\t" + card);
        }
        System.out.println();
        System.out.println("Players at Table");
        System.out.println("----------------");

        for (Player player : playersAtTable) {
            System.out.println(player);
        }
        System.out.println();
        System.out.println("Visible Cards");
        System.out.println("-------------");
        for (Card card : visibleCards)
            System.out.println("-" + card);
    }

}
