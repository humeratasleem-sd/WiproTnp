<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Auction</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="auction-box">

    <h1>Welcome to AP Auctions. Please Enter Bid.</h1>

    <% if (request.getAttribute("error") != null) { %>
        <h2 class="error-title">
            Required Data Missing! Enter and Resubmit.
        </h2>
    <% } %>

    <form action="<%=request.getContextPath()%>/AuctionServlet" method="post">

        <div class="row">
            <label>Item ID:</label>
            <input type="text" name="itemId"
                value="<%= request.getAttribute("itemId") == null ? "" : request.getAttribute("itemId") %>">
        </div>

        <% if (request.getAttribute("itemIdError") != null) { %>
            <div class="error">Required field! Item ID.</div>
        <% } %>


        <div class="row">
            <label>Item Name:</label>
            <input type="text" name="itemName"
                value="<%= request.getAttribute("itemName") == null ? "" : request.getAttribute("itemName") %>">
        </div>

        <% if (request.getAttribute("itemNameError") != null) { %>
            <div class="error">Required field! Item Name.</div>
        <% } %>


        <div class="row">
            <label>Your Name:</label>
            <input type="text" name="name"
                value="<%= request.getAttribute("name") == null ? "" : request.getAttribute("name") %>">
        </div>

        <% if (request.getAttribute("nameError") != null) { %>
            <div class="error">Required field! Your Name.</div>
        <% } %>


        <div class="row">
            <label>Your Email Address:</label>
            <input type="text" name="email"
                value="<%= request.getAttribute("email") == null ? "" : request.getAttribute("email") %>">
        </div>

        <% if (request.getAttribute("emailError") != null) { %>
            <div class="error">Required field! Your Email Address.</div>
        <% } %>


        <div class="row">
            <label>Amount Bid:</label>
            <input type="text" name="bid"
                value="<%= request.getAttribute("bid") == null ? "" : request.getAttribute("bid") %>">
        </div>

        <% if (request.getAttribute("bidError") != null) { %>
            <div class="error">Required field! Amount Bid.</div>
        <% } %>


        <div class="check-row">
            <label>Auto-increment bid to match other bidders?</label>

            <input type="checkbox"
                   name="autoIncrement"
                   value="true"
                   <%= "true".equals(request.getAttribute("autoIncrement")) ? "checked" : "" %>>
        </div>

        <input type="submit" value="Submit Bid" class="submit-btn">

    </form>

</div>

</body>
</html>