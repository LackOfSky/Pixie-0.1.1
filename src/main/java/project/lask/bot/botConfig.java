package project.lask.bot;

import project.lask.service.PowerShellService;

public class botConfig {

    public static Bot setUp(){
        ServiceDispatcher dispatcher =
                new ServiceDispatcher(
                        new PowerShellService());
        return new Bot(dispatcher);
    }
}
