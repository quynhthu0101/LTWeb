package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;
import vn.iotstar.services.UserService;
import vn.iotstar.services.imp.UserServiceImpl;


@WebServlet(urlPatterns = {"/profile"})
public class ViewProfileController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());


        // Sử dụng UserService để lấy thông tin người dùng từ cơ sở dữ liệu
        UserService service = new UserServiceImpl();
        User user = service.findByUserName(u.getUserName()); 

        if (user != null) {
        	req.setAttribute("usename", u.getFullName());
        	 req.setAttribute("phone", u.getPhone()); 
        	 String avatarFileName = u.getAvatar();
        	 String avatarPath = req.getContextPath() + "/uploads/avatars/" + avatarFileName;
        	 req.setAttribute("avatar", avatarPath);
           
            req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
	}

    }
	
}
