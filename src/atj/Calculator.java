package atj;

public class Calculator {
	
	private double value1 = 0;
	private double value2 = 0;
	private String result;

	public String add(){
		value1 = value1 + value2;
		return result = "" + value1;
	}

	public String subtract(){
		value1 = value2 - value1;
		return result = "" + value1;
	}
	
	public String multiply(){
		value1 = value1 * value2;
		return result = "" + value1;
	}
	
	public String divide() throws ArithmeticException{
		value1 = value2 / value1 ;
		result = "" + value1;
		return result;
	}
	
	public String changeSign(){
		value1 *=(-1);
		return result = "" + value1;
	}
	
	public String sqrt(){
		value1 = Math.sqrt(value1);
		return result = "" + value1;
	}
	
	public String percent(){
		value1 = value1 *(value2/100);
		return result = "" + value1;
	}
	
	public double getValue1() {
		return value1;
	}
	
	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}
	
	public void setValue2(double value2) {
		this.value2 = value2;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
		
	}	
}