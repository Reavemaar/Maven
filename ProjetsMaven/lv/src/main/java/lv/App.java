package lv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Cocaine!" );
        int maximum=0;
        App app=new App();
        maximum=app.max(4,5);
        System.out.println( maximum );
    }
    public int max(int a, int b){
    	//return a > b ? a: b;
    	return a;
    }
}
