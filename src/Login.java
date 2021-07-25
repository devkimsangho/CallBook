import java.util.*;
import java.io.*;

public class Login{
	private String id;
	private String pw;
	private Server server = new Server();
	
	private boolean logined=false;
	public Login() {
		server.Userload();
		Scanner sc_lo = new Scanner(System.in);
		System.out.println("=======================================");
		System.out.println("<<로그인>>");
		System.out.print("ID : ");
		id=sc_lo.nextLine();
		System.out.print("Password : ");
		pw=sc_lo.nextLine();
		if(userCheck(id,pw)==false) {
			CB loCB=new CB();
			loCB.Operation();
		}
		
	}
	public boolean userCheck(String id, String pw) {
		for(int i=0;i<server.userlist.size();i++){
			if(id.equals(server.userlist.elementAt(i).getUserId())) {
				if(pw.equals(server.userlist.elementAt(i).getUserPw())){
					this.logined=true;
					System.out.println("로그인완료");
					return true;
				}
			}
		}
		System.out.println("로그인실패");
		return false;
	}
	public boolean getLogined() {return logined;}
	public String getId() {return id;}
}