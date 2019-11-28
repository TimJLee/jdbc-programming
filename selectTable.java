import java.sql.*;
public class selectTable
{
	public static void main(String[] argv)
	{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection
				("jdbc:oracle:thin:@117.17.198.43:1531:ORCL",
				"CSDB226", "kingdragon95");
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM customer");
			while(rs.next())
			{

				String no = rs.getString(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				String date = rs.getString(6);
				String join = rs.getString(7);


				System.out.println(" NO : " + no);
				System.out.println(" NAME : " + name);
				System.out.println(" ADDRESS : " + addr);
				System.out.println(" PHONE : " + phone);
				System.out.println(" EMAIL : " + email);
				System.out.println(" DATE : " + date);
				System.out.println(" JOIN : " + join);
				System.out.println(" ================================================== ");
			}

			rs.close();

			stmt.close();

			conn.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
