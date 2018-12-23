import java.util.Scanner;

public class FizzBuzz
{
	static String parseNum(final int num)
	{
		return num%15==0 ? "FizzBuzz" :
		       num%3==0 ? "Fizz" :
		       num%5==0 ? "Buzz" :
		       num+"";
	}

	static StringBuilder playGame(final int num)
	{
		StringBuilder output=new StringBuilder();
		for (int i=1; i<num; i++)
			output.append(parseNum(i)).append(", ");
		return output.append(parseNum(num)).append('.');
	}

	static boolean checkNum(final int num)
	{
		return num>0 && num<101;
	}

	public static void main(final String[] args)
	{
		System.out.println("Please enter a number between 1 to 100 (including):");
		final int num=Integer.parseInt(new Scanner(System.in).nextLine());
		System.out.println(checkNum(num) ? playGame(num) : "The entered number is not between 1 to 100!!!");
	}
}