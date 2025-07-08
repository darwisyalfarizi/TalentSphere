package controllers;


import dao.DetailGajiDao;

import java.util.List;
import models.DetailGaji;

public class DetailGajiController {
    private DetailGajiDao detailGajiDAO;

    private DetailGajiDao detailGajiDao = new DetailGajiDao();

    public List<DetailGaji> getDetailGajiByKdSlip(String kdSlip) {
        return detailGajiDao.getDetailGajiByKdSlip( kdSlip);
    }
    
    public boolean insertDetailGaji(DetailGaji detailGaji) {
        return detailGajiDao.insertDetailGaji(detailGaji);
    }
    public boolean updateDetailGaji(DetailGaji detailGaji) {
        return detailGajiDao.updateDetailGaji(detailGaji);
    }
    public boolean deleteDetailGaji(String kd) {
        return detailGajiDao.deleteDetailGaji(kd);
    }
    
    public String getLastKodeDetailGaji() {
        return detailGajiDao.getLastKodeDetailGaji();
    }

}