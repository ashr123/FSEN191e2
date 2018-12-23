package acptTests.junit;

import acptTests.bridge.Bridge;
import acptTests.bridge.Driver;
import acptTests.data.OrderInfo;
import acptTests.data.ShowInfo;
import junit.framework.TestCase;

import java.util.List;

public abstract class ProjectTest extends TestCase
{
	static final int HALL_CITY=0;
	static final int HALL_NAME=1;
	private static final int HALL_SITS=2;
	static final int USER_CITY=0;
	static final int USER_USER=1;
	static final int USER_PASS=2;
	// SetUp information
	private final String[] cities={"Beer Sheva", "Tel Aviv", "Haifa"};
	final Object[][] halls={{cities[0], "hall 1", 300}, {cities[1], "hall 1", 230},
	                                  {cities[1], "hall 2", 413},};
	final String[][] users={{cities[0], "bAdmin", "bPassWord"}, {cities[1], "tlv", "abcd1234"},
	                                  {cities[2], "green", "house"}};
	private Bridge bridge;

	public void setUp()
	{
		this.bridge=Driver.getBridge();
		setUpCities();
		setUpHalls();
		setUpUsers();
	}

	private void setUpCities()
	{
		for (String city : cities)
			this.bridge.addCity(city);
	}

	private void setUpHalls()
	{
		for (Object[] hallInfo : halls)
		{
			this.bridge.addHall((String) hallInfo[HALL_CITY], (String) hallInfo[HALL_NAME],
			                    (Integer) hallInfo[HALL_SITS]);
		}
	}

	private void setUpUsers()
	{
		for (String[] userInfo : users)
		{
			this.bridge.addAdmin(userInfo[USER_CITY], userInfo[USER_USER], userInfo[USER_PASS]);
		}
	}

	int addShow(String user, String pass, ShowInfo showInfo)
	{
		return this.bridge.addNewShow(user, pass, showInfo);
	}

	void reserveMemberChairs(int showID, int from, int to)
	{
		this.bridge.reserveMemberChairs(showID, from, to);
	}

	int placeOrder(OrderInfo order)
	{
		return this.bridge.newOrder(order);
	}

	List<OrderInfo> getWaitings(int id)
	{
		return this.bridge.getWaitings(id);
	}
}