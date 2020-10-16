package videoclube;

public class CatalogoDeEmprestimos {

	private Emprestimo[] listaE;
	private int nEmp=0;
	
	public CatalogoDeEmprestimos(int n)
	{
		listaE=new Emprestimo[n];
	}
	
	public void checkIn(int iIDV,int iIDU,CatalogoDeVideos cat)
	{
		
		Emprestimo e=new Emprestimo(false, iIDU, iIDV);
		Video v;
		v=cat.procurarID(iIDV);
		
		listaE[nEmp]=e;
		nEmp++;
		v.setDisp(true);
	}
	
	public void checkOut (int iIDV,int iIDU,CatalogoDeVideos cat){
		for(int i=0;i<cat.getnumV();i++)
		{
		if(cat.procurarID(i).getID()==iIDV && cat.procurarID(i).getDisp()==true){
		Emprestimo e=new Emprestimo(true, iIDU, iIDV);
		Video v;
		v=cat.procurarID(iIDV);
		
		listaE[nEmp]=e;
		nEmp++;
		v.setDisp(false);
		System.out.println("Checkout efectuado com sucesso!");
		
		}else if(cat.procurarID(i).getID()==iIDV && cat.procurarID(i).getDisp()==false){
		System.out.println("Video não se encontra disponivel!");	
		}
		}
		
	}
	

	public void imprimirEmpU(int idv)
	{
		for(int i=0;i<nEmp;i++)
			if(listaE[i].getIDV()==idv){
			System.out.println(listaE[i]);
			}
	}
	
	public void imprimirUVideo(int idv)
	{
		for(int i=0;i<nEmp;i++)
			if(listaE[i].getIDV()==idv){
			System.out.println(listaE[i]);
			}
	}
	
	
	
}
