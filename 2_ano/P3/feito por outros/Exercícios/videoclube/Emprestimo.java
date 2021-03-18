package videoclube;

public class Emprestimo {

	private boolean checkOut;
	private int IDU;
	private int IDV;
	
	public Emprestimo(boolean icheckOut,int iIDU,int iIDV)
	{
	this.checkOut=icheckOut;
	this.IDU=iIDU;
	this.IDV=iIDV;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}

	public int getIDU() {
		return IDU;
	}

	public void setIDU(int iDU) {
		IDU = iDU;
	}

	public int getIDV() {
		return IDV;
	}

	public void setIDV(int iDV) {
		IDV = iDV;
	}
	
	public String toString()
	{
		if(isCheckOut()==true)
		{
			return "Nº sócio: "+getIDU()+", ID video: "+getIDV()+", CheckOut";
		}else
		{
			return "Nº sócio: "+getIDU()+", ID video: "+getIDV()+", CheckIn";
		}
	}
	
}
