package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.controllers;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sucursal")
public class SucursalViewController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/list")
    public String listSucursales(Model model) {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursales();
        model.addAttribute("sucursales", sucursales);
        return "sucursal/list";
    }
    @GetMapping("/edit/{id}")
    public String editSucursal(@PathVariable Long id, Model model) {
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
        model.addAttribute("sucursal", sucursalDTO);
        return "sucursal/edit";
    }

    @PostMapping("/update")
    public String updateSucursal(SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO.getPk_SucursalID(), sucursalDTO);
        return "redirect:/sucursal/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursal/list";
    }

    @GetMapping("/add")
    public String addSucursal(Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "sucursal/add";
    }

   @PostMapping({"/save", "/add"})
   public String saveSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
       // Llamar al método para determinar el tipo de sucursal
       sucursalDTO.determinarTipusSucursal();

       // Guardar la sucursal
       sucursalService.saveSucursal(sucursalDTO);
       return "redirect:/sucursal/list";
   }



}

