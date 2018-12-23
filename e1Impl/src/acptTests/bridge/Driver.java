package acptTests.bridge;

public abstract class Driver
{

	public static Bridge getBridge()
	{
		ProxyBridge bridge=new ProxyBridge();

		bridge.setRealBridge(new RealBridge()); // TODO
		return bridge;
	}
}
