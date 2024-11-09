package pe;

public class Teacher {
    int code;
    double coeff;
    
    public Teacher(int code, int coeff) {
    	this.code = code;
    	this.coeff = coeff;
    }
    
    
    
    public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public double getCoeff() {
		return coeff;
	}



	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}



	public String toString() {
    	return "(" + getCode() + ", " + getCoeff() +")";
    }
}
