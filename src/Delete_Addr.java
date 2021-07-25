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
		System.out.println("<<��ȣ����>>");
		if(DelCB.vc.size()<=0) {
			System.out.println("������ ����ó�� �����ϴ�.");
			DelCB.Operation();
		}
		System.out.print("1. �̸����� ���� / 2. ��ȭ��ȣ�� ���� / 3. ������ ���� : ");
		option=sc_de.nextInt();
		sc_de.nextLine();
		switch(option) {
		case 1:
			String delName;
			System.out.print("�̸��� �Է����ּ��� : ");
			delName=sc_de.nextLine();
			deleteByName(delName);
			break;
		case 2:
			String delTel;
			System.out.println("��ȭ��ȣ�� �Է����ּ��� : ");
			delTel=sc_de.nextLine();
			deleteByTel(delTel);
			break;
		case 3:
			multiDelete();
			break;
		default:
			System.out.println("�߸��� �����Դϴ�.");
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
			System.out.println("�����Ϸ�");
		}
		else {
			System.out.println("�������� �ʴ� �̸��Դϴ�.");
		}
	}
	
	public void deleteByTel(String tel) {
		int isi = isInAddr(null,tel,2);
		if(isi!=-1) {
			DelCB.vc.removeElementAt(isi);
			DelCB.save();
			System.out.println("�����Ϸ�");
		}
		else {
			System.out.println("�������� �ʴ� ��ȣ�Դϴ�.");
		}
	}
	public void multiDelete() {
		int op;
		System.out.println("<<������ ���� ���>>");
		System.out.print("1.�̸����� ����, 2.��ȣ�� ���� : ");
		op=sc_de.nextInt();
		sc_de.nextLine();
		
		switch(op) {
			case 1:
				while(true) {
					String deleteName;
					System.out.print("�̸��� �Է����ּ���(end �Է½� ����) : ");
					deleteName=sc_de.nextLine();
					if(deleteName.equals("end")) {
						DelCB.save();
						break;
					}
					
					deleteByName(deleteName);
					if(DelCB.vc.size()<=0) {
						System.out.println("������ ����ó�� �����ϴ�.");
						DelCB.Operation();
					}
				}
				break;
			case 2:
				while(true) {
					String deleteTel;
					System.out.print("��ȭ��ȣ�� �Է����ּ���(end �Է½� ����) : ");
					deleteTel=sc_de.nextLine();
					if(deleteTel.equals("end")) {
						DelCB.save();
						break;
					}
					deleteByTel(deleteTel);
					if(DelCB.vc.size()<=0) {
						System.out.println("������ ����ó�� �����ϴ�.");
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
