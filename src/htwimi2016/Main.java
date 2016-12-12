/**
 * 
 */
package htwimi2016;

/**
 * @author Jannes Brunner & Katharina Wunder
 * @date 2016-12-10
 *
 */
public class Main {
	
	/**
	 * @param args
	 *            -det for determinant calculation / -newt for newton's method
	 *            
	 */
	public static void main(String[] args) {
		if (args.length == 2)
			new Main(args[0], args[1]);
		else
			help();

	}
	

	public Main(String startargument1, String startargument2) {

		switch (startargument1) {
		case "-det":
			new Det(startargument2);
			break;

		case "-newt":
			new Newton(startargument2);
			break;

		default:

			help();
			break;
		}

	}
	
	private static void help() {
		System.out.println(
				"Not a valid argument. Aborted. \n '-det filename.txt' for determinant calculation \n '-newt filename.txt' for newton's method");
	}

}
