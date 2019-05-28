package dao;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import  java.util.Optional;

public class IMap {

    Optional<RawMap> getMap(final String nameMap);

    void addMap(final RawMap rawMap);

    ArrayList<String> getMapListNames();

    void removeMap(final Stirng nameMap);

    void addObjectType(final objectType);

    void removeObjectType(fianl ObjectType objectType);

}
