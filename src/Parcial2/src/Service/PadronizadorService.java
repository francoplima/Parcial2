package Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author guilh
 * @versionDate
 * 
 * Esta classe possui diversos métodos estáticos para auxiliar toda a padronização de campos no programa.
 * 
 */
public abstract class PadronizadorService {
    /**
     * Este método recebe como parâmetro três valores, dia, mês e ano.
     * Estes valores são inteiros, e são validados retornando um Date no formato ainda não definido.
     * Caso venha ser passado um parâmetro com valores inválidos será retornado um objeto com valor null.
     */
    public static Date dataPadrao(int dia, int mes, int ano) throws ParseException {
        Calendar c = Calendar.getInstance();
        if (dia <= 0 || dia > 31 || mes <= 0 || mes > 12 || ano <= c.getTime().getYear()-200) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes, dia);
        return cal.getTime();
    }
    
    public static void main(String[] args) throws ParseException {
        Date a = PadronizadorService.dataPadrao(10, 06, 1996);
        System.out.println(a.getDate() + " " + a.getMonth() + " " + a.getYear());
        System.out.println(a);
    }
}
