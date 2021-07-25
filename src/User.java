import java.io.*;

public class User implements Serializable {
	private String UserName;
	private String UserId;
	private String UserPw;
	private boolean UserGender;
	private String UserTel;
	private String UserEmail;
	private int UserBirth;
	
	public void SetUserName(String UserName) {this.UserName=UserName;}
	public void setUserId(String UserId) {this.UserId=UserId;}
	public void setUserPw(String UserPw) {this.UserPw=UserPw;}
	public void setUserGender(boolean UserGender) {this.UserGender=UserGender;}
	public void setUserTel(String UserTel) {this.UserTel=UserTel;}
	public void setUserEmail(String UserEmail) {this.UserEmail=UserEmail;}
	public void setUserBirth(int UserBirth) {this.UserBirth=UserBirth;}
	public String getUserName() {return UserName;}
	public String getUserId() {return UserId;}
	public String getUserPw() {return UserPw;}
	public boolean getUserGender() {return UserGender;}
	public String getUserTel() {return UserTel;}
	public String getUserEmail() {return UserEmail;}
	public int getUserBirth() {return UserBirth;}
	
	public User(String UserName, String UserId, String UserPw, boolean UserGender, String UserTel, String UserEmail, int UserBirth) {
		this.UserName = UserName;
		this.UserId=UserId;
		this.UserPw=UserPw;
		this.UserGender=UserGender;
		this.UserTel=UserTel;
		this.UserEmail=UserEmail;
		this.UserBirth=UserBirth;
	}
	
}
