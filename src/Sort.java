import java.util.*;

public class Sort {
	private int option;
	private CB SorCB = new CB();
	private Scanner sc_so = new Scanner(System.in);
	
	public Sort() {
		SorCB.load();
		
		System.out.println("=======================================");
		System.out.println("<<정렬 방식 선택>>");
		System.out.print("1. 이름순 / 2. 번호순 / 3. 최근 연락순 : ");
		option = sc_so.nextInt();
		sc_so.nextLine();
		if(SorCB.vc.size()==0) {
			System.out.println("정렬할 연락처가 없습니다.");
			SorCB.Operation();
		}
		SortAddress(option);
		SorCB.Operation();
	}
	
	public int getOption() {return option;}
	public void setOption(int option) {this.option=option;}
	public void SortAddress(int option) {
		switch(option) {
			case 1:
				for(int i=0;i<SorCB.vc.size();i++) {
					for(int j=i+1;j<SorCB.vc.size();j++) {
						if((SorCB.vc.elementAt(j).getName()).compareTo(SorCB.vc.elementAt(i).getName())<0) {
							Address temp = SorCB.vc.elementAt(j);
							SorCB.vc.removeElementAt(j);
							SorCB.vc.add(i,temp);
							temp = SorCB.vc.elementAt(i+1);
							SorCB.vc.add(j,temp);
							SorCB.vc.removeElementAt(i+1);
						}
					}
				}
				break;
			case 2:
				for(int i=0;i<SorCB.vc.size();i++) {
					for(int j=i+1;j<SorCB.vc.size();j++) {
						if((SorCB.vc.elementAt(j).getTel()).compareTo(SorCB.vc.elementAt(i).getTel())<0) {
							Address temp = SorCB.vc.elementAt(j);
							SorCB.vc.removeElementAt(j);
							SorCB.vc.add(i,temp);
							temp = SorCB.vc.elementAt(i+1);
							SorCB.vc.add(j,temp);
							SorCB.vc.removeElementAt(i+1);
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<SorCB.vc.size();i++) {
					for(int j=i+1;j<SorCB.vc.size();j++) {
						if((SorCB.vc.elementAt(j).getLateCall()).compareTo(SorCB.vc.elementAt(i).getLateCall())<0) {
							Address temp = SorCB.vc.elementAt(j);
							SorCB.vc.removeElementAt(j);
							SorCB.vc.add(i,temp);
							temp = SorCB.vc.elementAt(i+1);
							SorCB.vc.add(j,temp);
							SorCB.vc.removeElementAt(i+1);
						}
					}
				}
				break;
		}
		System.out.println("정렬완료");
		SorCB.save();
	}
}
