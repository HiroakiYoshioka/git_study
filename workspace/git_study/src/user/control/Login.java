package user.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.arnx.jsonic.JSON;
import user.bean.UserAuth;
import user.bean.UserInfo;
import employ.OutLog;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String REQUEST_STRING = "requestJs";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/Login.jsp");
		HttpSession session = request.getSession(true);
		session.invalidate();
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String parameter = request.getParameter(REQUEST_STRING);
			UserInfo uInfo = JSON.decode(parameter, UserInfo.class);

			UserAuth uAuth = new UserAuth();

			HttpSession session = null;
			RequestDispatcher rd = null;

			// 認証
			if (uAuth.execute(uInfo) == true) {
				// 認証OK
				// セッションを新規作成
				session = request.getSession(true);

				// ユーザ情報を設定する
				session.setAttribute("userName", uInfo.getUserName());

				rd = request.getRequestDispatcher("/MenuList.jsp");
				OutLog.outLogDmp("ログインユーザ :" + uInfo.getUserName()
						+ ", ログインパスワード :" + uInfo.getUserPass());

			} else {
				request.setAttribute("errMsg",
						"ユーザ、またはパスワードが異なっています。やりなおしてください。");

				rd = request.getRequestDispatcher("/Login.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg",
					"エラーが発生しました。申し訳ありませんがもう一度最初からお願いします。");
			HttpSession session = request.getSession(true);
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
	}

	public boolean checkSession(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			return true;
		} else {
			return false;
		}
	}

}
