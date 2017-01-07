package FDTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Umar on 12/30/2016.
 */
public class FDParser {

    public static String[] parseFDs(String rawfd){
        String fds = rawfd.replaceAll("\\s","").toLowerCase();

        //making an array with each FD
        List<String> fdarray = new ArrayList<String>();

        for (String fd:fds.split(";")) {
            String[] depend = fd.split("->");
            //lhs = depend[0]
            //rhs = depend[1]
            if(depend[1].length() > 1){
                for(String singleton:depend[1].split("")){
                    fdarray.add(depend[0]+"->"+singleton);
                }
            }
            else{
                fdarray.add(fd);
            }
        }
        return fdarray.toArray(new String[0]);
    }

}
