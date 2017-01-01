import java.util.*;

public class TestClass
{
	public static void main(String[] args)
	{
		double degree = 45.0,
		convDedree =
		TemperatureConversion.convert(Temperature.FAHRENHEIT,
		Temperature.RANKINE, degree);
		System.out.println("Conversion from FAHRENHEIT to RANKINE\n");
		System.out.printf("Converting:\n%fºF to %fºRa", degree,
		convDedree);
	 System.out.println();
	}
}
