package aula07;

import java.io.*;


public class BitmapFileHeader implements Serializable {
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	private static final long serialVersionUID = 17434656464L;
	// beginning of the file to the bitmap data
	


	
	public BitmapFileHeader(RandomAccessFile f) throws IOException{ 
		type = Short.reverseBytes(f.readShort());	
		size = Integer.reverseBytes(f.readInt());
		reserved1 = Short.reverseBytes(f.readShort());
		reserved2 = Short.reverseBytes(f.readShort());
		
		if(reserved1 != 0 || reserved2 != 0)
			throw new IllegalArgumentException("Reserved1 or reserved2 != 0");
		offBits = Integer.reverseBytes(f.readInt());
		
	}
	
	public void write(RandomAccessFile f) throws IOException{ 
		
		f.writeShort(Short.reverseBytes(type));
		f.writeInt(Integer.reverseBytes(size));
		f.writeShort(Short.reverseBytes(reserved1));
		f.writeShort(Short.reverseBytes(reserved2));
		f.writeInt(Integer.reverseBytes(offBits));
		}
}
