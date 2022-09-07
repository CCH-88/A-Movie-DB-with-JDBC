package com.example.webapimoviedb.mappers;
import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.models.franchise.FranchiseDTO;
import com.example.webapimoviedb.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;




@Mapper(componentModel = "spring")
public interface FranchiseMapper {


    FranchiseDTO franchiseToFranchiseDto(Franchise franchise);

    @Mapping(target = "movies", ignore = true )
    Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);
}
