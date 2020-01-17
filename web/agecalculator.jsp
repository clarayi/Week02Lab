<%-- 
    Document   : agecalculator
    Created on : Jan 17, 2020, 11:25:02 AM
    Author     : 810783
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week2 Lab - Age Calculators</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <div>
            <form>
                Enter your age: <input type="number" name="age"/><br>
                <input type="submit" name="nextButton" value="Age next birthday"/><br>
                <div name="must">${result}</div><br>
                <div name="arithmetic"><a href="arithmetic">Arithmetic Calculator</a></div>
            </form>
        </div>
    </body>
</html>
