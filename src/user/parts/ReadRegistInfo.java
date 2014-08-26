package user.parts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import user.bean.RegistrantInfo;

/**
 * このクラスは、雇用者情報の読み出しに関する機能を提供します。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class ReadRegistInfo {
	final static private File file = new File("c:/temp/userInfo.txt");

	private static int lineCount() throws IOException{
		LineNumberReader lr = new LineNumberReader(new FileReader(file));
		String tmpLine;
		while (null != (tmpLine = lr.readLine())) {
		}
		int lineNum = lr.getLineNumber();
		lr.close();
		return lineNum;
	}

	public static RegistrantInfo[] getReglist() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));

		int lineNum = lineCount();
		RegistrantInfo[] regInfo = new RegistrantInfo[lineNum];

		String rLine = null;

		for (int i = 0; i < lineNum; i++) {
			regInfo[i] = new RegistrantInfo();
			rLine = br.readLine();
			String[] rInfo = rLine.split(",");

			regInfo[i].setrId(rInfo[0]);
			regInfo[i].setrName(rInfo[1]);
			regInfo[i].setrAge(rInfo[2]);
		}

		br.close();
		return regInfo;
	}

	public static String getNewId() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));

		int lineNum = lineCount();
		int intNewId = 0;
		int bufId;
		String strNewId = null;
		String rLine = null;

		for (int i=0; i<lineNum; i++) {
			rLine = br.readLine();
			String[] rInfo = rLine.split(",");
			bufId = Integer.parseInt(rInfo[0]);
			if(intNewId < bufId){
				intNewId = bufId;
			}
		}
		strNewId = String.format("%1$03d", intNewId + 1);
		br.close();
		
		return strNewId;
	}
	
}
