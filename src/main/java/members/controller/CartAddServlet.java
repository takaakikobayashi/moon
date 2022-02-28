package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.model.ItemBean;
import common.model.ItemDao;
import members.model.CartBean;
import members.model.CartDao;

public class CartAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartAddServlet() {
        super();
    }

    @SuppressWarnings({ "unused", "unchecked" })
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String item_id = request.getParameter("item_id");
        String amount = request.getParameter("amount");
        
        ItemDao itemDao = new ItemDao();
        ArrayList<CartBean> cart_item_list = new ArrayList<CartBean>();
        ItemBean itemBean  = itemDao.selectItem(Integer.parseInt(item_id));
        
        CartDao cartDao = new CartDao();
        
        int product_id = itemBean.getProductId();
        int cart_amount = Integer.parseInt(amount);
        

        CartBean cart_item_bean = cartDao.getCartItem(product_id);
        cart_item_bean.setAmount(Integer.parseInt(amount));
        ArrayList<CartBean> cart_item = new ArrayList<CartBean>();
        cart_item.add(cart_item_bean);

        HttpSession session = request.getSession();
        ArrayList<Integer> product_id_list = new ArrayList<>();
        if (session.getAttribute("cart_item") != null) {
            ArrayList<CartBean> cartList = (ArrayList<CartBean>) session.getAttribute("cart_item");
            for (CartBean bean : cartList) {
	            int cart_product_id = bean.getProductId();
	            product_id_list.add(cart_product_id);
            }
            session.setAttribute("cart_item", getCartContents(cartList, cart_item_bean, product_id_list));
            
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
            
        } else if (cart_item != null){
            session.setAttribute("cart_item", cart_item);
            
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
            
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
    public ArrayList<CartBean> getCartContents(ArrayList<CartBean> cartList, CartBean cart_item_bean, ArrayList<Integer> product_id_list) {
        
        if (product_id_list.contains(cart_item_bean.getProductId()) ){
            
            ArrayList<CartBean> now_cart_item = cartList;
            
            for ( CartBean list : cartList ) {
                if ( list.getProductId() == cart_item_bean.getProductId()) {
                    int now_amount = list.getAmount() ;
                    int add_amount = cart_item_bean.getAmount();
                    list.setAmount(now_amount + add_amount);
                }
            }
            
            return now_cart_item;
            
        } else {
            
            ArrayList<CartBean> now_cart_item = cartList;
            now_cart_item.add(cart_item_bean);
            return now_cart_item;
            
        }
        
    }
}