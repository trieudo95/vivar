package managa.factor.testing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class Endpoint {

	protected Channel channel;
	protected Connection connection;
	protected String endPointName;

	public Endpoint(String endpointName) throws IOException {
		this.endPointName = endpointName;

		// Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		// hostname of your rabbitmq server
		factory.setHost("localhost");
		
		factory.setUsername("tdo44");
		factory.setPassword("abc");

		// getting a connection
		try {
			connection = factory.newConnection();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// creating a channel
		channel = connection.createChannel();

		// declaring a queue for this channel. If queue does not exist,
		// it will be created on the server.
		channel.queueDeclare(endpointName, false, false, false, null);
	}

	/**
	 * Close channel and connection. Not necessary as it happens implicitly any way.
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		try {
			this.channel.close();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connection.close();
	}

}
