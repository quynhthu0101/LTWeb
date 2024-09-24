package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.UserService;
import vn.iotstar.services.imp.UserServiceImpl;
import vn.iotstar.ultis.Constant;

@WebServlet(urlPatterns = "/updateProfile")
public class ProfileController extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/updateProfile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập mã hóa UTF-8 cho request và response
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// Lấy thông tin từ request
		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String avatar = req.getParameter("image");

		// Tạo một instance của UserService
		UserService service = new UserServiceImpl();
		String alertMsg = "";

		// Kiểm tra username có tồn tại không trước khi cập nhật
		if (!service.checkExistUsername(username)) {
			alertMsg = "Tài khoản không tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.PROFILE).forward(req, resp);
			return;
		}

		// Cập nhật thông tin người dùng
		boolean isSuccess = service.profile(username, fullname, phone, avatar);

		if (isSuccess) {
			// Thông báo cập nhật thành công và chuyển hướng
			alertMsg = "Cập nhật thông tin thành công!";
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home"); // Chuyển về trang profile sau khi cập nhật
		} else {
			// Nếu có lỗi, trả về trang cập nhật với thông báo lỗi
			alertMsg = "Có lỗi xảy ra trong quá trình cập nhật!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.PROFILE).forward(req, resp);
		}
	}

}
