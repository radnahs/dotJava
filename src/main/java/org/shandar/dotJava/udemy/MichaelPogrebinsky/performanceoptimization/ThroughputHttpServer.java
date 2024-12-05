/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.performanceoptimization </p>
 * <p>File Name: ThroughputHttpServer.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 12:21:12 am </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.performanceoptimization;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


/**
 * run the program and hit this url of web browser
 * http://localhost:8000/search?word=is
 */
public class ThroughputHttpServer {

	private static final String INPUT_FILE = "D:/data/projects/github/dotJava/src/main/java/org/shandar/dotJava/udemy/MichaelPogrebinsky/performanceoptimization/war_and_peace.txt";;
	private static final int NUMBER_OF_THREADS = 1; // 2 or 4 or 8 ...this should be the number of cores of the system.

	public static void main(String[] args) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));

		startServer(text);
	}

	public static void startServer(String text) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/search", new WordCountHandler(text));
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		server.setExecutor(executor);
		server.start();
	}

	private static class WordCountHandler implements HttpHandler {
		private String text;

		public WordCountHandler(String text) {
			super();
			this.text = text;
		}

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String query = exchange.getRequestURI().getQuery();
			String[] keyValue = query.split("=");
			String action = keyValue[0];
			String word = keyValue[1];
			if(!action.equals("word")) {
				exchange.sendResponseHeaders(400, 0);
				return;
			}
			
			long count = countWord(word);
			byte[] response = Long.toString(count).getBytes();
			exchange.sendResponseHeaders(200, response.length);
			
			OutputStream outputStream = exchange.getResponseBody();
			outputStream.write(response);
			outputStream.close();
		}
		
		private long countWord(String word) {
			int count=0, index=0;
			while(index>=0) {
				index = text.indexOf(word, index);
				if(index>=0) {
					count++;
					index++;
				}
			}
			return count;
		}
	}
}
