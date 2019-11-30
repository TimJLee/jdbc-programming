import java.sql.*;

public class selectTablePrepared
{
	public static void main(String[] argv)
	{
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@117.17.198.43:1531:ORCL",
				"CSDB226", "kingdragon95");
			pstmt = conn.prepareStatement(
				"SELECT * FROM buying WHERE b_p_date = ? ");

			pstmt.setString(1, "17/09/13");

			rs = pstmt.executeQuery();
			while(rs.next())
			{

			     String c_no = rs.getString(1);
			     String p_name = rs.getString(2);
			     String date = rs.getString(3);


				System.out.println(" CUST NO : " + c_no);
				System.out.println(" PRODUCT NAME : " + p_name);
				System.out.println(" PRODUCT DATE : " + date);

				System.out.println(" ================================================== ");
			}

			rs.close();

			pstmt.close();

			conn.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
