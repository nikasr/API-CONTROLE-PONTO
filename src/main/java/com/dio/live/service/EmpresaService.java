package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa saveEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return   empresaRepository.findAll();
    }

    public Optional<Empresa> getById(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa updateEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);

    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
