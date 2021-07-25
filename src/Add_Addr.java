import java.util.Scanner;

public class Add_Addr {
	private String name;
	private String tel;
	private String etc;
	private String lateCall;
	private Scanner sc_ad = new Scanner(System.in);
	private CB AddCB = new CB();
	
	public String getName() {return name;}
	public String getTel() {return tel;}
	public String getEtc() {return etc;}
	public String getLateCall() {return lateCall;}
	
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setEtc(String etc) {this.etc=etc;}
	public void setLateCall(String lateCall) {this.lateCall=lateCall;}
	
	public boolean isAlreadyAdd(String name, String tel) {
		for(int i=0;i<(AddCB.vc).size();i++) {
			if((AddCB.vc.elementAt(i).getTel()).equals(tel) || AddCB.vc.elementAt(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	
	public Add_Addr() {
		AddCB.load();
		System.out.println("=======================================");
		System.out.println("<<��ȣ �߰�>>");
		System.out.print("�̸� : ");
		name = sc_ad.nextLine();
		System.out.print("��ȭ��ȣ : ");
		tel=sc_ad.nextLine();
		System.out.print("��Ÿ���� : ");
		etc=sc_ad.nextLine();
		System.out.print("�ֱٿ�����(ex 20200610 / ������ x �Է�) : ");
		lateCall=sc_ad.nextLine();

	
		if (isAlreadyAdd(name,tel)==false) {
			Address adr = new Address(name,tel,etc,false,lateCall);
			AddCB.vc.add(adr);
			System.out.println("�߰��Ϸ�");
			AddCB.save();
			AddCB.Operation();
		}
		else {
			System.out.println("�̹� �����ϴ� �̸�/��ȭ��ȣ �Դϴ�.");
			AddCB.Operation();
		}
	}

}
