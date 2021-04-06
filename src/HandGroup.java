import java.util.ArrayList;
import java.util.List;

public class HandGroup {

    private List<Hand> hands;

    public HandGroup(){
        this.hands = new ArrayList<>();
    }

    public void addHand(Hand hand){
        hands.add(hand);
    }

    public List<Hand> getHands(){
        return hands;
    }

    public void setHand(int position, Hand hand){
        hands.set(position, hand);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Hand hand : hands){
            str.append("\n\t\t");
            str.append(hand);
        }
        return str.toString();
    }

}
