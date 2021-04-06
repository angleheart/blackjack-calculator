public enum PlayerHand {

    SOFT_TWENTY_ONE("Soft 21",21, 'S', 12),
    SOFT_TWENTY("Soft 20",20, 'S', 13),
    SOFT_NINETEEN("Soft 19",19, 'S', 14),
    SOFT_EIGHTEEN("Soft 18",18, 'S', 15),
    SOFT_SEVENTEEN("Soft 17",17, 'S', 16),
    SOFT_SIXTEEN("Soft 16",16, 'S', 17),
    SOFT_FIFTEEN("Soft 15",15, 'S', 18),
    SOFT_FOURTEEN("Soft 14",14, 'S', 19),
    SOFT_THIRTEEN("Soft 13",13, 'S', 20),

    TWENTY_ONE("Hard 21",21, 'H', 0),
    TWENTY("Hard 20",20, 'H', 0),
    NINETEEN("Hard 19",19, 'H', 0),
    EIGHTEEN("Hard 18",18, 'H', 0),
    SEVENTEEN("Hard 17",17, 'H', 1),
    SIXTEEN("Hard 16",16, 'H', 2),
    FIFTEEN("Hard 15",15, 'H', 3),
    FOURTEEN("Hard 14",14, 'H', 4),
    THIRTEEN("Hard 13",13, 'H', 5),
    TWELVE("Hard 12",12, 'H', 6),
    ELEVEN("Hard 11",11, 'H', 7),
    TEN("Hard 10",10, 'H', 8),
    NINE("Hard 9",9, 'H', 9),
    EIGHT("Hard 8",8, 'H', 10),
    SEVEN("Hard 7",7, 'H', 11),
    SIX("Hard 6",6, 'H', 11),
    FIVE("Hard 5",5, 'H', 11),

    PAIR_OF_ACES("Pair As",12, 'P', 21),
    PAIR_OF_TENS("Pair 10s",20, 'P', 22),
    PAIR_OF_NINES("Pair 9s",18, 'P', 23),
    PAIR_OF_EIGHTS("Pair 8s",16, 'P', 24),
    PAIR_OF_SEVENS("Pair 7s",14, 'P', 25),
    PAIR_OF_SIXES("Pair 6s",12, 'P', 26),
    PAIR_OF_FIVES("Pair 5s",10, 'P', 27),
    PAIR_OF_FOURS("Pair 4s",8, 'P', 28),
    PAIR_OF_THREES("Pair 3s",6, 'P', 29),
    PAIR_OF_TWOS("Pair 2s",4, 'P', 30),

    BUSTED("Busted", 1000,'B',1000),
    NOT_APPLICABLE("Not Applicable", 1000, 'N', 1000);

    public final String name;
    public final int value;
    public final char tag;
    public final int row;

    PlayerHand(String name, int value, char tag, int row) {
        this.name = name;
        this.value = value;
        this.tag = tag;
        this.row = row;
    }


}
