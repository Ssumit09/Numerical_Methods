// Java code for solving inverse interpolation
import java.util.Scanner;
class inverse_lagrange
{
static class Data
{
	double x, y;

	public Data(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
};

// Function to calculate
// the inverse interpolation
static double inv_interpolate(Data []d, int n, double y)
{
	// Initialize final x
	double x = 0;

	int i, j;

	for (i = 0; i < n; i++)
	{
		double xi = d[i].x;
		for (j = 0; j < n; j++) 
		{

			if (j != i) 
			{
				xi = xi
					* (y - d[j].y)
					/ (d[i].y - d[j].y);
			}
		}

		// Add term to final result
		x += xi;
	}
	return x;
}

// Driver Code
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
	int n;
	double a,b;
	System.out.println("Enter no:");
	n=sc.nextInt();
	
	Data[] obj=new Data[n];
	for(int i=0;i<n;i++){
	    System.out.print("Enter year x["+i+"]=");
	    a=sc.nextDouble();
	    System.out.println();
	    System.out.print("Enter population  y["+i+"]=");
	    b=sc.nextDouble();
	    obj[i]=new Data(a,b);
	}

	
	double search_value;;
System.out.println("Enter the value of y for finding x:");
	search_value=sc.nextDouble();
	System.out.printf("Year at which population="+search_value+"is :"+
		 inv_interpolate(obj, n, search_value));
}
}

