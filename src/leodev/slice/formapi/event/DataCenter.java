package leodev.slice.formapi.event;

import java.util.HashMap;

import leodev.slice.formapi.base.Form;


public class DataCenter {
	
	public static HashMap<Integer, Form> forms = new HashMap<Integer, Form>();

	protected static void initalize() {
		forms = new HashMap<>();
	}

	public static void addForm(int id, Form form) {
		forms.put(id, form);
	}

	public static Form getFormById(int id) {
		return forms.get(id);
	}

	public static void removeForm(int id) { forms.remove(id); };

}
