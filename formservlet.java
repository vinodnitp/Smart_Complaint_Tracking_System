import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class formservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String c_name,c_fname,c_landline,c_mobile,c_email,c_post_address,c_district,c_ps,c_typecrime,c_subject,c_incident_detail,c_incident_date,c_incident_time,c_incident_place,c_incident_district,c_incident_ps;
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection con=null;
        PreparedStatement pstat;
        c_name=request.getParameter("c_name");
        c_fname=request.getParameter("c_fname");
        c_landline=request.getParameter("c_landline");
        c_mobile=request.getParameter("c_mobile");
        c_email=request.getParameter("c_email");
        c_post_address=request.getParameter("c_post_address");
        c_district=request.getParameter("c_district");
        c_ps=request.getParameter("c_ps");
        c_typecrime=request.getParameter("c_typecrime");
        c_subject=request.getParameter("c_subject");
        c_incident_detail=request.getParameter("c_incident_detail");
        c_incident_date=request.getParameter("c_incident_date");
        c_incident_time=request.getParameter("c_incident_time");
        c_incident_place=request.getParameter("c_incident_place");
        c_incident_district=request.getParameter("c_incident_district");
        c_incident_ps=request.getParameter("c_incident_ps");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
            pstat=con.prepareStatement("insert into fir values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstat.setString(1, c_name);
            pstat.setString(2, c_fname);
            pstat.setString(3, c_landline);
            pstat.setString(4, c_mobile);
            pstat.setString(5, c_email);
            pstat.setString(6, c_post_address);
            pstat.setString(7, c_district);
            
            pstat.setString(8, c_ps);
            pstat.setString(9, c_typecrime);
            pstat.setString(10, c_subject);
            pstat.setString(11, c_incident_detail);
            pstat.setString(12, c_incident_date);
            pstat.setString(13, c_incident_time);
            pstat.setString(14, c_incident_place);
            pstat.setString(15, c_incident_district);
            pstat.setString(16, c_incident_ps);
            pstat.executeUpdate();
            pstat.close();
            con.close();
            response.sendRedirect("fir.jsp");
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
        
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
