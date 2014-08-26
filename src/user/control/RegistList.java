package user.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;
import user.parts.RegInfDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistList
 */
public class RegistList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegInfDAO rDAO = null;
		try {
			rDAO = new RegInfDAO();
			// åªç›ìoò^Ç≥ÇÍÇƒÇ¢ÇÈìoò^é“ÇéÊìæ
			ArrayList<RegistrantInfo> regInfo = rDAO.getReglist();

			HttpSession session = request.getSession(false);
			session.setAttribute("regList", regInfo);

			RequestDispatcher rd = request.getRequestDispatcher("/RegistList.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "ÉGÉâÅ[Ç™î≠ê∂ÇµÇ‹ÇµÇΩÅBê\ÇµñÛÇ†ÇËÇ‹ÇπÇÒÇ™Ç‡Ç§àÍìxç≈èâÇ©ÇÁÇ®äËÇ¢ÇµÇ‹Ç∑ÅB");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
