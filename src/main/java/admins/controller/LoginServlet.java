package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admins.model.AdminDao;
import admins.model.LoginAdminBean;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

public LoginServlet() {
    super();
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String mail = request.getParameter("mail");
    String password = request.getParameter("password");

    LoginAdminBean loginAdminBean = new LoginAdminBean();
    loginAdminBean.setMail(mail);
    loginAdminBean.setPassword(password);

    AdminDao adminDao = new AdminDao();
    LoginAdminBean loginUserBean = adminDao.selectAdmin(loginAdminBean);

    if (loginUserBean != null) {
        HttpSession session = request.getSession();
        session.setAttribute("admin", loginUserBean);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    } else {
    	request.setAttribute("login_error","ログインIDまたはパスワードに誤りがあります");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
    
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
