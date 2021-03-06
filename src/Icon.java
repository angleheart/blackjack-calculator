public enum Icon {

    TWO("Two", 2, '2'),
    THREE("Three", 3,'3'),
    FOUR("Four", 4,'4'),
    FIVE("Five", 5,'5'),
    SIX("Six", 6,'6'),
    SEVEN("Seven", 7,'7'),
    EIGHT("Eight", 8, '8'),
    NINE("Nine", 9, '9'),
    TEN("Ten", 10, 'T'),
    JACK("Jack", 10, 'J'),
    QUEEN("Queen", 10, 'Q'),
    KING("King", 10, 'K'),
    ACE("Ace", 11, 'A');

    public final String nameString;
    public final int bjValue;
    public final char nameChar;


    Icon(String name, int bjValue, char nameChar){
        this.nameString = name;
        this.bjValue = bjValue;
        this.nameChar = nameChar;
    }


}
