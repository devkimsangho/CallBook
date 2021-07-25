import java.util.Scanner;
// ȸ�������� ���� Class
public class Register {
	
	private String name;
	private String id;
	private String pw;
	private boolean gender;
	private String tel;
	private String email;
	private int birth;
	private Server server = new Server();
	
	
	public Register() {
		server.Userload();
		Scanner sc_reg=new Scanner(System.in);
		System.out.println("=======================================");
		System.out.println("ȸ������");
		System.out.print("�̸� : ");
		name=sc_reg.nextLine();
		System.out.print("�������(ex 970326) : ");
		birth=sc_reg.nextInt();
		sc_reg.nextLine();
		System.out.print("����(��/��) : ");
		String Strgender;
		Strgender=sc_reg.nextLine();
		if(Strgender.equals("��")) gender=true;
		else gender=false;
		System.out.print("ID : ");
		id=sc_reg.nextLine();
		System.out.print("Password : ");
		pw=sc_reg.nextLine();
		System.out.print("��ȭ��ȣ : ");
		tel=sc_reg.nextLine();
		System.out.print("e-mail : ");
		email=sc_reg.nextLine();
		
		if(HasId(id) || HasUser(tel)) {
			System.out.println("�̹� �����ϴ� ȸ�� �����Դϴ�.");
		}
		else {
			NewUser();
		}
		
	}
	
	
	public boolean HasId(String id) {
		for(int i=0;i<server.userlist.size();i++) {
			if(id.equals(server.userlist.elementAt(i).getUserId())) {
				System.out.println("���̵� �����մϴ�.");
				return true;
			}
		}
		return false;
	}
	public boolean HasUser(String tel) {
		for(int i=0;i<server.userlist.size();i++) {
			if(id.equals(server.userlist.elementAt(i).getUserTel())) {
				System.out.println("��ȭ��ȣ�� �����մϴ�.");
				return true;
			}
		}
		return false;
	}
	public void NewUser() {
		User us=new User(this.name,this.id,this.pw,this.gender,this.tel,this.email,this.birth);
		server.AddUserList(us);
		server.Usersave();
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
	}

}
