package sliver;
import java.net.*;
import java.io.*;

public class TEST_CODE {

	// User and Launcher Information
	static final String NICKNAME = "SEOUL01_LEESSAFY";
	//static final String NICKNAME = "SEOUL05_KANGYONGWOOK";
	static final String HOST = "127.0.0.1";

	// Static Value(Do not modify)
	static final int PORT = 1447;

	// Predefined Variables(Do not modify)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		byte[] bytes = new byte[1024];

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.\n--------------------");

			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
