package cafe.oda.cafeoda;

public class TestVO {
	
	private int testnum;
	private String teststr;
	
	
	
	public TestVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TestVO(int testnum, String teststr) {
		super();
		this.testnum = testnum;
		this.teststr = teststr;
	}



	public int getTestnum() {
		return testnum;
	}



	public void setTestnum(int testnum) {
		this.testnum = testnum;
	}



	public String getTeststr() {
		return teststr;
	}



	public void setTeststr(String teststr) {
		this.teststr = teststr;
	}



	@Override
	public String toString() {
		return "TestVO [testnum=" + testnum + ", teststr=" + teststr + "]";
	}



	


}
