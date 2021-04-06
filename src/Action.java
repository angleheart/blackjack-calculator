public enum Action {
    STAND("Stand"),
    HIT("Hit"),
    DOUBLE_DOWN("Double Down"),
    SPLIT("Split"),
    SURRENDER("Surrender"),
    TAKE_INSURANCE("Take Insurance");

    public final String asString;

    Action(String asString){
        this.asString = asString;
    }

@Override
public String toString(){
        return this.asString;
}

}
