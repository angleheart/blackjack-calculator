import java.util.List;

public interface Player {

    void setTable(Table table);
    Action requestAction(List<Action> availableActions, Hand hand);
    double getBet();
    String getName();
    void pay(double amount);
    void collect(double amount);
    double getBalance();
    PlayerResults getPlayerResults();
    List<Hand> getHands();
}
