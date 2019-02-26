/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hayba
 */
@WebServlet(name = "Composto", urlPatterns = {"/composto.html"})
public class CompostoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Composto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juros Composto</h1>");
            out.println("<form>");
            out.println("<table>");
            out.println("<tr><th>Valor</th>");
            out.println("<th>Número de parcelas</th>");
            out.println("<th>Taxa de juros</th></tr>");
            out.println("<tr><td><input type='text', name='valor'/></td>");
            out.println("<td><input type='text', name='parcela'/></td>");
            out.println("<td><input type='text', name='juros'/></td>");
            out.println("<td><input type='submit', name='calculo', value='='/></td></tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</hr>");
            out.println("<h5><a href='index.html'>Voltar - Home</a></h5>");
            if(request.getParameter("calculo")!=null){
                try{
                    double valor = Double.parseDouble(request.getParameter("valor"));
                    double parcela = Double.parseDouble(request.getParameter("parcela"));
                    double juros = (Double.parseDouble(request.getParameter("juros"))/100);                
                    double calculo = 0;
                    double soma = 0;
                    
                    out.println("<table>");
                    for (double i=1;i<=parcela;i++){
                        
                        out.println("<tr>");
                        out.println("<th>Parcela " + i + "</th>");
                        calculo = valor *(Math.pow(1+juros,i));
                        out.println("<td>Valor: " + calculo + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<h1>Total: "+ soma +"</h1>");
                    out.println("<h5><a href='composto.html'>Voltar - Juros composto</a></h5>");
                    out.println("<h5><a href='index.html'>Voltar - Home</a></h5>");
                }catch(Exception ex){
                    out.println("<h1>Erro no processo</h1>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
