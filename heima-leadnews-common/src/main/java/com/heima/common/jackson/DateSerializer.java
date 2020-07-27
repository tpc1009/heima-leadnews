package com.heima.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Object> {

    public  void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        try {
            if (value != null) {
                //日期变成时间戳
                //后台到前台
                jsonGenerator.writeNumber(((Date)value).getTime());
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        serializers.defaultSerializeValue(value, jsonGenerator);
    }
}
