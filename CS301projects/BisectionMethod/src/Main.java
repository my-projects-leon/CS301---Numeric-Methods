
import java.text.DecimalFormat;
import java.util.*;
//BISECTION METHOD
public class Main {
//true roots for func1 = .36510, 1.9217, 3.5632
//func #2 true root= 126.632
	public static void main(String[] args) {
		DecimalFormat df2 = new DecimalFormat(".####");
		Scanner scan = new Scanner(System.in);
		double ea, t, a, b, m, y_m, y_a;
		int iter = 0;
	    System.out.print("Enter a value for a:");
	    a = scan.nextDouble();
	    System.out.print("Enter a value for b:");
	    b = scan.nextDouble();
	    System.out.println("The true root is 126.632");//true root reminder
	    //t = 1;//used for actual error
	    t = 126.632;//used for true root
	    ea = 1;
	    System.out.println("Iterations\tRoot\tError");
	    m = (a+b)/2;
	   	 while ( ea > .01 && iter < 100 )
	   	 {
	   	    m = (a+b)/2;           // Mid point
	   	    //y = 2x^3 -11.7x^2 + 17.7x -5.0
	   	    //y_m = 2*Math.pow(m, 3) - 11.7*Math.pow(m,2) + 17.7*m - 5.0;       // y_m = f(m)
	   	    //y_a = 2*Math.pow(a, 3) - 11.7*Math.pow(a,2) + 17.7*a - 5.0;
	   	    //y = x + 10 - x*cosh(50/x)
	   	    y_m = m + 10 - (m*Math.cosh(50/m));      
	   	    y_a = a + 10 - (a*Math.cosh(50/a));
	   	    
	   	    ea = Math.abs(m-t)/m;
	   	    //t = m;//Comment this line out if doing true root error
	   	    if ( (y_m > 0 && y_a < 0) || (y_m < 0 && y_a > 0) )
	   	    {  // f(a) and f(m) have different signs: move b
	   	       b = m;
	   	    }
	   	    else
	   	    {  // f(a) and f(m) have same signs: move a
	   	       a = m;
	   	    }
	   	    
	            System.out.println(iter + "\t\t" + df2.format(m) + "\t" + df2.format(ea));
	            iter++;
	                                           // Print progress  
	   	 }
	    
	   	 System.out.println("Approximate solution = " + (a+b)/2 );

	}

}
