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

        String numberStr = request.getParameter("number");
        ArrayList<Integer> primes = new ArrayList<>();

        if (numberStr != null && !numberStr.isEmpty()) {
            try {
                int number = Integer.parseInt(numberStr);

                for (int i = 2; i <= number; i++) {
                    if (isPrime(i)) {
                        primes.add(i);
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("primes", primes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Problem1/primes.jsp");
        dispatcher.forward(request, response);
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
