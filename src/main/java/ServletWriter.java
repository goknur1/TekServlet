import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServletWriter implements Servlet {

    List<Person> personList = new ArrayList<>();
    Person person;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

       String kaydet = servletRequest.getParameter("tip");
       String listele= servletRequest.getParameter("tip");

       String ad= servletRequest.getParameter("ad");
       String soyAd= servletRequest.getParameter("soyad");

       servletRequest.setCharacterEncoding("UTF-8");

       PrintWriter pw = servletResponse.getWriter();

       servletResponse.setCharacterEncoding("UTF-8");

       person = new Person(ad,soyAd);


       if(kaydet.equals("kaydet")){
           personList.add(person);
       }
       else if (listele.equals("listele")){
           for (Person person:personList)
           {
               System.out.print(person.getAd() + person.getSoyAd());

               pw.write("ad : "+ person.getAd() + "soyad: " + person.getSoyAd() +"\n");
           }

       }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
