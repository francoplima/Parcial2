package Domain.DAO;

import Domain.Service.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO extends Banco {
    public ArrayList<Curso> getAll() {
        // codigo, nome, disciplinas, numeroPeriodos, titulacao
        conectar();
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c";
        ArrayList<Curso> cursos = new ArrayList<>();
        
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                int numeroPeriodos = Integer.parseInt(resultSet.getObject(3).toString());
                String titulacao = resultSet.getObject(4).toString();
                cursos.add(new Curso(codigo, nome, numeroPeriodos, titulacao));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return cursos;
    }
    public Curso findByCodigo(int codigo) {
        conectar();
        // codigo, nome, periodos, titulacao
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c where c.codigo = " + codigo;
        Curso curso = null;
        
        resultSet = exec(sql);
        
        if (resultSet != null) {
            try {
                curso = new Curso(
                    Integer.parseInt(resultSet.getObject(1).toString()),
                    resultSet.getObject(2).toString(),
                    Integer.parseInt(resultSet.getObject(3).toString()),
                    resultSet.getObject(4).toString());
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        desconectar();
        return curso;
    }
    public ArrayList<Curso> findByName(String name) {
        conectar();
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao "
                         + "from curso c where c.nome = " + name;
        ArrayList<Curso> cursos = new ArrayList<>();
        
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                int numeroPeriodos = Integer.parseInt(resultSet.getObject(3).toString());
                String titulacao = resultSet.getObject(4).toString();
                cursos.add(new Curso(codigo, nome, numeroPeriodos, titulacao));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return cursos;
    }
    public boolean delete(Curso curso) {
        if(curso != null) {
            final String sql = "delete from Curso where codigo = " + curso.getCodigo();
            return super.delete(sql);
        }
        return false;
    }
}
