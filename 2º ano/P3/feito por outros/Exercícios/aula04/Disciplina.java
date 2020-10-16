package aula04;

public class Disciplina {
	private String nome;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private Estudante[] alunos = new Estudante[1000];
	private static int nAlunos = 0;
	
	public Disciplina(String nome, String areaCientifica, int ects, Professor responsavel) {
		this.nome = nome;
		this.areaCientifica = areaCientifica;
		this.ects = ects;
		this.responsavel = responsavel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getAreaCientifica() {
		return areaCientifica;
	}
	
	public int getEcts() {
		return ects;
	}
	
	public Professor getResponsavel() {
		return responsavel;
	}
	
	public String toString() {
		return "Disciplina: " + nome + " (6 ECTS) da Área de " + areaCientifica + "\nResponsável: PROFESSOR: " + responsavel + "\nExistem " + nAlunos + " Alunos Inscritos";
	}
	
	/*public Estudante[] novoAlunos() {
		Estudante[] novo = new Estudante[alunos.length+1];
		for (int i=0; i<alunos.length; i++) {
			novo[i]=alunos[i];
		}
		return novo;
	}*/
	
	/*public boolean alunosIsFull() {
		if (nAlunos==(alunos.length-1)) {
			return true;
		}
		return false;
	}*/
	
	public boolean alunoInscrito(int nMec) {
		for (int i=0; i<nAlunos; i++) {
			if (nMec == alunos[i].getNMec()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addAluno(Estudante est) {
		/*if (alunosIsFull()) {
			alunos = novoAlunos();
			alunos[nAlunos] = est;
			nAlunos++;
			return true;
		}*/
		
		if (!alunoInscrito(est.getNMec())) {
			alunos[nAlunos] = est;
			nAlunos++;
			return true;
		}
		return false;
	}
	
	public boolean delAluno(int nMec) {
		if (alunoInscrito(nMec)) {
			for (int i=0; i<alunos.length; i++) {
				if (nMec == alunos[i].getNMec()) {
					for (int j=i; j<nAlunos-1; j++) {
						alunos[j] = alunos[j+1];
					}
					alunos[--nAlunos] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public int numAlunos() {
		return nAlunos;
	}
	
	public Estudante[] getAlunos() {
		Estudante [] aux = new Estudante[nAlunos];
		for (int i=0; i<nAlunos; i++) {
			aux[i]=alunos[i];
		}
		return aux;
	}
	
	public Estudante[] getAlunos(String tipo) {
		Estudante[] bolseiros = new Estudante[1000];
		int cont = 0;
		for (int i=0; i<nAlunos; i++) {
			if ((alunos[i].whoAmI()).equals(tipo)) {
				bolseiros[cont] = alunos[i];
				cont++;
			}
		}
		
		Estudante[] aux = new Estudante[cont];
		for (int i=0; i<cont; i++) {
			aux[i]=bolseiros[i];
		}
		
		return aux;
	}
}
