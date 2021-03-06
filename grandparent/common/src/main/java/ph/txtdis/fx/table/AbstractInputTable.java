package ph.txtdis.fx.table;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import ph.txtdis.fx.dialog.Inputted;

public abstract class AbstractInputTable<E, D> {
    protected Inputted<E> inputDialog;
    protected final D dto;
    protected final Stage stage;
    protected TableView<E> table;

    public AbstractInputTable(Stage stage, D dto) {
        this.dto = dto;
        this.stage = stage;
        setup();
    }

    private void setup() {
        createTable();
        createContextMenu();
        createInputDialog();
    }

    private void createTable() {
        table = new TableView<>();
        addTableColumns();
        addTableProperties();
    }

    private void addTableProperties() {
        table.setEditable(true);
        table.setTooltip(new Tooltip("Right-click to add/delete;\ndouble-click to edit"));
        setTableContextMenu();
        setRowContextMenu();
    }

    public void setTableContextMenu() {
        table.setContextMenu(createContextMenu());
    }

    protected ContextMenu createContextMenu() {
        ContextMenu contextMenu = new ContextMenu();
        createMenuItem(contextMenu);
        return contextMenu;
    }

    protected void createMenuItem(ContextMenu contextMenu) {
        MenuItem menuItem = new MenuItem("Append");
        contextMenu.getItems().add(menuItem);
        menuItem.setOnAction(event -> doOnPressedAppendContextMenu());
    }

    private void doOnPressedAppendContextMenu() {
        createInputDialog();
        ((Stage) inputDialog).showAndWait();
        addTableItems();
    }

    protected void addTableItems() {
        table.getItems().addAll(getAddedItems());
        table.scrollTo(table.getItems().size() - 1);
    }

    protected List<E> getAddedItems() {
        return inputDialog.getAddedItems();
    }

    private void setRowContextMenu() {
        table.setRowFactory(tableView -> setupRowForContextMenu(tableView));
    }

    private TableRow<E> setupRowForContextMenu(TableView<E> table) {
        TableRow<E> row = new TableRow<>();
        row.contextMenuProperty().bind(
                Bindings.when(Bindings.isNotNull(row.itemProperty())).then(createPerTableRowMenu(table, row))
                        .otherwise((ContextMenu) null));
        return row;
    }

    protected ContextMenu createPerTableRowMenu(TableView<E> table, final TableRow<E> row) {
        ContextMenu rowMenu = new ContextMenu();
        addTableMenuToRowMenu(table, rowMenu);
        createRowMenuItem(row, rowMenu);
        return rowMenu;
    }

    protected void addTableMenuToRowMenu(TableView<E> table, ContextMenu rowMenu) {
        ContextMenu tableMenu = table.getContextMenu();
        if (tableMenu != null)
            rowMenu.getItems().addAll(tableMenu.getItems());
    }

    private void createRowMenuItem(TableRow<E> row, ContextMenu rowMenu) {
        MenuItem rowMenuItem = createRowMenuItem();
        rowMenuItem.setOnAction(event -> handleRowMenuItemSelection(row));
        rowMenu.getItems().add(rowMenuItem);
    }

    protected MenuItem createRowMenuItem() {
        return new MenuItem("Delete row");
    }

    protected void handleRowMenuItemSelection(TableRow<E> row) {
        table.getItems().remove(row.getItem());
    }

    protected abstract void addTableColumns();

    protected abstract void createInputDialog();

    public TableView<E> getTable() {
        return table;
    }
}
