package pl.edu.agh.game.player.listener.interpreter.commands;

import pl.edu.agh.game.model.enemies.beasts.Bear;
import pl.edu.agh.game.model.enemies.beasts.QuillBeast;
import pl.edu.agh.game.player.action.messages.ActionMsg;

import java.util.HashMap;
import java.util.Map;

public class Fight implements Command {
    
    private static final Map<String, pl.edu.agh.game.player.action.messages.ActionMsg> messages = new HashMap<>();
    static {
        messages.put("bear", new pl.edu.agh.game.player.action.messages.Fight(new Bear()));
        messages.put("quill", new pl.edu.agh.game.player.action.messages.Fight(new QuillBeast()));

    }

    private static final String NO_ARGS_MSG =
            "NO BEAST: please enter beast name after fight command (FIGHT {BEAR/QUILL})";

    @Override
    public ActionMsg execute(String[] args) {
        if (args.length == 0) {
            System.out.println(NO_ARGS_MSG);
        } else {
            if (messages.containsKey(args[0])){
                return messages.get(args[0]);
            }
        }
        return null;
    }

}
