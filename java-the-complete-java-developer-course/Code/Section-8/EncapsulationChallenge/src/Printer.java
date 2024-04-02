public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel <= 0 || tonerLevel > 100) ? -1 : tonerLevel;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        int totalToner = this.tonerLevel + tonerAmount;
        if (totalToner < 0 || totalToner > 100) {
            return -1;
        }
        // only add toner if we pass validation
        return this.tonerLevel += tonerAmount;
    }

    public int printPages(int pages) {
        int totalPages = (this.duplex) ? (pages / 2) + (pages % 2) : pages;
        System.out.println("Printing " + totalPages + ((duplex) ? " on a duplex printer": ""));
        this.pagesPrinted += totalPages;
        return totalPages;
    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }
}
