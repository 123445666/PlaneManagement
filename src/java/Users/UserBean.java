/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Customer.Customer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author PDBac
 */
@ManagedBean
@ViewScoped
public class UserBean {

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        try {
            userDAO = new UserDAO();
            ls_user_all = userDAO.getData();
            if (!ls_user_all.isEmpty()) {
                selectedRow = ls_user_all.get(0);
                user = selectedRow;
                if (user.getStatus() == 0) {
                    Status = "Disable";
                } else if (user.getStatus() == 1) {
                    Status = "Enable";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String Username;
    private String Password;
    private Integer ID_Customer;
    private String Status;
    private List<Users> ls_user_all;
    private List<Users> ls_user_cusid;
    private Users selectedRow;
    private Users user;
    private UserDAO userDAO;
    private Boolean add = false;
    private Boolean update = false;
    private Boolean isDisable = false;
    private List<Customer> ls_Customer;

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }

    public List<Users> getLs_user_all() {
        return ls_user_all;
    }

    public void setLs_user_all(List<Users> ls_user_all) {
        this.ls_user_all = ls_user_all;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Integer getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Users getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Users selectedRow) {
        this.selectedRow = selectedRow;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void onRowSelect(SelectEvent event) {
        try {
            user = (Users) event.getObject();
            if (user.getStatus() == 0) {
                Status = "Disable";
            } else if (user.getStatus() == 1) {
                Status = "Enable";
            }
            disable = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add() {
        if (validator()) {
            try {
                userDAO = new UserDAO();
                userDAO.insert(user);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Insert Susscess"));
                ls_user_all.add(user);
                selectedRow = user;
                disable = true;
                add = false;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public void update() {
        if (validator()) {
            try {
                userDAO = new UserDAO();
                userDAO.update(user);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Update Susscess"));
                int i = 0;
                for (Users us : ls_user_all) {
                    if (us.getUsername().equals(user.getUsername())) {
                        ls_user_all.set(i, user);
                        disable = true;
                        update = false;
                        break;
                    }
                    i++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete() {
        try {
            userDAO = new UserDAO();
            userDAO.delete(user);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Delete Susscess"));
            int i = 0;
            for (Users us : ls_user_all) {
                if (us.getUsername().equals(user.getUsername())) {
                    ls_user_all.remove(i);
                    if (!ls_user_all.isEmpty()) {
                        user = ls_user_all.get(i - 1);
                        selectedRow = user;

                    }
                    disable = true;
                    break;
                }
                i++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private boolean validator() {
        if (user.getUsername().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "User name must input!"));
            return false;
        } else if (user.getUsername().length() > 50) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "User name can not greater 50 character!"));
            return false;
        } else if (user.getPassword().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password must input!"));
            return false;
        } else if (user.getPassword().length() > 50) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Password can not greater 50 character!"));
            return false;
        }
        return true;
    }

    public void clearValue() {
        disableUname();
        user = new Users();
        isDisable = true;
        add = true;

    }

    public String convertDateToString(java.util.Date date) {
        String t = "";
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        t = mySimpleDateFormat.format(date);
        return t;
    }

    public String showUserStatus(Integer status) {
        String t = "";
        if (status == 1) {
            t = "Enable";
        } else {
            t = "Disable";
        }
        return t;
    }

    public void disableUname() {
        disable = false;
    }
    private Boolean disable = true;

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public void updateclick() {
        isDisable = true;
        update = true;

    }

    public void submit() {
        setUserstatus();
        if (add == true) {
            add();
        } else if (update == true) {
            update();
        }
        isDisable = false;
    }

    public void reSet() {
        isDisable = false;
        update = false;
        add = false;
        user = new Users();
    }

    public void setUserstatus() {
        if (Status.equals("Enable")) {
            user.setStatus(1);
        } else if (Status.equals("Disable")) {
            user.setStatus(0);
        }
    }

    public void getUserstatus() {
        if (user.getStatus() == 0) {
            Status = "Disable";
        } else if (user.getStatus() == 1) {
            Status = "Enable";
        }
    }
}
