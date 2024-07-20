package com.console_project.configuration;

import com.console_project.command.CommandInvoker;
import com.console_project.command.TypeOfCommand;
import com.console_project.command.collection_command.*;
import com.console_project.file_util.FileReaderWriter;
import com.console_project.model.City;
import com.console_project.storage.Storage;

public class CommandConfiguration {
    public static CommandInvoker<City> getCommandsInvoker(Storage<City> storage, FileReaderWriter<City> fileReaderWriter) {
        CommandInvoker<City> commandInvoker = new CommandInvoker<>();
        commandInvoker.registerCommand(new AddCommand<>(storage, TypeOfCommand.ADD));
        commandInvoker.registerCommand(new AddIfMaxCommand<>(storage, TypeOfCommand.ADD_IF_MAX));
        commandInvoker.registerCommand(new AddIfMinCommand<>(storage, TypeOfCommand.ADD_IF_MIN));
        commandInvoker.registerCommand(new AverageOfMetersAboveSeaLevelCommand<>(storage,
                TypeOfCommand.AVERAGE_OF_METERS_ABOVE_SEA_LEVEL));
        commandInvoker.registerCommand(new ClearCommand<>(storage, TypeOfCommand.CLEAR));
        commandInvoker.registerCommand(new ExecuteScriptCommand<>(storage, TypeOfCommand.EXECUTE_SCRIPT));
        commandInvoker.registerCommand(new GroupCountingByMetersAboveSeaLevelCommand<>(storage,
                TypeOfCommand.GROUP_COUNTING_BY_METERS_ABOVE_SEA_LEVEL));
        commandInvoker.registerCommand(new HelpCommand<>(TypeOfCommand.HELP));
        commandInvoker.registerCommand(new InfoCommand<>(storage, TypeOfCommand.INFO));
        commandInvoker.registerCommand(new PrintAscendingCommand<>(storage, TypeOfCommand.PRINT_ASCENDING));
        commandInvoker.registerCommand(new RemoveByIdCommand<>(storage, TypeOfCommand.REMOVE_BY_ID));
        commandInvoker.registerCommand(new RemoveHeadCommand<>(storage, TypeOfCommand.REMOVE_HEAD));
        commandInvoker.registerCommand(new SaveCommand<>(fileReaderWriter, storage,
                TypeOfCommand.SAVE));
        commandInvoker.registerCommand(new ShowCommand<>(storage, TypeOfCommand.SHOW));
        commandInvoker.registerCommand(new UpdateIdCommand<>(storage, TypeOfCommand.UPDATE_ID));
        return commandInvoker;
    }
}
