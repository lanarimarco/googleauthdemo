/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rds_software.googeauthtutorial;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Attiva il flusso di autorizzazione.
 * Questa servlet risponderà al link "Entra con GMail".
 * @author lana
 */
@WebServlet(urlPatterns = {"/", "/glogon/auth"})
public class GLogonAuthServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
    //Se la validazione gmail ha successo
    String callbackUrl = baseUrl + "/glogon/callback";
    //Se la validazione gmail non ha successo
    String fallbackUrl = baseUrl + "/glogon/fallback";
    resp.sendRedirect("https://aspweb.rds-software.com/rds-google-apis/oauth2"
            + "?onSuccessUri=" + URLEncoder.encode(callbackUrl, "UTF-8")
            + "&onErrorUri=" + URLEncoder.encode(fallbackUrl, "UTF-8"));
  }
  
  
  
}
