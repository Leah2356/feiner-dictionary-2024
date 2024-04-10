package feiner.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Reads the englishDictionary file ONCE.
 */
public class EnglishDictionary {
    private HashMap<String, List<String>> dictionary = new HashMap<>();

    public EnglishDictionary() throws CsvValidationException, IOException {
        // gets the file from the "resources" directory
        InputStream in = EnglishDictionary.class.getResourceAsStream("/englishDictionary.csv");
        if (in == null) {
            throw new IOException("Dictionary file not found");
        }
        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String[] record;

        while ((record = reader.readNext()) != null) {
            String word = record[0].toUpperCase();
            String definition = record[2];

            if (dictionary.containsKey(word)) {
                List<String> definitions = dictionary.get(word);
                definitions.add(definition);
            } else {
                List<String> definitions = new ArrayList<>();
                definitions.add(definition);
                dictionary.put(word, definitions);
            }
        }

        reader.close();
    }



    /**
     * @param word to look up.
     * @return a List of definitions, or an empty list if the word doesn't exist.
     */
    public List<String> getDefinition(String word) {
        word = word.toUpperCase();
        return dictionary.getOrDefault(word, new ArrayList<>());
    }


}
