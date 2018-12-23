package acptTests.data;

import java.util.Objects;

public class ShowInfoExtention extends ShowInfo
{
	public enum ChairState
	{
		FREE, RESERVED, OCCUPIED
	}

	public ChairState[] chairs;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id=id;
	}

	private int id;

	public ShowInfoExtention(ShowInfo showInfo)
	{
		this.city=showInfo.city; //
		this.hall=showInfo.hall; //
		this.name=showInfo.name; //
		this.description=showInfo.description;
		this.lastOrderDate=showInfo.lastOrderDate;
		this.showTime=showInfo.showTime; //
		this.showDate=showInfo.showDate; //
		this.ticketCost=showInfo.ticketCost;
		this.hastime=showInfo.hastime;
		this.userstoinform=showInfo.userstoinform;
	}

	public void setChairs(int seats)
	{
		chairs=new ChairState[seats];
		for (int i=0; i<seats; i++)
			chairs[i]=ChairState.FREE;
	}

	public void setReservation(int from, int to)
	{
		if ((0<=from) && (to<=chairs.length) && (from<=to))
		{
			for (int i=from; i<to; i++)
			{
				chairs[i]=ChairState.RESERVED;
			}
		}
	}

	public ChairState getChairState(int seat)
	{
		return chairs[seat];
	}

	@Override
	public boolean equals(Object o)
	{
		if (this==o)
			return true;
		if (o==null || getClass()!=o.getClass())
			return false;

		ShowInfo showInfo=(ShowInfo) o;

		return showDate!=showInfo.showDate ||
		       !city.equals(showInfo.city) ||
		       !hall.equals(showInfo.hall) ||
		       !name.equals(showInfo.name) ||
		       Objects.equals(showTime, showInfo.showTime);
	}

	@Override
	public int hashCode()
	{
		int result=city.hashCode();
		result=31*result+hall.hashCode();
		result=31*result+name.hashCode();
		result=31*result+(showTime!=null ? showTime.hashCode() : 0);
		result=31*result+(int) (showDate ^ (showDate >>> 32));
		return result;
	}
}