package aula06;

public enum DiaSemana {
	Segunda, Terça, Quarta, Quinta, Sexta, Sábado, Domingo;
	
	public static DiaSemana getCodigo(int i) {
		switch(i)
		{
		 case 1: return Segunda;
		 case 2: return Terça;
		 case 3: return Quarta;
		 case 4: return Quinta;
		 case 5: return Sexta;
		 case 6: return Sábado;
		 case 7: return Domingo; 
		}
		return null;
	}
	
	public static DiaSemana rand() {
		return DiaSemana.getCodigo((int) (Math.random() * 7) +1);
	} 
}
