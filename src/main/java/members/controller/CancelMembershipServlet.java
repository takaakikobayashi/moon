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

public class CancelMembershipServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CancelMembershipServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
    	MemberDao memberDao = new MemberDao();
    	HttpSession session = request.getSession();
        LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member");
        int member_id = loginUser.getMemberId();
        memberDao.cancelMembership(member_id);
        session.invalidate();
    	
    	RequestDispatcher rd = request.getRequestDispatcher("afterCancelMembership.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
