package user.parts;

/**
 * このクラスは、雇用者情報の入力値をチェックする機能を提供します。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class RegInfCheck {
	private StringBuilder errMsg = new StringBuilder();
	final static String CHECK_TYPE_FIX = "1";
	final static String CHECK_TYPE_WITHIN = "0";
	
	public String getErrMsg() {
		return errMsg.toString();
	}
	
	public void checkName(String regName) {

		// 桁数チェック(以内)
		if (!lengthCheck(regName, CHECK_TYPE_WITHIN, 10)) {
			errMsg.append("名前は10桁以内で入力してください。<br />");
		}
	}
	
	public void checkAge(String regAge) {
		
		// 数値チェック
		if (!numberCheck(regAge)) {
			errMsg.append("年齢は数値(半角)で入力してください。<br />");
		}
		
		// 範囲チェック(16-60)
		if (!limitCheck(regAge, 16, 60)) {
			errMsg.append("年齢は(16-60)の範囲で入力してください。<br />");
		}
	}
	
	public void checkId(String regId){
		if(!maxCheck(regId,1000)){
			errMsg.append("登録可能なID（999）を超えています。管理者に問い合わせてください。<br />");
		}	
	}


	private boolean numberCheck(final String str) {

		int intChk = 0; 
		for (int i = 0; i < str.length(); i++) { 
		
			char c = str.charAt(i);
			char c1 = '0'; 
			char c2 = '9'; 
			if (c < c1 || c > c2) {
				intChk = intChk + 1;
			} 
		}

		if (intChk == 0) {
			return true;
		} else {
			return false;
		} 
	}

	private boolean lengthCheck(final String str, final String type, final int dig) {
		
		if (str == null || str.length()==0) {
			return false;
		}
		
		if (CHECK_TYPE_FIX.equals(type)) {
			
			if (str.length() == dig ) {
				return true;
			} else { 
				return false;
			}
		} else {
			
			if (str.length() <= dig) {
				return true;
			} else { 
				return false;
			}
		}
	}
	
	private boolean minCheck(final String val, final int min){
		try {
			int num = Integer.parseInt(val);
		
			if (min < num) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	private boolean maxCheck(final String val, final int max){
		try {
			int num = Integer.parseInt(val);
		
			if (num < max) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	private boolean limitCheck(final String val, final int min, final int max) {
		
		try {
			int num = Integer.parseInt(val);
		
			if ((min <= num) && (num <= max)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
