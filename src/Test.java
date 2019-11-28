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
			System.out.println(" 3. insertCustomer 4. deleteCustomer");
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
			case 3:
				System.out.println();
				InsertCustomer();
				break;
			case 4:
				System.out.println();
				DeleteCustomer();
				break;
			case 99:
				System.exit(0);
			}
		}
	}
	
	public static void ConnectDB() {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/project?useUnicode=yes&characterEncoding=UTF-8","jcy","1234");
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
			System.out.println(" 3. sell 4. sellproduct ");
			System.out.println(" 99. quit ");
			System.out.println("------------------------------------------------------------");
			System.out.print("확인 하려는 목록 입력 : ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ShowCustomer();
				break;
			case 2:
				System.out.println();
				ShowEmployee();
				break;
			case 3:
				System.out.println();
				ShowSell();
				break;
			case 4:
				System.out.println();
				ShowSellProduct();
				break;
			case 99:
				return;
			}
		}
	}
	
	public static void InsertCustomer() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.print("고객의 번호을 입력하세요 : ");
		String cusnum=menu.nextLine();
		System.out.print("고객의 이름을 입력하세요 : ");
		String name=menu.nextLine();
		System.out.print("고객의 주소를 입력하세요 : ");
		String location=menu.nextLine();
		System.out.print("고객의 전화번호를 입력하세요 : ");
		String phonenum=menu.nextLine();
		/*PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?)");
		pstmt.setString(1,cusnum);
		pstmt.setString(2,name);
		pstmt.setString(3,location);
		pstmt.setString(4,phonenum);
		pstmt.executeUpdate();*/
		String sql=("insert into customer values('"+cusnum+"','"+name+"','"+location+"','"+phonenum+"')");
		stmt.executeUpdate(sql);
		System.out.println("성공적으로 저장되었습니다!");
		}catch(Exception e) {System.out.println(e);}
		
	}
	public static void DeleteCustomer() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("삭제할 고객의 번호를 입력하세요 : ");
			String cusnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from customer where cusnum="+cusnum+";");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 삭제되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void ShowCustomer() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM customer");
			System.out.println("-------------------------고객 명단-----------------------------");
			System.out.println("고객 번호           고객 이름           고객 주소        고객 전화번호 ");
			while(rs.next()) {
				System.out.printf("%5s     ",rs.getString(1));
				System.out.printf("%4s       ",rs.getString(2));
				System.out.printf("%10s           ",rs.getString(3));
				System.out.printf("%11s    ",rs.getString(4));
				System.out.println();
			}
			con.close();
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowEmployee() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee");
			System.out.println("-------------------------직원 명단-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			con.close();
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowSell() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sell");
			System.out.println("-------------------------판매 명단-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
				+" "+rs.getInt(5)+" "+rs.getDate(6)+" "+rs.getInt(7));
			con.close();
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowSellProduct() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sellproduct");
			System.out.println("-------------------------물품 명단-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getInt(4));
			con.close();
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
}