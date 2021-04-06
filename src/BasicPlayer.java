import java.util.ArrayList;
import java.util.List;

public class BasicPlayer implements Player {

    private String name;
    private List<Hand> hands;
    private double balance;
    private int handsPlayed;
    private StrategyCard strategyCard;

    private Table table;

    public BasicPlayer(String name, double balance, StrategyCard strategyCard) {
        this.name = name;
        this.strategyCard = strategyCard;
        this.balance = balance;
        this.hands = new ArrayList<>();
    }

    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public Action requestAction(List<Action> availableActions, Hand hand) {
        Icon dealerIcon = table.getDealerUpCard().getIcon();
        if (availableActions.contains(strategyCard.getPreferredAction(hand.getIdentity(), dealerIcon)))
            return strategyCard.getPreferredAction(hand.getIdentity(), dealerIcon);
        else if (availableActions.contains(strategyCard.getAlternateAction(hand.getIdentity(), dealerIcon)))
            return strategyCard.getAlternateAction(hand.getIdentity(), dealerIcon);
        else
            return Action.STAND;
    }

    @Override
    public double getBet() {
        return table.getRules().getMinBet();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void pay(double amount) {
        balance += amount;
    }

    @Override
    public void collect(double amount) {
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public PlayerResults getPlayerResults() {
        return null;
    }

    @Override
    public List<Hand> getHands() {
        return hands;
    }

    @Override
    public String toString() {
        String str = name +
                "\n\tBalance: " +
                balance +
                "\n\tHands:" +
                handGroup;
        return str;
    }

}
