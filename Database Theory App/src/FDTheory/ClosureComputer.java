package FDTheory;

import java.util.*;

/**
 * Created by Umar on 1/3/2017.
 */
public class ClosureComputer {
    public ClosureComputer(String[] fds){
        this.fds = fds;
        populateHashMap();
    }
    private String[] fds;
    private HashMap<String, String> fdsMap = new HashMap<String, String>();
    /*
    1) Create hashmap with the fds, keys are the LHS. This simplifies the FDs by joining the RHS and constant time
    call up from the LHS. Hashmap will never change after this point (FDs never change in closure).

    2) Get all subsets of the attributes to get closure. Lookup LHS from hashmap, add the RHS, delete any duplicate atts

    Track what the answer is before (initially it's the attributes to get closure) and then after. If no change, stop,
    otherwise keep doing 2).
    */

    public String computeClosure(String closure){
        String ans = closure; //closure of anything includes itself
        int changeFlag = 1;

        while(changeFlag==1){
            changeFlag = 0;
            List<String> subsets = FDStringHandler.powerSet(ans);
            String temp = ans;
            for(String s:subsets){
                if (fdsMap.containsKey(FDStringHandler.sortString(s))){
                    ans = FDStringHandler.merge(ans, fdsMap.get(s));
                }
            }
            if(!(sameChars(temp,ans))){
                changeFlag = 1;
            }
        }

        return ans;
    }

    private boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public void populateHashMap(){
        for(String fd: this.fds){
            String[] depend = fd.split("->");
            String lhs = depend[0];
            String rhs = depend[1];
            if(this.fdsMap.containsKey(lhs)){
                this.fdsMap.put(FDStringHandler.sortString(lhs), FDStringHandler.merge(rhs, this.fdsMap.get(lhs)));
            }
            else{
                this.fdsMap.put(FDStringHandler.sortString(lhs), FDStringHandler.sortString(rhs));
            }
        }
    }

    public HashMap<String, String> getFDs(){
        return this.fdsMap;
    }

}
