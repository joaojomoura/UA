package aula03;

public class Videoclube {
	private Cliente[] clientes;
	private Video[] videos;


	public Videoclube(int maxUsers, int maxVideo)
	{ 
		
		videos = new Video[maxVideo];
		clientes = new Cliente[maxUsers];
		
	}

	public String adicionarVideo(Video a)
	{ 
		videos[Video.getID()]=a;
		return "Video adicionado com sucesso. ID: " +Video.getID();	
	}
	
	public String adicionarCliente (Cliente a)
	{ 	
		clientes[Cliente.getID()]=a;
		return "Cliente adicionado com sucesso. N�mero de S�cio: " +Cliente.getID();
	}
	
	public String removerCliente(int id)
	{ 
		if(Cliente.getID()<0)
			return "";
		for(int i =0; i<=Cliente.getID(); i++)
		{ 
			if(id == i)
			{
				videos[id]=null;
				return "Foi apagado com exito o cliente com o n� de s�cio" +id;
			}
		}
		
		return "N�o foi encontrado ningu�m com o n� s�cio " + id;
	}
	
	public String removerVideo(int id)
	{ 
		if(Video.getID()<0)
			return "";
		for(int i=0;i<=Video.getID();i++)
		{ 
			if(id == i)
			{ 
				videos[id]=null;
				return "Foi apagado com exito o video com o ID " +id;	
			}

		}
		return "N�o foi encontrado nenhum video com o ID " + id;
	}
	
	public String listarVideos()
	{ 
		if(Video.getID()<0)
			return "";
		String a="";
		for(int i = 0; i <= Video.getID(); i++)
		{ 
			if(videos[i]!=null)
				a = a + "ID: " + i + " | " + videos[i].toString() +"\n";
			
			
		}
		
		return a;
		
		
	}
	
	public String listarClientes()
	{ 
		if(Cliente.getID()<0)
			return "";
		String a="";
		
		for(int i = 0; i<= Cliente.getID(); i++)
		{ 
			if(clientes[i]!=null)
				a = a +"ID: " + i + " | " + clientes[i].toString()+ "\n";
			
			
		}
		return a;
		
		
		
	}
	
	public String encontrarVideo(int id)
	{ 
		if(Video.getID()<0)
			return "";
		
		for(int i=0;i<=Video.getID();i++)
		{ 
			if(id == i)
			{ 
				return "ID: " + id + videos[id].toString();	
			}
		}
		
		return "N�o foi encontrado o video com o id " + id;
		
		
	}
	
	public String editarVideo(int id, int nCopias)
	{ 
		if(Video.getID()<0)
			return "";
		for(int i = 0; i<=Video.getID();i++)
		{ 
			if(i==id)
			{ 	Video a = videos[id];
				videos[id] = new Video(a.getTitulo(),a.getCategoria(),a.getIdade(),nCopias);
				Video.decId();
				return "Video alterado com sucesso";
			}
			
		}
		return "N�o foi encontrado nenhum video com ID: " +id;
		
	}
	
	public String encontrarCliente(int id)
	{ 
		if(Cliente.getID()<0)
			return "";
		for(int i=0;i<=Cliente.getID();i++)
		{ 
			if(id == i)
			{ 
				return "ID: " + id + clientes[id].toString();	
			}
		}
		
		return "N�o foi encontrado o Cliente com o id " + id;
		
		
		
	}
	public boolean encontrouCl(int id)
	{ 
		for(int i=0;i<=Cliente.getID();i++)
		{ 
			if(id == i)
			{ 
				return true;	
			}
		}
		
		return false;
		
		
	}
	
	public boolean encontrouVi(int id)
	{ 
		for(int i=0;i<=Video.getID();i++)
		{ 
			if(id == i)
			{ 
				return true;	
			}
		}
		
		return false;
		
		
	}
	
	public String alugarVideo(int idC, int idV)
	{ 
		if(Video.getID()<0 || Cliente.getID()<0)
			return "";
		if(encontrouCl(idC))
		{ 
			if(encontrouVi(idV))
			{ 
				if(videos[idV].disponibilidade())
				{ 
					if(clientes[idC].filmeJaAlugado(videos[idV].getTitulo()))
						return "O Filme " + videos[idV].getTitulo() + " j� se encontra alugado pelo Cliente";
					if(clientes[idC].poderAlugar())
					{ 
						videos[idV].emprestimo(clientes[idC].getName());
						clientes[idC].alugar(videos[idV]);
						clientes[idC].historico();
								
						return "Foi alugado o video " + videos[idV].getTitulo() + " por " + clientes[idC].getName();						
					}
							
					return "O Cliente " +clientes[idC].getName() + " n�o pode alugar mais videos";
				}
					
						
				return "O Video " + videos[idV].getTitulo() + " n�o se encontra disponivel para aluguer";
			}
					
					
			return "N�o foi encontrado o Video com o ID " + idV;
		}
		
		return "N�o foi encontrado o Cliente com o ID " +idC;
			
		}
		
		
		
	
	public String devolverVideo(int idC, int idV,int r)
	{ 
		if(!encontrouCl(idC))
			return "Cliente n�o encontrado";
		if(!encontrouVi(idV))
			return "Video n�o encontrado";
		if(clientes[idC].semVideoAlugado())
			return "Sem videos para devolver neste Cliente ";
		else
		{
			if(!clientes[idC].videoAlugado(videos[idV].getTitulo()))
				return "O Video " + videos[idV].getTitulo() + " n�o se encontra alugado por este Cliente";
			else
			{ 
				videos[idV].devolucao(r);
				clientes[idC].devolucao(videos[idV].getTitulo());
				return "O Video " + videos[idV].getTitulo() + " foi devolvido com sucesso";
			}
		}
			
		
		
	}
	
	public String videosDA()
	{ 
		String a="";
		if(Video.getID()<0)
			return "";
		for(int i = 0; i<=Video.getID(); i++)
		{ 
			if(videos[i].disponibilidade())
			{ 
				a = a + videos[i].getTitulo() + " encontra-se disponivel com " + videos[i].getCheckin() + " c�pias \n";
				
			}
			else
				a = a + videos[i].getTitulo() + " n�o se encontra disponivel \n";
			
		}
		
		return a;
	}
	
	public String historico(int id)
	{ 
		if(Cliente.getID()<0)
			return "";
		for(int i = 0; i<=Cliente.getID();i++)
		{ 
			if(i==id)
				return clientes[id].getHistorico();
			
		}
		
		return "O id " + id+ "n�o foi encontrado";
	}
	
	public String imprimeRating(int id)
	{ 
		if(!encontrouVi(id))
			return "Insira um ID v�lido. O Video com o ID " + id + " n�o foi encontrado.";
		
		if(videos[id].getRatingT()==0)
			return "O video ainda n�o foi avaliado. ";
		
		return "Rating Total: " +videos[id].getRatingT() + "\nRating M�dio: " +videos[id].getRatingM() +"\n�ltimo rating: " +videos[id].getLastRating();
		
		
	}
	
	public boolean clienteIsFull()
	{ 
		return clientes[clientes.length-1]!=null;
	}
	
	public boolean videoIsFull()
	{ 
		return videos[videos.length-1]!=null;
	}
	

}
