import java.util.*;

public class Change {
	private String name;
	private String tel;
	private String etc;
	private int option;
	private String lateCall;
	private CB ChaCB=new CB();
	private Scanner sc_ch = new Scanner(System.in);
	
	public Change() {
		ChaCB.load();
		
		System.out.println("=======================================");
		System.out.println("<<수정>>");
		if(ChaCB.vc.size()<=0) {
			System.out.println("삭제할 연락처가 없습니다.");
			ChaCB.Operation();
		}
		System.out.print("1. 이름 찾아서 수정 / 2. 전화번호 찾아서 수정 / 3. 일괄수정 : ");
		option=sc_ch.nextInt();
		sc_ch.nextLine();
		
		switch(option) {
			case 1:
				String chaName;
				System.out.println("이름을 입력해주세요 : ");
				chaName=sc_ch.nextLine();
				changeByName(chaName);
				break;
			case 2:
				String chaTel;
				System.out.println("전화번호를 입력해주세요 : ");
				chaTel=sc_ch.nextLine();
				changeByTel(chaTel);
				break;
			case 3:
				multiChange();
				break;
		}
		ChaCB.Operation();
	}
	
	public String getName() {return name;}
	public String getTel() {return tel;}
	public String getEtc() {return etc;}
	public int getOption() {return option;}
	public String getLateCall() {return lateCall;}
	
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setEtc(String etc) {this.etc=etc;}
	public void setOption(int option) {this.option=option;}
	public void setLateCall(String lateCall) {this.lateCall=lateCall;}
	
	public int isInAddr(String name,String tel,int option) {
		switch(option) {
		case 1:
			for(int i=0;i<ChaCB.vc.size();i++) {
				Address adr = ChaCB.vc.elementAt(i);
				if(adr.getName().equals(name)) {
					return i;
				}
			}
			return -1;
		case 2:
			for(int i=0;i<ChaCB.vc.size();i++) {
				Address adr = ChaCB.vc.elementAt(i);
				if(adr.getTel().equals(tel)) {
					return i;
				}
			}
			return -1;
		default:
			return -1;
	}
	}
	public void changeByName(String name) {
		int isi=isInAddr(name,null,1);
		if(isi!=-1) {
			
			System.out.print("이름 : ");
			String chaName = sc_ch.nextLine();
			System.out.print("전화번호 : ");
			String chaTel=sc_ch.nextLine();
			System.out.print("기타사항 : ");
			String chaEtc=sc_ch.nextLine();
			System.out.print("최근연락일(ex 20200610 / 없으면 x) : ");
			String chaLateCall=sc_ch.nextLine();
			for(int i=0;i<ChaCB.vc.size();i++) {
				if(i==isi) continue;
				if(ChaCB.vc.elementAt(i).getTel().equals(chaTel) || ChaCB.vc.elementAt(i).getName().contentEquals(chaName)) {
					System.out.println("중복되는 연락처가 존재합니다. 수정실패");
					ChaCB.Operation();
					break;
				}
			}
			Address adr=new Address(chaName,chaTel,chaEtc,false,chaLateCall);
			ChaCB.vc.removeElementAt(isi);
			ChaCB.vc.add(adr);
			ChaCB.save();
			System.out.println("수정 완료");
		}
		else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}
	public void changeByTel(String tel) {
		int isi=isInAddr(null,tel,2);
		if(isi!=-1) {
			System.out.print("이름 : ");
			String chaName = sc_ch.nextLine();
			System.out.print("전화번호 : ");
			String chaTel=sc_ch.nextLine();
			System.out.print("기타사항 : ");
			String chaEtc=sc_ch.nextLine();
			System.out.print("최근연락일(ex 20200610) : ");
			String chaLateCall=sc_ch.nextLine();
			for(int i=0;i<ChaCB.vc.size();i++) {
				if(i==isi) continue;
				if(ChaCB.vc.elementAt(i).getTel().equals(chaTel) || ChaCB.vc.elementAt(i).getName().contentEquals(chaName)) {
					System.out.println("중복되는 연락처가 존재합니다. 수정실패");
					ChaCB.Operation();
					break;
				}
			}
			Address adr=new Address(chaName,chaTel,chaEtc,false,chaLateCall);
			ChaCB.vc.removeElementAt(isi);
			ChaCB.vc.add(adr);
			ChaCB.save();
			System.out.println("수정 완료");
		}
	}
	public void multiChange() {
		System.out.println("여러 연락처를 일괄 수정하는 메뉴입니다.");
		System.out.println("=======================================");
		for(int i=0;i<ChaCB.vc.size();i++) {
			Address adrs=ChaCB.vc.elementAt(i);
			if(adrs.getHiding()==false)
			System.out.println("["+i+"] "+adrs.getName()+" "+adrs.getTel()+" "+adrs.getEtc());
		}
		System.out.println("=======================================");
		System.out.println("일괄적으로 변경할 연락처들을 선택하여 주십시오(-1 입력시 선택 종료) : ");
		Vector<Integer> vint = new Vector<Integer>();
		while(true) {
			int sel = sc_ch.nextInt();
			if(sel==-1) break;
			else {
				vint.add(sel);
			}
		}
		System.out.println("1. 이름 앞에 추가 / 2. 이름 뒤에 추가 / 3. 기타사항 일괄수정 : ");
		int op = sc_ch.nextInt();
		sc_ch.nextLine();
		String input;
		switch(op) {
			case 1:
				System.out.println("이름 앞에 추가할 문자열을 입력하세요 : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					String changeName = input+ChaCB.vc.elementAt(vint.elementAt(i)).getName();
					ChaCB.vc.elementAt(vint.elementAt(i)).setName(changeName);
					}
				break;
			case 2:
				System.out.println("이름 뒤에 추가할 문자열을 입력하세요 : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					String changeName =ChaCB.vc.elementAt(vint.elementAt(i)).getName()+input;
					ChaCB.vc.elementAt(vint.elementAt(i)).setName(changeName);
				}
				break;
			case 3:
				System.out.println("변경할 기타사항 내용을 입력하세요 : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					ChaCB.vc.elementAt(vint.elementAt(i)).setEtc(input);
				}
				break;
		}
		ChaCB.save();
		System.out.println("일괄 수정이 완료되었습니다.");
	}
	
}
