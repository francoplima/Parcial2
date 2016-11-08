package Domain.DAO;

import Domain.Aluno;
import Domain.Curso;
import Domain.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author guilh
 */
public abstract class AlunoDAO extends Banco {
    public static Aluno get(Aluno aluno) {
        final String sql = "select a.id, a.nome, a.dataNascimento, a.cpf, a.idCurso from Aluno a "
                         + "where a.nome = " + aluno.getNome() + " a.dataNascimento = " + aluno.getDataNascimento() +
                           " a.cpf = " + aluno.getCpf();
        resultSet = exec(sql);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                Date data = new Date(resultSet.getString(3));
                String cpf = resultSet.getString(4);
                int idCurso = resultSet.getInt(5);
                Curso curso = CursoDAO.findById(idCurso);
                
                return new Aluno(id, nome, data, cpf, curso);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Aluno> getAllByTurma(Turma turma) {
        conectar();
        final String sql = "select a.id, a.nome, a.cpf, a.nascimento,"
                + "a.idCurso from Aluno a, AlunoTurma at where a.id = "
                + "at.idaluno and at.idturma = "+ turma.getId() ;
        resultSet = exec(sql);
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String cpf = resultSet.getString(3);
                Date data = resultSet.getDate(4);
                Curso idcurso = CursoDAO.findById(resultSet.getInt(5));
                alunos.add(new Aluno(id, nome, data, cpf, idcurso));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
        return alunos;
    }
    
    public static Aluno findById(int id) {
        conectar();
        final String sql = "select a.id, a.nome, a.cpf, a.nascimento, a.idcurso from Aluno a "
                         + "where id = " + id;
        
        resultSet = exec(sql);
        Aluno aluno = null;
        try {
            resultSet.next();
            if (resultSet != null) {
                int idaluno = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String cpf = resultSet.getString(3);
                Date data = resultSet.getDate(4);
                Curso idcurso = CursoDAO.findById(resultSet.getInt(5));
                aluno = new Aluno(idaluno, nome, data, cpf, idcurso);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return aluno;
    }
    public static boolean addAluno(String nome, String cpf, String nascimento,int idCurso ) {
        conectar();
        final String sql = "insert into Professor (nome, cpf, nascimento) "
                         + "values(" + nome + ", " + cpf +", " + nascimento +", " + idCurso + ")";
        desconectar();
        return save(sql);
    }
    //creio que remoção basta o ip como parâmetro
    public static boolean remAluno (int id) {
        conectar();
        final String sql = "delete from Aluno where id = " + id;
        desconectar();
        return delete(sql);
    }
    public static boolean save(Aluno aluno) {
        return false;
    }
    public static boolean delete(Aluno aluno) {
        return false;
    }
}
