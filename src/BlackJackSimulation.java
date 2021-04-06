import java.util.List;

public class BlackJackSimulation {

    private Table table;
    private Results results;

    public BlackJackSimulation(TableRules settings, List<Player> players) {
        table = new Table(settings, players);
    }

    public double run(long numberOfRounds) {
        runRound();
        return 0;
    }


    private void runRound() {
        table.getPlayerBets();
        table.dealRound();
        table.printStatus();

        if(table.getRules().allowLateSurrender())
            table.offerSurrender();


    }


}
