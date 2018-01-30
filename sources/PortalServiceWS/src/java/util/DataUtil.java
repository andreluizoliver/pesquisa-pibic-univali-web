/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import bean.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Andre Luiz
 */
public class DataUtil {

    public static String dateToStringDB(Date data){

        if(data != null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);

                String dia = StringUtil.addZero(cal.get(Calendar.DAY_OF_MONTH));
                String mes = StringUtil.addZero(cal.get(Calendar.MONTH) + 1);
                int ano = cal.get(Calendar.YEAR);
                String hora = StringUtil.addZero(cal.get(Calendar.HOUR_OF_DAY));
                String min = StringUtil.addZero(cal.get(Calendar.MINUTE));

                return ano+"-"+mes+"-"+dia+" "+hora+":"+min;

        } else {
                return null;
        }
    }

    public static String dateToString(Date data){

        if(data != null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);

                String dia = StringUtil.addZero(cal.get(Calendar.DAY_OF_MONTH));
                String mes = StringUtil.addZero(cal.get(Calendar.MONTH) + 1);
                int ano = cal.get(Calendar.YEAR);
                String hora = StringUtil.addZero(cal.get(Calendar.HOUR_OF_DAY));
                String min = StringUtil.addZero(cal.get(Calendar.MINUTE));

                return dia+"/"+mes+"/"+ano+" "+hora+":"+min;

        } else {
                return null;
        }
    }

    public static Date stringToDate(String txtData){

        if(txtData != null){
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date data;
                data = new Date(format.parse(txtData).getTime());
                return data;
            } catch (ParseException ex) {
                Logger.getLogger(DataUtil.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else {
                return null;
        }
    }

    /**
     * Needed to create XMLGregorianCalendar instances
     */
    private static DatatypeFactory df = null;
    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                "Exception while obtaining DatatypeFactory instance", dce);
        }
    }

    /**
     * Converts a java.util.Date into an instance of XMLGregorianCalendar
     *
     * @param date Instance of java.util.Date or a null reference
     * @return XMLGregorianCalendar instance whose value is based upon the
     *  value in the date parameter. If the date parameter is null then
     *  this method will simply return null.
     */
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        }
    }

    /**
     * Converts an XMLGregorianCalendar to an instance of java.util.Date
     *
     * @param xgc Instance of XMLGregorianCalendar or a null reference
     * @return java.util.Date instance whose value is based upon the
     *  value in the xgc parameter. If the xgc parameter is null then
     *  this method will simply return null.
     */
    public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public static String DataToStringView(Data data){

        if(data != null){
            return data.getDia()+"/"+data.getMes()+"/2011";
        } else {
            return null;
        }
    }

    public static void main(String args[]){
        Data dtData = new Data();
        dtData.setDia("01");
        dtData.setMes("12");
        String dtString = DataToStringView(dtData);
        System.out.println(dtString);
    }



}
