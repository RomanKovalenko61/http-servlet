package com.example.servlet;

import com.example.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getServletContext().getAttributeNames();
        var session = req.getSession();
        var user = (UserDTO) session.getAttribute(USER);
        if (user == null) {
            user = UserDTO.builder()
                    .id(25L)
                    .mail("test@gmail.com")
                    .build();
            session.setAttribute(USER, user);
        }
    }
}
