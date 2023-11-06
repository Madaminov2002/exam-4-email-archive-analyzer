import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EmailExam {
    public static void main(String[] args) throws IOException {
        EmailService emailService=new EmailService();
        List<Email> emails=emailService.getEmail("resource/emails.txt");
        for (Email email:emails){
            System.out.println(email+" ");
        }



    }
}