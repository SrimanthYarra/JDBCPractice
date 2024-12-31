package JDBCPractice;

import java.util.HashMap;

public class ProvideOptions {

    public HashMap<Integer,String> options(){
        HashMap<Integer,String> options=new HashMap<>();
        options.put(1,"Find All");
        options.put(2,"Find By Id");
        options.put(3,"Insert Data");
        options.put(4,"Find By Text");
        options.put(5,"Delete By Id");
        options.put(6,"Exit");
        return options;
    }
}
