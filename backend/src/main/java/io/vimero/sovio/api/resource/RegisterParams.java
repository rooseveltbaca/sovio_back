package io.vimero.sovio.api.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class RegisterParams {

    private TypeList documents;
    private TypeList genders;
    private Collection<RegionResource> regions;
    private TypeList countries;
    private TypeList levels;
    private TypeList disabilities;

}
