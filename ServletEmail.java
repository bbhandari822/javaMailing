import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by Binod Bhandari on 8/12/17.
 */

//http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html

@WebServlet("/ServletEmail")
public class ServletEmail extends javax.servlet.http.HttpServlet {

        private String hostName;
        private String portNumber;
        private String userName;
        private String password;


    //load the configuration after initializing initalize() method.
    public void initialize() {
        ServletContext con = getServletContext();
        hostName = con.getInitParameter("hostName");
        portNumber = con.getInitParameter("portNumber");
        userName = con.getInitParameter("userName");
        password = con.getInitParameter("password");

    }

    //support http post requests
    //call by server to allow a servlet to handle a post request by the help of service method
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        //returns value either as string or null if parameter does not exists.
        String email_Recipient = request.getParameter("Email Receipent");
        String email_subject = request.getParameter("Email Subject");
        String email_Content = request.getParameter("Email Content");

        String messageResult = "";

        try {
            MainEmailSend.main(hostName,portNumber,userName,password);
            messageResult = "Email Sent!";
        } catch (Exception ex){
            ex.printStackTrace();
            messageResult = "Sorry! Problem arises while sending email!";
        }finally {
            //store the message result in this request
            request.setAttribute("Message", messageResult);
            //getServletContext() get the servlet context to which the servlet request was dispatched.
            // getRequestDispatcher returns a request dispatcher object that as a wrapper for the
            //resource located at the given path.
            getServletContext().getRequestDispatcher("/result.jsp").forward(request,response);
        }
    }
    //supports http get requests
    //call by server to allow a servlet to handle a get request by the help of service method.
    //This application just deal with sending email so for this case this we will not be using doGet method(Service)
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

}
