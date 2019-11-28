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
			System.out.println(" Database Term Project // CY�ƿ﷿ Ű����ũ �ý��� ");
			System.out.println(" 2015041032 ������ ");
			System.out.println(" Chungbuk National University");
			System.out.println("------------------------------------------------------------");
			System.out.println(" 1. connection 2. showDB ");
			System.out.println(" 3. insertCustomer 4. deleteCustomer");
			System.out.println(" 5. insertShop 6. deleteShop");
			System.out.println(" 7. insertKiosk 8. deleteKiosk");
			System.out.println(" 99. quit ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Enter an integer: ");
			int number = menu.nextInt();
			switch(number) {
			case 1:
				System.out.println();
				ConnectDB();			//DB�� �����ϴ� �Լ�
				break;
			case 2:
				System.out.println();
				ShowDB();				//DB�� ����ϴ� �Լ�
				break;
			case 3:
				System.out.println();
				InsertCustomer();		//�� �߰�
				break;
			case 4:
				System.out.println();
				DeleteCustomer();		//�� ����
				break;
			case 5:
				System.out.println();
				InsertShop();			//���� �߰�
				break;
			case 6:
				System.out.println();
				DeleteShop();			//���� ����
				break;
			case 7:
				System.out.println();
				InsertKiosk();
				break;
			case 8:
				System.out.println();
				DeleteKiosk();
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
		System.out.println("���������� DB�� �����߽��ϴ�.");
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
			System.out.println("99. quit");
			System.out.println("------------------------------------------------------------");
			System.out.print("Ȯ�� �Ϸ��� ��� �Է� : ");
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
			case 5:
				System.out.println();
				ShowShop();
				break;	
			case 6:
				System.out.println();
				ShowKiosk();
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
		System.out.println("���� ��ȣ�� 1xxx�Դϴ�.");
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		String cusnum=menu.nextLine();
		System.out.print("���� �̸��� �Է��ϼ��� : ");
		String name=menu.nextLine();
		System.out.print("���� �ּҸ� �Է��ϼ��� : ");
		String location=menu.nextLine();
		System.out.print("���� ��ȭ��ȣ�� �Է��ϼ��� : ");
		String phonenum=menu.nextLine();
		String sql=("insert into customer values('"+cusnum+"','"+name+"','"+location+"','"+phonenum+"')");
		stmt.executeUpdate(sql);
		System.out.println("���������� ����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println(e);}
		
	}
	public static void DeleteCustomer() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("������ ���� ��ȣ�� �Է��ϼ��� : ");
			String cusnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from customer where cusnum="+cusnum+";");
			stmt.executeUpdate(sql);
			System.out.println("���������� �����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void InsertShop() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("������ ��ȣ�� 2xxx�Դϴ�.");
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		String shopnum=menu.nextLine();
		System.out.print("���� �ּҸ� �Է��ϼ��� : ");
		String location=menu.nextLine();
		
		String sql=("insert into shop values('"+shopnum+"','"+location+"')");
		stmt.executeUpdate(sql);
		System.out.println("���������� ����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void DeleteShop() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("������ ������ ��ȣ�� �Է��ϼ��� : ");
			String shopnum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from shop where shopnum="+shopnum+";");
			stmt.executeUpdate(sql);
			System.out.println("���������� �����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void InsertKiosk() {
		try{
		Statement stmt=con.createStatement();
		Scanner menu=new Scanner(System.in);
		System.out.println("Ű����ũ�� ��ȣ�� 3xxx�Դϴ�.");
		System.out.print("Ű����ũ ��ȣ�� �Է��ϼ��� : ");
		String kiosknum=menu.nextLine();
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		String shopnum=menu.nextLine();
		
		String sql=("insert into kiosk values('"+kiosknum+"','"+shopnum+"')");
		stmt.executeUpdate(sql);
		System.out.println("���������� ����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println("�� ���̺� ���� ��ȣ�� �����ϴ�.");}
	}
	public static void DeleteKiosk() {
		try {
			Scanner menu = new Scanner(System.in);
			System.out.print("������ Ű����ũ�� ��ȣ�� �Է��ϼ��� : ");
			String kiosknum = menu.nextLine();
			Statement stmt = con.createStatement();
			String sql=("delete from kiosk where kiosknum="+kiosknum+";");
			stmt.executeUpdate(sql);
			System.out.println("���������� �����Ǿ����ϴ�!");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void ShowCustomer() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM customer");
			System.out.println("-------------------------�� ���-----------------------------");
			System.out.println("�� ��ȣ           �� �̸�           �� �ּ�        �� ��ȭ��ȣ ");
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
			System.out.println("-------------------------���� ���-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowSell() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sell");
			System.out.println("-------------------------�Ǹ� ���-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
				+" "+rs.getInt(5)+" "+rs.getDate(6)+" "+rs.getInt(7));
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowSellProduct() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM sellproduct");
			System.out.println("-------------------------��ǰ ���-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getInt(4));
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowShop() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM shop");
			System.out.println("-------------------------���� ���-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
	public static void ShowKiosk() {
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM kiosk");
			System.out.println("-------------------------Ű����ũ ���-----------------------------");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			System.out.println("------------------------------------------------------------");
		}catch(Exception e){ System.out.println(e);}
	}
}