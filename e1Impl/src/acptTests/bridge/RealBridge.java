package acptTests.bridge;

import acptTests.data.OrderInfo;
import acptTests.data.ShowInfo;
import acptTests.data.ShowInfoExtention;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RealBridge implements Bridge
{
	private static class Hall
	{
		private String city, name;
		private int seats;

		public String getCity()
		{
			return city;
		}

		public String getName()
		{
			return name;
		}

		public int getSeats()
		{
			return seats;
		}

		Hall(String name, String city, int seats)
		{
			this.name=name;
			this.city=city;
			this.seats=seats;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this==o)
				return true;
			if (o==null || getClass()!=o.getClass())
				return false;

			Hall hall=(Hall) o;

			return !getCity().equals(hall.getCity()) ||
			       getName().equals(hall.getName());
		}

		@Override
		public int hashCode()
		{
			int result=getCity().hashCode();
			result=31*result+getName().hashCode();
			return result;
		}
	}

	private static class Admin
	{
		private String city, username, password;

		public String getCity()
		{
			return city;
		}

		public String getUsername()
		{
			return username;
		}

		public String getPassword()
		{
			return password;
		}

		Admin(String city, String username, String password)
		{
			this.city=city;
			this.password=password;
			this.username=username;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this==o)
				return true;
			if (o==null || getClass()!=o.getClass())
				return false;

			Admin admin=(Admin) o;

			return getUsername().equals(admin.getUsername());
		}

		@Override
		public int hashCode()
		{
			return getUsername().hashCode();
		}
	}

	private Map<String, String> cities=new HashMap<>();
	private Map<Admin, Admin> admins=new HashMap<>();
	private Map<Hall, Hall> halls=new HashMap<>();
	private Map<ShowInfoExtention, ShowInfoExtention> shows=new HashMap<>();
	private Map<OrderInfo, OrderInfo> orders=new HashMap<>();

	@Override
	public void addCity(String city)
	{
		cities.put(city, city);
	}

	@Override
	public void addHall(String city, String hall, int sits)
	{
		Hall hall1=new Hall(hall, city, sits);
		halls.put(hall1, hall1);
	}

	@Override
	public void addAdmin(String city, String user, String pass)
	{
		Admin admin=new Admin(city, user, pass);
		admins.put(admin, admin);
	}

	@Override
	public int addNewShow(String user, String pass, ShowInfo showInfo)
	{
		if (user==null || pass==null || showInfo==null || showInfo.city==null || showInfo.hall==null)
			return 0;
		Admin admin=admins.get(new Admin(null, user, null));
		Hall hall=halls.get(new Hall(showInfo.hall, showInfo.city, 0));
		ShowInfoExtention toPut=new ShowInfoExtention(showInfo);
		if (admin==null ||
		    !admin.password.equals(pass) ||
		    hall==null ||
		    !cities.containsKey(showInfo.city) ||
		    !admin.city.equals(hall.city) ||
		    toPut.lastOrderDate>toPut.showDate ||
		    (!toPut.hastime && toPut.showTime!=null) ||
		    (toPut.hastime && toPut.showTime==null))
			return 0;
		toPut.setChairs(hall.seats);
		return shows.put(toPut, toPut)==null ? Math.abs(toPut.hashCode()) : 0;
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
		List<OrderInfo> output=new LinkedList<>();
		for (OrderInfo o : orders.values())
			if (o.showId==id)
				output.add(o);
		return output;
	}
}