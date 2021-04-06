import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {

        try {
            StrategyCardParser strategyCardParser = new StrategyCardParser();
            TableRules rules = parseTableRules("jack_standard.properties");
            List<Player> players = new ArrayList<>();

            BasicPlayer player1 = new BasicPlayer(
                    "Michael",
                    1000,
                    strategyCardParser.getStrategyCard("BasicTable.csv"));
            BasicPlayer player2 = new BasicPlayer(
                    "James",
                    1000,
                    strategyCardParser.getStrategyCard("BasicTable.csv"));

            players.add(player1);
            players.add(player2);

            BlackJackSimulation simulator = new BlackJackSimulation(rules, players);
            simulator.run(1);




        } catch (ParseFailedException e) {
            System.out.println(e.getMessage());
        }

    }


    private static TableRules parseTableRules(String fileName) throws ParseFailedException {
        try (InputStream input =
                     Main.class.getClassLoader().getResourceAsStream(fileName)) {
            Properties config = new Properties();

            if (input == null) {
                throw new ParseFailedException("Failed to locate file " + fileName);
            }

            config.load(input);
            boolean resplitAces = Boolean.parseBoolean(config.getProperty("resplitAces"));
            boolean doubleAfterSplit = Boolean.parseBoolean(config.getProperty("doubleAfterSplit"));
            boolean lateSurrender = Boolean.parseBoolean(config.getProperty("lateSurrender"));
            boolean hitSoftSeventeen = Boolean.parseBoolean(config.getProperty("hitSoftSeventeen"));
            boolean hitAfterAceSplit = Boolean.parseBoolean(config.getProperty("hitAfterAceSplit"));
            boolean offerInsurance = Boolean.parseBoolean(config.getProperty("offerInsurance"));
            double bjPayout = Double.parseDouble(config.getProperty("bjPayout"));
            double minBet = Double.parseDouble(config.getProperty("minBet"));
            double maxBet = Double.parseDouble(config.getProperty("maxBet"));
            int splitsPerRound = Integer.parseInt(config.getProperty("splitsPerRound"));
            int numberOfDecksInShoe = Integer.parseInt(config.getProperty("numberOfDecks"));
            double percentOfShoeDealt = Double.parseDouble(config.getProperty("percentOfShoeDealt"));

            return new TableRules(
                    resplitAces,
                    doubleAfterSplit,
                    lateSurrender,
                    hitSoftSeventeen,
                    hitAfterAceSplit,
                    offerInsurance,
                    bjPayout,
                    minBet,
                    maxBet,
                    splitsPerRound,
                    numberOfDecksInShoe,
                    percentOfShoeDealt);

        } catch (IOException ex) {
            throw new ParseFailedException("Failed to parse config file " + fileName);
        }

    }

}
