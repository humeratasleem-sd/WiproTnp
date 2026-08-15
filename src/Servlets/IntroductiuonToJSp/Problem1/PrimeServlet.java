package Servlets.IntroductionToJSP.Problem1;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrimeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("number"));

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < number; i++) {

            boolean prime = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes.add(i);
            }
        }

        request.setAttribute("primes", primes);

        RequestDispatcher rd =
                request.getRequestDispatcher("/Problem1/primes.jsp");

        rd.forward(request, response);
    }
}