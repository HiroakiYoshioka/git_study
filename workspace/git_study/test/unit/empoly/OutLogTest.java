package unit.empoly;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import employ.OutLog;


public class OutLogTest {
	
	@Before
	public void clearBeforeLog(){
		try{
			// log.txtの初期化
			FileWriter fw = new FileWriter("/test/log/log.txt", false);
			fw.close();
		}
		catch(IOException e){
			System.err.println("file error@clearlog()");
		}
	}
	
	@Test
	public void testOutLogDmpString() {
		System.out.println("UT003-001 START");
		OutLog.outLogDmp("sample：サンプル");
		System.out.println("UT003-001 END");
	}

	@Test
	public void testOutLogDmpInteger() {
		System.out.println("UT003-002 START");
		OutLog.outLogDmp(12345);
		System.out.println("UT003-002 END");
	}
	
	@After
	public void clearAfterLog(){
		try{
			// log.txtに書き込まれているか確認する
			BufferedReader br = new BufferedReader(new FileReader("/test/log/log.txt"));

			// ファイルの読み込み
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			/*ファイルをクローズします。*/
			br.close();
			
			// log.txtの初期化
			FileWriter fw = new FileWriter("/test/log/log.txt", false);
			fw.close();
		}
		catch(IOException e){
			System.err.println("file error@clearlog()");
		}
	}

}
