import static org.junit.Assert.*;
import org.junit.Test;

public class WordFeatureTest
{
	@Test
	public void testWordFeature()
	{
		WordFeature wf = new WordFeature("testword", 7, 13);
		
		assertTrue(wf.getHamCount() ==7);
		assertTrue(wf.getSpamCount() == 13);
		assertTrue(wf.getWord() == "testword");
	}
}
