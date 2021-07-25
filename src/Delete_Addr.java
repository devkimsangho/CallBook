import java.util.*;

public class Delete_Addr {
	private String name;
	private int option;
	private String tel;
	private CB DelCB=new CB();
	private Scanner sc_de = new Scanner(System.in);
	
	public Delete_Addr() {
		DelCB.load();
		System.out.println("=======================================");
		System.out.println("<<번호삭제>>");
		if(DelCB.vc.size()<=0) {
			System.out.println("삭제할 연락처가 없습니다.");
			DelCB.Operation();
		}
		System.out.print("1. 이름으로 삭제 / 2. 전화번호로 삭제 / 3. 여러명 삭제 : ");
		option=sc_de.nextInt();
		sc_de.nextLine();
		switch(option) {
		case 1:
			String delName;
			System.out.print("이름을 입력해주세요 : ");
			delName=sc_de.nextLine();
			deleteByName(delName);
			break;
		case 2:
			String delTel;
			System.out.println("전화번호를 입력해주세요 : ");
			delTel=sc_de.nextLine();
			deleteByTel(delTel);
			break;
		case 3:
			multiDelete();
			break;
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
		DelCB.Operation();
	}
	
	public String getName() {return name;}
	public String getTel() {return tel;}
	public int getOption() {return option;}
	
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setOption(int option) {this.option=option;}
	
	public void deleteByName(String name) {
		int isi=isInAddr(name,null,1);
		if(isi!=-1) {
			DelCB.vc.removeElementAt(isi);
			DelCB.save();
			System.out.println("삭제완료");
		}
		else {
			System.out.println("존재하지 않는 이름입니다.");
		}
	}
	
	public void deleteByTel(String tel) {
		int isi = isInAddr(null,tel,2);
		if(isi!=-1) {
			DelCB.vc.removeElementAt(isi);
			DelCB.save();
			System.out.println("삭제완료");
		}
		else {
			System.out.println("존재하지 않는 번호입니다.");
		}
	}
	public void multiDelete() {
		int op;
		System.out.println("<<여러명 삭제 방식>>");
		System.out.print("1.이름으로 삭제, 2.번호로 삭제 : ");
		op=sc_de.nextInt();
		sc_de.nextLine();
		
		switch(op) {
			case 1:
				while(true) {
					String deleteName;
					System.out.print("이름을 입력해주세요(end 입력시 종료) : ");
					deleteName=sc_de.nextLine();
					if(deleteName.equals("end")) {
						DelCB.save();
						break;
					}
					
					deleteByName(deleteName);
					if(DelCB.vc.size()<=0) {
						System.out.println("삭제할 연락처가 없습니다.");
						DelCB.Operation();
					}
				}
				break;
			case 2:
				while(true) {
					String deleteTel;
					System.out.print("전화번호를 입력해주세요(end 입력시 종료) : ");
					deleteTel=sc_de.nextLine();
					if(deleteTel.equals("end")) {
						DelCB.save();
						break;
					}
					deleteByTel(deleteTel);
					if(DelCB.vc.size()<=0) {
						System.out.println("삭제할 연락처가 없습니다.");
						DelCB.Operation();
					}
				}
				break;
		}
	}
	public int isInAddr(String name,String tel,int option) {
		switch(option) {
			case 1:
				for(int i=0;i<DelCB.vc.size();i++) {
					Address adr = DelCB.vc.elementAt(i);
					if(adr.getName().equals(name)) {
						return i;
					}
				}
				return -1;
			case 2:
				for(int i=0;i<DelCB.vc.size();i++) {
					Address adr = DelCB.vc.elementAt(i);
					if(adr.getTel().equals(tel)) {
						return i;
					}
				}
				return -1;
			default:
				return -1;
		}
	}
}
