import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
//MODIFIED SECANT METHOD
	public static void main(String[] args) {
		DecimalFormat df2 = new DecimalFormat(".####");
		Scanner scan = new Scanner(System.in);
		double t, x, d, x1, f_x, f_dx, ea;
		int iter = 0;
	    System.out.print("Enter a value for x0:");
	    x = scan.nextDouble();
	    System.out.println("The true root is 126.632");//true root reminder
	    t = 126.632;//used for true root
	    System.out.println("Iter\tX\t\tXn+1\t\tF(x)\t\tError");
	    ea = 1;
	    //t = 0;//used for actual root
	   	 while ( ea > .01 && iter < 100 )
	   	 {  
	   	
	   		//y = 2x^3 -11.7x^2 + 17.7x -5.0
	   	    //f_x = 2*Math.pow(x, 3) - 11.7*Math.pow(x,2) + 17.7*x - 5.0;
	   	    //d = x + (.01*x);
	   	    //f_dx = 2*Math.pow(d, 3) - 11.7*Math.pow(d,2) + 17.7*d- 5.0;
	   	    
	   	    //y = x + 10 - x*cosh(50/x)
	   	    f_x = x + 10 - (x*Math.cosh(50/x));
	   	    d = x + (.01*x);
	   	    f_dx = d + 10 - (d*Math.cosh(50/d));
	   	    
	   	    x1 = x - ((f_x*(.01*x))/(f_dx - f_x));
	   	    //t = x;
	   	    ea = Math.abs(x1-t)/Math.abs(x1);
	    
	            System.out.println(iter + "\t" + df2.format(x) 
	            		+ "\t\t" + df2.format(x1) +"\t\t"+df2.format(f_x)
	            		+"\t\t"+df2.format(ea));
	            x = x1;
	            iter++;
	                                           // Print progress
	   	 }
	    
	   	 System.out.println("Approximate solution = " + df2.format(x) );

	}

}
