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
		System.out.println("<<연락처 숨김>>");
		if(HidCB.vc.size()<=0) {
			System.out.println("출력할 연락처가 없습니다.");
			HidCB.Operation();
		}
		System.out.print("1. 연락처 숨기기 / 2. 숨겨진 연락처 보기 / 3. 숨겨진 연락처 다시 보이게 하기 : ");
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
				System.out.print("숨길 연락처의 번호를 선택하세요 : ");
				sel =sc_hi.nextInt();
				sc_hi.nextLine();
				HidCB.vc.elementAt(sel).setHiding(true);
				System.out.println("숨김 완료");
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
					System.out.println("숨겨진 연락처가 없습니다.");
					break;
				}
				System.out.print("다시 보이게 할 연락처의 번호를 선택하세요 : ");
				sel=sc_hi.nextInt();
				sc_hi.nextLine();
				HidCB.vc.elementAt(sel).setHiding(false);
				System.out.println("보이기 완료");
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
		System.out.println("숨겨진 연락처 목록");
		int cnt=0;
	for(int i=0;i<HidCB.vc.size();i++) {
		Address adr=HidCB.vc.elementAt(i);
		if(adr.getHiding()==true) {
			System.out.println(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t"+adr.getLateCall());
			cnt++;
		}
	}
	if(cnt==0) {
		System.out.println("숨겨진 연락처가 없습니다.");
	}
	else {
		System.out.println("출력완료");
	}}
	
	
}
