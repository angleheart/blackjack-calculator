public class TableRules {

    private final boolean resplitAces;
    private final boolean doubleAferSplit;
    private final boolean lateSurrender;
    private final boolean hitSoftSeventeen;
    private final boolean hitAfterAceSplit;
    private final boolean offerInsurance;

    private final double bjPayout;
    private final double minBet;
    private final double maxBet;
    private final int splitsPerRound;
    private final int numberOfDecks;
    private final double percentOfShoeDealt;


    public TableRules(
            boolean resplitAces,
            boolean doubleAfterSplit,
            boolean lateSurrender,
            boolean hitSoftSeventeen,
            boolean hitAfterAceSplit,
            boolean offerInsurance,
            double bjPayout,
            double minBet,
            double maxBet,
            int splitsPerRound,
            int numberOfDecks,
            double percentOfShoeDealt
    ) {
        this.resplitAces = resplitAces;
        this.doubleAferSplit = doubleAfterSplit;
        this.lateSurrender = lateSurrender;
        this.hitSoftSeventeen = hitSoftSeventeen;
        this.hitAfterAceSplit = hitAfterAceSplit;
        this.offerInsurance = offerInsurance;
        this.bjPayout = bjPayout;
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.splitsPerRound = splitsPerRound;
        this.numberOfDecks = numberOfDecks;
        this.percentOfShoeDealt = percentOfShoeDealt;
    }

    public boolean aceResplitAllowed() {
        return resplitAces;
    }

    public boolean doubleAfterSplitAllowed() {
        return doubleAferSplit;
    }


    public boolean allowLateSurrender() {
        return lateSurrender;
    }

    public boolean dealerHitsSoftSeventeen() {
        return hitSoftSeventeen;
    }

    public boolean hitSplitAcesAllowed() {
        return hitAfterAceSplit;
    }

    public boolean offerInsurance(){return offerInsurance;}

    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public double getBjMultipler() {
        return bjPayout;
    }

    public int getPermittedSplitCount() {
        return splitsPerRound;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public double getPercentOfShoeDealt() {
        return percentOfShoeDealt;
    }


}
