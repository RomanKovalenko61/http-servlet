package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setContentType("application/json");

//        Files.readAllBytes(Path.of("resources", "first.json"));
        try (var outputStream = resp.getOutputStream();
             var stream =
                     DownloadServlet.class.getClassLoader().getResourceAsStream("first.json")) {
            outputStream.write(stream.readAllBytes());
        }
    }
}
