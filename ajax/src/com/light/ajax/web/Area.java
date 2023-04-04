package com.light.ajax.web;

import java.util.Objects;

public class Area {
    private String code;
    private String name;

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Area() {
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(code, area.code) && Objects.equals(name, area.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
