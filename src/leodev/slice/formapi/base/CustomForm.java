package leodev.slice.formapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leodev.slice.formapi.element.FormElement;
import cn.nukkit.Player;

import com.google.gson.Gson;


/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>CustomForm</h1>
 * <p>ç‹¬è‡ªã�§ã‚«ã‚¹ã‚¿ãƒ ã�—ã�Ÿãƒ•ã‚©ãƒ¼ãƒ ã‚’æ‰±ã�†ã‚¯ãƒ©ã‚¹ã�§ã�™ã€‚ä¸€èˆ¬çš„ã�«IDã�¨ã‚¿ã‚¤ãƒˆãƒ«ã‚’æŒ‡å®šã�—ã€�addFormElement(FormElement)ã�§è¦�ç´ ã‚’è¿½åŠ ã�—ã�¦ä½¿ã�„ã�¾ã�™ã€‚ã€Œé€�ä¿¡ã€�ãƒœã‚¿ãƒ³ã‚¯ãƒªãƒƒã‚¯æ™‚ã�®æŒ™å‹•ã�¯onEnter()ãƒ¡ã‚½ãƒƒãƒ‰ã‚’ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹ã�“ã�¨ã�§å®Ÿè£…ã�§ã��ã�¾ã�™ã€‚
 * <br>
 * 
 * @see CustomForm#addFormElement(FormElement)
 * @see CustomForm#setId(int)
 * @see CustomForm#setTitle(String)
 * @see CustomForm#onEnter(Player, List)
 * 
 * @author itsu
 *
 */

public class CustomForm implements Form {
	
    private int id;
    private String title;
    private List<FormElement> elements;
    
    private Map<String, Object> data;
    private Gson gson;
    private String json;
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm()</h1>
     * <p>CustomFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm() {
    	this(0);
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm(int id)</h1>
     * <p>CustomFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id) {
    	this(id, "");
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm()</h1>
     * <p>CustomFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm(int id, String title)
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id, String title) {
    	this(id, title, new ArrayList<FormElement>());
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm(int id, String title, List elements)</h1>
     * <p>CustomFormã�®ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id, String title, List<FormElement> elements) {
        this.id = id;
        this.title = title;
        this.elements = elements;
        
        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setId(int id)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«IDã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm(int)
     * 
     * @author itsu
     *
     */
    public CustomForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setTitle(String title)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«ã‚¿ã‚¤ãƒˆãƒ«ã‚’è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm(int, String)
     * 
     * @author itsu
     *
     */
    public CustomForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setFormElements(List<FormElement> element)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¿½åŠ ã�™ã‚‹è¦�ç´ ã‚’ä¸€æ‹¬ã�§è¨­å®šã�—ã�¾ã�™ã€‚ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿ã�§æŒ‡å®šã�™ã‚‹ã�“ã�¨ã‚‚ã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm setFormElements(List<FormElement> elements) {
        this.elements = elements;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setFormElements(FormElement[] element)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¿½åŠ ã�™ã‚‹è¦�ç´ ã‚’é…�åˆ—ã�«ã‚ˆã‚Šä¸€æ‹¬ã�§è¨­å®šã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public CustomForm setFormElements(FormElement[] elements) {
        this.elements = Arrays.asList(elements);
        return this;
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElement(FormElement element)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®æœ€å¾Œéƒ¨ã�«è¦�ç´ ã‚’è¿½åŠ ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElement(FormElement element) {
    	this.elements.add(element);
    	return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElements(List<FormElement> element)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¦�ç´ ã‚’ä¸€æ‹¬ã�§è¿½åŠ ã�—ã�¾ã�™ã€‚setFormElements()ã�¨ã�¯ã�¡ã�Œã�„ã€�ã�“ã�¡ã‚‰ã�§ã�¯ä¸€æ‹¬è¿½åŠ å¾Œã‚‚addFormElement()ã�§è¦�ç´ ã‚’è¿½åŠ ã�™ã‚‹ã�“ã�¨ã�Œã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#setFormElements(List)
     * @see CustomForm#addFormElement(FormElement)
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElements(List<FormElement> elements) {
        this.elements.addAll(elements);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElements(FormElement[] element)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�«è¦�ç´ ã‚’é…�åˆ—ã�«ã‚ˆã�£ã�¦ä¸€æ‹¬ã�§è¿½åŠ ã�—ã�¾ã�™ã€‚setFormElements()ã�¨ã�¯ã�¡ã�Œã�„ã€�ã�“ã�¡ã‚‰ã�§ã�¯ä¸€æ‹¬è¿½åŠ å¾Œã‚‚addFormElement()ã�§è¦�ç´ ã‚’è¿½åŠ ã�™ã‚‹ã�“ã�¨ã�Œã�§ã��ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#setFormElements(List)
     * @see CustomForm#addFormElement(FormElement)
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElements(FormElement[] elements) {
        this.elements.addAll(Arrays.asList(elements));
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - getTitle()</h1>
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
     * <h1>CustomForm - getFormElements()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®è¦�ç´ ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
    public List<FormElement> getFormElements() {
        return this.elements;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - encode()</h1>
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
     * <h1>CustomForm - build()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã‚’Gsonãƒ©ã‚¤ãƒ–ãƒ©ãƒªçµŒç�?±ã�§JsonåŒ–ã�§ã��ã‚‹ã‚ˆã�†ã�«ã‚¨ãƒ³ã‚³ãƒ¼ãƒ‰ã�—ã�¾ã�™ã€‚ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã�®å‘¼ã�³å‡ºã�—ã�¯é�žæŽ¨å¥¨ã�§ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
	@Override
	public Form build() {
        data.clear();

        data.put("type", "custom_form");
        data.put("title", this.title);
        
        List<Map<String, Object>> list = new ArrayList<>();
        for(FormElement element : elements) {
        	list.add(element.build());
        }
        
        data.put("content", list);

        return this;
	}

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - getJson()</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®JsonåŒ–ã�—ã�Ÿã‚‚ã�®ã‚’å�–å¾—ã�—ã�¾ã�™ã€‚ã�ªã�Šã€�build()ã€�encode()ã�®é †ã�§å‘¼ã�³å‡ºã�—ã‚’ã�—ã�Ÿå¾Œã�§ã�ªã�„ã�¨NullPointerExceptionã‚’èµ·ã�“ã�—ã�¾ã�™ã€‚
     * <br>
     * 
     * @see CustomForm#build()
     * @see CustomForm#encode()
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
     * <h1>CustomForm - getId()</h1>
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
     * <h1>CustomForm - onEnter(Player player, List<Object> response)</h1>
     * <p>ã�“ã�®ãƒ•ã‚©ãƒ¼ãƒ ã�®ã€Œé€�ä¿¡ã€�ãƒœã‚¿ãƒ³ã‚’ã‚¯ãƒªãƒƒã‚¯ã�—ã�Ÿéš›ã�«å‘¼ã�³å‡ºã�•ã‚Œã�¾ã�™ã€‚ã�“ã�®ãƒ¡ã‚½ãƒƒãƒ‰ã�¯ãƒ—ãƒ©ã‚°ã‚¤ãƒ³å�´ã�§ã‚ªãƒ¼ãƒ�ãƒ¼ãƒ©ã‚¤ãƒ‰ã�™ã‚‹å¿…è¦�ã�Œã�‚ã‚Šã�¾ã�™ã€‚
     * <br>
     * 
     * @author itsu
     *
     */
	public void onEnter(Player player, List<Object> response) {
		
	}

}
