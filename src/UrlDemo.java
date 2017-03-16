
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kabir
 */
public class UrlDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/JavaWebApp/index.html");
            URLConnection com = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(com.getInputStream()));
            String data = null;
            while((data = br.readLine()) != null){
                System.out.println(data);
            }
            
            System.out.println("WRITING TO SERVER");
            System.out.println("=======================================");
            com.setDoOutput(true);
            PrintWriter p = new PrintWriter(com.getOutputStream());
            p.println("<h1>This is a message from me");
            p.flush();
            p.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
