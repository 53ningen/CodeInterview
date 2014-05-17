import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by yuki_yanagi on 2014/05/15.
 */
public class Application {
    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(7);

        {
            Iterator current = list.iterator();

            while( current.hasNext() ){
                Iterator runner  = list.iterator();
                while( runner.hasNext() ){
                    runner.next();
                    if(current.equals(runner))
                        current.remove();
                }
                current.next();
            }

            System.out.println(current.toString());
        }


    }

}
