package aula06;

public enum DiaSemana {
	Segunda, Ter�a, Quarta, Quinta, Sexta, S�bado, Domingo;
	
	public static DiaSemana getCodigo(int i) {
		switch(i)
		{
		 case 1: return Segunda;
		 case 2: return Ter�a;
		 case 3: return Quarta;
		 case 4: return Quinta;
		 case 5: return Sexta;
		 case 6: return S�bado;
		 case 7: return Domingo; 
		}
		return null;
	}
	
	public static DiaSemana rand() {
		return DiaSemana.getCodigo((int) (Math.random() * 7) +1);
	} 
}
