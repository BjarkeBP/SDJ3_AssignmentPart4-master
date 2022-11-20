package com.MalasataXD.Application.DAOInterfaces;

import com.MalasataXD.Domain.DTOs.TrayCreationDTO;

public interface ITrayDao {

    String getPartsFromTrayNumber(int trayNumber);
    void addPartToTray(int partNumber, int trayNumber);
    void addTray(TrayCreationDTO dto);

}
