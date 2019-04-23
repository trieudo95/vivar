package manage.factor.viver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manage.factor.control.Control;
import manage.factor.dao.Product;
import manage.factor.db.JdbcUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JdbcUtils jdbc = new JdbcUtils();
		Product pro = new Product();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");

		try {

			Date manufactureDateUtils = (Date) dateformat.parse("20181205");

			Date expirationDateUtils = (Date) dateformat.parse("20200114");
			//try date
			Date beforeDate = (Date) dateformat.parse("20170512");

			Date afterDate = (Date) dateformat.parse("20200114");
			

			java.sql.Date manufactureDate = new java.sql.Date(manufactureDateUtils.getTime());
			java.sql.Date expirationDate = new java.sql.Date(expirationDateUtils.getTime());
			System.out.println(manufactureDate);
			pro = new Product("TGF12R", "Dark Lamp", "Lamp for dark", 5.5, 21544, manufactureDate, expirationDate, 400);
			
			Control con = new Control();
			con.checkProductBetweenDate(pro, beforeDate, afterDate);
			
		//	jdbc.insertProdcut(pro);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
