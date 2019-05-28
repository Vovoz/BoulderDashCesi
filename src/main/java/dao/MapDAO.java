package dao;

import com.sun.org.apache.bcel.internal.generic.ObjectType;
import sun.rmi.transport.ObjectTable;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class MapDAO implements IMap {

    private Connection connection;
    private static CallableStatement statement;

    public MapDAO(){
        this.connection = Dao.getInstance().getConnection();
    }

    public void addObjectType(final ObjectType) {
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallableStatement("boulderdash.addObjectType(?)", parameters).ifPresent(MapDAO: :executeCallStatement);

    }

    public Optional<RawMap> getMap(final String nameMap) {
        Interger width = 0, height = 0, nbrDiamond = 0, timeReaming = 0, x = 0, y = 0;
        RawMap rawMap;
        Optional<ResultSet> oResult;
        ArrayList<>
    }
}
