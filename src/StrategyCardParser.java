import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrategyCardParser {

    private String fileName;

    public StrategyCard getStrategyCard(String fileName) throws ParseFailedException {
        this.fileName = fileName;
        List<List<String>> records = new ArrayList<>();
        StrategyCard.TableRequest[][] requests = new StrategyCard.TableRequest[31][10];

        try {
            Scanner scan = new Scanner(new File("Strategy Cards/" + fileName));


            while (scan.hasNextLine()) {
                records.add(getRecordFromLine(scan.nextLine()));
            }

        } catch (FileNotFoundException fnf) {
            throw new ParseFailedException("Failed to locate file: " + fileName);
        }

        for (int i = 1; i < 32; i++) {
            for (int j = 1; j < 11; j++) {
                requests[i - 1][j - 1] = getRequestFromString(records.get(i).get(j));
            }
        }

        return new StrategyCard(requests, fileName);
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    private StrategyCard.TableRequest getRequestFromString(String s) throws ParseFailedException {

        return switch (s) {
            case "S" -> StrategyCard.TableRequest.STAND_REQUEST;
            case "H" -> StrategyCard.TableRequest.HIT_REQUEST;
            case "DH" -> StrategyCard.TableRequest.DOUBLE_DOWN_HIT_REQUEST;
            case "DS" -> StrategyCard.TableRequest.DOUBLE_DOWN_STAND_REQUEST;
            case "PH" -> StrategyCard.TableRequest.SPLIT_HIT_REQUEST;
            case "PS" -> StrategyCard.TableRequest.SPLIT_STAND_REQUEST;
            case "FH" -> StrategyCard.TableRequest.SURRENDER_HIT_REQUEST;
            case "FS" -> StrategyCard.TableRequest.SURRENDER_STAND_REQUEST;
            default -> throw new ParseFailedException("Failed to interpret string " + s + " from " + fileName);
        };
    }

}
