import java.io.Serializable;
// �� ��ȭ��ȣ(�ּ�)�� ���� Class�� ������ ���� ���� ���ؼ� Serializable ���
public class Address implements Serializable{
	
	private String name;
	private String tel;
	private String etc;
	private boolean hiding;
	private String lateCall;
	
	public String getName() {return name;}
	public String getTe() {return tel;}
	public String getEtc() {return etc;}
	public boolean getHiding() {return hiding;}
	public String getLateCall() {return lateCall;}
	
	public void setName(String name) {this.name=name;}
	public void setTel(String tel) {this.tel=tel;}
	public void setEtc(String etc) {this.etc=etc;}
	public void setHiding(boolean hiding) {this.hiding=hiding;}
	public void setLateCall(String lateCall) {this.lateCall=lateCall;}
	
	public Address(String name, String tel, String etc, boolean hiding, String lateCall) {
		this.name=name;
		this.tel=tel;
		this.etc=etc;
		this.hiding=hiding;
		this.lateCall=lateCall;
	}
}
