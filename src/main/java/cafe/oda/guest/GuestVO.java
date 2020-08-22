package cafe.oda.guest;

public class GuestVO {
	
	private String guestphone;
	private String pass;
	private String nickname;
	private int point;
	private int mycafe1;
	private int mycafe2;
	private int mycafe3;
	private int mycafe4;
	private int mycafe5;
	
	public GuestVO() {
		super();
	}

	public GuestVO(String guestphone, String pass, String nickname, int point, int mycafe1, int mycafe2, int mycafe3,
			int mycafe4, int mycafe5) {
		super();
		this.guestphone = guestphone;
		this.pass = pass;
		this.nickname = nickname;
		this.point = point;
		this.mycafe1 = mycafe1;
		this.mycafe2 = mycafe2;
		this.mycafe3 = mycafe3;
		this.mycafe4 = mycafe4;
		this.mycafe5 = mycafe5;
	}

	public String getGuestphone() {
		return guestphone;
	}

	public void setGuestphone(String guestphone) {
		this.guestphone = guestphone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getMycafe1() {
		return mycafe1;
	}

	public void setMycafe1(int mycafe1) {
		this.mycafe1 = mycafe1;
	}

	public int getMycafe2() {
		return mycafe2;
	}

	public void setMycafe2(int mycafe2) {
		this.mycafe2 = mycafe2;
	}

	public int getMycafe3() {
		return mycafe3;
	}

	public void setMycafe3(int mycafe3) {
		this.mycafe3 = mycafe3;
	}

	public int getMycafe4() {
		return mycafe4;
	}

	public void setMycafe4(int mycafe4) {
		this.mycafe4 = mycafe4;
	}

	public int getMycafe5() {
		return mycafe5;
	}

	public void setMycafe5(int mycafe5) {
		this.mycafe5 = mycafe5;
	}

	@Override
	public String toString() {
		return "GuestVO [guestphone=" + guestphone + ", pass=" + pass + ", nickname=" + nickname + ", point=" + point
				+ ", mycafe1=" + mycafe1 + ", mycafe2=" + mycafe2 + ", mycafe3=" + mycafe3 + ", mycafe4=" + mycafe4
				+ ", mycafe5=" + mycafe5 + "]";
	}





	
	
	
	
	
	
	

}
