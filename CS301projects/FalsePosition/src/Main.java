import java.text.DecimalFormat;
import java.util.Scanner;

//FALSE POSITION METHOD
public class Main {
	public static void main(String[] args) {
		DecimalFormat df2 = new DecimalFormat(".####");
		Scanner scan = new Scanner(System.in);
		double t, x, x1, x2, f_x, f_x1, f_x2, ea;
		int iter = 0;
	    System.out.print("Enter a value for x0:");
	    x = scan.nextDouble();
	    System.out.print("Enter a value for x1:");
	    x1 = scan.nextDouble();
	    x2 = 0;
	    System.out.println("The true root is 126.632");//true root reminder
	    t = 126.632;//used for true root
	    System.out.println("Iter\tXn-1\tX\tXn+1\tF(xn-1)\tF(x)\tF(xn+1)\t\tError");
	    ea = 1;
	    //t = 0;//used for actual error
	   	 while ( ea > .01 && iter < 100 )
	   	 {   
	   		//y = 2x^3 -11.7x^2 + 17.7x -5.0
	   	    //f_x = 2*Math.pow(x, 3) - 11.7*Math.pow(x,2) + 17.7*x - 5.0;
	   	    //f_x1 = 2*Math.pow(x1, 3) - 11.7*Math.pow(x1,2) + 17.7*x1 - 5.0;
	   	   
	   	    //y = x + 10 - x*cosh(50/x)
	   	    f_x = x + 10 - (x*Math.cosh(50/x));
	   	    f_x1 = x1 + 10 - (x1*Math.cosh(50/x1));
	   	    
	   	    x2 = x1 - (f_x1*(x-x1)/(f_x - f_x1));
	   	    
	   	    //f_x2 = 2*Math.pow(x2, 3) - 11.7*Math.pow(x2,2) + 17.7*x2 - 5.0;
	   	    f_x2 = x2 + 10 - (x2*Math.cosh(50/x2));
	   	    
	   	    ea = Math.abs(x2-t)/Math.abs(x2);
	   	    //t = x2;
	    
	            System.out.println(iter + "\t" + df2.format(x) 
	            		+ "\t" + df2.format(x1) + "\t" + df2.format(x2) +"\t"+df2.format(f_x)
	            		+"\t"+df2.format(f_x1)+"\t"+df2.format(f_x2)+"\t\t"+df2.format(ea));
	            if ((f_x2 > 0 && f_x < 0) || (f_x2 < 0 && f_x > 0)) {
	        	    x1 = x2;
	                 }
	        	 else {
	        	    x = x2;
	                 }
	            iter++;
	                                           // Print progress
	   	 }
	    
	   	 System.out.println("Approximate solution = " + df2.format(x2) );
	}

}
