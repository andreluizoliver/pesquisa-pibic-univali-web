/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Andre Luiz
 */
public class StringUtil {

    public static String addZero(int num){

        if(num < 10){
                return '0'+Integer.toString(num);
        } else {
                return Integer.toString(num);
        }
    }
}
