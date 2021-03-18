package aula06;

public class ListaLigada
{
	private No pin = null;
	private int size = 0;

	public void in(Prato p, DiaSemana dia)
	{		
		assert(!isFull());
		
		No n = new No();
		n.prato = p;
		n.dia = dia;
		
		if(pin == null)
		{
			n.next = n;
			pin=n;	
		}
		else
		{
			No aux = pin.next;
			
			if(pin.next.dia.compareTo(dia) < 0 )
			{
					n.next = pin.next;
					pin.next = n;
			}
			else if (dia.compareTo(pin.dia) < 0)
			{
				n.next = pin.next;
				pin.next = n;
				pin = n;	
			}
			else
			{	
				while(aux.next.dia.compareTo(dia) > 0)
				{				
					aux = aux.next;
				}
				n.next = aux.next;
				aux.next = n;
			}
		}
		size++;
	}
	
	public Prato out()
	{
		assert(!isEmpty());
	
		Prato aux2 = pin.next.prato;
		pin.next = pin.next.next;
		size--;
		if(size==0)
			pin=null;
		return aux2;		
	}
	
	public Prato peek()
	{
		assert(!isEmpty());
		return pin.next.prato;		
	}
	
	public DiaSemana peekPriority()
	{
		DiaSemana aux2 = pin.next.dia;
		return aux2;		
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public boolean isFull()
	{
		return false;
	}
	
	public int size()
	{
		return size;	
	}
	
	public void clear()
	{
		pin = null;
		size = 0;	
	}
	
	public void listar()
	{
		int i = 1;        
        No aux = pin;
        
        while (aux != null)
        {
        	System.out.println("Ingrediente " + aux.prato + ", dia "+DiaSemana.getCodigo(i) );
            aux = aux.next;
            
            if(i < 7)
            {    	
            	i = i+1;
            }
            else
            {
               	break;                	
            }    	
        }
	}
}

class No
{
	Prato prato;
	DiaSemana dia;
	No next;
}
