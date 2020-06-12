package leodev.slice.formapi.event;

import java.util.ArrayList;
import java.util.List;

import leodev.slice.formapi.base.CustomForm;
import leodev.slice.formapi.base.Form;
import leodev.slice.formapi.base.ModalForm;
import leodev.slice.formapi.base.SimpleForm;
import leodev.slice.formapi.element.FormElement;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
public class NukkitFormEventListener implements Listener {

    @EventHandler
    public void onReceive(DataPacketReceiveEvent e) {
        if(!(e.getPacket() instanceof ModalFormResponsePacket)) return;

        ModalFormResponsePacket packet = (ModalFormResponsePacket) e.getPacket();
        int formId = packet.formId;
        Form form = DataCenter.getFormById(formId);
        Player player = e.getPlayer();

        if (packet.data != null && !packet.data.equals("") && !packet.data.equals("null") && form != null) {
            if (form instanceof SimpleForm) {
                SimpleForm simpleForm = (SimpleForm) form;

                try {
                    int buttonIndex = Integer.parseInt(packet.data.replaceAll("[^0-9]", ""));
                    simpleForm.onEnter(player, buttonIndex);
                    simpleForm.getButtons().get(buttonIndex).onClick(player);

                } catch (NumberFormatException e1) {
                    simpleForm.onEnter(player, -1);
                }

            } else if (form instanceof ModalForm) {
                ModalForm modalForm = (ModalForm) form;
                String result = packet.data;

                if (result.contains("true")) {
                    modalForm.onButton1Click(player);
                } else {
                    modalForm.onButton2Click(player);
                }

            } else if (form instanceof CustomForm) {
                CustomForm customForm = (CustomForm) form;
                String[] temp = packet.data.substring(1, packet.data.length() - 1).split(",");

                List<Object> result = new ArrayList<>();
                int count = 0;

                for (FormElement element : customForm.getFormElements()) {
                    switch (element.getReturnType()) {
                        case "string":
                            result.add(temp[count]);
                            break;

                        case "int":
                            result.add(Integer.parseInt(temp[count]));
                            break;

                        case "float":
                            result.add(Float.parseFloat(temp[count]));
                            break;

                        case "boolean":
                            result.add(Boolean.parseBoolean(temp[count]));
                            break;

                        case "null":
                            result.add("null");
                            break;
                    }
                    count++;
                }

                customForm.onEnter(player, result);
            }

            DataCenter.removeForm(formId);
        }

    }

}
