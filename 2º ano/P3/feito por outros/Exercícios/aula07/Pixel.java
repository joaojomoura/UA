package aula07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Pixel {

	byte [] pixel= new byte[4];
	
	public Pixel(byte r, byte g,byte b, byte reserved ){
		pixel[0]=r;
		pixel[1]=g;
		pixel[2]=b;
		pixel[3]=reserved;
	}
	
	public void write(RandomAccessFile f) throws IOException{
		f.write(pixel[0]);
		f.write(pixel[1]);
		f.write(pixel[2]);
		f.write(pixel[3]);
	}
	
	public byte[] getPixel(){ return pixel;}
}
