package negocio;

import java.util.Calendar;
import java.util.Date;

public class Util {

	public static boolean compararDatas(Date data1, Date data2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(data1);
		cal2.setTime(data2);
		if (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			return true;
		}
		return false;
	}
	
	public static boolean compararDataComACorrente(Date data1){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(data1);
		cal2.setTime(new Date());
		if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) 
				&& cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.DATE) >= cal2.get(Calendar.DATE)
				){
			return true;
		}
		return false;
	}
	
}
