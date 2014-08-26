package user.control;

import java.io.IOException;
import java.io.PrintWriter;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class RegistList
 */
public class RegistDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String REQUEST_STRING = "selectNum";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String parameter = request.getParameter(REQUEST_STRING);
	
			// åªç›ìoò^Ç≥ÇÍÇƒÇ¢ÇÈìoò^é“ÇéÊìæ
			RegistrantInfo[] regInfo = ReadRegistInfo.getReglist();
			RegistrantInfo result = new RegistrantInfo(); 

			for (int i=0; i <regInfo.length; i++) {
				
				if (parameter.equals(regInfo[i].getrId())) {
					result.setrId(regInfo[i].getrId());
					result.setrName(regInfo[i].getrName());
					result.setrAge(regInfo[i].getrAge());					
				}
			}

			String tempString = JSON.encode(result);
			String outString = "{\"responseMessage\" : " + tempString+ "}";
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(outString);
	
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
