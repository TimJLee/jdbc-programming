
import java.sql.*;
import java.util.Scanner;

public class CallableStatementTest
{
	public static void main(String[] argv)
	{
		Connection conn;
		Scanner sc = new Scanner(System.in);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@117.17.198.43:1531:ORCL",
				"CSDB226", "kingdragon95");
		CallableStatement cs;
		cs = conn.prepareCall("{call r_date (?)}");

		System.out.println("input product number: ");
		int p_num = sc.nextInt();

		cs.setInt(1, p_num);
		cs.executeUpdate();

		cs.close();
		conn.close();
	}catch(Exception e)
         {e.printStackTrace();}
  }
}
