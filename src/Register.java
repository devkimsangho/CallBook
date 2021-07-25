import java.util.Scanner;
// 회원가입을 위한 Class
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
		System.out.println("회원가입");
		System.out.print("이름 : ");
		name=sc_reg.nextLine();
		System.out.print("생년월일(ex 970326) : ");
		birth=sc_reg.nextInt();
		sc_reg.nextLine();
		System.out.print("성별(남/여) : ");
		String Strgender;
		Strgender=sc_reg.nextLine();
		if(Strgender.equals("남")) gender=true;
		else gender=false;
		System.out.print("ID : ");
		id=sc_reg.nextLine();
		System.out.print("Password : ");
		pw=sc_reg.nextLine();
		System.out.print("전화번호 : ");
		tel=sc_reg.nextLine();
		System.out.print("e-mail : ");
		email=sc_reg.nextLine();
		
		if(HasId(id) || HasUser(tel)) {
			System.out.println("이미 존재하는 회원 정보입니다.");
		}
		else {
			NewUser();
		}
		
	}
	
	
	public boolean HasId(String id) {
		for(int i=0;i<server.userlist.size();i++) {
			if(id.equals(server.userlist.elementAt(i).getUserId())) {
				System.out.println("아이디가 존재합니다.");
				return true;
			}
		}
		return false;
	}
	public boolean HasUser(String tel) {
		for(int i=0;i<server.userlist.size();i++) {
			if(id.equals(server.userlist.elementAt(i).getUserTel())) {
				System.out.println("전화번호가 존재합니다.");
				return true;
			}
		}
		return false;
	}
	public void NewUser() {
		User us=new User(this.name,this.id,this.pw,this.gender,this.tel,this.email,this.birth);
		server.AddUserList(us);
		server.Usersave();
		System.out.println("회원가입이 완료되었습니다.");
	}

}
