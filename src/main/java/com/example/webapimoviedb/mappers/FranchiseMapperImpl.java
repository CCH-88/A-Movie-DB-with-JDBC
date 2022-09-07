package com.example.webapimoviedb.mappers;

import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.models.franchise.FranchiseDTO;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public class FranchiseMapperImpl implements FranchiseMapper{

    @Override
    public FranchiseDTO franchiseToFranchiseDto(Franchise franchise) {
        if (franchise == null){
            return null;
        }

        FranchiseDTO franchiseDTO = new FranchiseDTO();
        franchiseDTO.setId(franchise.getId());
        franchiseDTO.setName(franchise.getName());
        return franchiseDTO;
    }

    @Mapping(target = "movies", ignore = true)
    @Override
    public Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO) {
        if(franchiseDTO == null){
            return null;
        }

        Franchise franchise = new Franchise();
        franchise.setId(franchiseDTO.getId());
        franchise.setName(franchiseDTO.getName());
        return franchise;
    }
}
