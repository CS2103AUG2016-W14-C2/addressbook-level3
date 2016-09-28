package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.ArrayList;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListTagCommand extends Command {

    public static String tag;
    
    public static final String COMMAND_WORD = "listTag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all persons in the address book with given tag name as a list with index numbers.\n\t"
            + "Example: " + COMMAND_WORD
            + "friends";
    
    public ListTagCommand(String arguments) {
        ListTagCommand.tag = arguments;
    }

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allTagPersons = new ArrayList<ReadOnlyPerson>();
        try {
            allTagPersons = addressBook.getAllTagPersons(tag).immutableListView();
        } catch (IllegalValueException e) {
            return new CommandResult(getMessageForPersonListShownSummary(allTagPersons), allTagPersons);
        }
        return new CommandResult(getMessageForPersonListShownSummary(allTagPersons), allTagPersons);
    }
}
