package user.parts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import user.bean.RegistrantInfo;

/**
 * このクラスは、雇用者情報の書き込みに関する機能を提供します。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class WriteRegistInfo {
	final static File file = new File("c:\\temp/userInfo.txt");
	final static String infSprit = ",";

	public static void regRegInfo(RegistrantInfo regInfo) throws IOException {

		FileWriter fWriter = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));
		
		pw.println(regInfo.getrId() + infSprit 
				+ regInfo.getrName() + infSprit
				+ regInfo.getrAge());
		pw.close();
		
	}
	
	public static void modRegInfo(RegistrantInfo inputInfo) throws IOException{
		RegistrantInfo[] regInfo = getRegInfo();
		int t = searchId(inputInfo.getrId(), regInfo);

		FileWriter fWriter = new FileWriter(file);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));

		for (int i = 0; i < regInfo.length; i++) {

			if (i == t) {
				pw.println(inputInfo.getrId() + infSprit + inputInfo.getrName()
						+ infSprit + inputInfo.getrAge());
			} else {
				pw.println(regInfo[i].getrId() + infSprit
						+ regInfo[i].getrName() + infSprit
						+ regInfo[i].getrAge());
			}
		}
		pw.close();		
	}
	
	public static void delRegInfo(RegistrantInfo inputInfo) throws IOException {
		RegistrantInfo[] regInfo = getRegInfo();
		int t = searchId(inputInfo.getrId(), regInfo);
	
		FileWriter fWriter = new FileWriter(file);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));

		for (int i = 0; i < regInfo.length; i++) {

			if (i != t) {
				pw.println(regInfo[i].getrId() + infSprit
						+ regInfo[i].getrName() + infSprit
						+ regInfo[i].getrAge());
			}
		}

		pw.close();
	}

	private static int searchId(String regId, RegistrantInfo[] regInfo) {

		int target_number = -1;

		if (regId == null) {
			return target_number;
		}

		for (int i = 0; i < regInfo.length; i++) {

			if (regId.equals(regInfo[i].getrId())) {
				target_number = i;
				break;
			}
		}

		return target_number;
	}
	
	private static RegistrantInfo[] getRegInfo() throws IOException{
		RegistrantInfo[] getRegInfo = ReadRegistInfo.getReglist();
		return getRegInfo;
	}

}