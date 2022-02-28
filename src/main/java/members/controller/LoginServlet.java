package members.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.LoginUserBean;
import members.model.MemberDao;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

public LoginServlet() {
    super();
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String mail = request.getParameter("mail");
    String password = request.getParameter("password");

    LoginUserBean loginUserBean = new LoginUserBean();
    loginUserBean.setMail(mail);
    loginUserBean.setPassword(password);

    MemberDao memberDao = new MemberDao();
    LoginUserBean loginMemberBean = memberDao.selectUser(loginUserBean);

    if (loginMemberBean != null && loginMemberBean.getIsActive()) {
        HttpSession session = request.getSession();
        session.setAttribute("member", loginMemberBean);

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
