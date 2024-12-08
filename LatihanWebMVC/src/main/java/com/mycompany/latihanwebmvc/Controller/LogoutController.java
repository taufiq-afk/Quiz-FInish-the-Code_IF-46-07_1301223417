/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Controller;

/**
 *
 * @author helmy
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Menghapus session pengguna
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // Menghapus session yang aktif
        }
        response.sendRedirect("login.jsp");  // Arahkan ke halaman login setelah logout
    }
}
