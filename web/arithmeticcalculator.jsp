<%-- 
    Document   : arithmeticcalculator
    Created on : Jan 17, 2020, 11:26:58 AM
    Author     : 810783
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week2 Lab - Arithmetic Calculators</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <div>
            <form>
                First: <input type="text" name="first" value="${first}" /><br>
                Second: <input type="text" name="second" value="${second}" /><br>
                <input type="submit" name="add" value="+"/>
                <input type="submit" name="subtract" value="-"/>
                <input type="submit" name="multiply" value="*"/>
                <input type="submit" name="divide" value="/"/>
                <div name="result">${result}</div><br>
                <div name="arithmetic"><a href="age">Age Calculator</a></div>
            </form>
        </div>
    </body>
</html>
