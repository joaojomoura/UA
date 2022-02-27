package Shared;

public class StringUtils
{
    //https://stackoverflow.com/a/50162404
    public static String centerString (int width, String s) 
    {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}
