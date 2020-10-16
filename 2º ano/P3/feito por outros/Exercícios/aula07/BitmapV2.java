//Tentei implementar a class pixel em vez de byte [] Data

package aula07;

import java.io.*;

public class BitmapV2 implements Serializable{
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	Pixel [] pixel;
	private int k=1;

	private static final long serialVersionUID = 174345022134L;
	
	
	
	public BitmapV2(RandomAccessFile f) throws IOException{ 
		pixel = new Pixel[(int) (f.length()-54)/4];
		bitmapFileHeader= new BitmapFileHeader(f);
		bitmapInfoHeader=new BitmapInfoHeader(f);	
				
		for(int i = 0; i<(pixel.length); i++)
			pixel[i]=new Pixel((byte) f.readByte(),(byte) f.readByte(),(byte) f.readByte(),(byte) f.readByte());
		
	}

	public RandomAccessFile copyFile() throws IOException{
			
		RandomAccessFile p = new RandomAccessFile("CopiaNormal.bmp", "rw");
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		for(int i = 0; i<(pixel.length); i++)
			p.write(pixel[i].getPixel());

		return p;
		
	}
	
	public RandomAccessFile mirror() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("EfeitoEspelho.bmp", "rw");
		bitmapInfoHeader.flip();
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
	
		
		for(int i = pixel.length-1; i>=0; i--)
			pixel[i].write(p);
		
		return p;
		
	}
	
	public RandomAccessFile flip2() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("CopiaFlipada2.bmp", "rw");
		bitmapInfoHeader.flip();
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		for(int i = 0; i<(pixel.length); i++)
			p.write(pixel[i].getPixel());
		
		return p;
		
		
		
	}
	
	public RandomAccessFile guardaRaw() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("FormatoRaw.raw", "rw");
		for(int i = 0; i<(pixel.length); i++)
			pixel[i].write(p);
		
		return p;
		
		
	}
	
	public RandomAccessFile resize() throws IOException
	{ 
		RandomAccessFile p= new RandomAccessFile("CopiaRedimensionada.bmp", "rw");
		bitmapInfoHeader.resize(2);
		bitmapFileHeader.write(p);
		bitmapInfoHeader.write(p);
		bitmapInfoHeader.reset();
		
		for(int i = 0;i <= pixel.length-1; i++){ 
			if(i%2!=0 && k%2!=0)
				pixel[i].write(p);
			
			
			if(i/2==k*(bitmapInfoHeader.getWidth()))
				k++;
			
		}
		
		return p;
			
		
		
	}
	
}



