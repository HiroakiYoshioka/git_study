package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import user.parts.RegInfCheck;

public class RegInfCheckTest {

	private RegInfCheck infCheck = null;
	private String endNo = null;
	
	@Before
	public void before(){
		infCheck = new RegInfCheck();
	}
	
	@After
	public void after(){
		// é¿çsåãâ ÇÃèoóÕ
		System.out.println("Result:\"" + infCheck.getErrMsg() + "\"");
		System.out.println(endNo);
		if(infCheck != null) infCheck = null;
	}
	
	@Test
	public void testCheckName_001() {
		System.out.println("UT001-001 START");
		infCheck.checkName("0123456789");
		endNo = "UT001-001 END";
	}
	
	@Test
	public void testCheckName_002() {
		System.out.println("UT001-002 START");
		infCheck.checkName("Ç†Ç¢Ç§Ç¶Ç®Ç©Ç´Ç≠ÇØÇ±");
		endNo = "UT001-002 END";
	}
	
	@Test
	public void testCheckName_003() {
		System.out.println("UT001-003 START");
		infCheck.checkName("01234567890");
		endNo = "UT001-003 END";
	}
	
	@Test
	public void testCheckName_004() {
		System.out.println("UT001-004 START");
		infCheck.checkName("Ç†Ç¢Ç§Ç¶Ç®Ç©Ç´Ç≠ÇØÇ±Ç≥");
		endNo = "UT001-004 END";
	}

	@Test
	public void testCheckAge_005() {
		System.out.println("UT001-005 START");
		infCheck.checkAge("16");
		endNo = "UT001-005 END";
	}
	
	@Test
	public void testCheckAge_006() {
		System.out.println("UT001-006 START");
		infCheck.checkAge("60");
		endNo = "UT001-006 END";
	}
		
	@Test
	public void testCheckAge_007() {
		System.out.println("UT001-007 START");
		infCheck.checkAge("15");
		endNo = "UT001-007 END";
	}
	
	@Test
	public void testCheckAge_008() {
		System.out.println("UT001-008 START");
		infCheck.checkAge("61");
		endNo = "UT001-008 END";
	}
	
	@Test
	public void testCheckAge_009() {
		System.out.println("UT001-009 START");
		infCheck.checkAge("ÇPÇU");
		endNo = "UT001-009 END";
	}
	
	@Test
	public void testCheckAge_010() {
		System.out.println("UT001-010 START");
		infCheck.checkAge("Ç†Ç¢Ç§Ç¶Ç®");
		endNo = "UT001-010 END";
	}
	
	@Test
	public void testCheckAge_011() {
		System.out.println("UT001-011 START");
		infCheck.checkAge("16Ç†Ç¢Ç§Ç¶Ç®");
		endNo = "UT001-011 END";
	}

	@Test
	public void testCheckId_012() {
		System.out.println("UT001-012 START");
		infCheck.checkId("999");
		endNo = "UT001-012 END";
	}
	
	@Test
	public void testCheckId_013() {
		System.out.println("UT001-013 START");
		infCheck.checkId("1000");
		endNo = "UT001-013 END";
	}

}
