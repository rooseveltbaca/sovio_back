package io.vimero.sovio.service;

import io.vimero.sovio.api.resource.*;
import io.vimero.sovio.entity.GeoCode;
import io.vimero.sovio.entity.Parameter;
import io.vimero.sovio.repository.GeoCodeRepository;
import io.vimero.sovio.repository.ParameterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConfigurationService {

    private final ParameterRepository parameterRepository;
    private final GeoCodeRepository geoCodeRepository;

    public RegisterParams getRegisterParams() {
        RegisterParams params = new RegisterParams();

        params.setDocuments(getList(4));
        params.setGenders(getList(2));
        params.setLevels(getList(3));
        params.setRegions(getRegions());

        return params;
    }

    private TypeList getList(Integer id) {
        List<Parameter> list = parameterRepository.findByTable(id);
        return new TypeList(list.stream().map(param ->
                new TypeResource(param.getId(), param.getValue()))
                .collect(Collectors.toList()));
    }

    private Collection<RegionResource> getRegions() {
        List<GeoCode> list = geoCodeRepository.findAll();
        Map<String, RegionResource> regions = new HashMap<>();
        Map<String, Map<String, ProvinceResource>> provinces = new HashMap<>();
        for (GeoCode row : list) {
            RegionResource region = regions.getOrDefault(row.getDepartmentId(), new RegionResource(row.getDepartmentId(), row.getDepartment()));
            regions.put(row.getDepartmentId(), region);
            if (row.getProvinceId() != null) {
                Map<String, ProvinceResource> province = provinces.getOrDefault(row.getDepartmentId(), new HashMap<>());
                provinces.put(row.getDepartmentId(), province);
                ProvinceResource provinceResource = province.getOrDefault(row.getProvince(), new ProvinceResource(row.getId(), row.getProvince()));
                province.put(row.getProvince(), provinceResource);
                if (row.getDistrictId() != null) {
                    provinceResource.getDistricts().add(new TypeResource(row.getId(), row.getDistrict()));
                }
            }
        }

        for (Map.Entry<String, RegionResource> entry : regions.entrySet() ) {
            RegionResource regionResource = entry.getValue();
            regionResource.setProvinces(provinces.get(entry.getKey()).values());
        }

        return regions.values();
    }

}
