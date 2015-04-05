package noleggi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AutoTest.class, BilicoTest.class, ClienteTest.class,
		NoleggioTest.class, VeicoloTest.class })
public class AllTests {

}
