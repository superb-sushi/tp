package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.RoleIsMemberPredicate;

/**
 * List all members of cca (people with member role) in address book
 */
public class ListAttendanceCommand extends Command {
    public static final String COMMAND_WORD = "attendance";
    public static final String COMMAND_ALIAS = "atd";

    private static final RoleIsMemberPredicate memberFilter = new RoleIsMemberPredicate();

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.updateFilteredPersonList(memberFilter);

        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }
}
