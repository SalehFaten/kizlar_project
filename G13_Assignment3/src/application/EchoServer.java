package application;
//This file contains material supporting section 3.7 of the textbook:

//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.*;
import ocsf.server.*;
import common.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer {

	static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	// update USER, PASS and DB URL according to credentials provided by the
	// website:
	// https://remotemysql.com/
	// in future get those hardcoede string into separated config file.
	static private final String DB = "gVwEbvpoL3";
	static private final String DB_URL = "jdbc:mysql://remotemysql.com/" + DB + "?useSSL=false";
	static private final String USER = "gVwEbvpoL3";
	static private final String PASS = "PyIl4PPKot";

//Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF serverUI;

//Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public EchoServer(int port) {
		super(port);
	}

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port     The port number to connect on.
	 * @param serverUI The interface type variable.
	 */
	Connection conn = null;

	public EchoServer(int port, ChatIF serverUI) throws IOException {
		super(port);
		this.serverUI = serverUI;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("SQLException: " + se.getMessage());
			System.out.println("SQLState: " + se.getSQLState());
			System.out.println("VendorError: " + se.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */

	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		if (msg.toString().startsWith("#login ")) {
			if (client.getInfo("loginID") != null) {
				try {
					client.sendToClient("You are already logged in.");
				} catch (IOException e) {
				}
				return;
			}
			client.setInfo("loginID", msg.toString().substring(7));
		} else {
			if (client.getInfo("loginID") == null) {
				try {
					client.sendToClient("You need to login before you can chat.");
					client.close();
				} catch (IOException e) {
				}
				return;
			}
			String email = null;
			String pass = null;
			String firstname = null;
			String lastname = null;
			String tel = null;
			String visa = null;
			String cvv = null;
			String date = null;
			String id = null;
			String[] detail = ((String) msg).split(",");
			String command = detail[0];
			switch (command) {
			case "SignUp":
				email = detail[1];
				pass = detail[2];
				firstname = detail[3];
				lastname = detail[4];
				tel = detail[5];
				visa = detail[6];
				cvv = detail[7];
				date = detail[8];
				id = detail[9];
				Statement stmt = null;
				List<String> Email = new ArrayList<String>();
				try {
					stmt = conn.createStatement();
					String sql = "SELECT * FROM CustomerCard";
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						Email.add(rs.getString("Email"));
					}
					if (email.equals("") || pass.equals("") || firstname.equals("") || lastname.equals("")
							|| tel.equals("") || visa.equals("") || cvv.equals("") || date.equals("")
							|| id.equals("")) {
						JOptionPane.showMessageDialog(null, "One or more files are empty!! ");

					} else if (Email.contains(email)) {

						JOptionPane.showMessageDialog(null, "You are already registed ");

					} else if (!(email.contains("@hotmail.com")) && !(email.contains("@gmail.com"))) {

						JOptionPane.showMessageDialog(null, "Please enter correct mail ");

					} else if (tel.length() != 10 || (!tel.matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Please enter correct phone number ");

					} else if (visa.length() != 16 || (!visa.matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Please enter correct visa number ");

					} else if (cvv.length() != 3 || (!cvv.matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Please enter correct cvv number ");

					} else if (id.length() != 9 || (!id.matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Please enter correct id ");

					} else if (date.length() != 5 || (!date.matches("(1[0-2]|0[1-9])/(2[0-9])"))) {
						JOptionPane.showMessageDialog(null, "Please enter correct date number ");

					} else {
						this.handleMessageFromServerUI("SignUp");
						JOptionPane.showMessageDialog(null, "You SignUp successfully ");
					}
					if ((!email.equals("") && !pass.equals("") && !firstname.equals("") && !lastname.equals("")
							&& !tel.equals("") && !visa.equals("") && !cvv.equals("") && !date.equals("")
							&& !id.equals(""))) {
						PreparedStatement prep_stmt = conn.prepareStatement(
								"INSERT INTO CustomerCard " + "VALUES(?, ?, ?,?, ?, ?, ?, ?, ?, '1')");
						prep_stmt.setString(1, email);
						prep_stmt.setString(2, pass);
						prep_stmt.setString(3, firstname);
						prep_stmt.setString(4, lastname);
						prep_stmt.setString(5, tel);
						prep_stmt.setString(6, visa);
						prep_stmt.setString(7, cvv);
						prep_stmt.setString(8, date);
						prep_stmt.setString(9, id);
						prep_stmt.executeUpdate();
					}

				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("SQLException: " + se.getMessage());
					System.out.println("SQLState: " + se.getSQLState());
					System.out.println("VendorError: " + se.getErrorCode());
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "SignIn":
				email = detail[1];
				pass = detail[2];
				String useremail = null;
				String userpass = null;
				try {
					PreparedStatement prep_stmt = conn.prepareStatement("SELECT * FROM CustomerCard WHERE Email=?");
					prep_stmt.setString(1, email);
					ResultSet rs = prep_stmt.executeQuery();
					while (rs.next()) {
						useremail = rs.getString("Email");
						userpass = rs.getString("password");
					}
					if (email == null || pass == null) {
						JOptionPane.showMessageDialog(null, "One or more files are empty!! ");

					} else if (useremail == null) {
						JOptionPane.showMessageDialog(null, "You are not registed !!");
					} else if (useremail != null) {
						if (!(userpass.equals(pass))) {
							JOptionPane.showMessageDialog(null, "You entered uncorrect password !!");

						} else {
							this.handleMessageFromServerUI("SignIn");

						}
					}

				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("SQLException: " + se.getMessage());
					System.out.println("SQLState: " + se.getSQLState());
					System.out.println("VendorError: " + se.getErrorCode());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "PublicSearch":
			
			}
//			System.out.println("Message received: " + msg + " from \"" + client.getInfo("loginID") + "\" " + client);
//   this.sendToAllClients(client.getInfo("loginID") + "> " + msg);
		}
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI
	 */
	public void handleMessageFromServerUI(String message) {
		if (message.charAt(0) == '#') {
			runCommand(message);
		} else {
			// send message to clients
			serverUI.display(message);
			this.sendToAllClients(message);
		}
	}

	/**
	 * This method executes server commands.
	 *
	 * @param message String from the server console.
	 */
	private void runCommand(String message) {
		// run commands
		// a series of if statements

		if (message.equalsIgnoreCase("#quit")) {
			quit();
		} else if (message.equalsIgnoreCase("#stop")) {
			stopListening();
		} else if (message.equalsIgnoreCase("#close")) {
			try {
				close();
			} catch (IOException e) {
			}
		} else if (message.toLowerCase().startsWith("#setport")) {
			if (getNumberOfClients() == 0 && !isListening()) {
				// If there are no connected clients and we are not
				// listening for new ones, assume server closed.
				// A more exact way to determine this was not obvious and
				// time was limited.
				int newPort = Integer.parseInt(message.substring(9));
				setPort(newPort);
				// error checking should be added
				serverUI.display("Server port changed to " + getPort());
			} else {
				serverUI.display("The server is not closed. Port cannot be changed.");
			}
		} else if (message.equalsIgnoreCase("#start")) {
			if (!isListening()) {
				try {
					listen();
				} catch (Exception ex) {
					serverUI.display("Error - Could not listen for clients!");
				}
			} else {
				serverUI.display("The server is already listening for clients.");
			}
		} else if (message.equalsIgnoreCase("#getport")) {
			serverUI.display("Currently port: " + Integer.toString(getPort()));
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	/**
	 * Run when new clients are connected. Implemented by Benjamin Bergman, Oct 22,
	 * 2009.
	 *
	 * @param client the connection connected to the client
	 */
	protected void clientConnected(ConnectionToClient client) {
		// display on server and clients that the client has connected.
		String msg = "A Client has connected";
		System.out.println(msg);
		this.sendToAllClients(msg);
	}

	/**
	 * Run when clients disconnect. Implemented by Benjamin Bergman, Oct 22, 2009
	 *
	 * @param client the connection with the client
	 */
	synchronized protected void clientDisconnected(ConnectionToClient client) {
		// display on server and clients when a user disconnects
		String msg = client.getInfo("loginID").toString() + " has disconnected";

		System.out.println(msg);
		this.sendToAllClients(msg);
	}

	/**
	 * Run when a client suddenly disconnects. Implemented by Benjamin Bergman, Oct
	 * 22, 2009
	 *
	 * @param client    the client that raised the exception
	 * @param Throwable the exception thrown
	 */
	synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
		String msg = client.getInfo("loginID").toString() + " has disconnected";

		System.out.println(msg);
		this.sendToAllClients(msg);
	}

	/**
	 * This method terminates the server.
	 */
	public void quit() {
		try {
			close();
		} catch (IOException e) {
		}
		System.exit(0);
	}

//Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *        is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		EchoServer sv = new EchoServer(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
//End of EchoServer class