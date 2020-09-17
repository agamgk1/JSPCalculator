package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(description = "calculator", urlPatterns = { "/Calculator" })
public class CalcServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Tworzenie obiektu kalkulator
		Calculator calculator = (Calculator) session.getAttribute("calc");
		if (calculator == null) {
			calculator = new Calculator();
			session.setAttribute("calc", calculator);
			calculator.setResult("0");
		}

		// Akcje przycisk�w 0-9, C
		if (request.getParameterMap().containsKey("btn")) {
			String btn = request.getParameter("btn"); 

			// Przycisk C
			if (btn.equals("C")) {
				calculator.setResult("0");

				calculator.setValue1(0);
				calculator.setValue2(0);
				session.removeAttribute("action");
				session.removeAttribute("hideComma");
			}

			// Przycisk "."
			else if (btn.equals(".") && !calculator.getResult().contains(".")) {
				calculator.setResult(calculator.getResult() + ".");
				session.setAttribute("hideComma", true);
				calculator.setValue1(Double.parseDouble(calculator.getResult()));

			}
			// Przyciski (0-9)
			else {
				if (calculator.getResult().equals("0") || calculator.getValue1() == 0) {
					calculator.setResult("");
				}
				calculator.setResult(calculator.getResult() + btn);
				calculator.setValue1(Double.parseDouble(calculator.getResult()));
			}
		}

		// Akcje dla przycisk�w (+,-,*,/,%,sqrt,+/-)
		if (request.getParameterMap().containsKey("action")) {
			String action = request.getParameter("action");
			//przeniesienie value1 do value2
			if (session.getAttribute("action") == null) {
				calculator.setValue2(calculator.getValue1());
				calculator.setValue1(0);
				//zmaiana operacji po kolejnym wci�ni�ciu przycisku z dzia�aniem
				session.setAttribute("action", action);
			}

			// Przycisk "+/-"
			if (session.getAttribute("action").equals("+/-")) {
				if (!calculator.getResult().equals("0")) {
					calculator.setValue1(Double.parseDouble(calculator.getResult()));
					calculator.changeSign();
					session.removeAttribute("action");
				}
			}
			if (session.getAttribute("action") != null) {
				session.setAttribute("action", action);
				if (session.getAttribute("hideComma") != null && session.getAttribute("hideComma").equals(true)) {
					session.removeAttribute("hideComma");
				}
			}
		}

		// Akcja przycisku "="
		if (request.getParameterMap().containsKey("equals")) {
			if (session.getAttribute("action") != null) {
				// Jezeli +
				if (session.getAttribute("action").equals("+")) {
					calculator.add();
				}
				// Jezeli -
				if (session.getAttribute("action").equals("-")) {
					calculator.subtract();
				}
				// Jezeli *
				if (session.getAttribute("action").equals("*")) {
					calculator.multiply();
				}
				// Jezeli / + wygaszenie przyciskow i wyswietlenie bledu 
				if (session.getAttribute("action").equals("/")) {
					if (calculator.getValue1() == 0) {
						request.setAttribute("hide", true);
						request.setAttribute("hideComma", true);
						calculator.setResult("ERR");

					} else {
						calculator.divide();
					}
				}
				// Przycisk sqrt + wygaszenie przysiskow i wyswietlenie bledu
				if (session.getAttribute("action").equals("sqrt")) {
					if (Double.parseDouble(calculator.getResult()) < 0) {
						request.setAttribute("hide", true);
						request.setAttribute("hideComma", true);
						calculator.setResult("ERR");

					} else {
						calculator.setValue1(Double.parseDouble(calculator.getResult()));
						calculator.sqrt();
						if (session.getAttribute("hideComma") != null
								&& session.getAttribute("hideComma").equals(true)) {
							session.removeAttribute("hideComma");
						}
					}
				}
				//Przycisk %
				if (session.getAttribute("action").equals("%")) {
					calculator.percent();
				}

			}
			session.removeAttribute("action");
			session.removeAttribute("hideComma");
		}

		// widok kalkulatora
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Calc.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
