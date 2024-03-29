package acptTests.bridge;

import acptTests.data.OrderInfo;
import acptTests.data.ShowInfo;

import java.util.List;

public class ProxyBridge implements Bridge
{
	private Bridge real;

	public ProxyBridge()
	{
		real=null;
	}

	public void setRealBridge(Bridge implementation)
	{
		if (real==null)
			real=implementation;
	}

	@Override
	public void addCity(String city)
	{
		if (real!=null)
			real.addCity(city);
	}

	@Override
	public void addHall(String city, String hall, int sits)
	{
		if (real!=null)
			real.addHall(city, hall, sits);
	}

	@Override
	public void addAdmin(String city, String user, String pass)
	{
		if (real!=null)
			real.addAdmin(city, user, pass);
	}

	@Override
	public int addNewShow(String user, String pass, ShowInfo showInfo)
	{
		if (real!=null)
			return real.addNewShow(user, pass, showInfo);
		return 0;
	}

	@Override
	public void reserveMemberChairs(int showID, int from, int to)
	{
		if (real!=null)
			real.reserveMemberChairs(showID, from, to);
	}

	@Override
	public int newOrder(OrderInfo order)
	{
		if (real!=null)
			return real.newOrder(order);
		return 0;
	}

	@Override
	public List<OrderInfo> getWaitings(int id)
	{
		if (real!=null)
			return real.getWaitings(id);
		return null;
	}
}