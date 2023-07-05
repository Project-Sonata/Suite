package com.odeyalo.sonata.suite.reactive.exception.decoder.registry;

import com.odeyalo.sonata.suite.reactive.exception.decoder.DetaultReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.ReactiveFeignClientMethodExceptionHandlerDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientMethodExceptionHandlerDecoderContainer implements ClientMethodExceptionHandlerDecoderRegistry {
    private final Map<String, ReactiveFeignClientMethodExceptionHandlerDecoder> decoders;
    private DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler;

    public ClientMethodExceptionHandlerDecoderContainer(DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler) {
        this.decoders = new HashMap<>();
        this.defaultHandler = defaultHandler;
    }

    public ClientMethodExceptionHandlerDecoderContainer(List<ReactiveFeignClientMethodExceptionHandlerDecoder> decodersList,
                                                        DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler) {
        this.decoders = new HashMap<>();
        this.defaultHandler = defaultHandler;
        for (ReactiveFeignClientMethodExceptionHandlerDecoder decoder : decodersList) {
            addExceptionDecoder(decoder.supportedMethods(), decoder);
        }
    }

    public ClientMethodExceptionHandlerDecoderContainer(Map<String, ReactiveFeignClientMethodExceptionHandlerDecoder> decoders,
                                                        DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler) {
        this.decoders = decoders;
        this.defaultHandler = defaultHandler;
    }


    @Override
    public void addExceptionDecoder(String supportedMethodKey, ReactiveFeignClientMethodExceptionHandlerDecoder decoder) {
        decoders.put(supportedMethodKey, decoder);
    }

    @Override
    public void addExceptionDecoder(String[] supportedMethodKeys, ReactiveFeignClientMethodExceptionHandlerDecoder decoder) {
        for (String methodName : supportedMethodKeys) {
            addExceptionDecoder(methodName, decoder);
        }
    }

    @Override
    public ReactiveFeignClientMethodExceptionHandlerDecoder getDecoder(String methodKey, boolean returnDefault) {
        if (returnDefault) {
            return decoders.getOrDefault(methodKey, defaultHandler);
        }
        return decoders.get(methodKey);
    }

    @Override
    public boolean contains(String methodKey) {
        return decoders.containsKey(methodKey);
    }

    public void setDefaultHandler(DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler) {
        this.defaultHandler = defaultHandler;
    }
}
