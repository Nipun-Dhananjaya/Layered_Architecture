package dao.custom;

import dao.SuperDAO;
import model.CustomDTO;

import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    ArrayList<CustomDTO> searchCust();
}
