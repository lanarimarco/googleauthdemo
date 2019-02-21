/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rds_software.googeauthtutorial;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Contiene logica su autenticazione gmail fallita.
 * Ad esempio potrebbe fare redirect sulla form di validazione standard.
 * @author lana
 */
@WebServlet(urlPatterns = "/glogon/fallback")
public class GLogonFallbackServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().println("Errore di validazione");
  }
  
  
  
}
