package user.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * このクラスは、ログインユーザの認証を行います。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class UserAuth {

	public UserAuth() {
	}

	public boolean execute(UserInfo uInfo) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream("c:\\temp/user.properties");
			prop.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			fis.close();
		}
		String tmpId = prop.getProperty("user.id");
		String[] id = tmpId.split(",");
		String tmpPass = prop.getProperty("user.pass");
		String[] pass = tmpPass.split(",");

		for (int i = 0; i < id.length; i++) {

			if (id[i].equals(uInfo.getUserName())
					&& pass[i].equals(uInfo.getUserPass())) {

				// ユーザとパスワードが一致していればOK
				return true;
			}
		}

		return false;

	}

}
