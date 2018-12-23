package acptTests.bridge;

import acptTests.data.OrderInfo;
import acptTests.data.ShowInfo;

import java.util.List;

public class RealBridge implements Bridge
{
	@Override
	public void addCity(String city)
	{

	}

	@Override
	public void addHall(String city, String hall, int sits)
	{

	}

	@Override
	public void addAdmin(String city, String user, String pass)
	{

	}

	@Override
	public int addNewShow(String user, String pass, ShowInfo showInfo)
	{
		return 0;
	}

	@Override
	public void reserveMemberChairs(int showID, int from, int to)
	{

	}

	@Override
	public int newOrder(OrderInfo order)
	{
		return 0;
	}

	@Override
	public List<OrderInfo> getWaitings(int id)
	{
		return null;
	}
}