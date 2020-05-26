
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient implements Runnable {

    /***
     * clientSocket :  a client socket to connect with server.
     * writeData : send or write message to other clients.
     * readData : recieve or read message from other clients.
     * incomingData : message from other clients.
     * closed : to verfiy if connection between client and server close or open.
     */
    private static Socket clientSocket = null;
    private static PrintStream writeData = null;
    private static BufferedReader readData = null;
    private static BufferedReader incomingData = null;
    private static boolean closed = false;

    /**
     * UI components.
     * Frame : to place all UI components.
     * Textfield : to enter message
     * Textarea : to display conversation.
     * Scrollpane : to scroll textarea.
     * */
    private JFrame frame;
    private JTextField messageBox;
    private static JTextArea chatTextArea;
    private JScrollPane scrollPane;

    /** to set client name as frame tittle**/
    boolean setTittle = false;

    public static void main(String[] args) throws UnknownHostException, IOException {

        /****
         * portNumber : The default port. Assigned default value 2345.
         * Should be greater than 1023. Because it is reserved for special application(eg : email).
         * host : address for host. default is local host.
         *
         */
        int portNumber = 2345;
        String host = "localhost";

        System.out.println("Enter portnumber and host number (using command line argument. Separated by space). Otherwise default value will be assigned.");
        if (args.length < 2) {
            System.out.println("Now using host=" + host + ", portNumber=" + portNumber);
        } else {
            host = args[0];
            portNumber = Integer.valueOf(args[1]).intValue();
        }

        /***
         * Initialize client socket.
         * Initialize read and write message stream.
         */

        try {
            clientSocket = new Socket(host, portNumber);
            incomingData = new BufferedReader(new InputStreamReader(System.in));
            writeData = new PrintStream(clientSocket.getOutputStream());
            readData = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("UnknownHost " + host);
        } catch (IOException e) {
            System.err.println("Cannot establish input/output connection with host " + host);
        }

        /***
         * Once establish connection successfully, can read or write message to server using provided port.
         * Create connection in form of thread to read/write to/from server.
         * Continue chat until connection is closed by server.
         * Once connection is closed. Closed read/write data connection also.
         *
         */
        if (clientSocket != null && writeData != null && readData != null) {
            try {
                /* Create a thread to read from the server. */
                new Thread(new MultiThreadClient()).start();
                while (!closed) {
                    writeData.println(incomingData.readLine().trim());
                }
                /*
                 * Close the output stream, close the input stream, close the socket.
                 */
                writeData.close();
                readData.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }

    /****
     * Read from server until recieve "Close" from the server
     * Once recieved break the connection.
     */
    public void run() {
        try {
            MultiThreadClient window = new MultiThreadClient();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String broadcastData;

        try {
            String prevbroadCastData = "";
            while ((broadcastData = readData.readLine()) != null) {
                chatTextArea.setText(chatTextArea.getText() + "\n" +  broadcastData);
                if (broadcastData.indexOf("*** Disconnect user : ") != -1){
                    break;
                }
            }
            closed = true;
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

    /**
     * Create the application.
     */
    public MultiThreadClient() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground(UIManager.getColor("MenuBar.highlight"));
        frame.setBounds(10, 10, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set default frame title.
        frame.setTitle("Client");
        frame.setBackground(Color.black);
        frame.setLayout(new GridLayout(2,1));

        JPanel chatframe = new JPanel();
        chatframe.setLayout(new GridLayout(1,1));

        JPanel messageframe = new JPanel();
        messageframe.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.add(chatframe);
        frame.add(messageframe);

        scrollPane = new JScrollPane();
        chatframe.add(scrollPane);

        chatTextArea = new JTextArea();
        scrollPane.setViewportView(chatTextArea);
        chatTextArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        chatTextArea.setForeground(Color.white);
        chatTextArea.setBackground(new Color(209, 209, 224));
        chatTextArea.setEditable(false);
        DefaultCaret caret = (DefaultCaret) chatTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);


        messageBox = new JTextField();
        messageBox.setFont(new Font("Lato Medium", Font.PLAIN, 22));
        messageBox.setForeground(Color.BLACK);
        messageBox.setBackground(new Color(153, 255, 255));
        messageBox.setColumns(18);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        messageBox.setBorder(border);
        messageBox.setHorizontalAlignment(SwingConstants.LEFT);
        messageframe.add(messageBox);



        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (messageBox.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please write some text !");
                }else  {
                    //set client name as frame title.
                    if(!setTittle){
                        frame.setTitle(messageBox.getText());
                        setTittle = true;
                    }
                    chatTextArea.setText(chatTextArea.getText() + "\n" + "Client : " + messageBox.getText());
                    writeData.println(messageBox.getText());

                    messageBox.setText("");
                }

            }
        });
        sendButton.setFont(new Font("Georgia", Font.PLAIN, 22));
        sendButton.setForeground(Color.BLACK);
        sendButton.setBackground(new Color(255, 128, 128));
        sendButton.setHorizontalAlignment(SwingConstants.RIGHT);
        messageframe.add(sendButton);
    }
}
