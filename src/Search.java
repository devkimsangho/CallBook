import java.util.*;

public class Search {

	private String name;
	private String tel;
	private String etc;
	private int option;
	private String startDay;
	private String endDay;
	private CB SerCB = new CB();
	private Scanner sc_se = new Scanner(System.in);
	
	public Search() {
		SerCB.load();
		System.out.println("=======================================");
		System.out.println("<<�˻�>>");
		System.out.println("1. �̸����� �˻� / 2. ��ȣ�� �˻� / 3. �Ⱓ �� ���� ��ȣ �˻� : ");
		option = sc_se.nextInt();
		sc_se.nextLine();

		int isi;
		switch(option) {
			case 1:
				String serName;
				System.out.print("�̸��� �Է��ϼ��� : ");
				serName=sc_se.nextLine();
				isi=isInAddr(serName, null, 1);
				if(isi!=-1) {
					Address adr=SerCB.vc.elementAt(isi);
					System.out.println("�̸� \t��ȭ��ȣ \t��Ÿ���� \t���迩�� \t�ֱٿ�����");
					System.out.print(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t");
					System.out.print(adr.getHiding()==true?"����":"����");
					System.out.println("\t"+adr.getLateCall());
				}
				else {
					System.out.println("���� ����ó�Դϴ�.");
				}
				break;
			case 2:
				String serNum;
				System.out.println("��ȣ�� �Է��ϼ���.");
				serNum=sc_se.nextLine();
				isi=isInAddr(null,serNum,2);
				if(isi!=-1) {
					Address adr=SerCB.vc.elementAt(isi);
					System.out.println("�̸� \t��ȭ��ȣ \t��Ÿ���� \t���迩�� \t�ֱٿ�����");
					System.out.print(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t");
					System.out.print(adr.getHiding()==true?"����":"����");
					System.out.println("\t"+adr.getLateCall());
				}
				else {
					System.out.println("���� ����ó�Դϴ�.");
				}
				break;
			case 3:
				String startD,endD;
				System.out.println("���� �Ⱓ�� �Է��ϼ���(ex : 20200101) : ");
				startD = sc_se.nextLine();
				System.out.println("�� �Ⱓ�� �Է��ϼ���(ex : 20201231) : ");
				endD=sc_se.nextLine();
				changeByDay(startD,endD);
		}
		SerCB.Operation();
	}
	
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setEtc(String etc) {this.etc=etc;}
	public void setOption(int option) {this.option=option;}
	public void setStartDay(String startDay) {this.startDay=startDay;}
	public void setEndDay(String endDay) {this.endDay=endDay;}
	public String getName() {return name;}
	public String getTel() {return tel;}
	public String getEtc() {return etc;}
	public int getOption() {return option;}
	public String getStartDay() {return startDay;}
	public String getEndDay() {return endDay;}
	public int isInAddr(String name, String tel,int option) {
		switch(option) {
		case 1:
			for(int i=0;i<SerCB.vc.size();i++) {
				Address adr = SerCB.vc.elementAt(i);
				if(adr.getName().equals(name)) {
					return i;
				}
			}
			return -1;
		case 2:
			for(int i=0;i<SerCB.vc.size();i++) {
				Address adr = SerCB.vc.elementAt(i);
				if(adr.getTel().equals(tel)) {
					return i;
				}
			}
			return -1;
		default:
			return -1;
	}
			}
	
	public void changeByDay(String startDay,String endDay) {
		for(int i=0;i<SerCB.vc.size();i++) {
			Address adr=SerCB.vc.elementAt(i);
			if((adr.getLateCall()).compareTo(startDay)>=0 && (adr.getLateCall()).compareTo(endDay)<=0) {
				if(adr.getHiding()==false) {
					System.out.println("�̸� \t��ȭ��ȣ \t��Ÿ���� \t�ֱٿ�����");
					System.out.print(adr.getName()+"\t"+adr.getTel()+"\t"+adr.getEtc()+"\t");
					System.out.println(adr.getLateCall());
				}
			}
		}
		System.out.println("1.�ش� ����ó ���� 2.�˻� ����");
		int opt=sc_se.nextInt();
		sc_se.nextLine();
		switch(opt) {
			case 1:
				for(int i=SerCB.vc.size()-1;i>=0;i--) {
					Address adr=SerCB.vc.elementAt(i);
					if((adr.getLateCall()).compareTo(startDay)>=0 && (adr.getLateCall()).compareTo(endDay)<=0) {
						if(adr.getHiding()==false) {
							SerCB.vc.removeElementAt(i);
						}
					}
				}
				SerCB.save();
				break;
			case 2:
				break;
		}
	}
	
}
