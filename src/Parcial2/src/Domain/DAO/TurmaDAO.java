package Domain.DAO;

import Domain.Turma;

/**
 *
 * @author guilh
 */
public abstract class TurmaDAO extends Banco {
    public static Turma findById(int id) {
        final String sql = "select t.id, t. from Turma t";
        return null;
    }
}
