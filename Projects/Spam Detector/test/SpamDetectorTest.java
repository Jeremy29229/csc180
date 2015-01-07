import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class SpamDetectorTest
{

	@Test
	public void testSpamDetector() throws FileNotFoundException
	{
		FileInputStream detectorStream = new FileInputStream("antispam-table.txt");
		SpamDetector sd = new SpamDetector(detectorStream);
	}

	@Test
	public void testIsSpam() throws IOException
	{
		FileInputStream detectorStream = new FileInputStream("antispam-table.txt");
		SpamDetector sd = new SpamDetector(detectorStream);
		
		FileInputStream emailStream = new FileInputStream("email.txt");
		Email email = new Email(emailStream);
		assertFalse(sd.isSpam(email));
		
		FileInputStream spamEmailStream = new FileInputStream("spamEmail.txt");
		Email spamEmail = new Email(spamEmailStream);
		assertTrue(sd.isSpam(spamEmail));
	}

}
