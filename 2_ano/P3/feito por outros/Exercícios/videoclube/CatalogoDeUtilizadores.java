package videoclube;

public class CatalogoDeUtilizadores {

	private Utilizador[] listaU;
	private int numU;
	
	
	public CatalogoDeUtilizadores(int n)
	{
		listaU=new Utilizador[n];
	}
	
	public void adicionar(Utilizador u)
	{
		if (!isFull())
		{
			listaU[numU]=u;
			numU++;
		}
	}	
	public boolean isFull()
	{
		return (numU>=listaU.length);
	}
	
	
	public boolean delete (int iBI)
	{
		int i;
		for(i=0;i<numU;i++)
		{
			if(listaU[i].getBI()==iBI)
			{
				for(int j=i;j<numU-1;j++)
				{
					listaU [j]=listaU[j+1];
				
				}
				numU--;
				return true;
			}
		}return false;
	}
	
	public void imprimirU()
	{
		for(int i=0;i<numU;i++)
			System.out.println(listaU[i]);
	}
	
	public int getnumU()
	{
		return numU;
	}
	
}
	
