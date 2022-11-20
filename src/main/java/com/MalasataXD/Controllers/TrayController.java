package com.MalasataXD.Controllers;

import com.MalasataXD.Application.LogicInterfaces.ITrayLogic;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.TrayCreationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TrayController {

    private final ITrayLogic TrayLogic;

    public TrayController(ITrayLogic trayLogic) {
        TrayLogic = trayLogic;
    }

    @PostMapping(path = "/tray")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TrayCreationDTO dto)
    {
        TrayLogic.addTray(dto);
    }

    @GetMapping(value = "/tray")
    public String read(@RequestParam(required = false) int trayNumber){
        return TrayLogic.getPartsFromTrayNumber(trayNumber);
    }

    @GetMapping(value = "/trayAddPart")
    public void read(@RequestParam(required = false) int partNumber, int packageNumber){
        TrayLogic.addPartToTray(partNumber, packageNumber);
    }

}
