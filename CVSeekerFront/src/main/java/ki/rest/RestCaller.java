/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import jsf.mb.MBPrijava;

/**
 *
 * @author SOLUNAC
 */
public class RestCaller {
    
    String adresaResursa = "http://localhost:8080";
    String operacija = "";
    boolean trebaToken = false;
    
    private static RestCaller instance;
    
    public static RestCaller getInstance() 
    {
        if (instance == null) {
            instance = new RestCaller();
        }
        return instance;
    }
    
    private void resolveAdresaResursa(String roe, Integer i)
    {
        trebaToken = false;
        adresaResursa = "http://localhost:8080";
        switch (roe) {
            case "PROFIL_BRISANJE":  adresaResursa = adresaResursa + "/profil/delete/" ;
                                     operacija = RestHttpOperationEnum.DELETE.toString();
                                     trebaToken = true;
                     break;
            case "PROFIL_SVI": adresaResursa = adresaResursa + "/profil/all"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;
            case "PROFIL_ID":   adresaResursa = adresaResursa + "/profil/get/";
                                operacija = RestHttpOperationEnum.GET.toString();
                                trebaToken = true;
                     break;
            case "PROFIL_KORISNIK":   adresaResursa = adresaResursa + "/profil/getK/";
                                      operacija = RestHttpOperationEnum.GET.toString();
                                      trebaToken = true;
                     break;
            case "PROFIL_UNOS":   adresaResursa = adresaResursa + "/profil/save";
                                  operacija = RestHttpOperationEnum.POST.toString();
                                  trebaToken = true;
                     break;
            case "KORISNIK_PRIJAVA":   adresaResursa = adresaResursa + "/login";
                                       operacija = RestHttpOperationEnum.POST.toString();
                     break;
             case "KORISNIK_VRATI":   adresaResursa = adresaResursa + "/findByUsername";
                                       operacija = RestHttpOperationEnum.POST.toString();
                                       trebaToken = true;
                     break;         
            case "KORISNIK_REGISTRACIJA":   adresaResursa = adresaResursa + "/register";
                                            operacija = RestHttpOperationEnum.POST.toString();
                     break; 
            case "KORISNIK_RESETLOZINKE":   adresaResursa = adresaResursa + "/passwordReset";
                                            operacija = RestHttpOperationEnum.POST.toString();
                     break;  
            case "TAJNOPITANJE_VRATIRANDOM":   adresaResursa = adresaResursa + "/sq/RandomOne";
                                            operacija = RestHttpOperationEnum.GET.toString();
                     break; 
            case "TAJNOPITANJE_VRATI_KORISNIK":   adresaResursa = adresaResursa + "/sq/getUserSq";
                                            operacija = RestHttpOperationEnum.POST.toString();
                     break;  
            case "VRATI_SVE_KORISNIKE": adresaResursa = adresaResursa + "/all"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;
            case "VRATI_SIFARNIKE": adresaResursa = adresaResursa + "/sifarnik/all"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;
            case "OBRISI_SIFARNIK": adresaResursa = adresaResursa + "/sifarnik/delete/"; 
                               operacija = RestHttpOperationEnum.DELETE.toString();
                               trebaToken = true;
                     break;
            case "SACUVAJ_SIFARNIK": adresaResursa = adresaResursa + "/sifarnik/save"; 
                               operacija = RestHttpOperationEnum.POST.toString();
                               trebaToken = true;
                     break;
            case "VRATI_NOTIFIKACIJE": adresaResursa = adresaResursa + "/notify/getK/"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;  
            case "VRATI_SVE_NOTIFIKACIJE": adresaResursa = adresaResursa + "/notify/all/"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;
            case "SACUVAJ_NOTIFIKACIJU": adresaResursa = adresaResursa + "/notify/save"; 
                               operacija = RestHttpOperationEnum.POST.toString();
                               trebaToken = true;
                     break; 
            case "VALIDIRAJ_NOTIFIKACIJU": adresaResursa = adresaResursa + "/notify/validate"; 
                               operacija = RestHttpOperationEnum.POST.toString();
                               trebaToken = true;
                     break; 
            case "PRIKAZI_JASPER": adresaResursa = adresaResursa + "/profil/jasper/"; 
                               operacija = RestHttpOperationEnum.GET.toString();
                               trebaToken = true;
                     break;                        
            }
        
        if (i != 0)
        {
           adresaResursa += Integer.toString(i); 
        }
    }
    
    
   public String pozoviRestServis(String json, String roe, Integer id) throws Exception
    {      
        resolveAdresaResursa(roe, id);
        
        String url = adresaResursa;
        
        URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	con.setRequestMethod(operacija);
        
        if (trebaToken) //iscupati ekser tokena
        {   
            con.setRequestProperty("NN-TOKEN", MBPrijava.token);
        }
        
        if ((operacija.equals(RestHttpOperationEnum.POST.toString())) && (json.length() > 0))
        {
            con.setRequestProperty("Content-Type", "application/json");
            
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
        }
             
        int responseCode = con.getResponseCode();
        //String responseMessage = con.getResponseMessage();
        
        /*if (responseCode != 200)
        {
             return "Greška!";
        }
        */
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
        
	while ((inputLine = in.readLine()) != null) 
        {
            response.append(inputLine);
	}
	in.close();
        
        return response.toString();
    }      
   
}
