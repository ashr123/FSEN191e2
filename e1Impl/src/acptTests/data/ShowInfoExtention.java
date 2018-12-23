package acptTests.data;

import java.util.Objects;

public class ShowInfoExtention extends ShowInfo
{
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

	@Override
	public boolean equals(Object o)
	{
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;

		ShowInfo showInfo=(ShowInfo) o;

		if (showDate!=showInfo.showDate) return false;
		if (!city.equals(showInfo.city)) return false;
		if (!hall.equals(showInfo.hall)) return false;
		if (!name.equals(showInfo.name)) return false;
		return Objects.equals(showTime, showInfo.showTime);
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