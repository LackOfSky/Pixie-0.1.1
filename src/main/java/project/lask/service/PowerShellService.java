package project.lask.service;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import java.util.HashMap;
import java.util.Map;

public class PowerShellService {
    private boolean isWorking;
    private PowerShell powerShell;

    public boolean getIsWorking(){
        return isWorking;
    }

    public String doCommand(String command){
        PowerShellResponse response = powerShell.executeCommand(command);//"Get-Process"
        return response.getCommandOutput();
    }
    public String openSession(){
        Map<String, String> myConfig = new HashMap<>();
        myConfig.put("minWait", "1");

        powerShell = PowerShell.openSession();
        powerShell.configuration(myConfig);
        isWorking = true;
        return "Welcome to PowerShell mode";
    }
    public String closeSession(){
        powerShell.close();
        isWorking = false;
        return "Exit from PowerShell mode";
    }
}
