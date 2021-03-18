package aula09;

public class Exerc1 {
	public static void main(String args[]) {
		JogadorInterface j1 = new Jogador("Rui");
		Futebolista f1 = new Futebolista(new Jogador("Luis"));
		Basquetebolista x1 = new Basquetebolista(new Jogador("Ana"));
		Basquetebolista x2 = new Basquetebolista(j1);
		Basquetebolista x3 = new Basquetebolista(f1);
		Tenista t1 = new Tenista(j1);
		Tenista t2 = new Tenista(new Basquetebolista(new Futebolista(new Jogador("Bruna"))));
		JogadorInterface lista[] = { j1, f1, x1, x2, x3, t1, t2 };
		for (JogadorInterface ji: lista)
		ji.joga();
		GuardaRedes gr1 = new GuardaRedes(f1);
		GuardaRedes gr2 = new GuardaRedes(new Futebolista(new Jogador("Paredes")));
		gr1.joga();
		gr2.joga();
	}
}