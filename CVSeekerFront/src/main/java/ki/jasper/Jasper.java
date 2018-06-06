/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.jasper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import ki.domen.Profil;
/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintLine;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.base.JRBasePrintLine;
import net.sf.jasperreports.engine.base.JRBasePrintPage;
import net.sf.jasperreports.engine.base.JRBasePrintText;
import net.sf.jasperreports.engine.util.JRSaver;
*/
/**
 *
 * @author SOLUNAC
 */
public class Jasper {

    /*public void fill(List<Profil> lp) throws JRException {
        JasperPrint jprint = getJasperPrint(lp);
        JRSaver.saveObject(jprint, "izvestaj.jprint");
    }

    private JasperPrint getJasperPrint(List<Profil> lp) {
        JasperPrint jasperPrint = new JasperPrint();
        jasperPrint.setName("Izvestaj");
        jasperPrint.setPageHeight(800);
        jasperPrint.setPageWidth(600);

        JRPrintPage page = new JRBasePrintPage();
        JRPrintLine line = new JRBasePrintLine(jasperPrint.getDefaultStyleProvider());
        line.setX(40);
        line.setY(50);
        line.setWidth(500);
        line.setHeight(5);
        page.addElement(line);

        int y = 150;
        for (Profil p : lp) {
            JRPrintText text = new JRBasePrintText(jasperPrint.getDefaultStyleProvider());
            text.setX(40);
            text.setY(y);
            text.setWidth(500);
            text.setHeight(50);
            text.setTextHeight(50);
            text.setText(p.getId()+ "\t\t\t" + p.getDatum()+ "\t\t\t" + p.getOpis());
            page.addElement(text);
            y = y + 50;
        }
        jasperPrint.addPage(page);
        return jasperPrint;
    }*/
    
    //PRINT PDF ON FILESYSTEM CALLING SERVLET
   /* protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

    {

    try

    {


    //File jasper source

    String fileName="C:/reports/report2.jasper";

    //File pdf  destination

    String destFileNamePdf="C:/reports/report2.pdf";


    //Passing parameters to the jasper file.

    Map parameters = new HashMap();

    //parameters.put("paramName", new String(param1));//pass predefined (with iReport) params


    //Preparing the file to compile 

    //getConnection() returns your db connection

    JasperPrint jasperPrint=JasperFillManager.fillReport(fileName, parameters, getConnection());


    //Creation PDF file

    JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf); 


    response.getWriter().println("Report created from an existing file jasper");

    }

    catch (JRException e)

    {

    e.printStackTrace();

    } 

    catch (ClassNotFoundException e)

    {

    e.printStackTrace();

    } catch (SQLException e) 

    {

    e.printStackTrace();

    }

    }

    //PRINT PDF ON BROWSER CALLING SERVLET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
      {
        ServletOutputStream servletOutputStream = response.getOutputStream();

       String reportFileName ="C:/RGI/workspaceReports/EsempiReports/reports/reportParam.jasper";
       File reportFile = new File(reportFileName);

       String idAnagRicevuto= request.getParameter("comboId");
        Long idAnagParam=Long.parseLong(idAnagRicevuto);

       Map parameters = new HashMap();
      /* Long param = xxx
       parameters.put("paramName", new Long(param));*/

/*
        byte[] bytes = null;

        try
        {
          bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,getConnection());

          response.setContentType("application/pdf");
          response.setContentLength(bytes.length);

          servletOutputStream.write(bytes, 0, bytes.length);
          servletOutputStream.flush();
          servletOutputStream.close();
        }
        catch (JRException e)
        {
          // display stack trace in the browser
          StringWriter stringWriter = new StringWriter();
          PrintWriter printWriter = new PrintWriter(stringWriter);
          e.printStackTrace(printWriter);
          response.setContentType("text/plain");
          response.getOutputStream().print(stringWriter.toString());
        } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
      }*/

}
