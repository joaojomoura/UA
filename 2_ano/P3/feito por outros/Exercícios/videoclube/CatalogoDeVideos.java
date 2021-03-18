package videoclube;

public class CatalogoDeVideos {

	private Video[] listaV;
	private  int numV;

	//CATALOGO DE VIDEOS
	public CatalogoDeVideos(int n)
	{
		listaV = new Video[n];
	}

	public void adicionar(Video v)
	{
		if (!isFull())
		{
			listaV[numV]=v;
			numV++;
		}
	}	
	public boolean isFull()
	{
		return (numV>=listaV.length);
	}
	
	
	public boolean delete (int iID)
	{
		int i;
		for(i=0;i<numV;i++)
		{
			if(listaV[i].getID()==iID)
			{
				for(int j=i;j<numV-1;j++)
				{
					listaV [j]=listaV[j+1];
				}
				numV--;
				return true;
			}
		}
		return false;
	
	}
	
	public void procurarTitulo(String t)
	{
		for(int i=0;i< numV;i++)
			{
				if(listaV[i].gettitulo().compareTo(t)==0)
					System.out.println(listaV[i]);
			}			
	}
	
	public Video procurarID(int id)
	{
		for(int i=0;i<numV;i++)
			if(listaV[i].getID()==id)
				return listaV[i];
		return null;
	}
	
	public void imprimirV()
	{
		for(int i=0;i<numV;i++)
			System.out.println(listaV[i]);
	}
	
	public int getnumV()
	{
		return numV;
	}

	public Video[] getlistaVideo()
	{
		return listaV;
	}
	
	public void imprimirDisp(int idv)
	{
		for(int i=0; i<numV;i++)
		{
			if(listaV[i].getID()==idv && listaV[i].getDisp()==true)
			{
				System.out.println("O video está disponivel.");
			}else if(listaV[i].getID()==idv && listaV[i].getDisp()==false)
				System.out.println("O video não está disponivel.");
			}
		}
	}

