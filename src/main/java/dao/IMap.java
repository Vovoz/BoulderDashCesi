package dao;

import java.util.ArrayList;
import  java.util.Optional;

public interface IMap {

    Optional<Object> getMap(final String nameMap);

    void addMap(final RawMap rawMap);

    ArrayList<String> getMapListNames();

    void removeMap(final Stirng nameMap);

    void addObjectType(final objectType);

    void removeObjectType(fianl ObjectType objectType);

}
