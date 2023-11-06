import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailService {
    private static Logger logger=Logger.getLogger(EmailService.class.getName());
    private static final Pattern TIME_PATTERN=Pattern.compile("\\[\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\]");
    private static final Pattern USER_PATTERN=Pattern.compile("\\[.+\\]");
    private static final Pattern RECEIVER_PATTERN=Pattern.compile("\\[.+\\@.+\\.com\\]");
    private static final Pattern MASSAGE_PATTERN=Pattern.compile("\\[.+\\]");

    static {
        try {
            FileHandler fileHandler=new FileHandler("Errors/errors2.txt");
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Email email;

    public List<Email> getEmail(String filePath) throws IOException {
        List<Email> emails=new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line= bf.readLine())!=null){
                Matcher matcher1=TIME_PATTERN.matcher(line);
                Matcher matcher2=USER_PATTERN.matcher(line);
                Matcher matcher3=RECEIVER_PATTERN.matcher(line);
                Matcher matcher4=MASSAGE_PATTERN.matcher(line);
                if(matcher1.find() && matcher2.find() && matcher3.find() && matcher4.find()){
                    emails.add(new Email(matcher1.group(),matcher2.group(),matcher3.group(),matcher4.group()));
                }else {
                    logger.severe("ERROR INFORMATION ETNTERED!");
                }
            }
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }
        return   emails;
    }

}
