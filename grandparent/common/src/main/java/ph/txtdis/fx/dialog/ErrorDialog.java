package ph.txtdis.fx.dialog;

import javafx.stage.Stage;

public class ErrorDialog extends AbstractMessageDialog {

    public ErrorDialog(Stage stage, String message) {
        super(stage, message, "\ue61e", "maroon");
        show();
    }
}
