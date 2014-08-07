/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Plane;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import Plane.Plane;
import Plane.PlaneDAO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author aFun
 */
@ManagedBean
@ViewScoped
public class PlaneBean {

    /**
     * Creates a new instance of PlaneBean
     */
    public PlaneBean() {
        try
        {
            planmbDAO = new PlaneDAO();
            ls_planmb = planmbDAO.getData();
            if(!ls_planmb.isEmpty())
            {
                planmb = ls_planmb.get(0);
                selectedRow = planmb;
                if(planmb.getStatus()==1)
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
    private Plane planmb;
    private PlaneDAO planmbDAO;
    private Boolean add = false;
    private Boolean update = false;
    private Boolean isDisable = false;
    private Plane selectedRow;
    private List<Plane> ls_planmb;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }   

    public Plane getPlanmb() {
        return planmb;
    }

    public void setPlanmb(Plane planmb) {
        this.planmb = planmb;
    }    

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }

    public Plane getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Plane selectedRow) {
        this.selectedRow = selectedRow;
    }

    public List<Plane> getLs_planmb() {
        return ls_planmb;
    }

    public void setLs_planmb(List<Plane> ls_planmb) {
        this.ls_planmb = ls_planmb;
    }
    public void onRowSelect(SelectEvent event) {
        try {
            planmb = (Plane) event.getObject();
            if(planmb.getStatus()==1)
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
                planmbDAO = new PlaneDAO();
                planmbDAO.insert(planmb);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Thêm thành công!"));
                ls_planmb.add(planmb);
                selectedRow = planmb;
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
                planmbDAO = new PlaneDAO();
                planmbDAO.update(planmb);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Sửa thành công!"));
                int i = 0;
                for (Plane planmb1 : ls_planmb) {
                    if (planmb1.getId()==(planmb.getId())) {
                        ls_planmb.set(i, planmb);
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
            planmbDAO = new PlaneDAO();
            planmbDAO.delete(planmb);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Xóa thành công!"));
            int i = 0;
            for (Plane planmb1 : ls_planmb) {
                if (planmb1.getId()==(planmb.getId())) {
                    ls_planmb.remove(i);
                    if (!ls_planmb.isEmpty()) {
                        planmb = ls_planmb.get(i - 1);
                        selectedRow = planmb;

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
        if (planmb.getType().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Kiểu không được để trống!"));
            return false;
        } else if (planmb.getColor().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Màu không được quá 50 ký tự!"));
            return false;
        } else if (planmb.getDescription().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary", "Mô tả không được để trống!"));
            return false;
        } 
        return true;
    }

    public void clearValue() {
        disableUname();
        planmb = new Plane();
        isDisable = true;
        add = true;

    }

    public String convertDateToString(java.util.Date date) {
        String t = "";
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        t = mySimpleDateFormat.format(date);
        return t;
    }

    public String showPlaneStatus(Integer status) {
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
        setPlanetatus();
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
        planmb = new Plane();
    }

    public void setPlanetatus() {
        if (Status.equals("Enable")) {
            planmb.setStatus((short) 1);
        } else if (Status.equals("Disable")) {
            planmb.setStatus((short) 0);
        }
    }

    public void getPlanetatus() {
        if (planmb.getStatus() == 0) {
            Status = "Disable";
        } else if (planmb.getStatus() == 1) {
            Status = "Enable";
        }
    }
    
}
