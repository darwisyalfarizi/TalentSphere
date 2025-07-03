package controllers;

import dao.AbsensiDao;
import dao.DetailGajiDao;
import models.DetailGaji;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.DetailGaji;
import models.SlipGaji;

public class DetailGajiController {
    private DetailGajiDao detailGajiDAO;

    private DetailGajiDao detailGajiDao = new DetailGajiDao();

    public List<DetailGaji> getAllDetailGaji() {
        return detailGajiDao.getAllDetailGaji();
    }
    public List<DetailGaji> searchDetailGajiBySlip(String keyword) {
        return detailGajiDao.searchDetailGajiBySlip(keyword);
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

}