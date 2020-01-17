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
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        
        System.out.println("ArithmeticCalculatorServlet is running.");
        
        String resultString = "";
        System.out.println(request.getPart("first"));
        
        if(request.getParameter("first") != null && request.getParameter("second") != null)
        {
            try
            {
                int firstNum = Integer.parseInt(request.getParameter("first"));
                int secondNum = Integer.parseInt(request.getParameter("second"));
                int resultNum = 0;

                if(request.getParameter("add") != null)
                {
                    request.setAttribute("first", firstNum);
                    request.setAttribute("second", secondNum);
                    resultNum = firstNum + secondNum;
                }
                else if(request.getParameter("subtract") != null)
                {
                    request.setAttribute("first", firstNum);
                    request.setAttribute("second", secondNum);
                    resultNum = firstNum - secondNum;
                }
                else if(request.getParameter("multiply") != null)
                {
                    request.setAttribute("first", firstNum);
                    request.setAttribute("second", secondNum);
                    resultNum = firstNum * secondNum;
                }
                else if(request.getParameter("divide") != null)
                {
                    request.setAttribute("first", firstNum);
                    request.setAttribute("second", secondNum);
                    resultNum = firstNum / secondNum;
                }
                
                resultString = "Result: " + resultNum;
            }
            catch(ArithmeticException e)
            {
                e.printStackTrace();
                resultString = "Result: invalid.";
            }
            catch(NumberFormatException e)
            {
                e.printStackTrace();
                resultString = "Result: invalid.";
            }
        }
        else if(request.getParameter("first") == null && request.getParameter("second") == null)
        {
            resultString = "Result: --";
        }
        else
        {
            resultString = "Result: invalid.";
        }
        
        System.out.println("resultString");
        request.setAttribute("result", resultString);
        
        getServletContext().getRequestDispatcher("/arithmeticcalculator.jsp").forward(request, response);
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
