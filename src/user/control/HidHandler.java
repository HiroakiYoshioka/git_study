package user.control;

import java.io.IOException;

import user.bean.RegistrantInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RegistList
 */
public class HidHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final static String PROC_MOD = "0";
	final static String PROC_DEL = "1";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HidHandler() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8"); 
			
			String pageName = "";

			if (request.getParameter("mod") != null) {
				pageName = "/ModRegist.jsp";
			} else if (request.getParameter("del") != null) {
				pageName = "/DelRegist.jsp";
			}
			RegistrantInfo outInfo = new RegistrantInfo();
			
			outInfo.setrId(request.getParameter("id"));
			outInfo.setrName(request.getParameter("name"));
			outInfo.setrAge(request.getParameter("age"));

			HttpSession session = request.getSession(false);
			session.setAttribute("targetInfo", outInfo);

			RequestDispatcher rd = request.getRequestDispatcher(pageName);
			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "エラーが発生しました。申し訳ありませんがもう一度最初からお願いします。");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
	}

}
