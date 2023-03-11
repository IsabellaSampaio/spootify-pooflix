package persistence;

import java.sql.Connection;
import java.util.List;

import dominio.OBJPOOFlix;

/**
 * Interface do DAO
 */
public abstract class DAOPOOFLIX {
    protected Connection connection;

    public abstract int create(OBJPOOFlix obj);
    public abstract int update(OBJPOOFlix obj);
    public abstract int delete(String id);
    public abstract List<OBJPOOFlix> read();
}
