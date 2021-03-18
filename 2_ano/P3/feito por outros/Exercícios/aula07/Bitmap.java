package aula07;

import java.io.*;

public class Bitmap implements Serializable{
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] data;
	private int k=1;

	private static final long serialVersionUID = 174345022134L;
	
	
	
	public Bitmap(RandomAccessFile f) throws IOException{ 
		data = new byte[(int)f.length()-54];
		bitmapFileHeader= new BitmapFileHeader(f);
		bitmapInfoHeader=new BitmapInfoHeader(f);	
				
		for(int i = 0; i<(data.length); i++)
				data[i]=f.readByte();
		
		
	}

	public RandomAccessFile copyFile() throws IOException{
			
		RandomAccessFile p = new RandomAccessFile("CopiaNormal.bmp", "rw");
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		p.write(data);
		
		return p;
		
	}
	
	public RandomAccessFile mirror() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("EfeitoEspelho.bmp", "rw");
		bitmapInfoHeader.flip();
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		for(int i=(data.length);i>0;i--)
		{
			if(i%4==0)
			{
				p.write(data[i-4]);
				p.write(data[i-3]);
				p.write(data[i-2]);
				p.write(data[i-1]);
			}
		}
		
		
		return p;
		
	}
	
	public RandomAccessFile flip2() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("ImagemReversed.bmp", "rw");
		bitmapInfoHeader.flip();
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		p.write(data);
		
		return p;
		
		
		
	}
	
	public RandomAccessFile guardaRaw() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("imagem.raw", "rw");
		p.write(data);
		
		return p;
		
		
	}
	
	public RandomAccessFile resize(int n) throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("ImagemRedimensionada.bmp", "rw");
		bitmapInfoHeader.resize(n);
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		
		for(int i = 0;i <= data.length; i++)
		{ 
			if(i%(4*n)==0 && k%n==0)
			{ 
				p.write(data[i-4]);
				p.write(data[i-3]);
				p.write(data[i-2]);
				p.write(data[i-1]);
			}
			
			if(i/4==k*(bitmapInfoHeader.getWidth()))
			{
				k++;
			}
			
			
		}
		
		return p;
			
		
		
		
	}
	
}



