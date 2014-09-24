package ph.txtdis.fx.table;

import java.time.LocalDate;

import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import ph.txtdis.dto.EmployeeDTO;
import ph.txtdis.fx.dialog.AssignmentDialog;
import ph.txtdis.fx.util.FX;
import ph.txtdis.model.Assignment;

public class AssignmentBoxedTable extends AbstractBoxedTable<Assignment, EmployeeDTO> {

    public AssignmentBoxedTable(Stage stage, EmployeeDTO dto) {
        super("Assignment", stage, dto);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTableColumns() {

        TableColumn<Assignment, LocalDate> startCol = FX.addDateColumn("Start", "startDate");
        TableColumn<Assignment, LocalDate> endCol = FX.addDateColumn("End", "endDate");
        TableColumn<Assignment, String> locationCol = FX.addStringColumn("Location", "location", 160);
        TableColumn<Assignment, String> designationCol = FX.addStringColumn("Designation", "designation", 100);
        table.getColumns().addAll(startCol, endCol, locationCol, designationCol);
    }

    @Override
    protected void createInputDialog() {
        inputDialog = new AssignmentDialog(stage, dto);
    }
}
