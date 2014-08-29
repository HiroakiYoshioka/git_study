package allTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import unit.empoly.OutLogTest;
import unit.user.parts.RegInfCheckTest;
import unit.user.parts.RegInfDAOTest;

@RunWith(Suite.class)
@SuiteClasses({ RegInfCheckTest.class, RegInfDAOTest.class, OutLogTest.class })
public class AllTests {

}
