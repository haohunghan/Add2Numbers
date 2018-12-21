

/**
 *
 * @author Mickey Mouse
 */
public class ParameterFormatException extends Exception{
    String str;

    public ParameterFormatException(String x) {
        str = x;
    }

    @Override
    public String toString() {
        return "ParameterFormatException[key:\"" + str + "\"][line:" + getStackTrace()[0].getLineNumber() + "]";
    }
}