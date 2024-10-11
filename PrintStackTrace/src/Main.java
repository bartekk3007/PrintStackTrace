import java.io.PrintWriter;
import java.io.StringWriter;

public class Main
{
    public static void main(String[] args)
    {
        var t = new Throwable();
        var out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        System.out.println(description);

        StackWalker walker = StackWalker.getInstance();
        walker.forEach(System.out::println);

        Throwable throwable = new Throwable();
        StackTraceElement[] elems = throwable.getStackTrace();
        for (StackTraceElement elem : elems)
        {
            System.out.println(elem);
            System.out.println(elem.getClassLoaderName());
            System.out.println(elem.getClassName());
            System.out.println(elem.getFileName());
            System.out.println(elem.getLineNumber());
            System.out.println(elem.getMethodName());
            System.out.println(elem.getModuleName());
            System.out.println(elem.getModuleVersion());
            System.out.println("Is this method native " + elem.isNativeMethod());
        }
    }
}