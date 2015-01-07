
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;

public class EmailTest
{

	@Test
	public void testEmailStringStringStringString()
	{
		String to = "to";
		String from = "from";
		String subject = "subject";
		String content = "content";
		
		Email email = new Email(to, from, subject, content);
		
		assertTrue(to == email.getTo());
		assertTrue(from == email.getFrom());
		assertTrue(subject == email.getSubject());
		assertTrue(content == email.getContent());
	}

	@Test
	public void testGoodEmailInputStream() throws IOException
	{
		FileInputStream emailStream = new FileInputStream("email.txt");
		Email email = new Email(emailStream);
		
		assertTrue("jcummings@neumont.edu".equals(email.getTo()));;
		assertTrue("bob@neumont.edu".equals(email.getFrom()));
		assertTrue("Howdy".equals(email.getSubject()));
		assertTrue("What do you think of this new email system?".equals(email.getContent()));
	}
	
	@Test
	public void testBadEmailInputStream() throws IOException
	{	
		try
		{
			FileInputStream emailStream = new FileInputStream("bademail.txt");
			Email email = new Email(emailStream);
			fail("IllegalArgumentException not thrown.");
		}
		catch(IllegalArgumentException e)
		{
			//test passed
		}
	}
}
