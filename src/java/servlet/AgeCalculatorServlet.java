/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 810783
 */
public class AgeCalculatorServlet extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("AgeCalculatorServlet is running.");
        
        String resultString = "";
        
        if(request.getParameter("age") == null)
        {
            resultString = "";
        }
        else if(request.getParameter("age").equals(""))
        {
            resultString = "!You must give your current age!";
        }
        else
        {
            try
            {
                String ageString = request.getParameter("age");
                int age = Integer.parseInt(ageString);

                if(age < 0)
                {
                   request.setAttribute("ageInput", age);
                   resultString = "!Invalid input. Age must be an integer equal to or bigger than 0!";
                }
                else
                {
                    request.setAttribute("ageInput", age);
                    resultString = "Your age next birthday will be " + (age + 1);
                }

                System.out.println("Age Entered : " + age);
            }
            catch(NumberFormatException e)
            {
                e.printStackTrace();
                request.setAttribute("ageInput", request.getParameter("age"));
                resultString = "!Invalid input. Age must be an integer equal to or bigger than 0!";
            }
            
        }
        
        request.setAttribute("result", resultString);
            
        //request.setAttribute("firstname", age);

        getServletContext().getRequestDispatcher("/agecalculator.jsp").forward(request, response);
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
