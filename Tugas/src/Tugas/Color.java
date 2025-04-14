package Tugas;

public class Color implements Printer {
    String[] bgColor =
            {"\u001b[41m","\u001b[42m","\u001b[44m","\u001b[45m","\u001b[46m","\u001b[47m"};
    String[] color =
            {"\u001b[31m","\u001b[32m","\u001b[34m","\u001b[35m","\u001b[36m","\u001b[37m"};
    String reset = "\u001b[0m";

    @Override
    public void setColor(int col) {
        System.out.print(color[col]);
    }

    @Override
    public void setBgColor(int col) {
        System.out.print(bgColor[col]);
    }

    @Override
    public void resetColor() {
        System.out.print(reset);
    }
}
