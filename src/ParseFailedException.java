public class ParseFailedException extends Exception {

    public ParseFailedException(){
        super("Failed to parse.");
    }
    public ParseFailedException(String message){
        super(message);
    }

}
