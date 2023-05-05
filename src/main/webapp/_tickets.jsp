<%@ page import="com.example.service.TicketService" %>
<%@ page import="com.example.dto.TicketDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jsp is a servlet</title>
</head>
<body>
<h1>Купленные билеты</h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDTO> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDTO ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
</ul>
</body>
</html>

<%!
    public void jspInit() {
    }
%>