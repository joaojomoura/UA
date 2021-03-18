package aula09;

public class GuardaRedes extends jogDecorator {
	
	
	public GuardaRedes(Futebolista f) {
		super(f);
	}


	public void defende() {
		System.out.println("--> Defende.");
	}

}
