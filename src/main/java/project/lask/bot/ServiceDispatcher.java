package project.lask.bot;


import project.lask.service.PowerShellService;

public class ServiceDispatcher {
    private PowerShellService powerShellService;
    private String command;

    public ServiceDispatcher(PowerShellService powerShall) {
        this.powerShellService = powerShall;
    }
    public String getCommand(String command) {
        //this.command = command.substring(1,command.length() -1);
        this.command = command;
        if (command.trim().equalsIgnoreCase("PowerShell=on")) {
//            if(powerShall.getIsWorking() == true){
//                return "PowerShall is already working!";
//            }
            return powerShellService.openSession();
        } else if (command.trim().equalsIgnoreCase("PowerShell=off")) {
            return powerShellService.closeSession();
        } else {
            return shallHandler();
        }
    }

    public String shallHandler(){
        if (powerShellService.getIsWorking()) {
            return powerShellService.doCommand(command);
        } else {
            return commandHandler();
            }
        }
    public String commandHandler(){
        switch (command) {
            case "1": //by default
                return "Do nothing";
            default:
                return "Unknown command!";
        }
    }
}
