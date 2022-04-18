import java.util.*;
import java.io.*;
/**
 * Stores as instance data 
 * a two-dimensional array of 
 * String objects, which will 
 * store the misspelling pairs.
 *
 * @author (Andrew Choi)
 * @version (2020.05.01)
 */
public class SpellChecker
{
    private String[][] pairs;
    /**
     * Accepts the name of the 
     * input file as a parameter. 
     * It creates a Scanner object 
     * to read the input file, and 
     * sets the delimiter to "[,\n]" 
     * (as you did in Project 3) 
     * with the useDelimiter method. 
     * It then reads the first line 
     * of the input file using the 
     * nextInt method, and uses that 
     * value to create the 2D array.
     * 
     * @param fileName name of file
     */
    public SpellChecker(String fileName) throws Exception
    {
        //Maximum number of files 
        int linesMax = 0;

        //Reading file and 
        File file = new File("mispellings.txt");
        Scanner in = new Scanner(file);

        //Goes through the text file by line
        in.useDelimiter("[,\n]");
        linesMax = in.nextInt();
        pairs = new String[linesMax][2];

        //Loops until program reaches the max count
        for (int lineNumber = 0; in.hasNext() 
            && lineNumber < linesMax; lineNumber++)
        {
            //Rows 
            pairs[lineNumber][0] = in.next();
            pairs[lineNumber][1] = in.next();
        }
        in.close();
    }

    /**
     * Accepts a single word (String) 
     * as a parameter and performs a 
     * linear search on the 2D array, 
     * (starting an index zero), to 
     * see if the word is misspelled. 
     * If it finds the word, it returns 
     * the row index where it was found. 
     * If it is not found in the array, 
     * you can assume the word is spelled 
     * correctly and the method should 
     * return a -1.
     * 
     * @param word mispelled word
     * @return index
     */
    public int findWord(String word)
    {
        //Number of rows 
        int lines = pairs.length;

        //Continues until the index reaches number of rows
        for (int i = 0; i < lines; i++)
        {
            //Returns row index where it was found
            if (word.equals(pairs[i][0]))
            {
                return i;
            }
        }

        //Word is spelled correctly 
        return -1;
    }

    /**
     * Accepts a sentence as a parameter 
     * (String) and returns the number 
     * of misspellings found in the sentence.
     * 
     * @param sentence user input sentence
     * @return mispellings
     */
        public int checkSentence(String sentence)
    {
        int mispellings = 0;

        Scanner parser = new Scanner(sentence);

        //parser checks for mispellings 
        while (parser.hasNext())
        {
            String word = parser.next();
            boolean wrong = checkWord(word);
            if (wrong)
            {
                mispellings++;
            }
        }
        parser.close();
        return mispellings;
    }

    /**
     * Accepts a single word as a parameter 
     * and returns true if the word is 
     * misspelled and false otherwise. Check 
     * the word by calling the findWord method, 
     * passing it a lower case version of the 
     * word. If the word is found in the array, 
     * the checkWord method should print the 
     * original word from the input and its 
     * correct spelling.
     * 
     * @param word mispelled
     * @return true
     */
    public boolean checkWord(String word)
    {
        //Lower case version of the world
        word = word.toLowerCase();

        int index = findWord(word);

        if (index == 1)
        {
            return false;
        }
        System.out.println(word + " --> " + pairs[index][0]);
        return true;
    }
}
