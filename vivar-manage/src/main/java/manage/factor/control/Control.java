package manage.factor.control;

import java.util.List;
import java.util.Date;

import manage.factor.dao.Product;

public class Control {

	public void checkProductBetweenDate(Product pd, Date beginDate, Date closeDate) {
		Date d = pd.getManufactureDate();

		if (d.after(beginDate) && d.before(closeDate)) {
			System.out.println("between");
		} else {
			System.out.println("out of date");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
