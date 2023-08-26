package project.lask.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class Bot extends TelegramLongPollingBot {
    final int RECONNECT_PAUSE =10000;

    private String userName = "helloBOT";

    private final String token = "#";
    private ServiceDispatcher serviceDispatcher;

    public Bot(ServiceDispatcher serviceDispatcher){
        this.serviceDispatcher = serviceDispatcher;
    }

    /**
        Метод-обработчик поступающих сообщений.
        update объект, содержащий информацию о входящем сообщении
     */
    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                SendMessage outMessage = new SendMessage();

                outMessage.setChatId(inMessage.getChatId().toString());
                String response = serviceDispatcher.getCommand(inMessage.getText());

                System.out.println(response +"***");/////
                outMessage.setText("done\n"+ response);

                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        return userName;
    }
    @Override
    public String getBotToken() {
        return token;
    }

}
