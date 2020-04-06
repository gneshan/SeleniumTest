package mustKnowJavaforSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://root@localhost/demodatabase");
		Statement statement = connection.createStatement();

		String query = "Select * from tbl_teammembers";

		ResultSet results = statement.executeQuery(query);

		while(results.next()) {

			String SSO = results.getString(1);
			System.out.println(SSO);
			String firstName = results.getString(2);
			System.out.println(firstName);
			String lastName = results.getString(3);
			System.out.println(lastName);

		}





	}

}
