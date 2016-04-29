/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

/**
 *
 * @author Bryan
 */
public class Clima {
    

    public static String getHTML(String urlToRead) throws Exception {
	StringBuilder result = new StringBuilder();
	URL url = new URL(urlToRead);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String line;
	while ((line = rd.readLine()) != null) {
	   result.append(line);
	}
	rd.close();
	return result.toString(); 
}
    
  
    public static void main(String[] args) throws Exception {
        	// TODO Auto-generated method stub
              Scanner lea = new Scanner(System.in);
                
                 int op; 
        
                  
                  
             do{  
            System.out.println("----------\nMENU\n-----------");
            System.out.println("1- Ver todos los datos clima");
            System.out.println("2- Ver longuitud y Latitud");
            System.out.println("3- Temperatura minima y maxima");
            System.out.println("4- Humedad y Velocidad");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
             System.out.println("------------------------------------");
            System.out.println("Ingrase la ciudad que decea ver clima");
            System.out.println("-------------------------------------");
            String cuida  = lea.next();
            System.out.println("--------------------------------------");
           
          
           
            
            switch(op){
                case 1:
          	try {
                         
                  
                         String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q=" + cuida + ",uk&appid=edf6a6fe68ae2a1259efacb437914a55");
                        JSONObject obj = new JSONObject(respuesta);
			double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                        double lon = obj.getJSONObject("coord").getDouble("lon");
                        double lat = obj.getJSONObject("coord").getDouble("lat");
                        double pressure = obj.getJSONObject("main").getDouble("pressure");
                        double humidity = obj.getJSONObject("main").getDouble("humidity");
                        double temp_min = obj.getJSONObject("main").getDouble("temp_min")- 273.15;
                        double temp_max = obj.getJSONObject("main").getDouble("temp_max")-273.15 ;
                        double speed = obj.getJSONObject("wind").getDouble("speed");
                        System.out.println("Los datos optenidos de " + cuida);
                        System.out.println("***************************************1");
			System.out.println("La temperatura es: "+temp+" Celsius");
                        System.out.println("longuitud  es: "+lon);
                        System.out.println("Latitud es: "+lat);
                        System.out.println("La presurisacion  es: "+pressure);
                        System.out.println("La humedad es: "+humidity);
                        System.out.println("La temperatura minima es: "+temp_min+" Celsius");
                        System.out.println("La temperatura maxima es: "+temp_max+" Celsius");
                        System.out.println("La velocidad es: "+speed);
                
                
                } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
                Clima.main(null);
                    break;
                case 2:
                   try {
                         
                  
		        String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q=" + cuida + ",uk&appid=edf6a6fe68ae2a1259efacb437914a55");
                        JSONObject obj = new JSONObject(respuesta);
                        double lon = obj.getJSONObject("coord").getDouble("lon");
                        double lat = obj.getJSONObject("coord").getDouble("lat");
                        System.out.println("Los datos optenidos de"+ cuida+"son:");
                        System.out.print("longuitud  es: "+lon);
                        System.out.print("Latitud es: "+lat);
                       
                
                
                } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
                   Clima.main(null);
                    break;
                case 3:
           try {
                         
                  
			String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q=" + cuida + ",uk&appid=edf6a6fe68ae2a1259efacb437914a55");
                        JSONObject obj = new JSONObject(respuesta);
                        double temp_min = obj.getJSONObject("main").getDouble("temp_min")- 273.15;
                        double temp_max = obj.getJSONObject("main").getDouble("temp_max")-273.15 ;
                        System.out.println("Los datos optenidos de"+ cuida+"son:");
                        System.out.print("La temperatura minima es: "+temp_min+" Celsius");
                        System.out.print("La temperatura maxima es: "+temp_max+" Celsius");
                    
                
                
                } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
                 Clima.main(null);
                    break;
                case 4:
               try {
                         
                  
			String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q=" + cuida + ",uk&appid=edf6a6fe68ae2a1259efacb437914a55");
                        JSONObject obj = new JSONObject(respuesta);
                        double humidity = obj.getJSONObject("main").getDouble("humidity");
                        double speed = obj.getJSONObject("wind").getDouble("speed");
                        System.out.println("Los datos optenidos de"+ cuida+"son:");
                        System.out.print("La humedad es: "+humidity);
                        System.out.print("La velocidad es: "+speed);
                
                
                } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
               Clima.main(null);
               break;
              
                    
            }
             }while(op!=8);
    
                  
	
    }

    
}
