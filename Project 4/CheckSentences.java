import java.util.*;

/**
 * Program will read a series of 
 * sentences (without punctuation) 
 * from the user, (as in project 1), 
 * and will check the spelling of 
 * each word. For each misspelled 
 * word, it will print the correct 
 * spelling. For each sentence, it 
 * will print the number of misspelled 
 * words. The program ends when the user 
 * enters the word STOP.
 *
 * @author (Andrew Choi)
 * @version (05.01.2020)
 */
public class CheckSentences
{
    /**
     * Contains the main method of the program, 
     * which creates a Scanner object to read 
     * user input as well as a SpellChecker 
     * object. It then loops to read each 
     * sentence, check it for misspellings, and 
     * prints the number of misspelled words. 
     * Use the nextLine method to read the 
     * sentence from the user.
     * 
     * @param args argument
     */
    public static void main(String[] args) throws Exception
    {
        SpellChecker spellChecker = new SpellChecker("misspellings.txt");
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter a sentence (or STOP): ");
            //User input
            String userSentence = scanner.nextLine();

            if (userSentence.equals("STOP"))
            {
                //Number of mispelled words
                int mispelledWords = spellChecker.checkSentence(userSentence);
                System.out.println(mispelledWords + " incorrect"); 
            }
            scanner.close();
        }
    }
}
