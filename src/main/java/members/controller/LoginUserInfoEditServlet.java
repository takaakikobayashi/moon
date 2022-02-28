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

public class LoginUserInfoEditServlet extends HttpServlet {
		
		@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int member_id = Integer.parseInt(request.getParameter("member_id"));
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String kana_first_name = request.getParameter("kana_first_name");
			String kana_last_name = request.getParameter("kana_last_name");
			String mail = request.getParameter("mail");
			String phone_number = request.getParameter("phone_number");
			String postal_code = request.getParameter("postal_code");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String address3 = request.getParameter("address3");
			
			LoginUserBean loginUserBean = new LoginUserBean();
			loginUserBean.setMemberId(member_id);
			loginUserBean.setFirstName(first_name);
			loginUserBean.setLastName(last_name);
			loginUserBean.setKanaFirstName(kana_first_name);
			loginUserBean.setKanaLastName(kana_last_name);
			loginUserBean.setMail(mail);
			loginUserBean.setPhoneNumber(phone_number);
			loginUserBean.setPostalCode(postal_code);
			loginUserBean.setAddress1(address1);
			loginUserBean.setAddress2(address2);
			loginUserBean.setAddress3(address3);
			
			MemberDao memberdao = new MemberDao();
	        memberdao.updateUserInfo(loginUserBean.getMemberId(), loginUserBean.getFirstName(), loginUserBean.getLastName(), loginUserBean.getKanaFirstName(), loginUserBean.getKanaLastName(), loginUserBean.getMail(), loginUserBean.getPhoneNumber(), loginUserBean.getPostalCode(), loginUserBean.getAddress1(), loginUserBean.getAddress2(), loginUserBean.getAddress3());
			
			HttpSession session = request.getSession();
	        session.setAttribute("member", loginUserBean);
	        
	        RequestDispatcher rd = request.getRequestDispatcher("mypage.jsp");
	        rd.forward(request, response);
	        
		}
		
		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

}
