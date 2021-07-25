
public class Download {

	private String id;
	private Server server = new Server();
	
	public Download() {
		server.Userload();
		Login download_login = new Login();
		if(download_login.getLogined()==true) {
			DownloadFromServer(download_login.getId());
		}
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id=id;}
	public void DownloadFromServer(String id) {
		server.down(id);
	}
}
