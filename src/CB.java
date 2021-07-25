import java.io.*;
import java.util.*;

// CallBook Program을 실행시키는 Class
public class CB {
	public Vector<Address> vc=new Vector<Address>();
	private Scanner sc_cb=new Scanner(System.in);
	public void load() {
		File cbfile = new File("address.cb");
		try {
			vc.clear();
			ObjectInputStream oos=new ObjectInputStream(new FileInputStream(cbfile));
			vc=(Vector)oos.readObject();
			oos.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	public void save() {
		try {
			FileOutputStream fostream = new FileOutputStream("address.cb");
			ObjectOutputStream oostream=new ObjectOutputStream(fostream);
			oostream.writeObject(vc);
			oostream.flush();
			oostream.close();
		}
		catch(Exception ex){
			ex.getMessage();
		}
	}
	
	public void ShowMenu() {
		System.out.println("========= Call Book ver.1.0.1 =========");
		ShowAddressList();
		System.out.println("=======================================");
		System.out.println("1. Regist");
		System.out.println("2. Add / 3. Delete / 4. Change / 5. Search / 6. Hide / 7. Sort");
		System.out.println("8. Upload / 9. Download");
		System.out.println("0. Save and Exit / -1. reset(주소록비우기)");
		System.out.println("=======================================");
		System.out.print("Input : ");
	}
	
	public void ShowAddressList() {
		System.out.println("이름 \t 전화번호 \t\t 기타사항 \t 최근연락일");
		for(int i=0;i<vc.size();i++) {
			Address adr = vc.elementAt(i);
			if(adr.getHiding()==false) {
				System.out.println(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t"+adr.getLateCall());
			}
		}
	}
	
	public void Operation() {
		load();
		int option;
		ShowMenu();
		option = sc_cb.nextInt();
		switch(option) {
		case 0:
			save();
			return;
		case 1:
			new Register();
			Operation();
			break;
		case 2:
			new Add_Addr();
			break;
		case 3:
			new Delete_Addr();
			break;
		case 4:
			new Change();
			break;
		case 5:
			new Search();
			break;
		case 6:
			new Hide();
			break;
		case 7:
			new Sort();
			break;
		case 8:
			new Upload();
			break;
		case 9:
			new Download();
			break;
		case -1:
			vc.clear();
			save();
			Operation();
		default:
		}
	}
	
	
	public static void main(String[] args) {
		CB CallBook = new CB();
		CallBook.Operation();
	}

}
