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
		if (shows.put(toPut, toPut)==null)
		{
			int id=Math.abs(toPut.hashCode());
			toPut.setId(id);
			return id;
		}
		shows.remove(toPut);
		return 0;
	}

	@Override
	public void reserveMemberChairs(int showID, int from, int to)
	{
		ShowInfoExtention show=null;
		for (ShowInfoExtention showi : shows.values())
			if (showi.getId()==showID)
			{
				show=showi;
				break;
			}
		if (show!=null)
		{
			show.setReservation(from, to);
		}
	}

	@Override
	public int newOrder(OrderInfo order)
	{

		if (order!=null)
		{
			if (!(order.name==null || order.phone==null || order.name.equals("") || order.phone.equals("")))
			{
				if (!(order.chairsIds==null || order.chairsIds.length==0))
				{
					Show show=shows.get(order.showId);
					if (show!=null)
					{
						if (!(show.getShowInfo().lastOrderDate<System.currentTimeMillis()))
						{
							int[] showSeats=show.getSeats();
							int[] orderSeats=order.chairsIds;
							for (int orderSeat : orderSeats)
							{
								if (showSeats[orderSeat]==3 || showSeats[orderSeat]==2)
								{
									if (order.memberId==null)
									{
										System.out.println("Order Failed !");
										return 0;
									}
								}
							}
							for (int orderSeat : orderSeats) showSeats[orderSeat]=2;
							List<OrderInfo> list=show.userstoinform;
							boolean exist=false;
							for (Order order_key : list)
							{
								if (order_key.name.equals(order.name)) exist=true;
							}
							if (!exist)
							{
								list.add(order);
							}
							reservationid++;
							return reservationid;

							int res=app.OrderRegister(replica);
							if (res>0)
							{
								ShowInfo showInfo=all_shows_information.get(order.showId);
								List<OrderInfo> list=showInfo.userstoinform;
								boolean exist=false;
								for (OrderInfo order_key : list)
								{
									if (order_key.name.equals(order.name)) exist=true;
								}
								if (!exist)
								{
									list.add(order);
								}
							}
							return res;
						}
					}
				}
			}
		}
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