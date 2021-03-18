/**
 * 
 */
package aula3.ex4;

import static java.lang.System.*;

/**
 * @author João Moura
 *
 */
public class Movie {
	
	//Variaveis
	private static int seqID = 0;
	private final int id;
	private final String titulo;
	private final String categoria;
	private final String idade;
	private boolean existe;
	private int totRating;
	private int screenings;
	private int rating;
	
	//Construtor
	public Movie(String t, String cat, String i) {
		id = seqID++;
		titulo = t;
		existe = true;
		String tmp = cat.toLowerCase();
		if(!tmp.equals("Ação") && !tmp.equals("Comédia") && !tmp.equals("Infantil") && !tmp.equals("Drama") &&
				!tmp.equals("Terror"))
			throw new RuntimeException("Categoria não especializada.\n");
		categoria = cat;
		if (!i.equals("ALL") && !i.equals("M6") && !i.equals("M12") && !i.equals("M16") && !i.equals("M18"))
	    	throw new RuntimeException("Padrão etário não aceitável.\n");
		idade = i;
		
	}
	
	//getters
	public int getID() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public String getIdade() {
		return idade;
	}


	public boolean getExiste() {
		return existe;
	}

	//operaçoes
	
	/**
	 * para verificar se existe filme
	 */
	public void in() {
		existe = true;
	}
	/**
	 * 
	 * @return que o filme foi retirado ou nao existe
	 */
	public boolean out() {
		if(!getExiste()) {
			out.printf("Filme de momento não existe no videoclube/n");
			return false;
		}
		existe = false;
		return true;
	}
	
	public int getRating()
	  {
		  return rating;
	  }
	  
	  public void updateRating(int novo)
	  {
		  screenings++;
		  totRating += novo;
		  rating = totRating/screenings;
	  }
	  
	  public int compareTo(Movie m)
	  {
		  if (this.rating == m.rating)
			  return 0;
		  else if (this.rating < m.rating)
			  return -1;
		  else
			  return 1;
	  }
	public String toString() {
		return "ID do filme: " + id + " | Título: " + titulo + " | Categoria: " + categoria + 
		    	" | Faixa etária: " + idade + " | Disponível: " + (existe ? "sim" : "não") + "/n | Rating: " + rating + "\n";
		}
			
}


