
public class Upload {

	private String id;
	Server server=new Server();
	
	
	public Upload() {
		server.Userload();
		Login upload_login = new Login();
		
		if(upload_login.getLogined()==true) {
			UploadToServer(upload_login.getId());
		}
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id=id;}
	public void UploadToServer(String id) {
		server.AddressSave(id);
	}

}
