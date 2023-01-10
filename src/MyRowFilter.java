
import javax.swing.RowFilter;

public class MyRowFilter extends RowFilter {

    private final String searchText;

    MyRowFilter(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public boolean include(Entry entry) {
        //returns matched results
        return entry.getStringValue(1).contains(searchText) || entry.getStringValue(2).contains(searchText);

    }

}
