package com.example.servlet;

import com.example.dto.UserDTO;
import com.example.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.SESSIONS)
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getServletContext().getAttributeNames();
        var session = req.getSession();
        var user = (UserDTO) session.getAttribute(USER);
        if (user == null) {
            user = UserDTO.builder()
                    .id(25)
                    .email("test@gmail.com")
                    .build();
            session.setAttribute(USER, user);
        }
    }
}
