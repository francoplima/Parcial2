package Domain.DAO;

import Domain.Aluno;
import Domain.Curso;
import Domain.Turma;
import java.sql.SQLException;
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
        return null;
    }
    public static Aluno findById(int id) {
        return null;
    }
    public static boolean save(Aluno aluno) {
        return false;
    }
    public static boolean delete(Aluno aluno) {
        return false;
    }
}
