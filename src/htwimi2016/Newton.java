/**
 * 
 */
package htwimi2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jay
 *
 */
public class Newton {

	private String inputString;
	private String[] givenPolynoms;
	private Function function;
	private Function derivative;
	

	public Newton(String fileToRead) {

		inputString = readFile(fileToRead);
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("There is nothing to read.");
		}
		else {
		System.out.println(inputString);
		
		givenPolynoms = inputString.split("\\s");
		
		function = new Function(givenPolynoms);
		System.out.println(function.toString());
		
		}
	}
	
	

	private String readFile(String fileToRead) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileToRead));
			inputString = br.readLine();
			br.close();
			return inputString;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	

	private String generateDerivative(String function) {

		return null;
	}

	private class Function {
		double power;
		Polynom[] polynoms;
		
		public Function(String[] inputPolynoms) {
			
				polynoms = new Polynom[inputPolynoms.length];
			for (int i = 0; i < inputPolynoms.length; i++) {
				if(inputPolynoms[i].matches("([+-]\\d+)\\b")) {
					polynoms[i] = new Polynom(Double.parseDouble(inputPolynoms[i]), 1);
					System.out.println("nur zahl gefunden!"+polynoms[i]);
				} else {
					String sBasis = inputPolynoms[i].replaceAll("x[\\^][\\d]", "");
					String sExponent = inputPolynoms[i].replaceAll("[+-]*?\\d+x\\^", "");
					System.out.println(sBasis);
					System.out.println(sExponent);
					double basis = Double.parseDouble(sBasis);
					double exponent = Double.parseDouble(sExponent);
					polynoms[i] = new Polynom(basis, exponent);
				}
			}
			
			setPower();
			
		}
		
		@Override
		public String toString() {
			String toReturn = "";
			
			for(Polynom x : polynoms) {
				toReturn += "+("+x.getBasis()+"x^"+x.getExponent()+") ";
			}
			return toReturn;
		}
		
		
		private void setPower() {
			
			// String splitString = inputString.replaceAll("([+-]\\d+)\\b", "0");
			// splitString = splitString.replaceAll("[+-]?\\d+x\\^|[+-]", "");
//			String[] powers = splitString.split("\\s");
//			int power = 0;
//			for (int i = 0; i < powers.length; i++) {
//				if (Integer.parseInt(powers[i]) > power)
//					power = Integer.parseInt(powers[i]);
//			}
			double power = 0;
			for (Polynom x: polynoms) {
				if (x.getExponent() > power) power = x.getExponent();
			}
			this.power = power;
			
		}

		private class Polynom {
			double basis;
			double exponent;
			
			public Polynom (double basis, double exponent) {
				this.basis = basis;
				this.exponent = exponent;
			}

			public double getExponent() {
				return exponent;
			}

			public void setExponent(double exponent) {
				this.exponent = exponent;
			}

			public double getBasis() {
				return basis;
			}

			public void setBasis(double basis) {
				this.basis = basis;
			}

		}
	}

}