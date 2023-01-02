import java.util.ArrayList;

public class Interp {


    public static Object Interp(Object input, String Req){
        try{
            switch (Req) {
                case "Network_Talk":
                    if (input.getClass() == String.class) {
                        String Str = (String) input;
                        System.out.println("GOT STRING: " + Str);
                        switch (Str) {
                            case "Reply":
                                return 1;
                        }
                    }

                    if (input.getClass() == ArrayList.class) {
                        ArrayList<Object> x = (ArrayList<Object>) input;
                        ArrayList<Integer> A_Int = new ArrayList<>();
                        ArrayList<String> A_Str = new ArrayList<>();

                        if (x.isEmpty()) {
                            return null;
                        }

                        for (Object object : x) {
                            if (object.getClass() == Integer.class) {
                                A_Int.add((int) object);
                            }
                            if (object.getClass() == String.class) {
                                A_Str.add((String) object);
                            }
                        }

                        if (!A_Int.isEmpty() && A_Str.isEmpty()) {
                            return A_Int;
                        }

                        if (A_Int.isEmpty() && !A_Str.isEmpty()) {
                            return A_Str;
                        }

                        if (A_Int.isEmpty() && A_Str.isEmpty()) {
                            return null;
                        }


                    }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
