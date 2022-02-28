package members.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.LoginUserBean;

public class UserAuth extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Boolean logincheck = null;

    public UserAuth() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        LoginUserBean loginuser = (LoginUserBean) session.getAttribute("member");

        if(loginuser != null) {
            this.logincheck =  true;
        } else {
            this.logincheck = false;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
