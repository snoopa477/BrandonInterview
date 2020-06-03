package _0525_._03_readWriteLittleEndian;
import static java.lang.System.out;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Test_LittleEndianReader {

	public static void main(String[] args) throws IOException {
		
		DataInputStream dataInputStream = new DataInputStream( new FileInputStream(FileInfo.FILE_PATH));
		String tradeRead = null;
		
		while( (tradeRead = readTrade(dataInputStream))!=null ) {
			out.println(tradeRead);
		}
	}
	
	
	public static String readTrade(DataInputStream dataInputStream) throws IOException {
		
		byte[] buffer0 = new byte[4];
		if( dataInputStream.read(buffer0) < 0) {
			return null;
		}
		int buy = parseIntLittleEndian(buffer0);
		
		byte[] buffer1 = new byte[8];
		if( dataInputStream.read(buffer1) < 0) {
			return null;
		}
		long index = parseLongLittleEndian(buffer1);
		
		byte[] buffer2 = new byte[8];
		if( dataInputStream.read(buffer2) < 0) {
			return null;
		}
		long timestamp = parseLongLittleEndian(buffer2);
		
		return String.format("%d\t%d\t%s", timestamp, index, buy == 1? "BUY" : "SELL");
	}
	
	
	public static int parseIntLittleEndian(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
	}
	
	
	public static long parseLongLittleEndian(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getLong();
	}
}


