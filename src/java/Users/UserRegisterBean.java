/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Users;

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
public class UserRegisterBean {

    /**
     * Creates a new instance of UserRegisterBean
     */
    public UserRegisterBean() {
        user = new Users();
    }
    private Users user;
    private String Status;
    private UserDAO userDAO;
    private String checkpassword;
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getCheckpassword() {
        return checkpassword;
    }

    public void setCheckpassword(String checkpassword) {
        this.checkpassword = checkpassword;
    }
    public void setUserstatus()
    {
        if(Status.equals("Enable"))
        {
            user.setStatus(1);
        } else if(Status.equals("Disable"))
        {
            user.setStatus(0);
        }
    }
    public void add() {
        if (validator()) {
            try {
                setUserstatus();
                userDAO = new UserDAO();
                userDAO.insert(user);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Thêm thành công"));
                user = new Users();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
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
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password không được đểt trống!"));
            return false;
        } else if(user.getPassword().length()>50)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password không được quá 50 ký tự!"));
            return false;
        } else if(!user.getPassword().equals(checkpassword))
        {
            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password và Repeat Password không giống nhau!"));
            return false;
        }
        return true;
    }
    public void reSet()
    {
        user = new Users();
    }
}
