import java.util.*;
import java.io.*;

// Server의 역할을 위한 Class
public class Server {

	private String id;
	private String pw;
	public Vector<User> userlist=new Vector<User>();
	private File addressFile;
	
	public void Userload() {
		File userfile = new File("User.cb");
		try {
			userlist.clear();
			ObjectInputStream oos=new ObjectInputStream(new FileInputStream(userfile));
			userlist=(Vector)oos.readObject();
			oos.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	public void Usersave() {
		try {
			FileOutputStream fostream = new FileOutputStream("User.cb");
			ObjectOutputStream oostream=new ObjectOutputStream(fostream);
			oostream.writeObject(userlist);
			oostream.flush();
			oostream.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	
	public String getId() {return id;}
	public String getPw() {return pw;}
	
	public void setId(String id) {this.id=id;}
	public void setPw(String pw) {this.pw=pw;}
	
	public void AddUserList(User user) {
		Userload();
		userlist.add(user);
		Usersave();
	}
	public void AddressSave(String id) {
		CB ServerCB = new CB();
		ServerCB.load();
		String filename=id+".cb";
		try {
			FileOutputStream fostream = new FileOutputStream(filename);
			ObjectOutputStream oostream=new ObjectOutputStream(fostream);
			oostream.writeObject(ServerCB.vc);
			oostream.flush();
			oostream.close();
			System.out.println("업로드완료");
			ServerCB.Operation();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	public void down(String id) {
		CB ServerCB=new CB();
		String filename=id+".cb";
		File addressFile=new File(filename);
		try {
			ServerCB.vc.clear();
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(addressFile));
			ServerCB.vc=(Vector)oos.readObject();
			oos.close();
			ServerCB.save();
			System.out.println("Download 완료");
			ServerCB.Operation();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
}
