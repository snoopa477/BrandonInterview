package _0525_._03_readWriteLittleEndian;
import static java.lang.System.out;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Test_LittleEndianWriter {

	public static void main(String[] args) throws IOException {
		
		DataOutputStream dataOutputStream = new DataOutputStream( new FileOutputStream(FileInfo.FILE_PATH));
		Trade[] trades = {
			new Trade(1579620836000000000L, 1L, 0), new Trade(1579620839000000000L, 2L, 1),
			new Trade(1579620842000000000L, 3L, 1), new Trade(1579620851000000000L, 4L, 1),
			new Trade(1579620854000000000L, 5L, 1), new Trade(1579620855000000000L, 6L, 1),
			new Trade(1579620859000000000L, 7L, 0), new Trade(1579620867000000000L, 8L, 1),
		};
		
		writeTrades(dataOutputStream, trades);
		out.println("done writing");
	}
	
	public static void writeTrades(DataOutputStream dataOutputStream, Trade[] trades) throws IOException {
		
		for(Trade trade: trades) {
			writeTrade(dataOutputStream, trade);
		}
	}
	
	public static void writeTrade(DataOutputStream dataOutputStream, Trade trade) throws IOException {
		
		byte[] bytes0 = parseBytesLittleEndian( trade.buy );
		byte[] bytes1 = parseBytesLittleEndian( trade.index );
		byte[] bytes2 = parseBytesLittleEndian( trade.timestamp );
		
		dataOutputStream.write(bytes0);
		dataOutputStream.write(bytes1);
		dataOutputStream.write(bytes2);
	}
	
	
	public static byte[] parseBytesLittleEndian(int num) {
		
		byte[] bytes = ByteBuffer.allocate(4).putInt(num).array();
		reverseOrder(bytes);
		return bytes;
	}
	
	
	public static byte[] parseBytesLittleEndian(long num) {
		
		byte[] bytes = ByteBuffer.allocate(8).putLong(num).array();
		reverseOrder(bytes);
		return bytes;
	}
	
	
	public static void reverseOrder(byte[] bytes) {
		for( int i = 0; i < bytes.length / 2; i++) {
			swap(bytes, i, bytes.length -1 - i);
		}
	}
	
	public static void swap(byte[] bytes, int indexA, int indexB) {
		
		byte temp = bytes[indexA];
		bytes[indexA] = bytes[indexB];
		bytes[indexB] = temp;
	}
	
}


