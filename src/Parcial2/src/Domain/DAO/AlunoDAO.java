package Domain.DAO;

import Domain.Aluno;
import Domain.Turma;
import java.util.List;

/**
 *
 * @author guilh
 */
public abstract class AlunoDAO {
    public static Aluno get(Aluno aluno) {
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
