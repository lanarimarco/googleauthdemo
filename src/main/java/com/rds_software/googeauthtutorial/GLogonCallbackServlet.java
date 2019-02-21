/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rds_software.googeauthtutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Contiene logica su autenticazione gmail ok.
 * Esempio dall'indirizzo gmail (vedi doGet) cerca la userid (esempio tabella di relazione userid indirizzogmail)
 * ed a quel punto inserisce in HttpSession tutte le info necessarie
 * @author lana
 */
@WebServlet(urlPatterns = "/glogon/callback")
public class GLogonCallbackServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //Url che mi mette a disposizione l'indirizzo gmail
    //L'indirizzo gmail non viene passato direttamente a /glogon/callback
    //per ragioni di sicurezza
    URL authAccessTokenURL = new URL(req.getParameter("authAccessTokenURL"));
    BufferedReader reader = null;
    try{
      reader = new BufferedReader(new InputStreamReader(authAccessTokenURL.openStream()));
      String gmailAddress = reader.readLine();
      resp.getWriter().println("Il tuo indirizzo gmail: " + gmailAddress);
    }
    finally{
      if (reader != null){
        reader.close();
      }
    }
    
     
  }
  
  
  
  
}
