package objectF6MYAZ;

import org.json.simple.JSONObject;

public class ObjectF6MYAZ {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        obj.put("nev", "BMarton");
        obj.put("fizetes", 10000);
        obj.put("kor", 21);

        System.out.print(obj);
    }

}
