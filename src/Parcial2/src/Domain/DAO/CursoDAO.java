package Domain.DAO;

<<<<<<< HEAD
import Domain.Service.Curso;
=======
import Domain.Curso;
>>>>>>> Franco
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
public class CursoDAO extends Banco {
    public ArrayList<Curso> getAll() {
        // codigo, nome, disciplinas, numeroPeriodos, titulacao
        conectar();
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c";
=======
public abstract class CursoDAO extends Banco {
    
    public static Curso get(Curso curso) {
        // nome, disciplina, numeroPeriodo, titulacao
        final String sql = "select c.nome, c.numeroDePeriodos, c.titulacao from curso c " +
                           "where c.nome = " + curso.getNome() + "c.numeroDePeriodos = " + curso.getNumeroPeriodos() + "c.titulacao = " 
                          +curso.getTitulacao();
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                int numeroPeriodos = Integer.parseInt(resultSet.getObject(3).toString());
                String titulacao = resultSet.getObject(4).toString();
                return new Curso(codigo, nome, numeroPeriodos, titulacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Curso> getAll() {
        // id, nome, disciplinas, numeroPeriodos, titulacao
        conectar();
        final String sql = "select c.id, c.nome, c.numeroDePeriodos, c.titulacao from curso c";
>>>>>>> Franco
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
<<<<<<< HEAD
    public Curso findByCodigo(int codigo) {
        conectar();
        // codigo, nome, periodos, titulacao
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c where c.codigo = " + codigo;
=======
    public static Curso findById(int id) {
        conectar();
        // id, nome, periodos, titulacao
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c where c.id = " + id;
>>>>>>> Franco
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
<<<<<<< HEAD
    public ArrayList<Curso> findByName(String name) {
=======
    public static ArrayList<Curso> findByName(String name) {
>>>>>>> Franco
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
<<<<<<< HEAD
    public boolean delete(Curso curso) {
        if(curso != null) {
            final String sql = "delete from Curso where codigo = " + curso.getCodigo();
            return super.delete(sql);
=======
    public static boolean delete(Curso curso) {
        if(curso != null) {
            final String sql = "delete from Curso where id = " + curso.getId();
            return delete(sql);
        }
        return false;
    }
    
    public static boolean save(Curso curso) {
        if(curso != null) {
            final String sql = "insert into Curso(nome, numeroPeriodos, titulacao) " +
                           " values(" + curso.getNome()+","+curso.getNumeroPeriodos()+","+curso.getTitulacao()+")";
            return save(sql);
>>>>>>> Franco
        }
        return false;
    }
}
