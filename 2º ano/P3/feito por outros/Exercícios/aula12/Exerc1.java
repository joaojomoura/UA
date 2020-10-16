package aula12;

public class Exerc1 {

	public static void main(String[] args) {
		
		Localidade cid1 = new Localidade("Sacramento", 5125, TipoLocalidade.CIDADE);
		Localidade cid2 = new Localidade ("Vila Rija", 9345, TipoLocalidade.CIDADE);
		
		Estado est1 = new Estado("Euro Norte", 23133, cid1);
		Estado est2 = new Estado("Euro Sul", 43321, cid2);
		
		Provincia prov1 = new Provincia("Centro", 232475, "Manuez Pereira");
		Provincia prov2 = new Provincia("Litoral ", 232475, "Maria Vilar");
		Provincia prov3 = new Provincia("Afro Poente", 287349, "Mané Lima");
		
		MyList<Regiao> reg1 = new MyList<Regiao>();
		reg1.add(est1);
		reg1.add(est2);
		
		MyList<Regiao> reg2 = new MyList<Regiao>();
		reg2.add(prov1);
		reg2.add(prov2);
		reg2.add(prov3);
		
		Pais p1 = new Pais("Eurais", est1.getCapital(), reg1);
		Pais p2 = new Pais("United XPTO", cid2, reg2);
		System.out.println(p1);
		
		Organizacao org = new Organizacao("Nações Reunidas");
		org.add(p1); org.add(p2);
		
		Iterator<?> itr = org.iterator();
		while ( itr.hasNext() )
			System.out.println( itr.next() );
		
		if (!org.add(p1))
			System.out.println("País já pertence à Organização.");
		
		org.remove(p2);
		if (!org.remove(p2))
			System.out.println("Pais não pertence à Organização.");
	}
}
