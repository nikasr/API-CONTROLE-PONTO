package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData createTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.saveTipoData(tipoData);
    }

    @GetMapping
    public List<TipoData> getTipoDataList(){
        return tipoDataService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData>  getTipoDataByID(@PathVariable("id") Long idTipoData) throws Exception {
        return  ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long idTipoData) throws Exception {
        try {
            tipoDataService.deleteTipoData(idTipoData);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();
    }

}
