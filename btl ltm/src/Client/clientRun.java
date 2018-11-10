/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONObject;
import org.w3c.dom.Document;

/**
 *
 * @author ahihi
 */
public class clientRun implements Serializable {

    public static void main(String[] args) throws IOException {
        client c = new client();
        c.connect("localhost", 80);
        System.out.println("Conneted!");
        c.getCapitalCity();
        c.requestGetWeather(c.getListCapital().get(0).getKey().toString());
        c.receiveWeatherJson();
        c.receiveWeatherXml();
        System.out.println(c.getListCapital().size());
        System.out.println(c.getJsonReceived());
//        System.out.println(c.getXmlReceived());
        try {
            TransformerFactory tranformer = TransformerFactory.newInstance();
            Transformer xform = tranformer.newTransformer();
            xform.transform(new DOMSource(c.getXmlReceived()), new StreamResult(System.out));
        } catch (Exception ex) {
            Logger.getLogger(clientRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done!");
        String quit = "";
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Are you want to quit (quit/no) : ");
            quit = s.nextLine();
            if(quit.equalsIgnoreCase("quit")){
                c.closeConnection();
                break;
            }else {
                System.out.println("Enter your city name: ");
                String str = s.nextLine();
                System.out.println(str);
                c.requestGetWeather(str);
                c.receiveWeatherJson();
                c.receiveWeatherXml();
            }
        }

        
        
        
        
        
        //        try {
//            Socket s = new Socket("localhost", 80);
//            System.out.println("connet to server: " + s.getInetAddress().getHostAddress());
//
//            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
//            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
//            ArrayList<Pair<String, String>> listCapital = new ArrayList<>();
//            System.out.println(listCapital.size());
//            listCapital = (ArrayList<Pair<String, String>>) ois.readObject();
//            System.out.println(listCapital.size());
//            String st = listCapital.get(4).getKey();
//
//            Object o = new Object();
//            o = st;
//            oos.writeObject(o);
//            oos.flush();
//
//            Object jsob = ois.readObject();
//            JSONObject j = new JSONObject(jsob.toString());
//            System.out.println(j.toString());
//            Document doc = (Document) ois.readObject();
//
//            TransformerFactory tranformer = TransformerFactory.newInstance();
//            Transformer xform = tranformer.newTransformer();
//            xform.transform(new DOMSource(doc), new StreamResult(System.out));
//            System.out.println("Done!");
//
////            ois.close();
////            oos.close();
//        } catch (Exception ex) {
//            Logger.getLogger(clientRun.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
