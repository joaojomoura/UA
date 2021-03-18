package aula07;

import java.io.*;


public class BitmapInfoHeader implements Serializable{
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	int sizeNormal;
	int widthNormal;
	int heightNormal;
	private static final long serialVersionUID = 17434632564L;
	
	

	public BitmapInfoHeader(RandomAccessFile f) throws IOException{ 
		size = Integer.reverseBytes(f.readInt());
		width = Integer.reverseBytes(f.readInt());
		height = Integer.reverseBytes(f.readInt());
		planes = Short.reverseBytes(f.readShort());
		bitCount = Short.reverseBytes(f.readShort());
		compression =Integer.reverseBytes(f.readInt());
		sizeImage = Integer.reverseBytes(f.readInt());
		xPelsPerMeter = Integer.reverseBytes(f.readInt());
		yPelsPerMeter = Integer.reverseBytes(f.readInt());
		clrUsed = Integer.reverseBytes(f.readInt());
		clrImportant = Integer.reverseBytes(f.readInt());
		sizeNormal=size;
		heightNormal=height;
		widthNormal = width;
	}
	
	
	
	
	public void write(RandomAccessFile f) throws IOException{ 
		f.writeInt(Integer.reverseBytes(size));
		f.writeInt(Integer.reverseBytes(width));
		f.writeInt(Integer.reverseBytes(height));
		f.writeShort(Short.reverseBytes(planes));
		f.writeShort(Short.reverseBytes(bitCount));
		f.writeInt(Integer.reverseBytes(compression));
		f.writeInt(Integer.reverseBytes(sizeImage));
		f.writeInt(Integer.reverseBytes(xPelsPerMeter));
		f.writeInt(Integer.reverseBytes(yPelsPerMeter));
		f.writeInt(Integer.reverseBytes(clrUsed));
		f.writeInt(Integer.reverseBytes(clrImportant));

	}
	
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	public void flip(){height = (-1)*height;}
	
	public void resize(int n){
		height = height/n;
		width = width/n;
		}
	
	public void reset()	{ 
		size=sizeNormal;
		height=heightNormal;
		width = widthNormal;
		}

	
}
