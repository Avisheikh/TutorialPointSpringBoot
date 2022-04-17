package Enum;

enum Color2{
    RED,
    GREEN,
    BLUE;
    
    // enum constructor called separately for each
    private Color2()
    {
        System.out.println("Constructor called for : " + this.toString());
    }
    
    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
    
}

public class Test2 
{
    public static void main(String[] args) {
        Color2 c1 = Color2.RED;
        System.out.println(c1);
        c1.colorInfo();
    }
}
