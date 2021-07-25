import java.util.*;

public class Hide {
	private String name;
	private String tel;
	private boolean hiding;
	private CB HidCB = new CB();
	private Scanner sc_hi = new Scanner(System.in);
	
	public Hide() {
		HidCB.load();
		int option;
		System.out.println("=======================================");
		System.out.println("<<����ó ����>>");
		if(HidCB.vc.size()<=0) {
			System.out.println("����� ����ó�� �����ϴ�.");
			HidCB.Operation();
		}
		System.out.print("1. ����ó ����� / 2. ������ ����ó ���� / 3. ������ ����ó �ٽ� ���̰� �ϱ� : ");
		option = sc_hi.nextInt();
		sc_hi.nextLine();
		int sel;
		int cnt=0;
		switch(option) {
			case 1:
				for(int i=0;i<HidCB.vc.size();i++) {
					Address adr=HidCB.vc.elementAt(i);
					if(adr.getHiding()==false){
						System.out.println("["+i+"]"+adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t"+adr.getLateCall());
					}
				}
				System.out.print("���� ����ó�� ��ȣ�� �����ϼ��� : ");
				sel =sc_hi.nextInt();
				sc_hi.nextLine();
				HidCB.vc.elementAt(sel).setHiding(true);
				System.out.println("���� �Ϸ�");
				break;
			case 2:
				showHidingList();
				break;
			case 3:
				for(int i=0;i<HidCB.vc.size();i++) {
					Address adr=HidCB.vc.elementAt(i);
					if(adr.getHiding()==true) {
						System.out.println("["+i+"]"+adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t"+adr.getLateCall());
						cnt++;
					}
				}
				if(cnt==0) {
					System.out.println("������ ����ó�� �����ϴ�.");
					break;
				}
				System.out.print("�ٽ� ���̰� �� ����ó�� ��ȣ�� �����ϼ��� : ");
				sel=sc_hi.nextInt();
				sc_hi.nextLine();
				HidCB.vc.elementAt(sel).setHiding(false);
				System.out.println("���̱� �Ϸ�");
				break;
		}
		HidCB.save();
		HidCB.Operation();
	}
	
	
	public String getName() {return name;}
	public String getTel() {return tel;}
	public boolean getHiding() {return hiding;}
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setHiding(boolean hiding) {this.hiding=hiding;}
	public void showHidingList() {
		System.out.println("������ ����ó ���");
		int cnt=0;
	for(int i=0;i<HidCB.vc.size();i++) {
		Address adr=HidCB.vc.elementAt(i);
		if(adr.getHiding()==true) {
			System.out.println(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t"+adr.getLateCall());
			cnt++;
		}
	}
	if(cnt==0) {
		System.out.println("������ ����ó�� �����ϴ�.");
	}
	else {
		System.out.println("��¿Ϸ�");
	}}
	
	
}
