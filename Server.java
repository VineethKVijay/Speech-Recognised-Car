import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
class Server
{
    public static void main(String srgs[])
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintStream printStream = null;
        
        try{
            serverSocket = new ServerSocket(0);
            System.out.println("I'm waiting here: " + serverSocket.getLocalPort());
        
            socket = serverSocket.accept();
            System.out.println("from " + socket.getInetAddress() + ":" + socket.getPort());
        
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            
            String line="",temp="";
		
	   
		while( 1==1 ){
			if(bufferedReader.ready()){
				temp = bufferedReader.readLine();	
				line = temp;	
			}
			//System.out.println("IN LOOP");
			if(temp != null){
				System.out.println(line);
				String[] command = {"python","straight.py",line};
				Process proc = Runtime.getRuntime().exec(command);
				//System.out.println("BHBH");
			}
		//	else {
		//		String[] command = {"python","straight.py",line};
		//		Process proc = Runtime.getRuntime().exec(command);
		//		temp = bufferedReader.readLine();
		//	}	
		//temp= null;
		//proc.waitFor();
				//BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			//	String line1="";
			//	while((line1=reader.readLine())!= null){
			//		System.out.print(line1 + "\n");
			//		}
			//	proc.waitFor();
		//	}
		//	catch(Exception e){ 
		//		System.out.println(e.toString());
	//		}
           }
        }catch(IOException e){
            System.out.println(e.toString());
        }finally{
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    System.out.print(ex.toString());
                }
            }
            
            if(printStream!=null){
                printStream.close();
            }
            
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.print(ex.toString());
                }
            }
        }
    }
}
