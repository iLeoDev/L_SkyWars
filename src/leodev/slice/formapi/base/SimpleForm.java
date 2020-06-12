package leodev.slice.formapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leodev.slice.formapi.element.Button;
import cn.nukkit.Player;

import com.google.gson.Gson;


/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>SimpleForm</h1>
 * <p>ãƒ¡ãƒ‹ãƒ¥ãƒ¼åž‹ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’æ‰±ã�†ã‚¯ãƒ©ã‚¹ã�§ã�™ã€‚ä¸€èˆ¬çš„ã�«IDã�¨ã‚¿ã‚¤ãƒˆãƒ«ã‚’æŒ‡å®šã�—ã€�addButton(Button)ã�§è¦�ç´ ã‚’è¿½åŠ ã�—ã�¦ä½¿ã�„ã�¾ã�™ã€‚ãƒœã‚¿ãƒ³ã‚¯ãƒªãƒƒã‚¯æ™‚ã�®æŒ™å‹•ã�¯onEnter()ãƒ¡ã‚½ãƒƒãƒ‰ã‚’ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹ã�“ã�¨ã�§å®Ÿè£…ã�§ã��ã�¾ã�™ã€‚
 * <br><p>ã�ªã�Šã€�Buttonã‚¯ãƒ©ã‚¹ã�®ãƒœã‚¿ãƒ³ä¸€ã�¤ä¸€ã�¤ã�«å‡¦ç�†ã‚’å‰²ã‚ŠæŒ¯ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
 * <br>
 * 
 * @see SimpleForm#setId(int)
 * @see SimpleForm#setTitle(String)
 * @see SimpleForm#onEnter(Player player, int index)
 * @see Button
 * @see Button#onClick(Player player)
 * 
 * @author itsu
 *
 */

public class SimpleForm implements Form {

    private int id;
    private String title;
    private String content;
    private List<Button> buttons;

