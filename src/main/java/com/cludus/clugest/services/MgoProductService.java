package com.cludus.clugest.services;

import com.cludus.clugest.dtos.MgoProductDto;
import com.cludus.clugest.model.MgoProduct;
import com.cludus.clugest.repositories.MgoProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@Profile("mongodb")
public class MgoProductService {
    @Autowired
    private MgoProductRepository repo;

    public List<MgoProductDto> findAll() {
        return repo.findAll().stream().map(this::mapProduct).toList();
    }

    public Optional<MgoProductDto> findProductByName(@NonNull String name) {
        return repo.findProductByName(name)
            .map(this::mapProduct);
    }

    public void create(@NonNull MgoProductDto dto) {
        var product = MgoProduct.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
        repo.save(product);
    }

    private MgoProductDto mapProduct(@NonNull MgoProduct mgoProduct) {
        return MgoProductDto.builder()
            .name(mgoProduct.getName())
            .description(mgoProduct.getDescription())
            .build();
    }
}
