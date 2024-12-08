/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Controller;

/**
 *
 * @author helmy
 */
import com.mycompany.latihanwebmvc.Model.User; //import class User dari Package Model
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Ambil parameter dari view form login
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // create objek User dari inputan form login
            User user = new User(username, password, null);

            // panggil method Validasi login dari objek User
            if (user.isValidUser()) {
                // Jika login berhasil, arahkan ke halaman welcome.jsp
                HttpSession session = request.getSession();
                session.setAttribute("user", user);  // Menyimpan objek User dalam session
                response.sendRedirect("welcome.jsp");
            } else {
                // Jika login gagal, set error message dan tampilkan lagi login.jsp
                request.setAttribute("errorMessage", "username atau password anda salah!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            // Jika ada error, tampilkan error page
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Terjadi kesalahan dalam memproses request");
        }
    }

}
