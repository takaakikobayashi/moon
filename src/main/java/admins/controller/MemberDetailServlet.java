package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.model.LoginUserBean;
import members.model.MemberDao;

public class MemberDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberDetailServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String member_id = request.getParameter("member_id");

        MemberDao memberDao = new MemberDao();
        LoginUserBean memberBean  = memberDao.getUserDetail(Integer.parseInt(member_id));

        if (memberBean != null) {
            request.setAttribute("memberBean", memberBean);

            RequestDispatcher rd = request.getRequestDispatcher("memberDetail.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
