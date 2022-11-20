package com.MalasataXD.Application.LogicInterfaces;

import com.MalasataXD.Domain.DTOs.TrayCreationDTO;

public interface ITrayLogic {

    String getPartsFromTrayNumber(int trayNumber);
    void addPartToTray(int partNumber, int trayNumber);
    void addTray(TrayCreationDTO dto);
}
