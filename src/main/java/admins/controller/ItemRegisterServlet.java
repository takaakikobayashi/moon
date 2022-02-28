package admins.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import common.model.ItemBean;
import common.model.ItemDao;

@MultipartConfig(location = "/tmp")
public class ItemRegisterServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Part part = request.getPart("image");
		InputStream inputStream = part.getInputStream();
		
		String name = request.getParameter("name");
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		String introduction = request.getParameter("introduction");
		byte[] byteImage = convertInputStreamToByteArray(inputStream);
		int price = Integer.parseInt(request.getParameter("price"));
		String ingredient = request.getParameter("ingredient");
		String allergy = request.getParameter("allergy");
		
		ItemBean itemBean = new ItemBean();
		itemBean.setName(name);
		itemBean.setCategoryId(category_id);
		itemBean.setIntroduction(introduction);
		itemBean.setImage(byteImage);
		itemBean.setPrice(price);
		itemBean.setIngredient(ingredient);
		itemBean.setAllergy(allergy);
		
		HttpSession session = request.getSession();
        session.setAttribute("itemBean", itemBean);
        
        ItemDao itemdao = new ItemDao();
        itemdao.uploadItem(itemBean.getName(), itemBean.getCategoryId(), itemBean.getIntroduction(), itemBean.getImage(), itemBean.getPrice(), itemBean.getIngredient(), itemBean.getAllergy());
        
        RequestDispatcher rd = request.getRequestDispatcher("itemDetail.jsp");
        rd.forward(request, response);
	}
	
	public byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16777215];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

}
