<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Prime Numbers</title>
</head>
<body>

<h2>Prime Numbers</h2>

<table border="1">

    <tr>
        <th>Prime Number</th>
    </tr>

<%
    ArrayList<Integer> primes =
        (ArrayList<Integer>) request.getAttribute("primes");

    for(Integer prime : primes) {
%>

    <tr>
        <td><%= prime %></td>
    </tr>

<%
    }
%>

</table>

</body>
</html>