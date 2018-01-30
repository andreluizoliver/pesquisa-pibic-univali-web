/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 *
 * @author Andre
 */
public class Login {

    private String usuario;

    private String senha;

    private String openid;

    public Login() {
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    

}
