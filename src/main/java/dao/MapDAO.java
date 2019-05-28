package dao;

import com.sun.org.apache.bcel.internal.generic.ObjectType;

import javax.lang.model.element.TypeParameterElement;
import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
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
        this.createCallableStatement("boulderdash.addObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);

    }

    public void removeObjectType(final ObjectType objectType){
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(objectType.name(), TypeParameters.IN));
        this.createCallabStatement("boulderdash.removeObjectType(?)", parameters).ifPresent(MapDAO::executeCallStatement);
    }
    
    public Optional<Object> getMap(final String nameMap) {
        Integer width = 0, height = 0, nbrDiamond = 0, timeReaming = 0, x = 0, y = 0;
        RawMap rawMap;
        Optional<ResultSet> oResult;
        ArrayList<Parameters> parameters = new ArrayList<>();

        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallStatement("boulderdash.getMap(?)", parameters).ifPresent(MapDAO::executeCallStatement);
        oResult = MapDAO.getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult.get().next()){
                    width = (Integer) oResult.get().getObject("Width");
                    height = (Integer) oResult.get().getObject("Height");
                    nbrDiamond = (Integer) oResult.get().getObject("Diamond");
                    timeReaming = (Integer) oResult.get().getObject("RemainingTime");
                    if (width == null || height == null ||  nbrDiamond == null || timeReaming == null){
                        return Optional.empty();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        } else  {
            return Optional.empty();
        }
        
        rawMap = new RawMap(nameMap, width, height, nbrDiamond, timeReaming);
        
        parameters.clear();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.getMapObjects(?)", parameters).ifPresent(MapDAO::executeCallStatement);
        oResult = MapDAO.getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult.get().next()){
                    ObjectType type = ObjectType.valueOf(oResult.get().getObject("TypeObject").toString());
                    x = (Integer)oResult.get().getObject("CoordX");
                    y = (Integer)oResult.get().getObject("CoordY");
                    rawMap.addElement(new RawElement(type, x, y));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
        MapDAO.closeStatement();
        return Optional.of(rawMap);
    }

    public void addMap(RawMap rawMap) {
        ArrayList<Parameters> parameters = new ArrayList<>();

        parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getWidth(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getHeight(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getNbrDiamond(), TypeParameters.IN));
        parameters.add(new Parameters<>(rawMap.getTimeRemaining(), TypeParamters.IN));
        this.createCallableStatement("boulderdash.addMap(?,?,?,?,?)", parameters).ifPresent(MapDAO::exectuteCallStatement);
        parameters.clear();

        for(rawElement element : rawMap.getElements()){
            parameters.add(new Parameters<>(rawMap.getName(), TypeParameters.IN));
            parameters.add(new Parameters<>(rawMap.getObject().name(), TypeParameters.IN));
            parameters.add(new Parameters<>(rawMap.getX(), TypeParameters.IN));
            parameters.add(new Parameters<>(rawMap.getY(), TypeParameters.IN));
            this.createCallableStatement("boulerdash.addMapElement(?,?,?,?)", parameters).ifPresent(MapDAO::executeCallStatement);
            parameters.clear();
        }
        closeStatement();
    }

    public void removeMap(String nameMap) {
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters<>(nameMap, TypeParameters.IN));
        this.createCallableStatement("boulderdash.removeMap(?)", parameters).ifPresent(MapDAO::executeCallStatement);

        closeStatement();
    }

    public ArrayList<String> getMapListNames() {

        Optional<ResultSet> oResult;
        ArrayList<String> namnames = new ArrayList<>();
        createCallableStatement("boulderdash.getMapNames()", new ArrayList<>()).ifPresent(MapDAO::executeCallableStatement);
        oResult = getResultSet();
        if(oResult.isPresent()){
            try {
                while (oResult .get().next()){
                    mapnames.add((String)oResult.get().getObject("Mapname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mapnames;
    }

    public final Optional<CallableStatement> createCallableStatement(String sql, final ArrayList<Parameters> parameters){

        final String call = "{ call " + sql + " }";
        int i = 1;
        try {
            CallableStatement callableStatement = this.connection.prepareCall(call);

                for (Parameters parameter : parameters){
                    switch (parameter.getTypeParameters()){
                        case IN:
                            if(parameter.getParameter() instanceof Integer) {
                                callableStatement.setInt(i, (Integer)parameter.getParameter());
                            }

                            else if (parameter.getParameter() instanceof String){
                                callableStatement.setString(i, (String)parameter.getParameter());
                            }

                            else if (parameter.getParameter() instanceof Double){
                                callableStatement.setDouble(i, (Double)parameter.getParameter());
                            }

                            else if (parameter.getParameter() instanceof Boolean){
                                callableStatement.setBoolean(i, (Boolean)parameter.getParameter());
                            }

                            else if (parameter.getParameter() instanceof Date){
                                callableStatement.setDate(i, (Date)parameter.getParameter());
                            }

                            break;

                        case OUT:
                            if(parameter.getParameter() instanceof )
                    }
                }
        }
    }



}
