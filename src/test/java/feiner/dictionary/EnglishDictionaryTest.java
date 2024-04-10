package feiner.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("hello");

        // then
        assertNotNull(definitions, "The definitions list should not be null.");
        assertFalse(definitions.isEmpty(), "The definitions list shouldn't be empty for known word");
        assertTrue(definitions.contains("See Halloo."), "The definitions list should contain the right definition.");
    }

}