package com.MalasataXD.Application.LogicImpl;

import com.MalasataXD.Application.DAOInterfaces.IPackageDao;
import com.MalasataXD.Application.DAOInterfaces.ITrayDao;
import com.MalasataXD.Application.LogicInterfaces.ITrayLogic;
import com.MalasataXD.Domain.DTOs.TrayCreationDTO;

public class TrayLogicImpl implements ITrayLogic {

    private ITrayDao TrayDao;

    public TrayLogicImpl(ITrayDao TrayDao) {
        this.TrayDao = TrayDao;
    }

    @Override
    public String getPartsFromTrayNumber(int trayNumber) {
        return TrayDao.getPartsFromTrayNumber(trayNumber);
    }

    @Override
    public void addPartToTray(int partNumber, int trayNumber) {
        TrayDao.addPartToTray(partNumber, trayNumber);
    }

    @Override
    public void addTray(TrayCreationDTO dto) {
        TrayDao.addTray(dto);
    }
}
