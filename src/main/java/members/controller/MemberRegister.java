package members.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.LoginUserBean;
import members.model.RegisterDao;


public class MemberRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberRegister() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String kana_first_name = request.getParameter("kana_first_name");
        String kana_last_name = request.getParameter("kana_last_name");
        String postal_code = request.getParameter("postal_code");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address3 = request.getParameter("address3");
        String mail = request.getParameter("mail");
        String phone_number = request.getParameter("phone_number");
        String password = request.getParameter("password");
        boolean is_active = true;
        String newsletter = request.getParameter("newsletter");
        Timestamp created_at = new Timestamp(System.currentTimeMillis());
        Timestamp updated_at = new Timestamp(System.currentTimeMillis());

        LoginUserBean loginMemberBean = new LoginUserBean();
        loginMemberBean.setFirstName(first_name);
        loginMemberBean.setLastName(last_name);
        loginMemberBean.setKanaFirstName(kana_first_name);
        loginMemberBean.setKanaLastName(kana_last_name);
        loginMemberBean.setPostalCode(postal_code);
        loginMemberBean.setAddress1(address1);
        loginMemberBean.setAddress2(address2);
        loginMemberBean.setAddress3(address3);
        loginMemberBean.setMail(mail);
        loginMemberBean.setPhoneNumber(phone_number);
        loginMemberBean.setPassword(password);
        loginMemberBean.setIsActive(is_active);
        loginMemberBean.setNewsletter(Boolean.valueOf(newsletter));
        loginMemberBean.setCreatedAt(created_at);
        loginMemberBean.setUpdatedAt(updated_at);

        RegisterDao registerdao = new RegisterDao();
        if (registerdao.registerDao(loginMemberBean)) {
        

	        HttpSession session = request.getSession();
	        session.setAttribute("member", loginMemberBean);
	
	        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        rd.forward(request, response);
        
        } else {
        	HttpSession session = request.getSession();
        	session.setAttribute("signup_error", "新規登録に失敗しました");

            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
