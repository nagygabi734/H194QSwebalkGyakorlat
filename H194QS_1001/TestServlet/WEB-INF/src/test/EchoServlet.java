package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class EchoServlet extends HttpServlet {
	 
	   @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      // Set the response message's MIME type
	      response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>Belépett</h2>");
	 
	         // Retrieve the value of the query parameter "username" (from text field)
	         String nev = request.getParameter("nev");
	         // Get null if the parameter is missing from query string.
	         // Get empty string or string of white spaces if user did not fill in
	         if (nev == null
	               || (nev = htmlFilter(nev.trim())).length() == 0) {
	            out.println("<p>Név: Hiányzik</p>");
	         } else {
	            out.println("<p>Név: " + nev + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "password" (from password field)
	         String jelszo = request.getParameter("jelszo");
	         if (jelszo == null
	               || (jelszo = htmlFilter(jelszo.trim())).length() == 0) {
	            out.println("<p>Jelszó: Hiányzik</p>");
	         } else {
	            out.println("<p>Jelszó: " + jelszo + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "gender" (from radio button)
	         String nem = request.getParameter("nem");
	         // Get null if the parameter is missing from query string.
	         if (nem == null) {
	            out.println("<p>Nem: Hiányzik</p>");
	         } else if (nem.equals("m")) {
	            out.println("<p>Nem: férfi</p>");
	         } else {
	            out.println("<p>Nem: nõ</p>");
	         }
	 
	         // Retrieve the value of the query parameter "age" (from pull-down menu)
	         String kor = request.getParameter("kor");
	         if (kor == null) {
	            out.println("<p>Kor: Hiányzik</p>");
	         } else if (kor.equals("1")) {
	            out.println("<p>Kor: &lt; 1 éves</p>");
	         } else if (kor.equals("99")) {
	            out.println("<p>Kor: 1-99 éves</p>");
	         } else {
	            out.println("<p>Kor: &gt; 99 éves</p>");
	         }
	 
	         // Retrieve the value of the query parameter "language" (from checkboxes).
	         // Multiple entries possible.
	         // Use getParameterValues() which returns an array of String.
	         String[] nyelvek = request.getParameterValues("nyelv");
	         // Get null if the parameter is missing from query string.
	         if (nyelvek == null || nyelvek.length == 0) {
	            out.println("<p>Nyelvek: Nincs</p>");
	         } else {
	            out.println("<p>Nyelvek: ");
	            for (String nyelv : nyelvek) {
	               if (nyelv.equals("c")) {
	                  out.println("C/C++ ");
	               } else if (nyelv.equals("cs")) {
	                  out.println("C# ");
	               } else if (nyelv.equals("java")) {
	                  out.println("Java ");
	               }
	            }
	            out.println("</p>");
	         }
	 
	         // Retrieve the value of the query parameter "instruction" (from text area)
	         String utasitas = request.getParameter("utasitas");
	         // Get null if the parameter is missing from query string.
	         if (utasitas == null
	              || (utasitas = htmlFilter(utasitas.trim())).length() == 0
	              || utasitas.equals("Utasítás:")) {
	            out.println("<p>Utasítás: Nincs</p>");
	         } else {
	            out.println("<p>Utasítás: " + utasitas + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "secret" (from hidden field)
	         String titkositas = request.getParameter("titkositas");
	         out.println("<p>Titkosítás: " + titkositas + "</p>");
	 
	         // Get all the names of request parameters
	         Enumeration names = request.getParameterNames();
	         out.println("<p>Lekért paraméter nevei: ");
	         if (names.hasMoreElements()) {
	            out.print(htmlFilter(names.nextElement().toString()));
	         }
	         do {
	            out.print(", " + htmlFilter(names.nextElement().toString()));
	         } while (names.hasMoreElements());
	         out.println(".</p>");
	 
	         // Hyperlink "BACK" to input page
	         out.println("<a href='form_input.html'>Viszza</a>");
	 
	         out.println("</body></html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
	   }
	 
	   // Redirect POST request to GET request.
	   @Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      request.setCharacterEncoding("UTF-8");
		  doGet(request, response);
	   }
	
	   // Filter the string for special HTML characters to prevent
	   // command injection attack
	   private static String htmlFilter(String message) {
	      if (message == null) return null;
	      int len = message.length();
	      StringBuffer result = new StringBuffer(len + 20);
	      char aChar;
	 
	      for (int i = 0; i < len; ++i) {
	         aChar = message.charAt(i);
	         switch (aChar) {
	             case '<': result.append("&lt;"); break;
	             case '>': result.append("&gt;"); break;
	             case '&': result.append("&amp;"); break;
	             case '"': result.append("&quot;"); break;
	             default: result.append(aChar);
	         }
	      }
	      return (result.toString());
	   }
	}