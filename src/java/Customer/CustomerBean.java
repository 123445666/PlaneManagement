/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Customer;

import Customer.CustomerDAO;
import Customer.Customer;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author PDBac
 */
@ManagedBean
@ViewScoped
public class CustomerBean{

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
        try
        {
            cusDAO = new CustomerDAO();
            ls_cus = cusDAO.getData();
            if(!ls_cus.isEmpty())
            {
                cus = ls_cus.get(0);
                selectedRow = cus;
                if(cus.getStatus()==1)
                {
                    Status = "Enable";
                } else 
                {
                    Status = "Disable";
                }
            }
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private Customer cus;
    private CustomerDAO cusDAO;
    private Boolean add = false;
    private Boolean update = false;
    private Boolean isDisable = false;
    private Customer selectedRow;
    private List<Customer> ls_cus;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }

    public Customer getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Customer selectedRow) {
        this.selectedRow = selectedRow;
    }

    public List<Customer> getLs_cus() {
        return ls_cus;
    }

    public void setLs_cus(List<Customer> ls_cus) {
        this.ls_cus = ls_cus;
    }
    public void onRowSelect(SelectEvent event) {
        try {
            cus = (Customer) event.getObject();
            if(cus.getStatus()==1)
            {
                Status = "Enable";
            } else 
            {
                Status = "Disable";
            }
            disable = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add() {
        if (validator()) {
            try {
                cusDAO = new CustomerDAO();
                cusDAO.insert(cus);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Thêm thành công!"));
                ls_cus.add(cus);
                selectedRow = cus;
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
                cusDAO = new CustomerDAO();
                cusDAO.update(cus);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Sửa thành công!"));
                int i = 0;
                for (Customer cus1 : ls_cus) {
                    if (cus1.getId()==(cus.getId())) {
                        ls_cus.set(i, cus);
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
            cusDAO = new CustomerDAO();
            cusDAO.delete(cus);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Xóa thành công!"));
            int i = 0;
            for (Customer cus1 : ls_cus) {
                if (cus1.getId()==(cus.getId())) {
                    ls_cus.remove(i);
                    if (!ls_cus.isEmpty()) {
                        cus = ls_cus.get(i - 1);
                        selectedRow = cus;

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
        if (cus.getName().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Tên không được để trống!"));
            return false;
        } else if (cus.getName().length() > 50) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Tên không được quá 50 ký tự!"));
            return false;
        } else if (cus.getIdentityNo().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Số chứng minh thư không được để trống!"));
            return false;
        } else if (cus.getIdentityNo().length() > 12) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Số chứng minh thư không được quá 12 ký tự!"));
            return false;
        } else if (cus.getPhone().length() > 15) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Số điện thoại không được quá 15 ký tự!"));
            return false;
        } else if (cus.getEmail().length() > 50) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Email không được quá 50 ký tự!"));
            return false;
        }
        return true;
    }

    public void clearValue() {
        disableUname();
        cus = new Customer();
        isDisable = true;
        add = true;

    }

    public String convertDateToString(java.util.Date date) {
        String t = "";
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        t = mySimpleDateFormat.format(date);
        return t;
    }

    public String showCustomerStatus(Integer status) {
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
        setCustomertatus();
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
        cus = new Customer();
    }

    public void setCustomertatus() {
        if (Status.equals("Enable")) {
            cus.setStatus(1);
        } else if (Status.equals("Disable")) {
            cus.setStatus(0);
        }
    }

    public void getCustomertatus() {
        if (cus.getStatus() == 0) {
            Status = "Disable";
        } else if (cus.getStatus() == 1) {
            Status = "Enable";
        }
    }
}
