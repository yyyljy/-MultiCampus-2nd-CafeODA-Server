package cafe.oda.getStationCount;

public class stationDataVO {
	/*
	writedate varchar2(8),
	line varchar2(60),
	stationID varchar2(4),
	stationName varchar2(60),
	onCount number,
	offCount number
	*/
	private String writedate;
	private String line;
	private String stationID;
	private String stationName;
	private int onCount;
	private int offCount;
	
	public stationDataVO() {
		
	}
	
	public stationDataVO(String writedate, String line, String stationID, String stationName, int onCount, int offCount) {
		super();
		this.writedate = writedate;
		this.line = line;
		this.stationID = stationID;
		this.stationName = stationName;
		this.onCount = onCount;
		this.offCount = offCount;
	}
	
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStationID() {
		return stationID;
	}
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getOnCount() {
		return onCount;
	}
	public void setOnCount(int onCount) {
		this.onCount = onCount;
	}
	public int getOffCount() {
		return offCount;
	}
	public void setOffCount(int offCount) {
		this.offCount = offCount;
	}
	
	@Override
	public String toString() {
		return "salesDataVO [writedate=" + writedate + ", line=" + line + ", stationID=" + stationID + ", stationName="
				+ stationName + ", onCount=" + onCount + ", offCount=" + offCount + "]";
	}
	
	
}
