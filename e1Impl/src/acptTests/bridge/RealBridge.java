package acptTests.bridge;

import acptTests.data.OrderInfo;
import acptTests.data.ShowInfo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RealBridge implements Bridge
{
	private class Hall
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

		public Hall(String name, String city, int seats)
		{
			this.name=name;
			this.city=city;
			this.seats=seats;
		}
	}

	private class Admin
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

		public Admin(String city, String username, String password)
		{
			this.city=city;
			this.password=password;
			this.username=username;
		}
	}

	Set<String> cities=new HashSet<>();
	List<Admin> admins=new LinkedList<>();
	List<Hall> halls=new LinkedList<>();
	List<ShowInfo> shows=new LinkedList<>();
	List<OrderInfo> orders=new LinkedList<>();

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