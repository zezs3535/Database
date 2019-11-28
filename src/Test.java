import java.sql.*;
import java.util.Scanner;
public class Test
{
	static Connection con;
	static ResultSet rs;
	public static void main(String args[])
	{
		Scanner menu = new Scanner(System.in);
		
		while(true)
		{
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("------------------------------------------------------------");
			System.out.println(" Database Term Project // CY아울렛 키오스크 시스템 ");
			System.out.println(" 2015041032 장찬용 ");
			System.out.println(" Chungbuk National University");
			System.out.println("------------------------------------------------------------");
			System.out.println(" 1. connection 2. showDB ");
			System.out.println(" 99. quit ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Enter an integer: ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ConnectDB();
				break;
			case 2:
				System.out.println();
				ShowDB();
				break;
			case 99:
				System.exit(0);
			}
		}
	}
	
	public static void ConnectDB() {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/project","jcy","1234");
		}catch(Exception e){ System.out.println(e);} 
		System.out.println("성공적으로 DB에 연결했습니다.");
	}
	
	public static void ShowDB() {
		Scanner menu = new Scanner(System.in);
		
		while(true)
		{
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("------------------------------------------------------------");
			System.out.println(" 1. customer 2. employee ");
			System.out.println(" 3. kiosk 4. sell ");
			System.out.println(" 5. sellproduct 6. shop ");
			System.out.println(" 99. quit ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Enter an integer: ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ShowCustomer();
				break;
			case 2:
				System.out.println();
				ShowDB();
				break;
			case 99:
				
				break;
			}
		}
	}
	
	public static void ShowCustomer() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM customer");
			System.out.println("-------------------------고객 명단-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			con.close();
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
}