package common.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.ItemDao;

public class GetImageServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      String item_id = request.getParameter("item_id");

      ItemDao itemDao = new ItemDao();
      byte[] imageByte  = itemDao.getImageByte(Integer.parseInt(item_id));

      InputStream inputStream = new ByteArrayInputStream(imageByte);
      
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
      BufferedImage img = ImageIO.read(bufferedInputStream);
      
      response.setContentType("image/png");
      OutputStream outputStream = response.getOutputStream();
      ImageIO.write(img, "png", outputStream);
      outputStream.flush();
        
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
