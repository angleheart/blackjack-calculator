public enum Icon {

    TWO("Two", 2, '2', 1),
    THREE("Three", 3,'3',2),
    FOUR("Four", 4,'4',3),
    FIVE("Five", 5,'5',4),
    SIX("Six", 6,'6',5),
    SEVEN("Seven", 7,'7',6),
    EIGHT("Eight", 8, '8',7),
    NINE("Nine", 9, '9',8),
    TEN("Ten", 10, 'T',9),
    JACK("Jack", 10, 'J',9),
    QUEEN("Queen", 10, 'Q',9),
    KING("King", 10, 'K',9),
    ACE("Ace", 11, 'A',10);

    public final String name;
    public final int bjValue;
    public final char nameChar;
    public final int column;


    Icon(String name, int bjValue, char nameChar, int column){
        this.name = name;
        this.bjValue = bjValue;
        this.nameChar = nameChar;
        this.column = column;
    }


}
