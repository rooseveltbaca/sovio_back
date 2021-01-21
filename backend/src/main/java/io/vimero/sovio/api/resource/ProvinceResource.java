package io.vimero.sovio.api.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceResource extends TypeResource{

    private TypeList districts;

    public ProvinceResource(Integer id, String name) {
        this(id, name, new TypeList());
    }

    public ProvinceResource(Integer id, String name, TypeList districts) {
        super(id, name);
        this.districts = districts;
    }

}
