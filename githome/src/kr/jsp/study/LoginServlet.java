package kr.jsp.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("called get " + this.getServletName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("called post  " + this.getServletName());
        // 1. 파라미터 한글 변환.
        request.setCharacterEncoding("UTF-8");
        // 2. 파라미터 가져오기 - id, password
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println("id:" + id +", password:" + password);
        
        // 3. db에서 아이디, 비밀번호 맞는지 검사.
        int result = 0;
        result = 1;    // 맞을 때.
//        result = 0;    // 틀릴 때.
        
        // 4. 맞으면 "로그인하셨습니다." 후, 사용자 홈 화면으로 이동.
        //  틀리면 "아이디, 비밀번호가 일치하지 않습니다" 출력 후, loginForm으로 이동.
        String viewUrl;
        if (result > 0) {
            viewUrl = "loginSuccess.jsp";
            response.sendRedirect(viewUrl);
            return;
        } else {
            request.setAttribute("errorMsg", "아이디, 비밀번호가 일치하지 않습니다.");
            viewUrl = "login";
            response.sendRedirect(viewUrl);
            return;
        }
        
//        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
//        rd.forward(request, response);
	}

}