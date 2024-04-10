package feiner.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("bee");

        // then
        List<String> expDef = Arrays.asList("p. p. of Be; -- used for been.", "An insect of " +
                "the order Hymenoptera, and family Apidae (the honeybees), or " +
                        "family Andrenidae (the solitary bees.) See Honeybee.",
                "A neighborly gathering of people who engage in united labor for the benefit of an " +
                        "individual or family; as, a quilting bee; a husking bee; " +
                        "a raising bee.",
                "Pieces of hard wood bolted to the sides of the bowsprit, to reeve the fore-topm" +
                        "ast stays through; -- called also bee blocks.");
        assertNotNull(definitions, "The definitions list should not be null.");
        assertFalse(definitions.isEmpty(), "The definitions list shouldn't be empty for known word");
        assertEquals(expDef, definitions);
    }

}