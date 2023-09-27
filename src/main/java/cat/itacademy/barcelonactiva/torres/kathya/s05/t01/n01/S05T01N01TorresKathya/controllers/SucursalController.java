package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.controllers;


import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> addSucursal(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO savedSucursal = sucursalService.saveSucursal(sucursalDTO);
        return new ResponseEntity<>(savedSucursal, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO updatedSucursal = sucursalService.updateSucursal(id,sucursalDTO);
        return new ResponseEntity<>(updatedSucursal, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getOneSucursal(@PathVariable Long id) {
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
        return new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursales() {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursales();
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }
}
