import java.text.MessageFormat;

public class StaticChar {
    private static final String ROLE_NAME ="roles[{0},{1}]";

    public String format(){

        String str="woleile";
        String str2="woaini";
        String sb= MessageFormat.format(ROLE_NAME,str2,str);

        return sb;
    }

    public static void main(String[] args) {
        System.out.println(new StaticChar().format());
    }
}
