package at.fh.valuvi.resifo.models;

import java.util.ArrayList;
import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseModel;

public class Country extends BaseModel {

    public String code;
    public String name;

    public Country(String code) {
        this.code = code;
    }

    @Override
    public String getTableName() {
        return "Country";
    }

    public Country find(int id) {
        return (Country) super.find(id);
    }

    public Country find(HashMap<String, Object> attributes) {
        return (Country) super.find(attributes);
    }

    public Country[] findAll(HashMap<String, Object> attributes) {
        Object[] models = super.findAll(attributes);
        ArrayList<Country> newModels = new ArrayList<>();
        for (Object model: models) { newModels.add((Country) model); }

        return newModels.toArray(new Country[] {});
    }

    public String toString() {
        return code;
    }

}
