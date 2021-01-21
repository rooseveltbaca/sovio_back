package io.vimero.sovio.api.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class RegionResource extends TypeResource {

    private Collection<ProvinceResource> provinces;

    public RegionResource(String id, String name) {
        this(Integer.valueOf(id), name, new ArrayList<>());
    }

    public RegionResource(Integer id, String name, Collection<ProvinceResource> provinces) {
        super(id, name);
        this.provinces = provinces;
    }

}
