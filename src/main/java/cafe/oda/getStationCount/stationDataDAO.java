package cafe.oda.getStationCount;

import java.util.List;

public interface stationDataDAO {
	public List<stationDataVO> select(String address);
	public List<stationDTO> selectOnOff(String address);
}
