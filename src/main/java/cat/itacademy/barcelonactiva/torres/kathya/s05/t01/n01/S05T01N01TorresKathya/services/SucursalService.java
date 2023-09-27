package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.services;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.models.SucursalModel;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.repositories.ISucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService {
    @Autowired
    private ISucursalRepository sucursalRepository;

    public SucursalDTO saveSucursal(SucursalDTO sucursalDTO){
        sucursalDTO.determinarTipusSucursal();
        SucursalModel sucursalModel = convertToEntity(sucursalDTO);
        SucursalModel savedSucursal = sucursalRepository.save(sucursalModel);
        return convertToDTO(savedSucursal);


    }

    public List<SucursalDTO> getAllSucursales(){
        List<SucursalModel> sucursalModels = sucursalRepository.findAll();
        return sucursalModels.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SucursalDTO getSucursalById(Long id) {
        SucursalModel sucursalModel = sucursalRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Sucursal not found"));
        return convertToDTO(sucursalModel);
    }
    public void deleteSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }
    public SucursalDTO updateSucursal(Long id, SucursalDTO sucursalDTO) {
        SucursalModel sucursalModelToUpdate = sucursalRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Sucursal not found"));
        sucursalModelToUpdate.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursalModelToUpdate.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalDTO.determinarTipusSucursal();
        sucursalModelToUpdate.setTipoSucursal(sucursalDTO.getTipoSucursal());
        SucursalModel updatedSucursal= sucursalRepository.save(sucursalModelToUpdate);
        return convertToDTO(updatedSucursal);
    }


    private SucursalDTO convertToDTO(SucursalModel savedSucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(savedSucursal.getPk_SucursalID());
        sucursalDTO.setNameSucursal(savedSucursal.getNameSucursal());
        sucursalDTO.setPaisSucursal(savedSucursal.getPaisSucursal());
        sucursalDTO.setTipoSucursal(savedSucursal.getTipoSucursal());
        return sucursalDTO;
    }

    private SucursalModel convertToEntity(SucursalDTO sucursalDTO) {
        SucursalModel sucursalModel = new SucursalModel();
        sucursalModel.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursalModel.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursalModel.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalModel.setTipoSucursal(sucursalDTO.getTipoSucursal());
        return sucursalModel;
    }
}
