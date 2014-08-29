package employ;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * このクラスは、日付表示形式の変換を行います。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class DateString {
	public static String getDate14(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}
	
}
