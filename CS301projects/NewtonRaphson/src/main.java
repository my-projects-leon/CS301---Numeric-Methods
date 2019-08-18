import java.util.Scanner;
import java.text.*;
//NEWTON-RAPHSON METHOD

public class main {
	//true roots for func1 = .36510, 1.9217, 3.5632
	public static void main(String[] args) {
		DecimalFormat df2 = new DecimalFormat(".####");
		Scanner scan = new Scanner(System.in);
		double t, x, x1, f_x, f_x1, ea;
		int iter = 0;
	    System.out.print("Enter a value for x:");
	    x = scan.nextDouble();
	    System.out.println("The true root is 126.632");//true root reminder
	    //t = 1;//used for actual error
	    t = 126.632;//used for true root
	    System.out.println("Iter\tX\tXn+1\tF(x)\t\tError");
	    ea = 1;
	   	 while ( ea > .01 && iter < 100 )
	   	 {  
	   		//y = 2x^3 -11.7x^2 + 17.7x -5.0
	   	    //f_x = 2*Math.pow(x, 3) - 11.7*Math.pow(x,2) + 17.7*x - 5.0;  
	   	    //f_x1 = 6*Math.pow(x, 2) - 23.4*x + 17.7;
	   	    
	   		 //y = x + 10 - x*cosh(50/x)
	   	    f_x = x + 10 - (x*Math.cosh(50/x));      
	   	    f_x1 = 1 + - Math.cosh(50/x) + ((50* Math.sinh(50/x))/x);
	   	    
	   	    x1 = x - (f_x/f_x1);
	   	    ea = Math.abs((x1-t)/x1);
	   	    //t = x1;//Comment this line out if doing true root error
	    
	            System.out.println(iter + "\t" + df2.format(x) 
	            		+ "\t" + df2.format(x1) +"\t"+df2.format(f_x)
	            		+"\t\t"+df2.format(ea));
	            x = x1;
	            iter++;
	                                           // Print progress
	   	 }
	    
	   	 System.out.println("Approximate solution = " + x );

	}

}
