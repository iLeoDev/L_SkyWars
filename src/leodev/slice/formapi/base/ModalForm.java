package leodev.slice.formapi.base;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import com.google.gson.Gson;

/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>ModalForm</h1>
 * <p>æ–‡ç« ã�«äºŒã�¤ã�®ãƒœã‚¿ãƒ³ã�Œã�¤ã�„ã�Ÿã€�ç°¡æ˜“çš„ã�ªãƒ•ã‚©ãƒ¼ãƒ ã‚’æ‰±ã�†ã‚¯ãƒ©ã‚¹ã�§ã�™ã€‚ä¸€èˆ¬çš„ã�«IDã�¨ã‚¿ã‚¤ãƒˆãƒ«ã‚’æŒ‡å®šã�—ã€�setButton1Text(String)ã�¨setButton2Text(String)ã�§ãƒœã‚¿ãƒ³ã�®æ–‡å­—åˆ—ã‚’è¨­å®šã�—ã�¦æ‰±ã�„ã�¾ã�™ã€‚
 * <br><p>ãƒ¬ã‚¹ãƒ�ãƒ³ã‚¹ã�®å�–å¾—ã�¯onButton1Click()ã�¨onButton2Click()ã‚’ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�—ã�¦å‡¦ç�†ã�§ã��ã�¾ã�™ã€‚
 * <br><p>ã�ªã�Šã€�ã�“ã�®APIä¸­ã�®Button1ã�¯ä¸Šã�®ãƒœã‚¿ãƒ³ã€�Button2ã�¯ä¸‹ã�®ãƒœã‚¿ãƒ³ã�¨ã�—ã�¦æ‰±ã�£ã�¦ã�„ã�¾ã�™ã€‚
 * <br>
 * 
 * @see ModalForm#setButton1Text(String)
 * @see ModalForm#setButton2Text(String)
 * @see ModalForm#onButton1Click(Player player)
 * @see ModalForm#onButton2Click(Player player)
 * 
 * @author itsu
 *
 */

public class ModalForm implements Form {

    private int id;
    private String title;
    private String content;
    private String button1Text;
    private String button2Text;

    private Map<String, Object> data;
    private Gson gson;
    private String json;
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm()</h1>
     * <p>ModalFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm() {
        this(0);
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id)</h1>
     * <p>ModalFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id) {
        this(id, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title)</h1>
     * <p>ModalFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title) {
        this(id, title, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title, String content)</h1>
     * <p>ModalFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title, String content) {
        this(id, title, content, "", "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title, String content, String button1Text, String button2Text)</h1>
     * <p>ModalFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title, String content, String button1Text, String button2Text) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.button1Text = button1Text;
        this.button2Text = button2Text;

        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setId(int id)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«IDã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm(int)
     * 
     * @author itsu
     *
     */
    public ModalForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setTitle(String title)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«ã‚¿ã‚¤ãƒˆãƒ«ã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setContent(String content)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¡¨ç¤ºã�™ã‚‹æ–‡ç« ã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setContent(String content) {
        this.content = content;
        return this;
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setButton1Text(String button1Text)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸Šã�®ãƒœã‚¿ãƒ³ã�®ãƒ†ã‚­ã‚¹ãƒˆã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setButton1Text(String button1Text) {
        this.button1Text = button1Text;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setButton2Text(String button1Text)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸‹ã�®ãƒœã‚¿ãƒ³ã�®ãƒ†ã‚­ã‚¹ãƒˆã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setButton2Text(String button2Text) {
        this.button2Text = button2Text;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getTitle()</h1>
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
     * <h1>ModalForm - getContent()</h1>
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
     * <h1>ModalForm - getButton1Text()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸Šã�®ãƒœã‚¿ãƒ³ã�®ãƒ†ã‚­ã‚¹ãƒˆã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public String getButton1Text() {
        return this.button1Text;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getButton1Text()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸‹ã�®ãƒœã‚¿ãƒ³ã�®ãƒ†ã‚­ã‚¹ãƒˆã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public String getButton2Text() {
        return this.button2Text;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - encode()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’Gsonãƒ©ã‚¤ãƒ–ãƒ©ãƒªçµŒç�?±ã�§JsonåŒ–ã�—ã�¾ã�™ã€‚ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã�®å‘¼ã�³å‡ºã�—ã�¯é�žæŽ¨å¥¨ã�§ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public Form encode() {
        json = gson.toJson(data);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - build()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’Gsonãƒ©ã‚¤ãƒ–ãƒ©ãƒªçµŒç�?±ã�§JsonåŒ–ã�§ã��ã‚‹ã‚ˆã�†ã�«ã‚¨ãƒ³ã‚³ãƒ¼ãƒ‰ã�—ã�¾ã�™ã€‚ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã�®å‘¼ã�³å‡ºã�—ã�¯é�žæŽ¨å¥¨ã�§ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public Form build() {
        data.clear();

        data.put("type", "modal");
        data.put("title", this.title);
        data.put("content", this.content);
        data.put("button1", this.button1Text);
        data.put("button2", this.button2Text);

        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getJson()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®JsonåŒ–ã�—ã�Ÿã‚‚ã�®ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚ã�ªã�Šã€�build()ã€�encode()ã�®é †ã�§å‘¼ã�³å‡ºã�—ã‚’ã�—ã�Ÿå¾Œã�§ã�ªã�„ã�¨NullPointerExceptionã‚’èµ·ã�“ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @see ModalForm#build()
     * @see ModalForm#encode()
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
     * <h1>ModalForm - getId()</h1>
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
     * <h1>ModalForm - onButton1Click(Player player)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸Šã�®ãƒœã‚¿ãƒ³ã‚’ã‚¯ãƒªãƒƒã‚¯ã�—ã�Ÿéš›ã�«å‘¼ã�³å‡ºã�•ã‚Œã�¾ã�™ã€‚ã�“ã�®ãƒ¡ã‚½ãƒƒãƒ‰ã�¯ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹å¿…è¦�ã�Œã�‚ã‚Šã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public void onButton1Click(Player player) {

    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - onButton1Click(Player player)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ä¸‹ã�®ãƒœã‚¿ãƒ³ã‚’ã‚¯ãƒªãƒƒã‚¯ã�—ã�Ÿéš›ã�«å‘¼ã�³å‡ºã�•ã‚Œã�¾ã�™ã€‚ã�“ã�®ãƒ¡ã‚½ãƒƒãƒ‰ã�¯ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹å¿…è¦�ã�Œã�‚ã‚Šã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public void onButton2Click(Player player) {

    }

}
