/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import br.rnp.sctfed.service.util.DataUtil;

/**
 *
 * @author Andre Luiz
 */
public class Teste2 {

    public static void main(String arg[]){

        String aux = "12/04/2010";
        aux = DataUtil.stringTostringDB(aux);
        System.out.println(aux);      

    }

}
