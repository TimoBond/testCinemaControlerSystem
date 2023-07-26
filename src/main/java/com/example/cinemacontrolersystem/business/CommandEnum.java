package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.model.Schedule;

public enum CommandEnum {
    REGISTRATION {
        {
            command = new CommandRegistration();
        }
    },
    COMMAND_VERIFICATION {
        {
            command = new CommandVerification();
        }
    },
    LOGIN{
        {
            command = new CommandLogin();
        }
    }, COMMAND_LOGOUT{
        {
            command = new CommandLogout();
        }
    }, SCHEDULE_COMMAND{
        {
            command = new Schedule_Command();
        }
    },TICKETS{
        {
            command = new TicketsCommand();
        }
    }, INCOME{
        {
            command = new IncomeCommand();
        }
    }, GO_INCOME{
        {
            command = new GoIncomeCommand();
        }
    };
    Command command;

    public Command getCommand() {
        return command;
    }
}
