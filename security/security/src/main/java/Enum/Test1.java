package Enum;

enum Color
{
    RED,
    GREEN,
    BLUE;
}

public class Test1 {

    public static void main(String[] args) {

        // Calling values()
        Color arr[] = Color.values();

        //enum with loop
        for(Color col : arr){
            System.out.println(col + " at index " + col.ordinal());
        }

        System.out.println(Color.valueOf("RED"));
    }
}
