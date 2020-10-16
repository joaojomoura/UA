package aula07;

import java.io.*;

public class Exerc2 {


	public static void main(String[] args) throws IOException {
	
		File a = new File("figura.bmp");
		RandomAccessFile x = new RandomAccessFile(a,"r");
		BitmapV2 k = new BitmapV2(x);
		
		
		RandomAccessFile p = k.copyFile();
		RandomAccessFile t = k.mirror();
		RandomAccessFile m = k.flip2();
		RandomAccessFile y = k.resize();
		
	
	}
}
