package videoclube;

public class Video {

	private int ID;
	private String titulo;
	private Categoria cat;
	private Idade idd;
	private boolean disp;
	private int ratingTotal=0,ratingNValores=0,ratingMedio=0;
	
	public Video(int ID,String ititulo, Categoria icat, Idade iidd)
	{
		this.cat=icat;
		this.ID=ID;
		this.titulo=ititulo;
		this.cat=icat;
		this.idd=iidd;
		this.disp=true;
	}
	public void setVideo(int ID,String ititulo, Categoria icat, Idade iidd)
	{
		this.cat=icat;
		this.ID=ID;
		this.titulo=ititulo;
		this.cat=icat;
		this.idd=iidd;
	}
	
	public void setDisp(boolean idisp)
	{
		this.disp=idisp;
	}
	
	public boolean getDisp()
	{
		return this.disp;
	}
	public int getID()
	{
		return this.ID;
	}
	
	public String gettitulo()
	{
		return this.titulo;
	}
	
	
	public Categoria getcat()
	{
		return this.cat;
	}
	
	public Idade getidd()
	{
		return this.idd;
	}
	
	public String toString()
	{
		return 	"ID: "+ ID +"    " +"   TÍTULO: "+titulo+"   CATEGORIA: "+cat+ "   " +"   IDADE: "+idd;
	}
}

