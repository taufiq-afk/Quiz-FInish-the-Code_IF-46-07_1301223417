/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Controller;

/**
 *
 * @author helmy
 */
import com.mycompany.latihanwebmvc.Database.DBUtil; //import class DBUtil
import com.mycompany.latihanwebmvc.Model.User; //import class User dari Package Model
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");

        User user = new User(username, password, fullName);
        try (Connection conn = DBUtil.getConnection()) {
            String query = "INSERT INTO users (username, password, full_name) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getFullName());
                stmt.executeUpdate();
            }
            response.sendRedirect("userList.jsp"); // Redirect ke halaman list setelah berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