    private Map<String, Object> data;
    private Gson gson;
    private String json;

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm()</h1>
     * <p>SimpleFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm() {
        this(0, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id)</h1>
     * <p>SimpleFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id) {
        this(id, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title)</h1>
     * <p>SimpleFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title) {
        this(id, title, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title, String content)</h1>
     * <p>SimpleFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title, String content) {
        this(id, title, content, new ArrayList<Button>());
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title, String content)</h1>
     * <p>SimpleFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title, String content, List<Button> buttons) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.buttons = buttons;

        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButton(Button button)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®æœ€å¾Œéƒ¨ã�«ãƒœã‚¿ãƒ³ã‚’è¿½åŠ ã�—ã�¾ã�™ã€‚addButtons()ã‚„setButtonsã�§ä¸€æ‹¬ã�§è¿½åŠ ã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#addButtons(List)
     * @see SimpleForm#addButtons(Button[])
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#setButtons(Button[])
     * 
     * @author itsu
     *
     */
    public SimpleForm addButton(Button button) {
        this.buttons.add(button);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setId(int id)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«IDã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int)
     * 
     * @author itsu
     *
     */
    public SimpleForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setTitle(String title)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«ã‚¿ã‚¤ãƒˆãƒ«ã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String)
     * 
     * @author itsu
     *
     */
    public SimpleForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setContent(String content)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¡¨ç¤ºã�™ã‚‹æ–‡ç« ã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String)
     * 
     * @author itsu
     *
     */
    public SimpleForm setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setButtons(List<Button> buttons)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¿½åŠ ã�™ã‚‹è¦�ç´ ã‚’ä¸€æ‹¬ã�§è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setButtons(Button[] buttons)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¿½åŠ ã�™ã‚‹è¦�ç´ ã‚’é…�åˆ—ã�«ã‚ˆã�£ã�¦ä¸€æ‹¬ã�§è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm setButtons(Button[] buttons) {
        this.buttons = Arrays.asList(buttons);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButtons(List<Button> buttons)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¦�ç´ ã‚’ä¸€æ‹¬ã�§è¿½åŠ ã�—ã�¾ã�™ã€‚setButtons()ã�¨ã�¯ã�¡ã�Œã�„ã€�ã�“ã�¡ã‚‰ã�§ã�¯ä¸€æ‹¬è¿½åŠ å¾Œã‚‚addButton()ã�§è¦�ç´ ã‚’è¿½åŠ ã�™ã‚‹ã�“ã�¨ã�Œã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#addButton(Button)
     * 
     * @author itsu
     *
     */
    public SimpleForm addButtons(List<Button> buttons) {
        this.buttons.addAll(buttons);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButtons(List<Button> buttons)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¦�ç´ ã‚’é…�åˆ—ã�«ã‚ˆã�£ã�¦ä¸€æ‹¬ã�§è¿½åŠ ã�—ã�¾ã�™ã€‚setButtons()ã�¨ã�¯ã�¡ã�Œã�„ã€�ã�“ã�¡ã‚‰ã�§ã�¯ä¸€æ‹¬è¿½åŠ å¾Œã‚‚addButton()ã�§è¦�ç´ ã‚’è¿½åŠ ã�™ã‚‹ã�“ã�¨ã�Œã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#addButton(Button)
     * 
     * @author itsu
     *
     */
    public SimpleForm addButtons(Button[] buttons) {
        this.buttons.addAll(Arrays.asList(buttons));
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getTitle()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ã‚¿ã‚¤ãƒˆãƒ«ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getContent()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®æ–‡ç« ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getButtons()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ãƒœã‚¿ãƒ³ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public List<Button> getButtons() {
        return this.buttons;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getId()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®Idã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - encode()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’Gsonãƒ©ã‚¤ãƒ–ãƒ©ãƒªçµŒç�?±ã�§JsonåŒ–ã�—ã�¾ã�™ã€‚ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã�®å‘¼ã�³å‡ºã�—ã�¯é�žæŽ¨å¥¨ã�§ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public SimpleForm encode() {
        json = gson.toJson(data);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - build()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’Gsonãƒ©ã‚¤ãƒ–ãƒ©ãƒªçµŒç�?±ã�§JsonåŒ–ã�§ã��ã‚‹ã‚ˆã�†ã�«ã‚¨ãƒ³ã‚³ãƒ¼ãƒ‰ã�—ã�¾ã�™ã€‚ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã�®å‘¼ã�³å‡ºã�—ã�¯é�žæŽ¨å¥¨ã�§ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public SimpleForm build() {
        data.clear();

        data.put("type", "form");
        data.put("title", this.title);
        data.put("content", this.content);

        List<Map<String, Object>> list = new ArrayList<>();
        for(Button button : buttons) {
            Map<String, Object> map = new HashMap<>();
            map.put("text", button.getText());
            map.put("data", button.getImage());
            list.add(map);
        }

        data.put("buttons", list);

        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getJson()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®JsonåŒ–ã�—ã�Ÿã‚‚ã�®ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚ã�ªã�Šã€�build()ã€�encode()ã�®é †ã�§å‘¼ã�³å‡ºã�—ã‚’ã�—ã�Ÿå¾Œã�§ã�ªã�„ã�¨NullPointerExceptionã‚’èµ·ã�“ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @see SimpleForm#build()
     * @see SimpleForm#encode()
     * @see NullPointerException
     * 
     * @author itsu
     *
     */
    @Override
    public String getJson() {
        return this.json;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - onEnter(Player player, int index)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ãƒœã‚¿ãƒ³ã‚’ã‚¯ãƒªãƒƒã‚¯ã�—ã�Ÿéš›ã�«å‘¼ã�³å‡ºã�•ã‚Œã�¾ã�™ã€‚indexã�¯ãƒœã‚¿ãƒ³ã�®ã‚¤ãƒ³ãƒ‡ãƒƒã‚¯ã‚¹ã�§ã€�ä¸€ç•ªä¸Šã�‹ã‚‰0, 1...ã�ªã�£ã�¦ã�„ã��ã�¾ã�™ã€‚ã�¨ã�“ã�®ãƒ¡ã‚½ãƒƒãƒ‰ã�¯ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹å¿…è¦�ã�Œã�‚ã‚Šã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public void onEnter(Player player, int index) {

    }

}
