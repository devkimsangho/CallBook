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
		System.out.println("<<����>>");
		if(ChaCB.vc.size()<=0) {
			System.out.println("������ ����ó�� �����ϴ�.");
			ChaCB.Operation();
		}
		System.out.print("1. �̸� ã�Ƽ� ���� / 2. ��ȭ��ȣ ã�Ƽ� ���� / 3. �ϰ����� : ");
		option=sc_ch.nextInt();
		sc_ch.nextLine();
		
		switch(option) {
			case 1:
				String chaName;
				System.out.println("�̸��� �Է����ּ��� : ");
				chaName=sc_ch.nextLine();
				changeByName(chaName);
				break;
			case 2:
				String chaTel;
				System.out.println("��ȭ��ȣ�� �Է����ּ��� : ");
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
			
			System.out.print("�̸� : ");
			String chaName = sc_ch.nextLine();
			System.out.print("��ȭ��ȣ : ");
			String chaTel=sc_ch.nextLine();
			System.out.print("��Ÿ���� : ");
			String chaEtc=sc_ch.nextLine();
			System.out.print("�ֱٿ�����(ex 20200610 / ������ x) : ");
			String chaLateCall=sc_ch.nextLine();
			for(int i=0;i<ChaCB.vc.size();i++) {
				if(i==isi) continue;
				if(ChaCB.vc.elementAt(i).getTel().equals(chaTel) || ChaCB.vc.elementAt(i).getName().contentEquals(chaName)) {
					System.out.println("�ߺ��Ǵ� ����ó�� �����մϴ�. ��������");
					ChaCB.Operation();
					break;
				}
			}
			Address adr=new Address(chaName,chaTel,chaEtc,false,chaLateCall);
			ChaCB.vc.removeElementAt(isi);
			ChaCB.vc.add(adr);
			ChaCB.save();
			System.out.println("���� �Ϸ�");
		}
		else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
	}
	public void changeByTel(String tel) {
		int isi=isInAddr(null,tel,2);
		if(isi!=-1) {
			System.out.print("�̸� : ");
			String chaName = sc_ch.nextLine();
			System.out.print("��ȭ��ȣ : ");
			String chaTel=sc_ch.nextLine();
			System.out.print("��Ÿ���� : ");
			String chaEtc=sc_ch.nextLine();
			System.out.print("�ֱٿ�����(ex 20200610) : ");
			String chaLateCall=sc_ch.nextLine();
			for(int i=0;i<ChaCB.vc.size();i++) {
				if(i==isi) continue;
				if(ChaCB.vc.elementAt(i).getTel().equals(chaTel) || ChaCB.vc.elementAt(i).getName().contentEquals(chaName)) {
					System.out.println("�ߺ��Ǵ� ����ó�� �����մϴ�. ��������");
					ChaCB.Operation();
					break;
				}
			}
			Address adr=new Address(chaName,chaTel,chaEtc,false,chaLateCall);
			ChaCB.vc.removeElementAt(isi);
			ChaCB.vc.add(adr);
			ChaCB.save();
			System.out.println("���� �Ϸ�");
		}
	}
	public void multiChange() {
		System.out.println("���� ����ó�� �ϰ� �����ϴ� �޴��Դϴ�.");
		System.out.println("=======================================");
		for(int i=0;i<ChaCB.vc.size();i++) {
			Address adrs=ChaCB.vc.elementAt(i);
			if(adrs.getHiding()==false)
			System.out.println("["+i+"] "+adrs.getName()+" "+adrs.getTel()+" "+adrs.getEtc());
		}
		System.out.println("=======================================");
		System.out.println("�ϰ������� ������ ����ó���� �����Ͽ� �ֽʽÿ�(-1 �Է½� ���� ����) : ");
		Vector<Integer> vint = new Vector<Integer>();
		while(true) {
			int sel = sc_ch.nextInt();
			if(sel==-1) break;
			else {
				vint.add(sel);
			}
		}
		System.out.println("1. �̸� �տ� �߰� / 2. �̸� �ڿ� �߰� / 3. ��Ÿ���� �ϰ����� : ");
		int op = sc_ch.nextInt();
		sc_ch.nextLine();
		String input;
		switch(op) {
			case 1:
				System.out.println("�̸� �տ� �߰��� ���ڿ��� �Է��ϼ��� : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					String changeName = input+ChaCB.vc.elementAt(vint.elementAt(i)).getName();
					ChaCB.vc.elementAt(vint.elementAt(i)).setName(changeName);
					}
				break;
			case 2:
				System.out.println("�̸� �ڿ� �߰��� ���ڿ��� �Է��ϼ��� : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					String changeName =ChaCB.vc.elementAt(vint.elementAt(i)).getName()+input;
					ChaCB.vc.elementAt(vint.elementAt(i)).setName(changeName);
				}
				break;
			case 3:
				System.out.println("������ ��Ÿ���� ������ �Է��ϼ��� : ");
				input = sc_ch.nextLine();
				for(int i=0;i<vint.size();i++) {
					ChaCB.vc.elementAt(vint.elementAt(i)).setEtc(input);
				}
				break;
		}
		ChaCB.save();
		System.out.println("�ϰ� ������ �Ϸ�Ǿ����ϴ�.");
	}
	
}
