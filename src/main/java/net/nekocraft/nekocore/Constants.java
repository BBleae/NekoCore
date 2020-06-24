package net.nekocraft.nekocore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public final class Constants {
    private Constants() {}
    public static final String WRONG_USAGE = "��c����������÷�!";
    public static final String NO_PERMISSION = "��c��û��Ȩ����ִ�����ָ��!";

    public static final String PLAYER_HEADER = "��b��m          ��r ��a[��eNekoCraft��a] ��b��m          \n��aTelegream Ⱥ��: ��7t.me/NekoCraft\n��aQQ Ⱥ: ��77923309\n��r";

    public static final String JOIN_MESSAGE_HEADER = "��b��m                       ��r ��a[��eNekoCraft��a] ��b��m                      ��r";
    public static final String JOIN_MESSAGE1 = "  ��c���ڷ�����û����ز��, �벻Ҫ������ȡ������Ʒ, �����ֱ�ӷ��!";
    public static final String JOIN_MESSAGE_FOOTER = "��b��m                                                          ��r\n\n\n";
    public static final TextComponent[] JOIN_MESSAGES = new TextComponent[9];

    public static final TextComponent[] RULES = new TextComponent[6];

    static {
        (JOIN_MESSAGES[0] = new TextComponent("  QQ Ⱥ: ")).setColor(ChatColor.GREEN);

        TextComponent c = JOIN_MESSAGES[1] = new TextComponent("7923309");
        c.setColor(ChatColor.GRAY);
        c.setUnderlined(true);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://jq.qq.com/?k=5AzDYNC"));

        JOIN_MESSAGES[2] = new TextComponent("      ");

        (JOIN_MESSAGES[3] = new TextComponent("Telegram Ⱥ��: ")).setColor(ChatColor.GREEN);

        c = JOIN_MESSAGES[4] = new TextComponent("@NekoCraft");
        c.setColor(ChatColor.GRAY);
        c.setUnderlined(true);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://t.me/NekoCraft"));

        (JOIN_MESSAGES[5] = new TextComponent("\n  �û����� & ���ͼ: ")).setColor(ChatColor.GREEN);

        JOIN_MESSAGES[6] = c = new TextComponent("user.n.apisium.cn");
        c.setColor(ChatColor.GRAY);
        c.setUnderlined(true);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://user.n.apisium.cn"));

        (JOIN_MESSAGES[7] = new TextComponent("\n  ��������ַ & ����: ")).setColor(ChatColor.GREEN);

        JOIN_MESSAGES[8] = c = new TextComponent("n.apisium.cn");
        c.setColor(ChatColor.GRAY);
        c.setUnderlined(true);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://n.apisium.cn/index.html"));

        RULES[0] = new TextComponent("  ��b��ӭ����һ������ ��eNekoCraft ��a!\n  ��e����Ҫɨ�������еĶ�ά����� ");

        c = RULES[1] = new TextComponent("[����]");
        c.setColor(ChatColor.BLUE);
        c.setUnderlined(true);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://user.n.apisium.cn/about"));

        RULES[2] = new TextComponent("  ��e���Ķ��������涨\n  ��7���ȷ�Ϻ���Ĭ�������Ķ������ط������涨!\n       ");

        c = RULES[3] = new TextComponent(" [�����Ķ������ط������涨] ");
        c.setColor(ChatColor.GREEN);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/acceptrule"));

        RULES[4] = new TextComponent("      ");

        c = RULES[5] = new TextComponent("[�ܾ�]");
        c.setColor(ChatColor.RED);
        c.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/denyrule"));
    }
}