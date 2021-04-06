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
			System.out.println(" 5. insertShop 6. deleteShop");
			System.out.println(" 7. insertKiosk 8. deleteKiosk");
			System.out.println(" 9. insertSellProduct 10. deleteSellProduct");
			System.out.println(" 11. insertEmployee 12. deleteEmployee");
			System.out.println(" 13. sell(order) 99. quit ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Enter an integer: ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ConnectDB();			//DB에 연결하는 함수
				break;
			case 2:
				System.out.println();
				ShowDB();				//DB를 출력하는 함수
				break;
			case 3:
				System.out.println();
				InsertCustomer();		//고객 추가
				break;
			case 4:
				System.out.println();
				DeleteCustomer();		//고객 삭제
				break;
			case 5:
				System.out.println();
				InsertShop();			//매장 추가
				break;
			case 6:
				System.out.println();
				DeleteShop();			//매장 삭제
				break;
			case 7:
				System.out.println();
				InsertKiosk();			//키오스크 추가
				break;
			case 8:
				System.out.println();
				DeleteKiosk();			//키오스크 삭제
				break;
			case 9:
				System.out.println();
				InsertSellProduct();	//판매품목 추가
				break;
			case 10:
				System.out.println();
				DeleteSellProduct();	//판매품목 삭제
				break;
			case 11:
				System.out.println();
				InsertEmployee();		//직원 추가
				break;
			case 12:
				System.out.println();
				DeleteEmployee();		//직원 삭제
				break;
			case 13:
				System.out.println();
				Sell();			//판매
				break;
			case 99:
				System.exit(0);
			}
		}
	}
	
	public static void ConnectDB() {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/project?useUnicode=yes&characterEncoding=UTF-8","아이디","비밀번호"); //JDBC로 mysql 계정에 접근
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
			System.out.println(" 5. shop 6. kiosk");
			System.out.println(" 99. quit");
			System.out.println("------------------------------------------------------------");
			System.out.print("확인 하려는 목록 입력 : ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ShowCustomer();		//고객 명단 출력
				break;
			case 2:
				System.out.println();
				ShowEmployee();		//직원 명단 출력
				break;
			case 3:
				System.out.println();
				ShowSell();			//판매 목록 출력
				break;
			case 4:
				System.out.println();
				ShowSellProduct();	//판매 품목 출력
				break;
			case 5:
				System.out.println();
				ShowShop();			//매장 목록 출력
				break;	
			case 6:
				System.out.println();
				ShowKiosk();		//키오스크 목록 출력
				break;
			case 99:
				return;
			}
		}
	}
	
	public static void InsertCustomer() {
		try{
		Statement stmt=con.createStatement(); //쿼리문을 실행하기 위한 객체
		Scanner menu=new Scanner(System.in);	//입력을 위한 스캐너
		System.out.println("고객의 번호는 1xxx입니다.");
		System.out.print("고객의 번호을 입력하세요 : ");
		String cusnum=menu.nextLine();			//변수에 한 줄 단위로 입력받는다
		System.out.print("고객의 이름을 입력하세요 : ");
		String name=menu.nextLine();
		System.out.print("고객의 주소를 입력하세요 : ");
		String location=menu.nextLine();
		System.out.print("고객의 전화번호를 입력하세요 : ");
		String phonenum=menu.nextLine();
		String sql=("insert into customer values('"+cusnum+"','"+name+"','"+location+"','"+phonenum+"')"); //String 변수 sql에 쿼리문을 저장
		stmt.executeUpdate(sql);	//stmt객체를 이용하여 sql 변수 쿼리문 실행
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
	public static void InsertShop() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("매장의 번호는 2xxx입니다.");
		System.out.print("매장 번호을 입력하세요 : ");
		String shopnum=menu.nextLine();
		System.out.print("매장 주소를 입력하세요 : ");
		String location=menu.nextLine();
		
		String sql=("insert into shop values('"+shopnum+"','"+location+"')");
		stmt.executeUpdate(sql);
		System.out.println("성공적으로 저장되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void DeleteShop() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("삭제할 매장의 번호를 입력하세요 : ");
			String shopnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from shop where shopnum="+shopnum+";");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 삭제되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void InsertKiosk() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("키오스크의 번호는 3xxx입니다.");
		System.out.print("키오스크 번호을 입력하세요 : ");
		String kiosknum=menu.nextLine();
		System.out.print("매장 번호를 입력하세요 : ");
		String shopnum=menu.nextLine();
		
		String sql=("insert into kiosk values('"+kiosknum+"','"+shopnum+"')");
		stmt.executeUpdate(sql);
		System.out.println("성공적으로 저장되었습니다!");
		}catch(Exception e) {System.out.println("주 테이블에 매장 번호가 없습니다.");}
	}
	public static void DeleteKiosk() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("삭제할 키오스크의 번호를 입력하세요 : ");
			String kiosknum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from kiosk where kiosknum="+kiosknum+";");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 삭제되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void InsertEmployee() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("직원의 번호는 6xxx입니다.");
		System.out.print("직원 번호을 입력하세요 : ");
		String empno=menu.nextLine();
		System.out.print("직원 계급을 입력하세요 : ");
		String position=menu.nextLine();
		System.out.print("직원 이름을 입력하세요 : ");
		String name=menu.nextLine();
		System.out.print("직원 주소을 입력하세요 : ");
		String location=menu.nextLine();
		System.out.print("직원 전화번호를 입력하세요 : ");
		String phonenum=menu.nextLine();
		
		String sql=("insert into employee values('"+empno+"','"+position+"','"+name+"','"+location+"','"+phonenum+"')");
		stmt.executeUpdate(sql);
		System.out.println("성공적으로 저장되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void DeleteEmployee() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("삭제할 매장의 번호를 입력하세요 : ");
			String shopnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from shop where shopnum="+shopnum+";");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 삭제되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void InsertSellProduct() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("판매 물품의 번호는 4xxx입니다.");
		System.out.print("매장 번호를 입력하세요 : ");
		String shopnum=menu.nextLine();
		System.out.print("판매 물품 번호를 입력하세요 : ");
		String productnum=menu.nextLine();
		System.out.print("유통기한 입력하세요 : ");
		String life=menu.nextLine();
		System.out.print("가격을 입력하세요 : ");
		String price=menu.nextLine();
		
		String sql=("insert into sellproduct values('"+shopnum+"','"+productnum+"','"+life+"','"+price+"')");
		stmt.executeUpdate(sql);
		System.out.println("성공적으로 저장되었습니다!");
		}catch(Exception e) {System.out.println("주 테이블에 행이 없습니다.");}
	}
	public static void DeleteSellProduct() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("삭제할 판매 물품의 번호를 입력하세요 : ");
			String productnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from sellproduct where productnum="+productnum+";");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 삭제되었습니다!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void Sell() {
		try{
			Statement stmt=con.createStatement();
			Scanner menu=new Scanner(System.in);
			System.out.println("판매 번호는 5xxx입니다.");
			System.out.print("판매 번호를 입력하세요 : ");
			String sellnum=menu.nextLine();
			System.out.print("매장 번호를 입력하세요 : ");
			String shopnum=menu.nextLine();
			System.out.print("고객 번호를 입력하세요 : ");
			String cusnum=menu.nextLine();
			System.out.print("판매 물품 번호를 입력하세요 : ");
			String productnum=menu.nextLine();
			System.out.print("수량을 입력하세요 : ");
			String count=menu.nextLine();
			System.out.print("판매 날짜를 입력하세요 : ");
			String selldate=menu.nextLine();
			int c=Integer.parseInt(count); //count를 int형으로 변환
			rs = stmt.executeQuery("SELECT price FROM sellproduct where productnum="+productnum+";");	//rs객체에 쿼리문의 결과를 저장한다
			rs.next();	//쿼리문의 주소?가 담겨있어서 next()를 통해 값에 접근
			int price=rs.getInt(1);	//price를 int형으로 변환
			int pay=c*price;	//수량*가격=금액

			
			
			
			String sql=("insert into sell values('"+sellnum+"','"+shopnum+"','"+cusnum+"','"+productnum+"','"+count+"','"+selldate+"','"+pay+"')");
			stmt.executeUpdate(sql);
			System.out.println("성공적으로 저장되었습니다!");
			}catch(Exception e) {System.out.println("주 테이블에 행이 없습니다.");}
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
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
	public static void ShowEmployee() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee");
			System.out.println("-------------------------직원 명단-----------------------------");
			while(rs.next())
				System.out.println("[직원 번호 : "+rs.getString(1)+"] [직원 계급 : "+rs.getString(2)+"] [직원 이름 : "+rs.getString(3)+"] [직원 주소 : "+rs.getString(4)+"] [직원 전화번호 : "+rs.getString(5)+"]");
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
	public static void ShowSell() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sell");
			System.out.println("-------------------------판매 명단-----------------------------");
			while(rs.next())
				System.out.println("[판매 번호 : "+rs.getString(1)+"] [매장 번호 : "+rs.getString(2)+"] [고객 번호 : "+rs.getString(3)+"] [판매품목 번호 : "+rs.getString(4)
				+"] [수량 : "+rs.getInt(5)+"] [판매 날짜 : "+rs.getDate(6)+"] [금액 : "+rs.getInt(7)+"]");
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
	public static void ShowSellProduct() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sellproduct");
			System.out.println("-------------------------물품 목록-----------------------------");
			System.out.println("매장 번호           물품 번호           유통 기한                          가격 ");
			while(rs.next()) {
				System.out.printf("%5s     ",rs.getString(1));
				System.out.printf("%4s       ",rs.getString(2));
				System.out.printf("%5s ",rs.getDate(3));
				System.out.printf("%11s    ",rs.getInt(4));
				System.out.println();
			}
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
	public static void ShowShop() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM shop");
			System.out.println("-------------------------매장 목록-----------------------------");
			while(rs.next())
				System.out.println("[매장 번호 : "+rs.getString(1)+"] [매장 위치 : "+rs.getString(2)+"]");
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
	public static void ShowKiosk() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM kiosk");
			System.out.println("-------------------------키오스크 목록-----------------------------");
			while(rs.next())
				System.out.println("[키오스크 번호 : "+rs.getString(1)+"] [매장 번호 : "+rs.getString(2)+"]");
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println("데이터베이스에 연결하세요");}
	}
}
