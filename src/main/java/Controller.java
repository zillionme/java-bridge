import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public String get () {
        try {
            String input = inputView.readString();

        }catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return get ();
    }
}
