package com.ejada.telemoney.db.dto.importDtos;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentEntryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient JSONObject data;
    private long channelId;
    private String action;
    private long affectedEntityId;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(data != null ? data.toString() : null);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String jsonStr = (String) in.readObject();
        try {
            this.data = jsonStr != null ? JSONFactoryUtil.createJSONObject(jsonStr) : null;
        } catch (Exception e) {
            this.data = null;
        }
    }
}
