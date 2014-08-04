/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Users;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PDBac
 */
@ManagedBean
@ViewScoped
public class UsersLoginBean {

    /**
     * Creates a new instance of UsersLoginBean
     */
    public UsersLoginBean() {
        try{
        user = new Users();
        userDAO = new UserDAO();
        ls_user = userDAO.getData();
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private Users user;
    private List<Users> ls_user;
    private UserDAO userDAO;
    private Boolean checklogin;
    
    private boolean validator() {
        if(user.getUsername().equals(""))
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "User name không được để trống!"));
            return false;
        } else if(user.getUsername().length()>50)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "User name không được quá 50 ký tự!"));
            return false;
        } else if(user.getPassword().equals(""))
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password không được để trống!"));
            return false;
        } else if(user.getPassword().length()>50)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password không được quá 50 ký tự!"));
            return false;
        } 
        return true;
    }
    public void login()
    {
        if(validator())
        {
            if(!checkuserlogin())
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "User name hoặc Password không đúng!"));
            } else 
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Đăng nhập thành công!"));
            }
        }
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Users> getLs_user() {
        return ls_user;
    }

    public void setLs_user(List<Users> ls_user) {
        this.ls_user = ls_user;
    }

    private boolean checkuserlogin() {
        for (Users us : ls_user) {
                if(us.getUsername().equals(user.getUsername()))
                {
                    if(us.getPassword().equals(user.getPassword()))
                    {
                        checklogin = true;
                        break;
                    } else 
                    {
                        checklogin = false;
                        break;
                    }
                } 
            }
        return checklogin;
    }
    
}
