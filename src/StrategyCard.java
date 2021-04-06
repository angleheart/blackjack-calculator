public class StrategyCard {

    private TableRequest[][] requests;
    private String fileName;

    public StrategyCard(TableRequest[][] requests, String fileName){
        this.requests = requests;
        this.fileName = fileName;
    }

    public enum TableRequest {

        STAND_REQUEST(Action.STAND, Action.STAND),
        HIT_REQUEST(Action.HIT, Action.STAND),

        DOUBLE_DOWN_HIT_REQUEST(Action.DOUBLE_DOWN, Action.HIT),
        DOUBLE_DOWN_STAND_REQUEST(Action.DOUBLE_DOWN, Action.STAND),

        SPLIT_HIT_REQUEST(Action.SPLIT, Action.HIT),
        SPLIT_STAND_REQUEST(Action.SPLIT, Action.HIT),

        SURRENDER_HIT_REQUEST(Action.SURRENDER, Action.HIT),
        SURRENDER_STAND_REQUEST(Action.SURRENDER, Action.STAND);


        public final Action preferredAction;
        public final Action alternateAction;

        TableRequest(Action preferredAction, Action alternateAction){
            this.preferredAction = preferredAction;
            this.alternateAction = alternateAction;
        }

    }

    public Action getPreferredAction(PlayerHand hand, Icon dealersUpCard){
        return requests[hand.row][dealersUpCard.column].preferredAction;
    }

    public Action getAlternateAction(PlayerHand hand, Icon dealersUpCard){
        return requests[hand.row][dealersUpCard.column].alternateAction;
    }

    public String getFileName(){
        return fileName;
    }

}
